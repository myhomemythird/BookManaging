package org.richardliao.bookmanaging.books.domain;

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
}
