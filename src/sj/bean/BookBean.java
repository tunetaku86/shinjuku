package sj.bean;

import java.io.Serializable;
import java.sql.Date;

public class BookBean implements Serializable {

	private String isbn;
	private String name;
	private int catcode;
	private String author;
	private String publisher;
	private Date pubdate;
	private String coverurl;

	public BookBean() {
		super();
	}

	public BookBean(String isbn, String name, int catcode, String author, String publisher, Date pubdate,
			String coverurl) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.catcode = catcode;
		this.author = author;
		this.publisher = publisher;
		this.pubdate = pubdate;
		this.coverurl = coverurl;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCatcode() {
		return catcode;
	}

	public void setCatcode(int catcode) {
		this.catcode = catcode;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public String getCoverurl() {
		return coverurl;
	}

	public void setCoverurl(String coverurl) {
		this.coverurl = coverurl;
	}




}
