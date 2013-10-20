package com.klov.mail.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <title>MailMessage</title>
 * 
 * <project>HelperUtil</project>
 * 
 * <package>com.klov.mail.model</package>
 * 
 * <file>MailMessage.java</file>
 * 
 * <date>2013-3-1</date>
 * 
 * <brief>邮件信息内容</brief>
 * 
 * @author klov
 * 
 */
public class MailMessage {

	/* 发信人 */
	private String from;
	/* 收信人 */
	private String[] to;
	/* 是否需要验证 */
	private boolean auth;
	/* 用户名 */
	private String usrname;
	/* 密码 */
	private String pword;
	/* 邮件名 */
	private String subject;
	/* 正文 */
	private String content;
	/* 附件 */
	private String[] attachment;
	/* 附件名 */
	private List<String> attachnames = new ArrayList<String>();
	/* 展示名 */
	private String displayname;

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String[] getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String[] to) {
		this.to = to;
	}

	/**
	 * @return the auth
	 */
	public boolean isAuth() {
		return auth;
	}

	/**
	 * @param auth the auth to set
	 */
	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	/**
	 * @return the usrname
	 */
	public String getUsrname() {
		return usrname;
	}

	/**
	 * @param usrname the usrname to set
	 */
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	/**
	 * @return the pword
	 */
	public String getPword() {
		return pword;
	}

	/**
	 * @param pword the pword to set
	 */
	public void setPword(String pword) {
		this.pword = pword;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the attachment
	 */
	public String[] getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String[] attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the displayname
	 */
	public String getDisplayname() {
		return displayname;
	}

	/**
	 * @param displayname the displayname to set
	 */
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	/**
	 * @return the attachnames
	 */
	public List<String> getAttachnames() {
		return attachnames;
	}

	/**
	 * @param attachnames the attachnames to set
	 */
	public void setAttachnames(List<String> attachnames) {
		this.attachnames = attachnames;
	}

	public void addAttachment(String attachname) {

		this.attachnames.add(attachname);
	}

	public void removeAttachment(String attachname) {
		if (attachnames.contains(attachnames)) {
			this.attachnames.remove(attachname);
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder bu = new StringBuilder();
		bu.append("from = ").append(from);
		if (to != null) {
			for (int i = 0; i < to.length; i++) {
				 
				bu.append(" & to[ ").append(i).append(" ] = ").append(to[i]);
			}
		}

		bu.append(" & usrname = ").append(usrname).append(" & content = ").append(content);
		if (attachment != null) {
			for (int i = 0; i < attachment.length; i++) {
				 
				bu.append(" & attachement[ ").append(i).append(" ] = ").append(attachment[i]);
			}
		}
		return bu.toString();
	}

}
