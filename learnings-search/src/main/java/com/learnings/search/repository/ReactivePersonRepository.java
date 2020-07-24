package com.learnings.search.repository;

import org.reactivestreams.Publisher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import com.learnings.search.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactivePersonRepository extends ReactiveSortingRepository<Person, String> {

	Flux<Person> findByFirstname(String firstname);

	Flux<Person> findByFirstname(Publisher<String> firstname);

	Flux<Person> findByFirstnameOrderByLastname(String firstname);

	Flux<Person> findByFirstname(String firstname, Sort sort);

	Flux<Person> findByFirstname(String firstname, Pageable page);

	Mono<Person> findByFirstnameAndLastname(String firstname, String lastname);

	Mono<Person> findFirstByLastname(String lastname);

	@Query("{ \"bool\" : { \"must\" : { \"term\" : { \"lastname\" : \"?0\" } } } }")
	Flux<Person> findByLastname(String lastname);

	Mono<Long> countByFirstname(String firstname);

	Mono<Boolean> existsByFirstname(String firstname);

	Mono<Long> deleteByFirstname(String firstname);
}
