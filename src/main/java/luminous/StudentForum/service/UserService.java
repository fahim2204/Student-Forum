package luminous.StudentForum.service;

import luminous.StudentForum.model.User;
import luminous.StudentForum.model.UserPrincipal;
import luminous.StudentForum.repository.UserRepository;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found!!");
        }
        return new UserPrincipal(user);
    }

    public boolean userExists(String username) {
        System.out.println("+++++++");
        System.out.println("+++++++");
        System.out.println(userRepo.findByUsername(username).getUsername());
        System.out.println("+++++++");
        System.out.println("+++++++");
        System.out.println("+++++++");
        if (userRepo.findByUsername(username).getUsername() == null) {
        // if (userRepo.findByUsername(username).getUsername().isPresent()) {
            return true;
        } else {
            return false;
        }
        // return findByUsername(username).isPresent();
    }

    public void save(User user) {
        encodePassword(user);
        userRepo.save(user);
    }

    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

}
