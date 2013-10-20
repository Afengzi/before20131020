package com.klov.mail;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.StringUtils;

import com.klov.mail.model.MailMessage;
import com.klov.mail.model.MailProperties;

public class ManageMail {

	private static final String PROTOCOL_KEY = "mail.transport.protocol";
	private static final String PROTOCOL_VAL = "smtp";
	private static final String HOST_KEY = "mail.smtp.host";
	private static final String PORT_KEY = "mail.smtp.port";
	private static final String AUTH_KEY = "mail.smtp.auth";

	public boolean send(MailProperties mailProp,final MailMessage mailMesg) {

		boolean success = true ;
		Properties prop = new Properties();
		prop.setProperty(PROTOCOL_KEY, PROTOCOL_VAL);
		prop.setProperty(HOST_KEY, mailProp.getHost());
		prop.setProperty(PORT_KEY, mailProp.getPort());
		prop.setProperty(AUTH_KEY, mailMesg.isAuth() + "");

		Session session = null;
		//是否需要身份验证
		if (mailMesg.isAuth()) {

			session = Session.getInstance(prop, new Authenticator() {
				// 验证，重写
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication(mailMesg.getUsrname(), mailMesg.getPword());
				}
			});
		} else {
			session = Session.getInstance(prop, null);
		}

		//是否打印调试信息
		session.setDebug(true) ;
		Message msg = new MimeMessage(session);
		try {
			
			 //收信人地址
			String[] to = mailMesg.getTo();
			InternetAddress toAddr = null;
			InternetAddress[] toAddrs = new InternetAddress[to.length];
			for (int i = 0, len = to.length; i < len; i++) {
				toAddr = new InternetAddress(to[i]);
				toAddrs[i] = toAddr;
			}
            msg.setRecipients(RecipientType.TO, toAddrs) ;
            //发送人地址
            msg.setFrom(new InternetAddress(mailMesg.getFrom()));
            
			msg.setSentDate(new Date());
			//设置正文
			msg.setText(mailMesg.getContent());
			msg.setSubject(mailMesg.getSubject()) ;
			
			Multipart mp = new MimeMultipart();
			//正文体
			String content = mailMesg.getContent() ;
			if(!StringUtils.isEmpty(content)){
				MimeBodyPart contentBody = new MimeBodyPart() ;
				contentBody.setText(mailMesg.getContent()) ;
				mp.addBodyPart(contentBody) ;
			}
			
			//附件体
			MimeBodyPart attachBody = null ;
			String name = "";
			String[] attachments = mailMesg.getAttachment() ;
			//加入附件
			if(attachments!=null){
				for(int i = 0 ,len = attachments.length ; i<len ;i++){
					attachBody = new MimeBodyPart() ; 
					name = attachments[i] ;
					FileDataSource fds = new FileDataSource(name) ;
					attachBody.setDataHandler(new DataHandler(fds)) ;
					attachBody.setFileName(URLEncoder.encode(fds.getName(),"UTF-8")) ;

					mp.addBodyPart(attachBody) ;
				}
			}
			
			msg.setContent(mp) ;
			//发送 
			Transport.send(msg);
//			Transport trans = session.getTransport() ;
//			trans.connect() ;
//			trans.sendMessage(msg,toAddrs) ;
//			trans.close() ;
			
		} catch (MessagingException e) {
			e.printStackTrace();
			success = false ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			success = false ;
		}

		return success ;
	}

}
