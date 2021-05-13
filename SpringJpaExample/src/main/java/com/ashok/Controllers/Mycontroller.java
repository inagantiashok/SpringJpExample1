package com.ashok.Controllers;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ashok.Exceptions.NESLException;
import com.ashok.Repository.EntityRepository;
import com.ashok.Repository.RolesRepository;
import com.ashok.entity.Posts;
import com.ashok.entity.Roles;

@RestController
public class Mycontroller {
	@Autowired
	private EntityRepository repo;
	
	

	@Autowired
	private RolesRepository roleRepo;

	@GetMapping(path = "/show")
	String show() throws NESLException {
		String rolesdata = null;
		rolesdata = repo.getRolesdata1();
		
		return rolesdata;
	}

	@GetMapping(path = "/show1")
	String show1() {
		Iterable<Roles> findAll = roleRepo.findAll();
		// Optional<List<Roles>> findAll2 = Optional.of(roleRepo.findAll());
		Stream<Roles> stream = StreamSupport.stream(findAll.spliterator(), false);
		return "true";

	}
	@GetMapping(path = "/show2")
	String show2() {
		String url="https://jsonplaceholder.typicode.com/posts/1";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Posts> forEntity = restTemplate.getForEntity(url, Posts.class);
		System.out.println(forEntity);
		return "true";

	}

}
