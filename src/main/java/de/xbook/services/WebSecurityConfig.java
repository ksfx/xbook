package de.xbook.services;


import de.xbook.services.user.XbookUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, XbookUserDetailsService xbookUserDetailsService) throws Exception
    {
        auth.authenticationProvider(authenticationProvider(xbookUserDetailsService));
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(XbookUserDetailsService xbookUserDetailsService)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println("Encrypted Password: " + encoder.encode("12345"));

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(xbookUserDetailsService);
        authProvider.setPasswordEncoder(encoder);

        return authProvider;
    }
}
