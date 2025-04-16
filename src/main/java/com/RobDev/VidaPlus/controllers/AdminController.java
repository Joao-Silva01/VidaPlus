package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.administrator.AdminRequest;
import com.RobDev.VidaPlus.dto.administrator.AdminResponse;
import com.RobDev.VidaPlus.dto.administrator.UpdateAdminRequest;
import com.RobDev.VidaPlus.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdministratorService adminService;

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<AdminResponse> findById(@PathVariable long id){
        return ResponseEntity.ok().body(adminService.getAdmin(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('MAIN_ADMIN')")
    public ResponseEntity<?> create(@RequestBody AdminRequest request){
        adminService.create(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody UpdateAdminRequest request){
        adminService.update(id, request);
        return ResponseEntity.ok().build();
    }

}
