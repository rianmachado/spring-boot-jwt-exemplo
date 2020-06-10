package br.com.pitang.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.pitang.desafio.entities.User;


/**
 * @author rianmachado@gmail.com * 
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("FROM User u WHERE u.email = ?1 and u.password = ?2")	
	public Optional<User> findByEmailEndPassword(String email, String password);
	
	@Query("FROM User u WHERE u.email = ?1")
	public Optional<User> findByEmail(String email);

}