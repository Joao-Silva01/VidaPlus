package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.login.LoginRequest;
import com.RobDev.VidaPlus.dto.login.LoginResponse;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.entities.Patient;
import com.RobDev.VidaPlus.entities.enums.UserRole;
import com.RobDev.VidaPlus.repositories.AdministratorRepository;
import com.RobDev.VidaPlus.repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TokenService {

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private HealthProfessionalRepository hpRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AdministratorRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginResponse login(LoginRequest request) {
        var searchHpEmail = hpRepository.findByEmail(request.getEmail());
        var searchPatientEmail = patientRepository.findByEmail(request.getEmail());
        var searchAdminEmail = adminRepository.findByEmail(request.getEmail());

        if (searchHpEmail.isEmpty() &&
                searchPatientEmail.isEmpty() &&
                searchAdminEmail.isEmpty()) {
            throw new BadCredentialsException("Email invalid");
        }

        var now = Instant.now();
        String subjectElement = null;
        UserRole scope = null;


        if (searchHpEmail.isPresent()) {
            validatePassword(request.getPassword(), searchHpEmail.get().getPassword());

            subjectElement = searchHpEmail.get().getId().toString();
            scope = searchHpEmail.get().getRole();


        } else if (searchPatientEmail.isPresent()) {
            validatePassword(request.getPassword(), searchPatientEmail.get().getPassword());

            subjectElement = searchPatientEmail.get().getId().toString();
            scope = searchPatientEmail.get().getRole();

        } else if (searchAdminEmail.isPresent()) {
            validatePassword(request.getPassword(), searchAdminEmail.get().getPassword());

            subjectElement = searchAdminEmail.get().toString();
            scope = searchAdminEmail.get().getRole();

        }


        var claims = JwtClaimsSet.builder()
                .issuer("vidaVlus")
                .subject(subjectElement)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(600))
                .claim("authorities", List.of(scope))
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponse(jwtValue);
    }

    private void validatePassword(String passwordRequest, String password) {
        if (!bCryptPasswordEncoder.matches(passwordRequest, password)) {
            throw new BadCredentialsException("Password incorrect");
        }
    }

}
