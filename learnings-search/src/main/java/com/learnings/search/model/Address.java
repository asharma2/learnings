package com.learnings.search.model;

import org.springframework.data.elasticsearch.annotations.GeoPointField;

import lombok.Data;

@Data
public class Address {

	private String city;
	private String street;
	private String pincode;
	@GeoPointField
	private Point point;
}
