package com.email;

import java.util.Properties;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SendEmail {

    /** 发送邮箱用户名 */
    public final static String USERNAME = "18633971567@163.com";
    /** 密码 */
    public final static String PASSWORD = "7yyyyyyy.";
    /** 发送服务器 */
    public final static String MAIL_SERVER = "smtp.163.com";

    /**
     * 发送有奖
     * 
     * @param to
     *            收件人
     * @param subject
     *            发送邮件抬头
     * @param text
     *            发送有内容
     * @throws MailException
     */
    public static void sendEmailValidate(String to, String subject, String text) throws Exception {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        // 设定mail server
        senderImpl.setHost(MAIL_SERVER);
        // 建立邮件消息
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        senderImpl.setUsername(USERNAME);
        senderImpl.setPassword(PASSWORD);

        mailMessage.setTo(to);
        mailMessage.setFrom(USERNAME);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.timeout", "25000");
        senderImpl.setJavaMailProperties(prop);
        // 发送邮件
        senderImpl.send(mailMessage);
    }

    public static void main(String[] args) throws Exception {
        SendEmail.sendEmailValidate("734056487@qq.com", "测试2", "测试2");
    }
}
