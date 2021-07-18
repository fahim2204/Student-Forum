package luminous.StudentForum.repository;

import luminous.StudentForum.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Long> {
	
    
}
