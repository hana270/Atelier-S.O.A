package projet.spring.service;

import projet.spring.entities.Role;
import projet.spring.entities.User;
import java.util.*;


public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	
	List<User> findAllUsers();
}
