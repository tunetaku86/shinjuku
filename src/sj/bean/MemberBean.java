package sj.bean;

import java.io.Serializable;

public class MemberBean implements Serializable{

	private String name;
	private String address;
	private String tel;
	private String email;
	private String birth;

	public MemberBean(String name, String address, String tel, String email, String birth) {
		super();
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birth = birth;
	}

	public MemberBean() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}







}
