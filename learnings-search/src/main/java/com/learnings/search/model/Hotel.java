package com.learnings.search.model;

import lombok.Data;

@Data
public class Hotel {

	private String id;
	private String code;
	private String name;
	private Address address;
}
