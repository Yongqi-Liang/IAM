package liangyongqi.iam.Controller.webservice;

import liangyongqi.iam.Util.LogTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
    /**
     * 跳转到首页
     *
     * @param token 用户令牌
     * @return 首页
     */
    @GetMapping("/")
    public String HomePage() {
        LogTool.writelog("liangyongqi.iam.Controller.webservice.Home", "HomePage", "/");
        return "HomePage";
    }
}
