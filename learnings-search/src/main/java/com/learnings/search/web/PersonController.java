package com.learnings.search.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnings.search.model.Address;
import com.learnings.search.model.Person;
import com.learnings.search.model.Point;
import com.learnings.search.repository.ReactivePersonRepository;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1.0/person")
public class PersonController {

	@Autowired
	ReactivePersonRepository reactivePersonRepository;

	@PostMapping
	public Mono<Person> save(@RequestBody Person person) {
		return reactivePersonRepository.save(person);
	}

	@GetMapping("/ping")
	public Mono<Person> ping() {
		Person p = new Person();
		p.setFirstname("Atul");
		p.setLastname("Sharma");
		Address a = new Address();
		a.setCity("Noida");
		a.setPincode("201303");
		a.setStreet("Lotus Boulevard Sector 100");
		p.setAddress(a);
		Point pt = new Point();
		pt.setLat(28.5448);
		pt.setLon(77.3687);
		a.setPoint(pt);
		return Mono.just(p);
	}

}
