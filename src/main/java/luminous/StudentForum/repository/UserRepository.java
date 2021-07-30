package luminous.StudentForum.repository;

import luminous.StudentForum.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	List <User> findByName(String name);
	@Query("from User where name=?1 order by user_name")
	List <User> findByNameSortedAsc(String name);
    
}
