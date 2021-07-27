package luminous.StudentForum.service;

import luminous.StudentForum.model.User;
import luminous.StudentForum.model.UserPrincipal;
import luminous.StudentForum.repository.UserRepository;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    

    private User user;
    
    ///--------For login credentials checking
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found!!");
        }
        // session.setAttribute("fname",user.getName());
        // System.out.println("I am from user service");
        return new UserPrincipal(user);
    }
   

    public boolean userExists(String username) {
        return  userRepo.findByUsername(username) != null ? true : false;
    }

    ///---------- Saving the user registration
    public void save(User user) {
        encodePassword(user);
        userRepo.save(user);
    }

    public User GetLoggedUser(){
        return user;
    }

    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

}
