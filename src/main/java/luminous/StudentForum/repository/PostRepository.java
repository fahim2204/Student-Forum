package luminous.StudentForum.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import luminous.StudentForum.model.Post;
import luminous.StudentForum.model.PostDetails;
import luminous.StudentForum.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Short> {   
   // @Query("SELECT new luminous.StudentForum.model.PostDetails(c.cname, p.pbody, p.title, p.views) FROM Post p JOIN p.Category c")
   // public List<PostDetails> getAllPostDetails();
   // public String getAllPostDetails();
   @Query(value="SELECT username, cname, pbody, title, created_at, views FROM posts as p JOIN categories as c ON p.fk_category_id=c.id JOIN users as u ON p.fk_user_id = u.id", nativeQuery = true)
   public List<Collection> getAllPostDetails();
   // String getCategoryName(Post post);

   // List <Post> findById(short id);

}
