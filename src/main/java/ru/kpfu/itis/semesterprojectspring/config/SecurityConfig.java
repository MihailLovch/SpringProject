package ru.kpfu.itis.semesterprojectspring.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.kpfu.itis.semesterprojectspring.security.SuccessHandler;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http, SuccessHandler successHandler) throws Exception {
        return http.authorizeHttpRequests()
                .requestMatchers("/profile/**","/dashboard").authenticated()
                .requestMatchers("/api/recipes/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login").successHandler(successHandler).failureUrl("/login?error=true")
                .usernameParameter("email").passwordParameter("password").defaultSuccessUrl("/profile")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/home")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().build();
    }
}
