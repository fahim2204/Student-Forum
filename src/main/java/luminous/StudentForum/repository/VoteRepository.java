package luminous.StudentForum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import luminous.StudentForum.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    Vote findByFkPost(int post);
    Vote findByFkUser(String username);
}
