package liangyongqi.iam.Ability;

import liangyongqi.iam.Util.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.context.Context;


@Service
public class AccountActiveMailSender {

    @Autowired
    private SpringTemplateEngine templateEngine;
    @Autowired
    private Mail mail;

    public boolean sendAccountActiveMail(String to, String uid, String ugp, String code) {
        try {
            Context context = new Context();
            context.setVariable("code", code);       // 填充验证码
            context.setVariable("uid", uid);         // 填充用户ID
            context.setVariable("ugp", ugp);         // 填充用户组
            String htmlContent = templateEngine.process("templates/AccountActiveMail.html", context);
            Boolean action = mail.sendMail(to, null, "whoIAM 账户激活邮件", htmlContent);
            if (!action) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
