package com.cooksys.model;

import java.util.Date;

public class HitsReq {
	
	long hitRegion;
	Date timestamp;
	
	public long getHitRegion() {
		return hitRegion;
	}
	public void setHitRegion(Integer hitRegion) {
		this.hitRegion = hitRegion;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public HitsReq(long l, Date timestamp) {
		super();
		this.hitRegion = l;
		this.timestamp = timestamp;
	}
	public HitsReq() {
		super();
	}
	
}
