package luminous.StudentForum.repository;

import luminous.StudentForum.model.User;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	@Query(value="SELECT username, COUNT(*) FROM posts as p JOIN users as u WHERE p.fk_user_id = u.id GROUP BY fk_user_id ORDER BY COUNT(*) DESC LIMIT 5", nativeQuery = true)
	Collection findTopUser();
	List <User> findByName(String name);
	@Query("from User where name=?1 order by user_name")
	List <User> findByNameSortedAsc(String name);

	@Query(value="select count(*) from users", nativeQuery = true)
	public String countUser();
    
}
