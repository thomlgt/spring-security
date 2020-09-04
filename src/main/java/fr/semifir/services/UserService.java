package fr.semifir.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.semifir.models.User;
import fr.semifir.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	public Iterable<User> trouverTout() {
		return this.repository.findAll();
	}

	public Optional<User> trouverParId(String id) {
		return this.repository.findById(id);
	}

	public void ajouter(User user) {
		this.repository.save(user);
	}

	public void supprimer(User user) {
		this.repository.delete(user);
	}
	
	@Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        User user = this.repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return user;
    }
}
