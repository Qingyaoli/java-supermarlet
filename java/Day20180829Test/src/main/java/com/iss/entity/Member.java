/**
 * 
 */
package com.iss.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @作者： 李庆尧 @时间： 2018年8月30日 下午7:22:09
 */
public class Member {

	private String memberId;// 会员编号
	private String memberName;// 会员姓名
	private int memberIntegral;// 会员积分
	private String memberTelephone;// 会员电话号码
	
	
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		SimpleDateFormat sdf=null;
		sdf = new SimpleDateFormat("yyyyMMddHHmm");
		this.memberId =sdf.format(new Date())+memberId;
//		System.out.println(this.memberId);
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberIntegral() {
		return memberIntegral;
	}

	public void setMemberIntegral(int memberIntegral) {
		this.memberIntegral = memberIntegral;
	}

	public String getMemberTelephone() {
		return memberTelephone;
	}

	public void setMemberTelephone(String memberTelephone) {
		this.memberTelephone = memberTelephone;
	}

}
