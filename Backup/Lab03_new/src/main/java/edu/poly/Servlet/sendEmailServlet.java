package edu.poly.Servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendEmailServlet")
public class sendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/sendEmail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String username = "ducnvph14435@fpt.edu.vn";
		final String password = "nguyenvanduc";
		Properties pro = new Properties();
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.port", "587");
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(pro, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		String emailTo = request.getParameter("to");
		String emailSub = request.getParameter("subject");
		String emailContent = request.getParameter("content");

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			message.setSubject(emailSub);
			message.setText(emailContent);
			Transport.send(message);
			System.out.print("Done");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
