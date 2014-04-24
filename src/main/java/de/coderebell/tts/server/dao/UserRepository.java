package de.coderebell.tts.server.dao;

import de.coderebell.tts.client.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by MALPI on 24.04.2014.
 */
public interface UserRepository extends JpaRepository<User, String> {
    @Query("Select u from User u where u.email = ?1")
    public User findUserByEmail(String email);
}
