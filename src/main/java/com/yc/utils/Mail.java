package com.yc.utils;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

	private MimeMessage mimeMsg;// 发送邮件需要配置邮件服务器属性信息 邮件对象
	private Session session;// 邮件会话对象

	private Properties props;// 读取项目的配置文件 系统属性
	private String username;// 发件人真实的账户名
	private String password;// 发件人密码
	private Multipart mp;// 邮件的正文部分

	private Mail(String smtp) {
		setSmtpHost(smtp);// 系统属性
		createMimeMessage();// 会话，邮件对象
	}

	/*
	 * 将smtp服务器的主机名加入到系统配置信息中
	 */
	private void setSmtpHost(String hostName) { // smtp.163.com
		if (props == null) {
			props = System.getProperties(); // Properties()存放邮件服务器的信息
		}
		props.put("mail.smtp.host", hostName); // 设置SMTP主机
	}

	// 获取会话对象，创建邮件对象
	private boolean createMimeMessage() {
		try {
			session = Session.getDefaultInstance(props, null);
		} catch (Exception e) {
			return false;
		}
		try {
			mimeMsg = new MimeMessage(session); // 创建MIME邮件对象
			mp = new MimeMultipart(); // mp 一个multipart对象
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* 定义SMTP是否需要验证 */
	private void setNeedAuth(boolean need) {
		if (props == null)
			props = System.getProperties();
		if (need) {
			props.put("mail.smtp.auth", "true");
		} else {
			props.put("mail.smtp.auth", "false");
		}
	}

	// 发送方 用户设置
	private void setNamePass(String name, String pass) {
		this.username = name;
		this.password = pass;
	}

	/* 定义邮件主题 */
	private boolean setSubject(String subject) {
		try {
			mimeMsg.setSubject(subject);
			return true;
		} catch (Exception e) {
			System.err.println("定义邮件主题发生错误！");
			return false;
		}
	}

	/* 定义邮件正文 */
	private boolean setBody(String content) {
		try {
			BodyPart bp = new MimeBodyPart();
			bp.setContent("" + content, "text/html;charset=GBK");
			mp.addBodyPart(bp);
			return true;
		} catch (Exception e) {
			System.err.println("定义邮件正文时发生错误！" + e);
			return false;
		}
	}

	/* 设置发信人 */
	private boolean setFrom(String from) {
		try {
			mimeMsg.setFrom(new InternetAddress(from)); // 发信人
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* 定义收信人 */
	private boolean setTo(String to) {
		if (to == null)
			return false;
		try {
			mimeMsg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* 发送邮件模块 */
	private boolean sendOut() {
		try {
			mimeMsg.setContent(mp);// 生成文件内容
			mimeMsg.saveChanges();// 保存并生成最终的邮件正文
			Session mailSession = Session.getInstance(props, null);// 获得Session实例对象
			Transport transport = mailSession.getTransport("smtp");// 获得Transport实例对象
			transport.connect((String) props.get("mail.smtp.host"), username,
					password);// 打开连接
			transport.sendMessage(mimeMsg,
					mimeMsg.getRecipients(Message.RecipientType.TO));// 将message对象传递给transport，并发出去
			transport.close();
			return true;
		} catch (Exception e) {
			System.err.println("发送邮件失败！" + e);
			return false;
		}
	}

	/* 调用sendOut方法完成发送 */
	public static boolean sendAndCc(String smtp, String from, String to,
			String copyto, String subject, String content, String username,
			String password) {
		Mail theMail = new Mail(smtp);
		theMail.setNeedAuth(true);
		if (!theMail.setSubject(subject))// 设置主题
			return false;
		if (!theMail.setBody(content))// 正文
			return false;
		if (!theMail.setTo(to))// 收件人邮件地址
			return false;
		if (!theMail.setFrom(from))// 发件人邮件地址
			return false;
		theMail.setNamePass(username, password);
		if (!theMail.sendOut())
			return false;
		return true;
	}
}