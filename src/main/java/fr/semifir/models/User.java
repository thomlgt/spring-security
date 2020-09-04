package fr.semifir.models;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document
public class User implements Serializable , UserDetails {
    
	@Id
    private String id;
    private String username;
    private String password;
    
    
    public String getId() {
		return id;
	}
    
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUsername() {
        return username;
    }
	
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
    
    @Override
    public boolean isEnabled() {
        return false;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}