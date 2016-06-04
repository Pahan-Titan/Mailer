package ua.kurs.test;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class EmailHandler implements Serializable {
 
    /**
     * Creates a new instance of SendMailBean
     */
    private String subject = "tema";
    private String body = "text";
    private static String username = "pashok.moyo@gmail.com";
    private static String password = "Rengers1995";
	
	private static void EmailHandler(String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props,
        		new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        Message msg = new MimeMessage(session);
        try {
			msg.setFrom(new InternetAddress(username, "Orange+"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                "k.komu3@yandex.ru", "Dear customer"));
			msg.setSubject("Your order is accepted");
			msg.setText("Message ololo...");
			Transport.send(msg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
    	EmailHandler("Your order is accepted","Message ololo...");
    }

}