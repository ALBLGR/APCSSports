package backlogics;

import java.util.*;

public class Student {

	private String name;
	private String id;
	private List<Order> stack;
	private String mobile;
	private int credit;
	private String gender;
	private String org;
	
	Student(String name, String mobile, String gender, String org, String id){
		this.name = name;
		this.mobile = mobile;
		this.credit = 100;
		this.gender = gender;
		this.org = org; //or to say, grade & class
		this.id = id;
		stack = new ArrayList<Order>();  // the orders the student is holding
	}
	
	public boolean modifyCredit(int num){
		if (credit < 0)		//credit can only be >0
			return false;
		credit -= num;
		return true;
	}
	
	public int getCredit(){
		return credit;
	}
	
	public List<Order> getStack(){
		return stack;
	}
	
	public String getId(){
		return id;
	}
	
        @Override
	public String toString(){
		return "Name:"+ name + "\tGender:"+ gender +"\tMobile:" + mobile + "\tOrganization:" + org + "\tCredit:" + credit;
	}
}
