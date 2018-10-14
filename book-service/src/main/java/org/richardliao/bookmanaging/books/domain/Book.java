package org.richardliao.bookmanaging.books.domain;

import java.util.Date;

public class Book {
    private String id;
    private String title;
    private String auth;
    private String description;
    private String publishDate;
    private String addingDate;

    public Book() {}
    
    public Book(String id, String title, String auth, String description) {
	this.id = id;
	this.title = title;
	this.auth = auth;
	this.description = description;
    }

    public void setId(String id) {
	this.id = id;
    }
    
    public String getId() {
	return this.id;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getTitle() {
	return this.title;
    }

    public void setAuth(String auth) {
	this.auth = auth;
    }

    public String getAuth() {
	return this.auth;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getDescription() {
	return this.description;
    }

    public void setPublishDate(String publishDate) {
	this.publishDate = publishDate;
    }

    public String getPublishDate() {
	return this.publishDate;
    }

    public void setAddingDate(String addingDate) {
	this.addingDate = addingDate;
    }

    public String getAddingDate() {
	return this.addingDate;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Book [");
	sb.append("id=").append(this.id).append(",");
	sb.append("title=").append(this.title).append(",");
	sb.append("auth=").append(this.auth).append(",");
	sb.append("description=").append(this.description);
	sb.append("publishDate=").append(this.publishDate);
	sb.append("addingDate=").append(this.addingDate);
	sb.append("]");
	return sb.toString();
    }
}
