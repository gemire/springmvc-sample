package com.dhenton9000.greenmail;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetupTest;
import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/greenmail-spring.xml")
public class AppTest {
// http://www.icegreen.com/greenmail/

    /**
     * Class under test
     */
    @Resource
    private JavaMailSender emailService;
    private GreenMail greenMail;
    private final Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Before
    public void startMailServer() {
        greenMail = new GreenMail(ServerSetupTest.SMTP);
        greenMail.start();
    }

    @After
    public void stopMailServer() {
        greenMail.stop();
    }

    @Test
    public void testSimpleMailer()
            throws InterruptedException, MessagingException {

        String mailText = "Hallo World";
        String mailSubject = "Hallo";
        String mailTo = "test@excaple.com";
        String mailFrom = "test@excaple.com";

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mailFrom);
        message.setTo(mailTo);
        message.setSubject(mailSubject);
        message.setText(mailText);


        emailService.send(message);
        assertTrue(greenMail.waitForIncomingEmail(2000, 1));
        Message[] messages = greenMail.getReceivedMessages();
        assertEquals(1, messages.length);
        assertEquals(mailSubject, messages[0].getSubject());
        String body = GreenMailUtil.getBody(messages[0]).replaceAll("=\r?\n", "");
        logger.info("body " + body);

        assertEquals(mailText, body);
    }

    @Test
    public void testYourSendingCode() throws Exception {
         
        GreenMailUtil.sendTextEmailTest("to@localhost.com", "from@localhost.com", "subject", "body"); //replace this with your send code
        assertEquals("body", GreenMailUtil.getBody(greenMail.getReceivedMessages()[0]));
        greenMail.stop();
        //That's it!
    }
}