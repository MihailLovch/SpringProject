package ru.kpfu.itis.semesterprojectspring.security;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;

import java.io.IOException;

@Component
public class SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        request.getSession().setAttribute("user",user);
        super.onAuthenticationSuccess(request,response,authentication);
    }
}
