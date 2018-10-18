/**
 * 
 */
package com.iss.entity;

/**
 * @作者： 李庆尧 @时间： 2018年8月29日 下午1:46:49 商品类
 */

public class Commodity {
	private int Cid;		//商品编号
	private String Cname;	 // 商品名称
	private double Cnum; 	 // 商品数量
	private double Cprice;	 // 商品价格
	
	
	

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public double getCnum() {
		return Cnum;
	}

	public void setCnum(double cnum) {
		Cnum = cnum;
	}

	public double getCprice() {
		return Cprice;
	}

	public void setCprice(double cprice) {
		Cprice = cprice;
	}

	
	public int getCid() {
		return Cid;
	}

	
	public void setCid(int cid) {
		Cid = cid;
	}

}
