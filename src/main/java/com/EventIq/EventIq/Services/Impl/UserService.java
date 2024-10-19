package com.EventIq.EventIq.Services.Impl;

import com.EventIq.EventIq.Entities.Organisation;
import com.EventIq.EventIq.Entities.UserTable;
import com.EventIq.EventIq.ExceptionHandlers.ResourceNotFoundException;
import com.EventIq.EventIq.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
   private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("user with email not found"));
    }

    public UserTable getUserById(UUID userId){
        return userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found"));
    }

    public void updateUserOrganisation(Organisation organisation){
        UserTable userTable1=organisation.getUser();

        userTable1.getOrganisations().add(organisation);
        userRepo.save(userTable1);
    }
}
