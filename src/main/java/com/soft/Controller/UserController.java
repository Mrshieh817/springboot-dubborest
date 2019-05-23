package com.soft.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soft.model.usermodel;
import com.soft.tools.JwtUtils;

/**
 * @author 作者:大飞
 * @version 创建时间：2019年2月27日 下午2:48:45 类说明
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/test")
	public Object test() {
		usermodel mm = new usermodel();
		mm.setId("1008611");
		mm.setName("中国移动快捷方式");
		return mm;
	}

	@RequestMapping({ "/gettoken" })
	public String Gettoken() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("userid", "ff");
		map.put("account", "1008611");
		return JwtUtils.createToken(map);
	}

	@GetMapping({ "/getmap" })
	public Object getmap(HttpServletRequest request) throws Exception {
		String token = request.getHeader("Authorization");
		if (token == "" || token == null) {
			return "没有权限";
		} else {
			String userid = JwtUtils.verifyToken(token).get("userid");
			String account = JwtUtils.verifyToken(token).get("account");
			System.out.println("userid:" + userid + "account:" + account);
			return JwtUtils.verifyToken(token);
		}

	}
}
