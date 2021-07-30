package luminous.StudentForum.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class WebSecurityConfigaration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
   
    @Autowired
    private AuthenticationSuccessWithSessionHandler successHandler;

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
        .antMatchers("/student/**").hasAnyAuthority("ROLE_STUDENT")
        .antMatchers("/moderator/**").hasAnyAuthority("ROLE_MODERATOR")
        .antMatchers("/post/create")
        .authenticated()
        .anyRequest()
        .permitAll()
                .and()
                .formLogin().loginPage("/login").usernameParameter("username").defaultSuccessUrl("/").successHandler(successHandler)
                .and()
                .logout().invalidateHttpSession(true).clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll();
        // .httpBasic();

        // .antMatchers("/student/**").hasAnyAuthority("STUDENT")
    }

    //////--------------Decrypt password during login
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
