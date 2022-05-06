package com.xinxin.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xinxin.bean.sql.User;
import com.xinxin.common.ResultMessage;
import com.xinxin.common.excepiton.UserExcepiton;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

/**
 * @author smile
 * @ClassName JwtUtils.java
 * @Description TODO
 * @createTime 2022年04月27日 20:02:00
 */
@Slf4j
public class JwtUtils {

    /**
     * 签发对象：这个用户的id
     * 签发时间：现在
     * 有效时间：30分钟
     * 载荷内容：暂时设计为：这个人的名字，这个人的昵称
     * 加密密钥：这个人的id加上一串字符串
     */
    public static String createToken(User user) {

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 30);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(user.getUid().toString())   //签发对象
                .withIssuedAt(new Date())    //发行时间
                .withExpiresAt(expiresDate)  //有效时间
                .withClaim("userName", user.getUserName())    //载荷，随便写几个都可以
                .sign(Algorithm.HMAC256(user.getUid() + "Smileya.wx"));   //加密
    }

    /**
     * 检验合法性，其中secret参数就应该传入的是用户的id
     *
     * @param token
     */
    public static void verifyToken(String token, String secret) throws UserExcepiton.UserTokenExpired {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret + "Smileya.wx")).build();
            jwt = verifier.verify(token);
            log.info("jwt校验成功,jwt = {}", jwt);
        } catch (TokenExpiredException e) {
            // token过期
            throw new UserExcepiton.UserTokenExpired(ResultMessage.USERTOKENEXPIRED);
        }

    }

    /**
     * 获取签发对象
     */
    public static String getAudience(String token) {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            //这里是token解析失败
            System.out.println("解析失败");
        }
        return audience;
    }


    /**
     * 通过载荷名字获取载荷的值
     */
    public static Claim getClaimByName(String token, String name) {
        return JWT.decode(token).getClaim(name);
    }
}


