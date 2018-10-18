/**
 * 
 */
package com.iss.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.iss.entity.Commodity;
import com.iss.entity.Member;
import com.iss.entity.Supermarket;
import com.iss.entity.User;

/**
 * @作者： 李庆尧 @时间： 2018年8月29日 下午1:49:47
 */
public class Main {

	/**
	 * @param args
	 */
	static Supermarket supermarket = new Supermarket();// 实例化超市
	static Scanner scanner = new Scanner(System.in);
	static User user = new User(); // 实例化用户
	static Member member = new Member();// 实例化会员
	static ArrayList<Member> listMem = new ArrayList<Member>();
	static ArrayList<Commodity> list = new ArrayList<Commodity>();
	Gson gson = new Gson();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		user.initial(); // 用户初始化
		commodityInit();// 商品初始化
		memberInit(); // 会员初始化
		supermarket.WelcomeInterface();
		int welcomeChoose = 0;
		do {
			welcomeChoose = scanner.nextInt();
			login(welcomeChoose);
		} while (welcomeChoose != 1 || welcomeChoose != 2);
		System.out.println("出来了");

	}

	// 商品初始化
	public static void commodityInit() {
		Commodity commodity1 = new Commodity();
		Commodity commodity2 = new Commodity();
		Commodity commodity3 = new Commodity();
		commodity1.setCid(1);
		commodity1.setCname("香蕉");
		commodity1.setCnum(30);
		commodity1.setCprice(6);
		commodity2.setCid(2);
		commodity2.setCname("苹果");
		commodity2.setCnum(40);
		commodity2.setCprice(6);
		commodity3.setCid(3);
		commodity3.setCname("橘子");
		commodity3.setCnum(50);
		commodity3.setCprice(6);
		list.add(commodity1);
		list.add(commodity2);
		list.add(commodity3);
	}

	// 会员初始化
	public static void memberInit() {
		Member member1 = new Member();
		Member member2 = new Member();
		Member member3 = new Member();
		member1.setMemberId("00001");
		member1.setMemberName("张三");
		member1.setMemberIntegral(10);
		member1.setMemberTelephone("17862107641");
		member2.setMemberId("00002");
		member2.setMemberName("李四");
		member2.setMemberIntegral(12);
		member2.setMemberTelephone("17862107642");
		member3.setMemberId("00003");
		member3.setMemberName("王五");
		member3.setMemberIntegral(13);
		member3.setMemberTelephone("17862107643");
		listMem.add(member1);
		listMem.add(member2);
		listMem.add(member3);
	}

	// 登录选择
	public static void login(int welcomeChoose) {
		if (welcomeChoose == 1) {
			loginFace();
		} else if (welcomeChoose == 2) {
			System.out.println("欢迎您下次使用！");
			System.exit(0);
		} else {
			System.out.println("输入有误!!!");
			supermarket.WelcomeInterface();
		}
	}

	// 登录类
	public static void loginFace() {
		System.out.println("\t登录系统");
		System.out.print("请输入用户名：");
		String username = scanner.next();
		System.out.print("请输入密码：");
		String password = scanner.next();
		/*
		 * System.out.println(user.getUserName());
		 * System.out.println(user.getPassword());
		 */
		if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
			systemInterface();
		} else {
			System.out.println("用户名或密码错误");
			loginFace();
		}

	}

	// 系统主界面
	public static void systemInterface() {
		System.out.println("\t欢迎使用丰翼超市管理系统" + "\t" + user.getUserName());
		System.out.println("**********************************");
		System.out.println("\t1.商品管理");
		System.out.println("\t2.会员管理");
		System.out.println("\t3.结账");
		System.out.println("\t4.退出系统");
		System.out.println("**********************************");
		System.out.print("请输入您的选择：");
		int systemChoose = scanner.nextInt();
		switch (systemChoose) {
		case 1:
			commodityManagement();
			break;
		case 2:
			memberManagement();
			break;
		case 3:
			payment();
			break;
		case 4:
			System.out.println("欢迎您下次使用！");
			System.exit(0);
			break;
		default:
			System.out.println("输入有误！！！");
			systemInterface();
		}
	}

	// 商品管理
	public static void commodityManagement() {
		System.out.println("\t欢迎使用丰翼超市管理系统" + "\t" + user.getUserName());
		System.out.println("**********************************");
		System.out.println("\t1.添加商品");
		System.out.println("\t2.删除商品");
		System.out.println("\t3.显示所有商品");
		System.out.println("\t4.返回上一级");
		System.out.println("**********************************");
		System.out.print("请输入您的选择：");
		int commodityChoose = scanner.nextInt();
		switch (commodityChoose) {
		case 1:
			addCommodity();
			break;
		case 2:
			deleCommodity();
			break;
		case 3:
			showCommHead();
			showCommodity();
			break;
		case 4:
			systemInterface();
			break;
		default:
			System.out.println("输入有误！！！");
			commodityManagement();
		}
	}

	// 会员管理
	public static void memberManagement() {
		System.out.println("\t欢迎使用丰翼超市管理系统" + "\t" + user.getUserName());
		System.out.println("**********************************");
		System.out.println("\t1.添加会员");
		System.out.println("\t2.删除会员");
		System.out.println("\t3.显示所有会员");
		System.out.println("\t4.返回上一级");
		System.out.println("**********************************");
		System.out.print("请输入您的选择：");
		int MemberChoose = scanner.nextInt();
		switch (MemberChoose) {
		case 1:
			addMember();
			break;
		case 2:
			deleMember();
			break;
		case 3:
			showMemHead();
			showMember();
			break;
		case 4:
			Main.systemInterface();
			break;
		default:
			System.out.println("输入有误！！！");
			memberManagement();
		}
	}

	/**
	 * 显示商品表头
	 */

	public static void showCommHead() {
		System.out.println("\t欢迎使用丰翼超市管理系统" + "\t" + user.getUserName());
		System.out.println("**********************************");
		System.out.print("编号\t");
		System.out.print("名称\t");
		System.out.print("库存量\t");
		System.out.print("单价\t");
		System.out.println("合计\t");
	}

	/**
	 * 显示所有商品
	 */
	private static void showCommodity() {
		// TODO Auto-generated method stub
		for (Commodity commodity : list) {
			System.out.print(commodity.getCid() + "\t");
			System.out.print(commodity.getCname() + "\t");
			System.out.print(commodity.getCnum() + "\t");
			System.out.print(commodity.getCprice() + "\t");
			System.out.print(commodity.getCnum() * commodity.getCprice() + "\t");
			System.out.println();

			// for (int i = 0; i < list.size(); i++) {
			// System.out.print(list.get(i).getCid()+"\t");
			// System.out.print(list.get(i).getCname()+"\t");
			// System.out.print(list.get(i).getCnum()+"\t");
			// System.out.print(list.get(i).getCprice()+"\t");
			// System.out.print(list.get(i).getCnum()*list.get(i).getCprice()+"\t");
			// System.out.println();
			// }

		}
		System.out.println("*********************************");
		System.out.println("按q键返回：");
		qReturnComm();

	}

	/**
	 * 显示会员表头
	 */
	private static void showMemHead() {
		// TODO Auto-generated method stub
		System.out.println("\t欢迎使用丰翼超市管理系统" + "\t" + user.getUserName());
		System.out.println("**********************************");
		System.out.print("编号\t\t\t");
		System.out.print("姓名\t");
		System.out.print("积分\t");
		System.out.print("电话\t");
		System.out.println();
	}

	/**
	 * 显示会员
	 */
	private static void showMember() {
		// TODO Auto-generated method stub
		for (Member member : listMem) {
			System.out.print(member.getMemberId() + "\t");
			System.out.print(member.getMemberName() + "\t");
			System.out.print(member.getMemberIntegral() + "\t");
			System.out.print(member.getMemberTelephone() + "\t");
			System.out.println();

			// for (int i = 0; i < list.size(); i++) {
			// System.out.print(list.get(i).getCid()+"\t");
			// System.out.print(list.get(i).getCname()+"\t");
			// System.out.print(list.get(i).getCnum()+"\t");
			// System.out.print(list.get(i).getCprice()+"\t");
			// System.out.print(list.get(i).getCnum()*list.get(i).getCprice()+"\t");
			// System.out.println();
			// }

		}
		System.out.println("*********************************");
		System.out.println("按q键返回：");
		qReturnMem();
	}

	/**
	 * 删除商品
	 */
	private static void deleCommodity() {
		// TODO Auto-generated method stub
		System.out.println("\t欢迎使用丰翼超市管理系统" + "\t" + user.getUserName());
		System.out.println("**********************************");
		Commodity c = searchCommodity();
		String delChoose;

		if (c == null) {
			System.out.println("没有找到对应的商品，按q键返回:");
			qReturnComm();
		} else {
			System.out.println("成功查找到" + c.getCname() + "是否进行删除删除？（按y进行删除-按q键返回：）");

			do {
				delChoose = scanner.next();
				if (delChoose.equals("y")) {
					list.remove(c);
					System.out.println("成功删除" + c.getCname());
					System.out.print("添加成功！按q键返回：");
					qReturnComm();
				} else if (delChoose.equals("q")) {
					commodityManagement();
				} else {
					System.out.print("输入不正确！请重新输入:");
				}
			} while (!delChoose.equals("y") || !delChoose.equals("q"));
		}
	}

	/**
	 * 查找商品
	 */
	public static Commodity searchCommodity() {
		// TODO Auto-generated method stub
		System.out.print("请输入要删除的商品名称：");
		String Cname = scanner.next();
		for (Commodity commodity : list) {
			if (commodity.getCname().equals(Cname)) {
				return commodity;
			}
		}

		return null;
	}

	/**
	 * 删除会员
	 */
	private static void deleMember() {
		// TODO Auto-generated method stub
		System.out.println("\t欢迎使用丰翼超市管理系统" + "\t" + user.getUserName());
		System.out.println("**********************************");
		Member m = searchMember();// 查找是否有此会员
		String delChoose;

		if (m == null) {
			System.out.println("没有找到对应的会员，按q键返回:");
			qReturnMem();
		} else {
			System.out.println("成功查找到" + m.getMemberName() + "是否进行删除删除？（按y进行删除-按q键返回：）");

			do {
				delChoose = scanner.next();
				if (delChoose.equals("y")) {
					listMem.remove(m);
					System.out.println("成功删除" + m.getMemberName());
					System.out.print("删除成功！按q键返回：");
					qReturnMem();
				} else if (delChoose.equals("q")) {
					memberManagement();
				} else {
					System.out.print("输入不正确！请重新输入:");
				}
			} while (!delChoose.equals("y") || !delChoose.equals("q"));
		}
	}

	/**
	 * 查找会员
	 */
	public static Member searchMember() {
		// TODO Auto-generated method stub
		System.out.print("请输入要删除的会员编号：");
		String memberId = scanner.next();
		for (Member member : listMem) {
			if (member.getMemberId().equals(memberId)) {
				return member;
			}
		}

		return null;
	}

	/**
	 * 添加商品
	 */
	public static void addCommodity() {
		System.out.print("请输入商品编号：");
		int Cid = scanner.nextInt();
		System.out.print("请输入商品名称：");
		String Cname = scanner.next();
		System.out.print("请输入商品数量：");
		Double Cnum = (double) scanner.nextInt();
		System.out.print("请输入商品单价：");
		Double Cprice = (double) scanner.nextInt();
		Commodity commodity = new Commodity();
		commodity.setCid(Cid);
		commodity.setCname(Cname);
		commodity.setCnum(Cnum);
		commodity.setCprice(Cprice);
		list.add(commodity);
		System.out.println("\t欢迎使用丰翼超市管理系统" + "\t" + user.getUserName());
		System.out.println("**********************************");
		System.out.println("\t商品编号:" + commodity.getCid() + "\t");
		System.out.println("\t商品名称:" + commodity.getCname() + "\t");
		System.out.println("\t商品数量:" + commodity.getCnum() + "\t");
		System.out.println("\t商品单价:" + commodity.getCprice() + "\t");
		System.out.println("**********************************");
		System.out.print("添加成功！按q键返回：");
		qReturnComm();

	}

	/**
	 * 添加会员
	 */
	private static void addMember() {
		// TODO Auto-generated method stub

		String memberId = "";
		System.out.print("请输入会员姓名：");
		String memberName = scanner.next();
		System.out.print("请输入会员积分：");
		int memberIntegral = scanner.nextInt();
		System.out.print("请输入会员电话号码：");
		String memberTelephone = scanner.next();

		member.setMemberId(memberId);

		member.setMemberName(memberName);

		member.setMemberIntegral(memberIntegral);

		member.setMemberTelephone(memberTelephone);

		listMem.add(member);
		System.out.println("\t欢迎使用丰翼超市管理系统" + "\t" + user.getUserName());
		System.out.println("**********************************");
		System.out.println("\t会员编号:" + member.getMemberId() + "\t");
		System.out.println("\t会员姓名:" + member.getMemberName() + "\t");
		System.out.println("\t会员积分:" + member.getMemberIntegral() + "\t");
		System.out.println("\t会员号码:" + member.getMemberTelephone() + "\t");
		System.out.println("**********************************");
		System.out.print("添加成功！按q键返回：");
		qReturnMem();

	}

	// 按q键返回 去添加或删除吗？
	// 按q键返回 商品管理界面
	public static void qReturnComm(/* int addOrdele */) {
		String qReturn = scanner.next();
		if (qReturn.equals("q")) {
			commodityManagement();
			/*
			 * if (addOrdele==1) { addCommodity(); } else if(addOrdele==2) {
			 * deleCommodity(); }
			 */
		} else {
			System.out.print("输入错误，请重新输入：");
			qReturnComm(/* addOrdele */);
		}
	}

	public static void qReturnMem(/* int addOrdele */) {
		String qReturn = scanner.next();
		if (qReturn.equals("q")) {
			memberManagement();
			/*
			 * if (addOrdele==1) { addCommodity(); } else if(addOrdele==2) {
			 * deleCommodity(); }
			 */
		} else {
			System.out.print("输入错误，请重新输入：");
			qReturnMem(/* addOrdele */);
		}
	}

	/*
	 * 结账功能
	 */
	public static void payment() {
		ArrayList<Commodity> listpay = new ArrayList<Commodity>();
		String payCommodityName;
		Commodity payCommodity = new Commodity();
		int payCommodityNum;
		
		String payNext;
		do {   //是否选购完毕
			int choose = -1;
			do { //输入物品  超市是否存在
				if (choose != -1) {
					System.out.println("丰翼超市中不存在此物品！");
					showCommodity();
				}
				System.out.print("请输入购买的物品：");
				payCommodityName = scanner.next();
				for (Commodity commodity : list) {
					if (commodity.getCname().equals(payCommodityName)) {
						payCommodity.setCname(payCommodityName);
						payCommodity.setCprice(commodity.getCprice());
						choose = 1;
					}
				}
			} while (choose == -1);
			do {
				if (choose != 1) { //输入数量超市是否足够
					System.out.println("请输入超市中物品存在的数量！");
					showCommodity();
				}
				System.out.print("请输入购买的数量：");
				payCommodityNum = scanner.nextInt();
				for (Commodity commodity : list) {
					if (commodity.getCnum() > payCommodityNum) {
						payCommodity.setCnum(payCommodityNum);
						choose = 2;
					}
				}
			} while (choose == 1);
			
			listpay.add(payCommodity);
			System.out.print("是否继续选购：（y-继续 ）");
			payNext =scanner.nextLine();
		} while (!payNext.equals("y"));
		
		double sum = 0;
		double allSum =0;
		
		//输出选购的物品及价格
		System.out.println("\t欢迎使用丰翼超市管理系统" + "\t" + user.getUserName());
		System.out.println("**********************************");
		System.out.print("名称\t");
		System.out.print("数量\t");
		System.out.print("单价\t");
		System.out.println("合计\t");
		for (Commodity paCommodity: listpay) {
			sum =paCommodity.getCnum() * paCommodity.getCprice();
			System.out.print(paCommodity.getCname() + "\t");
			System.out.print(paCommodity.getCnum() + "\t");
			System.out.print(paCommodity.getCprice() + "\t");
			System.out.print( sum+ "\t");
			System.out.println();
			allSum=allSum+sum;
		}
		System.out.println("===================================");
		System.out.println("合计：\t\t\t"+allSum);
	}

}
