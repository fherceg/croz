package App.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager usersDatabase = new InMemoryUserDetailsManager();
        usersDatabase.createUser(User.withDefaultPasswordEncoder().username("croz").password("croz").roles("USER").build());
        usersDatabase.createUser(User.withDefaultPasswordEncoder().username("test1").password("croz1").roles("USER").build());
        usersDatabase.createUser(User.withDefaultPasswordEncoder().username("test2").password("croz2").roles("USER").build());
        usersDatabase.createUser(User.withDefaultPasswordEncoder().username("test3").password("croz3").roles("USER").build());
        return usersDatabase;
    }
}