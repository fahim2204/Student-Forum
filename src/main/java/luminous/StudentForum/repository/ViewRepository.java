package luminous.StudentForum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import luminous.StudentForum.model.View;

public interface ViewRepository extends JpaRepository<View, Integer> {
    View findByFkUserAndFkPost(int u, int p);
    View findByFkPost(int p);
    // @Query(value = "DELETE FROM `views` WHERE fk_post = ?1", nativeQuery = true)
    // void deleteByFkPost(int p);
}
