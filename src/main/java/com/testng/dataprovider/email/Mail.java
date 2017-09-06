import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

	public static void main(String[] args) {
		String content="<html><head> <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script> "
				+ "			<script type=\"text/javascript\">+ "
				+ "  google.charts.load('current', {'packages':['corechart']});+ "
				+ "  google.charts.setOnLoadCallback(drawChart); function drawChart() {"
				+ "        var data = new google.visualization.DataTable();data.addColumn('string', 'status'); "
				+ "  data.addColumn('number', 'Percentage');data.addRows([['passed',27],['failed',0],['skipped',0]]); "
				+ "var options = {'title':'Test Run ',    'width':400,               'height':300}; "
				+ "var chart = new google.visualization.PieChart(document.getElementById('chart_div')); "
				+ "        chart.draw(data, options);      }     </script> "
				+ "</head><body> <div id=\"chart_div\"></div></body></html> ";
		 Mailer.send("automation.resultsqait@gmail.com","QaitAutomation","porwalparascs97@gmail.com","hello Mayank",content);  
	}
}
class Mailer{  
    public static void send(String from,String password,String to,String sub,String content){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,  new javax.mail.Authenticator(){
        	  protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(from, password);
			}
		  }   		  
        		  
        		  );    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);   
           MimeBodyPart messageBodyPart = new MimeBodyPart();
           messageBodyPart.setContent(content, "text/html");
   		Multipart multipart = new MimeMultipart();
   		multipart.addBodyPart(messageBodyPart);           message.setContent(multipart);
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  