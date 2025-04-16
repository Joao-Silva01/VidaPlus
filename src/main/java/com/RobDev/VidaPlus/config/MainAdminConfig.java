package com.RobDev.VidaPlus.config;

import com.RobDev.VidaPlus.entities.Administrator;
import com.RobDev.VidaPlus.entities.enums.UserRole;
import com.RobDev.VidaPlus.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MainAdminConfig implements CommandLineRunner {

    @Autowired
    private AdministratorRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {


            Administrator main_admin = new Administrator();

            main_admin.setName("MAIN_ADMIN");
            main_admin.setEmail("jnete2004@gmail.com");
            main_admin.setPassword(bCryptPasswordEncoder.encode("main_admin_password"));
            main_admin.setRole(UserRole.MAIN_ADMIN);

            adminRepository.save(main_admin);

    }
}
