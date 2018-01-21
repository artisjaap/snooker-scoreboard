package be.qnh.gertronic.snooker.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {



    @Override
    public JwtUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return JwtUser.newBuilder().withUsername(username).build();


    }




}
