package luminous.StudentForum.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import luminous.StudentForum.service.UserService;

@Service
public class AuthenticationSuccessWithSessionHandler extends SavedRequestAwareAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler {

    @Autowired
    UserService userService;

    @Autowired
    private HttpSession session;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    // ** This method is called from WebSeciurityConfigaration after succesfull login
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        super.onAuthenticationSuccess(request, response, authentication);
        // System.out.println("yeah i am called ++++++");
        // * Save User details into session for further use
        session.setAttribute("sessName", userService.GetLoggedUser().getName());
        session.setAttribute("sessUsername", userService.GetLoggedUser().getUsername());
        session.setAttribute("sessType", userService.GetLoggedUser().getType());
        session.setAttribute("sessStatus", userService.GetLoggedUser().getStatus());
    }

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    //*  --------------- For redirect user to their roled page after login 
    protected String determineTargetUrl(final Authentication authentication) {

        Map<String, String> roleTargetUrlMap = new HashMap<>();
        roleTargetUrlMap.put("ROLE_STUDENT", "/student");
        roleTargetUrlMap.put("ROLE_ADMIN", "/admin");
        roleTargetUrlMap.put("ROLE_MODERATOR", "/moderator");

        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (final GrantedAuthority grantedAuthority : authorities) {
            String authorityName = grantedAuthority.getAuthority();
            if (roleTargetUrlMap.containsKey(authorityName)) {
                return roleTargetUrlMap.get(authorityName);
            }
        }

        throw new IllegalStateException();
    }
}
