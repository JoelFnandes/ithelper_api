package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.ufrn.imd.ITHelper.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByLogin(username);
    }

}
