/**
 * 
 */
package org.edtoktay.testproject.repo;

import java.util.Optional;

import org.edtoktay.testproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author deniz.toktay
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u left join fetch u.roles r where u.username=:username")
    public Optional<User> findByUsername(@Param("username") String username);
}
