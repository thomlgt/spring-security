package fr.semifir.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.semifir.models.User;
import fr.semifir.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping()
	public Iterable<User> findAll() {
		return this.service.trouverTout();
	}
	
	@GetMapping("/{id}")
	public Optional<User> findById(@PathVariable String id) {
		return this.service.trouverParId(id);
	}
	
	@PostMapping()
	public void save(@RequestBody User user) {
		this.service.ajouter(user);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody User user) {
		this.service.supprimer(user);
	}
}
