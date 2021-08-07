package luminous.StudentForum.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import luminous.StudentForum.model.Vote;
import luminous.StudentForum.repository.PostRepository;
import luminous.StudentForum.repository.UserRepository;
import luminous.StudentForum.repository.VoteRepository;

@Controller
public class VoteController {
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private VoteRepository voteRepo;

    @GetMapping("/vote/create/{postid}/{username}/{state}")
    public String CommentCreate(@PathVariable("postid") int postid, @PathVariable("username") String username, @PathVariable("state") int state, HttpSession session) {
        System.out.println("Called up vote");
        if (session.getAttribute("sessUsername") != null) {
            if(voteRepo.findByFkUserAndFkPost(username,postid)==null){
                voteRepo.save(new Vote(postid, username, state));
                System.out.println("Vote saved");
            }else{
                voteRepo.delete(voteRepo.findByFkUserAndFkPost(username,postid)); 
                System.out.println("Vote deleted");
                voteRepo.save(new Vote(postid, username, state));
                System.out.println("Vote new saved");
                }
            }else{
            System.out.println("Session not found");
            return "redirect:/login";

        }
        return "redirect:/";
    }

}
