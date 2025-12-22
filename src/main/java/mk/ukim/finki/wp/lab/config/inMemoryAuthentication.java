package mk.ukim.finki.wp.lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class inMemoryAuthentication {

    private final PasswordEncoder passwordEncoder;

    public inMemoryAuthentication(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/listChefs", "/dishes", "/assets/**")
                        .permitAll()
                        .requestMatchers("/dishes/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .formLogin( form -> form
                        .defaultSuccessUrl("/dishes", true)
                )
        ;

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails adminUser = User.builder()
                .username("aleksandar.b")
                .password(passwordEncoder.encode("ab"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(adminUser);
    }
}
