package edu.home.service;

import edu.home.model.Account;
import edu.home.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username){
        try {
            Account account = accountService.findById(username);
            System.out.println("Username: " + account.getUsername());
            System.out.println("Password: " + account.getPassword());

            //Create userDetail from account
            String password = account.getPassword();
            String[] roles = account.getAuthorities().stream()
                    .map(a -> a.getRole().getId())
                    .collect(Collectors.toList()).toArray(new String[0]);
            return User.withUsername(username)
                    .password(passwordEncoder.encode(password))
                    .roles(roles).build();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception Username 3: " +username);
            throw new UsernameNotFoundException(username + "not found!");
        }
    }
}
