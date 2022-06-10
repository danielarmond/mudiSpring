package br.com.daniel.mvc.mudi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.daniel.mvc.mudi.model.User;

@Repository
public interface UserRepository  extends CrudRepository <User, String>{

	User findByUsername(String username);
	
}
