package com.ssm.pojo;

import java.util.Date;

public class User {

	private String userId;
	private String userName;
	private String password;
	private SEX sex;
	private String phone;
	private Date birthday;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSex(SEX sex) {
		this.sex = sex;
	}

	public SEX getSex() {
		return sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "[userId:" + userId + ",userName:" + userName + ",birthday:"
				+ birthday + ",sex:" + sex + ",phone:" + phone + "]";
	}

	public void createKey() {
		Long time = System.currentTimeMillis();
		byte[] tt = new byte[4];
		String id= time.toString() + tt.toString();
		id=id.substring(id.length()-16, id.length());
		this.userId=id;
	}
}