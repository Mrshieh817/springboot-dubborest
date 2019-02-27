package com.soft.model;

import java.io.Serializable;

/**
 * @author 作者:大飞
 * @version 创建时间：2019年2月27日 下午2:56:27 类说明
 */
@SuppressWarnings("serial")
public class usermodel  implements Serializable{
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
