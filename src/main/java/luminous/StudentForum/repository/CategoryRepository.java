package luminous.StudentForum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import luminous.StudentForum.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByCname(String cname);
}
