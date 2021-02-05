package com.codegym.createcart.service.impl;

import com.codegym.createcart.model.MyUserDetail;
import com.codegym.createcart.model.User;
import com.codegym.createcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;

@Service
@Transactional
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user  = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("username not found: " + username);
        }
        return new MyUserDetail(user);
    }
}
