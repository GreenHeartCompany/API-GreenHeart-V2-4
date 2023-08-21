package api.service.email;

import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@NoArgsConstructor
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("$support.mail")
    private String supportMail;

    public void enviaEmail(String enderecoEmailDestino, String conteudo) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);

        mimeMessageHelper.setFrom(supportMail);
        mimeMessageHelper.setTo(enderecoEmailDestino);
        mimeMessageHelper.setSubject("Green Heart notifica");
        mimeMessageHelper.setText(conteudo);
            javaMailSender.send(message);
        }
}
