package com.cooksys.entity;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hits")
public class Hits {
	
	//SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="hitRegion")
	private long hitRegion;
	
	@Column(name="timestamp")
	private Date timestamp;
	
	@Column(name="hit_count")
	private long hitCount;
	
	public Hits() {
		super();
	}

	public Hits(long hitRegion, Date date, long hitCount) {
		super();
		this.hitRegion = hitRegion;
		this.timestamp = date;
		this.hitCount = hitCount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getHitRegion() {
		return hitRegion;
	}

	public void setHitRegion(int hitRegion) {
		this.hitRegion = hitRegion;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public long getHitCount() {
		return hitCount;
	}

	public void setHitCount(long hitCount) {
		this.hitCount = hitCount;
	}

	public void setHitRegion(long hitRegion) {
		this.hitRegion = hitRegion;
	}
	
	
	
}
