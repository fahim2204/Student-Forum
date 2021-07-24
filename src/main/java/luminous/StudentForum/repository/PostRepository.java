package luminous.StudentForum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import luminous.StudentForum.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Short> {
}
