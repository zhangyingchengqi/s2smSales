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

	private MimeMessage mimeMsg;// �����ʼ���Ҫ�����ʼ�������������Ϣ �ʼ�����
	private Session session;// �ʼ��Ự����

	private Properties props;// ��ȡ��Ŀ�������ļ� ϵͳ����
	private String username;// ��������ʵ���˻���
	private String password;// ����������
	private Multipart mp;// �ʼ������Ĳ���

	private Mail(String smtp) {
		setSmtpHost(smtp);// ϵͳ����
		createMimeMessage();// �Ự���ʼ�����
	}

	/*
	 * ��smtp�����������������뵽ϵͳ������Ϣ��
	 */
	private void setSmtpHost(String hostName) { // smtp.163.com
		if (props == null) {
			props = System.getProperties(); // Properties()����ʼ�����������Ϣ
		}
		props.put("mail.smtp.host", hostName); // ����SMTP����
	}

	// ��ȡ�Ự���󣬴����ʼ�����
	private boolean createMimeMessage() {
		try {
			session = Session.getDefaultInstance(props, null);
		} catch (Exception e) {
			return false;
		}
		try {
			mimeMsg = new MimeMessage(session); // ����MIME�ʼ�����
			mp = new MimeMultipart(); // mp һ��multipart����
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* ����SMTP�Ƿ���Ҫ��֤ */
	private void setNeedAuth(boolean need) {
		if (props == null)
			props = System.getProperties();
		if (need) {
			props.put("mail.smtp.auth", "true");
		} else {
			props.put("mail.smtp.auth", "false");
		}
	}

	// ���ͷ� �û�����
	private void setNamePass(String name, String pass) {
		this.username = name;
		this.password = pass;
	}

	/* �����ʼ����� */
	private boolean setSubject(String subject) {
		try {
			mimeMsg.setSubject(subject);
			return true;
		} catch (Exception e) {
			System.err.println("�����ʼ����ⷢ������");
			return false;
		}
	}

	/* �����ʼ����� */
	private boolean setBody(String content) {
		try {
			BodyPart bp = new MimeBodyPart();
			bp.setContent("" + content, "text/html;charset=GBK");
			mp.addBodyPart(bp);
			return true;
		} catch (Exception e) {
			System.err.println("�����ʼ�����ʱ��������" + e);
			return false;
		}
	}

	/* ���÷����� */
	private boolean setFrom(String from) {
		try {
			mimeMsg.setFrom(new InternetAddress(from)); // ������
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* ���������� */
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

	/* �����ʼ�ģ�� */
	private boolean sendOut() {
		try {
			mimeMsg.setContent(mp);// �����ļ�����
			mimeMsg.saveChanges();// ���沢�������յ��ʼ�����
			Session mailSession = Session.getInstance(props, null);// ���Sessionʵ������
			Transport transport = mailSession.getTransport("smtp");// ���Transportʵ������
			transport.connect((String) props.get("mail.smtp.host"), username,
					password);// ������
			transport.sendMessage(mimeMsg,
					mimeMsg.getRecipients(Message.RecipientType.TO));// ��message���󴫵ݸ�transport��������ȥ
			transport.close();
			return true;
		} catch (Exception e) {
			System.err.println("�����ʼ�ʧ�ܣ�" + e);
			return false;
		}
	}

	/* ����sendOut������ɷ��� */
	public static boolean sendAndCc(String smtp, String from, String to,
			String copyto, String subject, String content, String username,
			String password) {
		Mail theMail = new Mail(smtp);
		theMail.setNeedAuth(true);
		if (!theMail.setSubject(subject))// ��������
			return false;
		if (!theMail.setBody(content))// ����
			return false;
		if (!theMail.setTo(to))// �ռ����ʼ���ַ
			return false;
		if (!theMail.setFrom(from))// �������ʼ���ַ
			return false;
		theMail.setNamePass(username, password);
		if (!theMail.sendOut())
			return false;
		return true;
	}
}