package com.capg.fms.entity;


import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User
{

	@Id  
	 @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userId_Sequence")
    @SequenceGenerator(name="userId_Sequence", sequenceName="USERID_SEQ")
	
	@Column(name="user_Id")
	private long userId;
	
	@Column(name="user_Age")
	private int userAge;
	
	@Column(name="user_Name")
	private String userName;
	
	@Column(name="user_Password")
	private String userPassword;
	
	@Column(name="user_Phone")
	private long userPhone;
	
	@Column(name="user_Email")
	private String userEmail;

	
    public User() {
		super();
		
	}
    
    public User(int userId, int userAge, String userName, String userPassword, long userPhone,
			String userEmail) {
		super();
		this.userId = userId;
		this.userAge = userAge;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}
    public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getUserAge() {
		return userAge;
	}
	public void setUseAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
