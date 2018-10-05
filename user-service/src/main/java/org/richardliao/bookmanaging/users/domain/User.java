package org.richardliao.bookmanaging.users.domain;

public class User {
    private String id;
    private String account;
    private String password;
    private String roleId;

    public User(String id, String account, String password, String roleId) {
	this.id = id;
	this.account = account;
	this.password = password;
	this.roleId = roleId;
    }

    public String getId() {
	return this.id;
    }

    public String getAccount() {
	return this.account;
    }

    public String getPassword() {
	return this.password;
    }

    public String getRoleId() {
	return this.roleId;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("User [");
	sb.append("id=").append(this.id).append(",");
	sb.append("account=").append(this.account).append(",");
	sb.append("password=").append(this.password).append(",");
	sb.append("roleId=").append(this.roleId);
	sb.append("]");
	return sb.toString();
    }
}
