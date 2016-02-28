package com.shadowaterservices.thehub.data.entities;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	@Lob
	@Column(columnDefinition = "text")
	private String body;

	private String uri;
	
	@Column(name = "DATETIME_FIELD")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar publishDate;
	
	private Post() {};
	
	public Post(String title, String body, String uri, Calendar publishDate) {
		this.setTitle(title);
		this.setBody(body);
		this.setUri(uri);
		this.setPublishDate(publishDate);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Calendar getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Calendar publishDate) {
		this.publishDate = publishDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
