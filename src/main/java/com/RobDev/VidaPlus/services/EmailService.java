package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.notification.NotificationRequest;
import com.RobDev.VidaPlus.entities.Notification;
import com.RobDev.VidaPlus.entities.Patient;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.mapper.NotificationMapper;
import com.RobDev.VidaPlus.repositories.NotificationRepository;
import com.RobDev.VidaPlus.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationMapper notificationMapper;

    @Value("spring.mail.username")
    private String sender;

    public void sendEmail(long patientId,NotificationRequest request){

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IdNotFoundException("Patient not found for sending email"));

        Notification email = notificationMapper.toRequest(request);
        email.setPatient(patient);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(patient.getEmail());
        simpleMailMessage.setSubject(email.getTitle());
        simpleMailMessage.setText(email.getMessage());

        javaMailSender.send(simpleMailMessage);

        notificationRepository.save(email);

    }

}
