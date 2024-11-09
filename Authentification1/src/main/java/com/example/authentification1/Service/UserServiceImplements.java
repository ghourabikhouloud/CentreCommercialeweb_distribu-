package com.example.authentification1.Service;

import com.example.authentification1.Repos.IUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImplements implements IUserService {
    private final IUserRepo iUserRepo ;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return iUserRepo.findByEmail(username).orElseThrow(()->new RuntimeException("utilisateur non trouvé"));
            }
        };
    }
}
