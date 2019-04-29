package com.soft.IMP;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.soft.model.usermodel;

/**
 * @author 作者:大飞
 * @version 创建时间：2018年7月4日 上午10:48:51 类说明
 */

@Path("hello")
public class UserService implements IuserService {
	@Override
	@Path("test/{username}")
	@GET
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public usermodel getuserinfo(@PathParam("username") String username) {
		usermodel mo = new usermodel();
		mo.setId("100010");
		mo.setName("大飞是我爸爸"+username);
		return mo;
	}
	
	
	@Override
	@Path("ni")
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String ni() {

		return "dubbo rest   test  success！";
	}
}
