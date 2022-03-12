package com.example.lab3;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "SendMailServlet", value = "/SendMailServlet")
public class SendMailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/sendMail/formSend.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = "ducit2509@gmail.com";
        final String password = "nguyenvanduc";
        Properties pro = new Properties();
        pro.put("mail.smtp.host", "smtp.gmail.com");
        pro.put("mail.smtp.port", "587");
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.starttls.enable", "true");
        Authenticator authenticator;
        Session session = Session.getInstance(pro, new Authenticator() {
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
            e.printStackTrace();
        }
        request.getRequestDispatcher("/views/sendMail/formSend.jsp").forward(request, response);

    }
}
