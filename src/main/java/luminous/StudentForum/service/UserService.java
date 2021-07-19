package luminous.StudentForum.service;


import luminous.StudentForum.model.User;
import luminous.StudentForum.repository.UserRepository;
import luminous.StudentForum.service.UserPrincipal;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrincipal(user);
    }


//    @Autowired
//    private BCryptPasswordEncoder bcryptPasswordEncoder;

//    public User findByUserName(String username){
//        return userRepository.findByUserName(username);
//    }

//    @Transactional
//    public void save(User user){
//        user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }

   

}
