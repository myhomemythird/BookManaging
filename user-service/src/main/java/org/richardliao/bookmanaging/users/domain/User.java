package org.richardliao.bookmanaging.users.domain;

import java.util.Date;

public class User {
    private String id;
    private String account;
    private String name;
    private String address;
    private String email;
    private String password;
    private String roleId;
    private Date registerDate;

    public User() {}
    
    public User(String id, String account, String password, String roleId) {
	this.id = id;
	this.account = account;
	this.password = password;
	this.roleId = roleId;
    }

    public void setId(String id) {
	this.id = id;
    }
    
    public String getId() {
	return this.id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
	return this.account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
	return this.name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
	return this.address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
	return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
	return this.password;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
	return this.roleId;
    }

    public Date getRegisterDate() {
	return this.registerDate;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("User [");
	sb.append("id=").append(this.id).append(",");
	sb.append("account=").append(this.account).append(",");
	sb.append("name=").append(this.name).append(",");
	sb.append("address=").append(this.address).append(",");
	sb.append("email=").append(this.email).append(",");
	sb.append("password=").append(this.password).append(",");
	sb.append("roleId=").append(this.roleId).append(",");
	sb.append("registerDate=").append(this.registerDate);
	sb.append("]");
	return sb.toString();
    }
}
