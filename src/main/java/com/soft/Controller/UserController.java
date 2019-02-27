package com.soft.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soft.model.usermodel;

/**
* @author 作者:大飞
* @version 创建时间：2019年2月27日 下午2:48:45
* 类说明
*/

@RestController
@RequestMapping("/user")
public class UserController {
  
	
	@RequestMapping("/test")
	public Object test()
	{
		usermodel mm=new usermodel();
		mm.setId("1008611");
		mm.setName("中国移动快捷方式");
		return mm;
	}
}
