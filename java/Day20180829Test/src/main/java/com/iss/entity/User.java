/**
 * 
 */
package com.iss.entity;

/**
 * @作者： 李庆尧 @时间： 2018年8月29日 下午1:46:23 用户类
 */
public class User {
	private int userId;		//用户编号
	private String userName;// 用户名
	private String password;// 用户密码
	private int integral;// 用户积分
	private int telephoneNum;// 用户号码

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

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public int getTelephoneNum() {
		return telephoneNum;
	}

	public void setTelephoneNum(int telephoneNum) {
		this.telephoneNum = telephoneNum;
	}

	
	//用户名和密码初始化
	public void initial() {
		this.userName = "admin";
		this.password = "123456";
	}

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
