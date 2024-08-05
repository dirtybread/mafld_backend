package zjubiomedit.mafld_backend.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class UtilClass {
    /**
     * 获取手机号
     *
     * @param code
     * @param appId
     * @param appSecret
     * @return
     */
    public static JSONObject getPhoneNumber(String code, String appId, String appSecret) {
        JSONObject phone;
        // 获取token
        String token_url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",
                appId, appSecret);
        try {
            JSONObject token = JSON.parseObject(HttpClientSslUtils.doGet(token_url));
            if (token == null) {
                log.info("获取token失败");
                return null;
            }
            String accessToken = token.getString("access_token");
            if (StringUtils.isEmpty(accessToken)) {
                log.info("获取token失败");
                return null;
            }
            log.info("token : {}", accessToken);
            //获取phone
            String url = "https://api.weixin.qq.com/wxa/business/getuserphonenumber"
                    + "?access_token=" + accessToken;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", code);
            String reqJsonStr = JsonUtil.objToString(jsonObject);
            phone = JSON.parseObject(HttpClientSslUtils.doPost(url, reqJsonStr));

            if (phone == null) {
                log.info("获取手机号失败");
                return null;
            }
            return phone;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

