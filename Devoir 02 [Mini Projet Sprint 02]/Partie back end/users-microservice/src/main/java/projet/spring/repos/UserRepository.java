package projet.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername(String username);

}
