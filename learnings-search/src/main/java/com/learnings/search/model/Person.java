package com.learnings.search.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "person", replicas = 1, shards = 1, refreshInterval = "5s")
public class Person {

	@Id
	String id;
	String firstname;
	String lastname;
	Address address;

}
