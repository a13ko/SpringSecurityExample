package com.ali.springsecurityexample.util;

import com.ali.springsecurityexample.model.Role;
import com.ali.springsecurityexample.model.User;
import com.ali.springsecurityexample.repository.RoleRepository;
import com.ali.springsecurityexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoad implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role roleAdmin = Role.builder().id(1L).roleName("ROLE_ADMIN").build();
        Role roleUser = Role.builder().id(2L).roleName("ROLE_USER").build();
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        List<Role> adminRoleList = new ArrayList<>();
        adminRoleList.add(roleAdmin);

        User admin = User.builder().id(3L).username("Elizamin").password("12345").roles(adminRoleList).build();
        userRepository.save(admin);


        List<Role> userRoleList = new ArrayList<>();
        userRoleList.add(roleUser);

        User user = User.builder().id(4L).username("Rufet").password("12345").roles(userRoleList).build();
        userRepository.save(user);

        System.out.println("-- Roles --");
        roleRepository.findAll().forEach(System.out::println);
        System.out.println("-- User --");
        userRepository.findAll().forEach(System.out::println);

    }
}
