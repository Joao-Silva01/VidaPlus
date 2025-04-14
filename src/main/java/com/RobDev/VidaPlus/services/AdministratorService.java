package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.administrator.AdminRequest;
import com.RobDev.VidaPlus.dto.administrator.AdminResponse;
import com.RobDev.VidaPlus.dto.administrator.UpdateAdminRequest;
import com.RobDev.VidaPlus.entities.Administrator;
import com.RobDev.VidaPlus.entities.enums.UserRole;
import com.RobDev.VidaPlus.mapper.AdministratorMapper;
import com.RobDev.VidaPlus.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository adminRepository;

    @Autowired
    private AdministratorMapper adminMapper;

    public AdminResponse getAdmin(long id){
        Administrator admin = adminRepository.findById(id).orElseThrow();
        return adminMapper.toResponse(admin);
    }

    public void create(AdminRequest request){
        Administrator newAdmin = adminMapper.toRequest(request);
        newAdmin.setRole(UserRole.ADMINISTRATOR);
        adminRepository.save(newAdmin);
    }

    public void update(long id,UpdateAdminRequest request){
        Administrator admin = adminRepository.findById(id).orElseThrow();

        adminMapper.toUpdateRequest(request,admin);

        adminRepository.save(admin);
    }
}
