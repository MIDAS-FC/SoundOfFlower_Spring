package midas.SoundOfFlower.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import midas.SoundOfFlower.error.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import static midas.SoundOfFlower.error.ErrorCode.SEND_EMAIL_FAIL;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String email, String randomNum) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject("소리꽃 이메일 인증");
            mimeMessageHelper.setText("""
            <div>
                <h1>소리꽃 이메일 인증</h1>
                <p>안녕하세요!</p>
                <p>귀하의 인증 번호는 다음과 같습니다: <strong>%s</strong></p>
                <p>이 번호를 인증 과정에서 사용해 주세요.</p>
            </div>
            """.formatted(randomNum), true);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new CustomException(SEND_EMAIL_FAIL);
        }

    }



}
