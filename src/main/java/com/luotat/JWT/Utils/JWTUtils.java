package com.luotat.JWT.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class JWTUtils
{
    private static final String signKey = "LuoTat@20040210";// 签名密钥
    private static final Algorithm algorithm = Algorithm.HMAC512(signKey);// 算法
    private static final Long expire = 43200000L; // 有效时间

    /**
     * 生成JWT令牌
     *
     * @param claims JWT第二部分负载 payload 中存储的内容
     * @return sJWT令牌
     */
    public static String generateJWT(Map<String, Object> claims)
    {

        return JWT.create()
                  .withClaim("LogIn", claims)// 自定义信息（有效载荷）
                  .withExpiresAt(new Date(System.currentTimeMillis() + expire))//过期时间
                  .sign(algorithm);
    }

    /**
     * 解析JWT令牌
     *
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static DecodedJWT parseJWT(String jwt) throws JWTVerificationException
    {
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(jwt);
    }
}