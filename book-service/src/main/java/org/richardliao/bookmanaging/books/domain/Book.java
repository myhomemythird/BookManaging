package org.richardliao.bookmanaging.books.domain;

public class Book {
    private String id;
    private String title;
    private String auth;
    private String description;

    public Book() {}
    
    public Book(String id, String title, String auth, String description) {
	this.id = id;
	this.title = title;
	this.auth = auth;
	this.description = description;
    }

    public String getId() {
	return this.id;
    }

    public String getTitle() {
	return this.title;
    }

    public String getAuth() {
	return this.auth;
    }

    public String getDescription() {
	return this.description;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Book [");
	sb.append("id=").append(this.id).append(",");
	sb.append("title=").append(this.title).append(",");
	sb.append("auth=").append(this.auth).append(",");
	sb.append("description=").append(this.description);
	sb.append("]");
	return sb.toString();
    }
}
