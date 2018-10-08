package sj.bean;

import java.io.Serializable;
import java.sql.Date;


public class MemberBean implements Serializable{

	private int id;
	private String name;
	private String address;
	private String tel;
	private String email;
	private Date birthday;
	private Date admission;
	private Date unsubscribe;
	private String remarks;



	public MemberBean() {
		super();

	}

	public MemberBean(int id, String name, String address, String tel, String email, Date birthday, Date admission,
			Date unsubscribe, String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birthday = birthday;
		this.admission = admission;
		this.unsubscribe = unsubscribe;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getAdmission() {
		return admission;
	}

	public void setAdmission(Date admission) {
		this.admission = admission;
	}

	public Date getUnsubscribe() {
		return unsubscribe;
	}

	public void setUnsubscribe(Date unsubscribe) {
		this.unsubscribe = unsubscribe;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
