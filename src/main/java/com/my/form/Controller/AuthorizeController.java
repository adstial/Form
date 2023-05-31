package com.my.form.Controller;

import com.my.form.DTO.AccessTokenDTO;
import com.my.form.Util.GitHubUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubUtil gitHubUtil;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("dd4d4e4f1d00d1dd1c37");
        accessTokenDTO.setClient_secret("7f2c1c4bb831d6c91a8cddd3a8401270c233be5a");
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        gitHubUtil.getAccessToken(accessTokenDTO);
        return "index";
    }
}
