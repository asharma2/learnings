package com.learnings.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, CassandraAutoConfiguration.class,
		KafkaAutoConfiguration.class })
@EnableSwagger2
public class SearchApp {

	public static void main(String[] args) {
		SpringApplication.run(SearchApp.class, args);
	}
}
