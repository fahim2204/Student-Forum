package luminous.StudentForum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import luminous.StudentForum.model.View;

public interface ViewRepository extends JpaRepository<View, Integer> {
    View findByFkUserAndFkPost(int u, int p);
}
