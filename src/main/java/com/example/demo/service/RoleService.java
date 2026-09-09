package com.example.demo.service;


import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role){
        roleRepository.save(role);
    }

}
