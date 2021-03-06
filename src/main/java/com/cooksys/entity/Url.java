package com.cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "urls")
public class Url {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "hit_region")
	private Hits urlHits;

	public Url(long id, String url, String label, String description, Hits urlHits) {
		super();
		this.id = id;
		this.url = url;
		this.label = label;
		this.description = description;
		this.urlHits = urlHits;
	}

	public Url() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Hits getUrlHits() {
		return urlHits;
	}

	public void setUrlHits(Hits urlHits) {
		this.urlHits = urlHits;
	}
	
}
