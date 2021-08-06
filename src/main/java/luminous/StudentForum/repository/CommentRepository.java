package luminous.StudentForum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import luminous.StudentForum.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByFrPostOrderByCreatedAtDesc(int p);
    @Query(value="select count(*) from comments", nativeQuery = true)
    public String countComment();
}
