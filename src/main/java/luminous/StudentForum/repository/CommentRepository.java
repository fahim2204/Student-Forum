package luminous.StudentForum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import luminous.StudentForum.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByFrPostOrderByCreatedAtDesc(int p);
}
