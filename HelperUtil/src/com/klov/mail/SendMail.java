package com.klov.mail;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.klov.mail.model.MailMessage;
import com.klov.mail.model.MailProperties;
import com.klov.util.InstanceFactory;
import com.klov.util.PropertiesFactory;
import com.klov.util._InitLog4j;

public class SendMail {

	private MailProperties mailProp;
	private MailMessage mailMesg;
	private String file;
	private static final Logger LOG = Logger.getLogger("SendMail") ;
	private void intiMailInfo(){
		if(StringUtils.isEmpty(file)){
			file = "com.klov.util.mail";
		}
		PropertiesFactory properties = PropertiesFactory.getInstance(file);
		mailProp = InstanceFactory.getInstance(MailProperties.class);
		mailProp.setHost(properties.get("host"));
		mailProp.setPort(properties.get("port"));

		mailMesg = InstanceFactory.getInstance(MailMessage.class);
		mailMesg.setAttachment(StringUtils.split(properties.get("attachment"),"&"));
		mailMesg.setAuth(BooleanUtils.toBoolean(properties.get("auth")));
		mailMesg.setContent(properties.get("content"));
		mailMesg.setFrom(properties.get("from"));
		mailMesg.setPword(properties.get("pword"));
		mailMesg.setSubject(properties.get("subject"));
		mailMesg.setTo(StringUtils.split(properties.get("to"), "&"));
		mailMesg.setUsrname(properties.get("usrname"));
	}
	
	public boolean send(){
		ManageMail mmail = InstanceFactory.getInstance(ManageMail.class) ;
		intiMailInfo();
		boolean flag = mmail.send(mailProp, mailMesg) ;
		_InitLog4j.initialLog4jProperties(null);
		if(flag){
		   LOG.info("send email successed ... ") ;
		}else{
			LOG.error("send email errored ... ") ;
		}
		LOG.info(mailMesg.toString()) ;
		return flag ;
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}
	
	public static void main(String[] args) {
		SendMail s = new SendMail() ;
		s.send();
	}
}
