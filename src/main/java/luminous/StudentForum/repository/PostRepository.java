package luminous.StudentForum.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import luminous.StudentForum.model.Post;
import luminous.StudentForum.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Short> {
   
}
