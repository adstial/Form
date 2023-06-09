package com.my.form.Util;

import com.alibaba.fastjson2.JSON;
import com.my.form.DTO.AccessTokenDTO;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubUtil {

    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO),mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try{
            Response response = client.newCall(request).execute();
            String s = response.body().string();
            System.out.println(s);
            return s;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
