package luminous.StudentForum.repository;

import java.util.Collection;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import luminous.StudentForum.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {   

   Post findById(int id);

   // @Query(value="SELECT username, cname, pbody, title, created_at, (SELECT COUNT(id) FROM views WHERE fk_post=p.id) AS views, (SELECT COUNT(id) FROM comments WHERE fr_post=p.id) AS comments, p.id FROM posts as p JOIN categories as c ON p.fk_category_id=c.id JOIN users as u ON p.fk_user_id = u.id ORDER BY p.created_at DESC LIMIT 6", nativeQuery = true)
   // public Collection getAllPostDetails();
   @Query(value="SELECT * FROM postdetails where status=1 LIMIT 6", nativeQuery = true)
   public Collection getAllPostDetails();
   
   // @Query(value="SELECT username, cname, pbody, title, created_at, (SELECT COUNT(id) FROM views WHERE fk_post=p.id) AS views, (SELECT COUNT(id) FROM comments WHERE fr_post=p.id) AS comments, p.id FROM posts as p JOIN categories as c ON p.fk_category_id=c.id JOIN users as u ON p.fk_user_id = u.id", nativeQuery = true)
   @Query(value="SELECT * FROM postdetails where status=1", nativeQuery = true)
   public Page<Collection> getAllPostDetailsPagination(Pageable pageable);

   @Query(value="SELECT * FROM postdetails", nativeQuery = true)
   public Collection getAllPostDetailsNoLimit();

   @Query(value="SELECT * FROM postdetails WHERE cname=?1 AND status=1", nativeQuery = true)
   public Page<Collection> getCategoryPostDetailsPagination(String cat,Pageable pageable);

   @Query(value="SELECT * FROM postdetails WHERE title LIKE %?1% AND status=1", nativeQuery = true)
   public Page<Collection> getBySearchPostDetailsPagination(String shrc,Pageable pageable);

   @Query(value="SELECT * FROM postdetails WHERE title LIKE '%?1%' AND status=1", nativeQuery = true)
   public Collection getBySearchPostDetails(String shrc);

   @Query(value="SELECT * FROM postdetails WHERE username=?1", nativeQuery = true)
   public Collection getUserPostDetails(String username);


   @Query(value="SELECT username, cname, pbody, title, created_at, (SELECT COUNT(id) FROM views WHERE fk_post=p.id) AS views, (SELECT COUNT(id) FROM comments WHERE fr_post=p.id) AS comments, p.id FROM posts as p JOIN categories as c ON p.fk_category_id=c.id JOIN users as u ON p.fk_user_id = u.id WHERE p.id=?2 AND c.cname=?1", nativeQuery = true)
   public Collection getAllPostDetailsByID(String cat,int id);

   @Query(value="SELECT username, cname, pbody, title, created_at, (SELECT COUNT(id) FROM views WHERE fk_post=p.id) AS views, (SELECT COUNT(id) FROM comments WHERE fr_post=p.id) AS comments, p.id FROM posts as p JOIN categories as c ON p.fk_category_id=c.id JOIN users as u ON p.fk_user_id = u.id WHERE p.id=?1", nativeQuery = true)
   public Collection getAllPostDetailsByID(int id);


}
