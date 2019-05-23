package com.soft.tools;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * 生成token
 * @author 作者:大飞
 * @version 创建时间：2019年5月23日 下午2:08:58 类说明
 */

public class JwtUtils {
	private static final String SECRET = "secret";
	private static final String ISSUER = "xcf";

	/**
	 * 生成token
	 *
	 * @param claims
	 * @return
	 */
	public static String createToken(Map<String, String> claims) throws Exception {
		try {
			Algorithm algorithm = Algorithm.HMAC256(SECRET);
			JWTCreator.Builder builder = JWT.create().withIssuer(ISSUER)
					// 设置过期时间为2小时
					.withExpiresAt(DateUtils.addHours(new Date(), 2));
			claims.forEach(builder::withClaim);
			return builder.sign(algorithm);
		} catch (IllegalArgumentException e) {
			throw new Exception("生成token失败");
		}
	}

	/**
	 * 验证jwt，并返回数据
	 */
	public static Map<String, String> verifyToken(String token) throws Exception {
		Algorithm algorithm;
		Map<String, Claim> map;
		try {
			algorithm = Algorithm.HMAC256(SECRET);
			JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
			DecodedJWT jwt = verifier.verify(token);
			map = jwt.getClaims();
		} catch (Exception e) {
			throw new Exception("鉴权失败");
		}
		Map<String, String> resultMap = new HashMap<>(map.size());
		map.forEach((k, v) -> resultMap.put(k, v.asString()));
		return resultMap;
	}

}
