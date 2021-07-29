package luminous.StudentForum.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import luminous.StudentForum.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Short> {   

   @Query(value="SELECT username, cname, pbody, title, created_at, views FROM posts as p JOIN categories as c ON p.fk_category_id=c.id JOIN users as u ON p.fk_user_id = u.id", nativeQuery = true)
   public List<Collection> getAllPostDetails();


}
