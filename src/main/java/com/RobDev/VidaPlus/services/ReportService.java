package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.report.ReportRequest;
import com.RobDev.VidaPlus.dto.report.ReportResponse;
import com.RobDev.VidaPlus.entities.Administrator;
import com.RobDev.VidaPlus.entities.Report;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.mapper.ReportMapper;
import com.RobDev.VidaPlus.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private AdministratorRepository adminRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private HospitalAdmissionRepository haRepository;

    @Autowired
    private MedicalExaminationRepository examRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private ReportMapper reportMapper;

    public List<ReportResponse> getAllReports() {
        return reportMapper.toListResponse(
                reportRepository.findAll()
        );
    }

    public ReportResponse getReport(long id) {
        return reportMapper.toResponse(
                reportRepository.findById(id)
                        .orElseThrow(
                                () -> new IdNotFoundException("Report not found")
                        )
        );
    }

    public SucessResponse create(long adminId, ReportRequest request) {
        Administrator admin = adminRepository.findById(adminId)
                .orElseThrow(
                        () -> new IdNotFoundException("Report not found for creation")
                );

        Report report = new Report();
        report.setNumberQueries(consultationRepository.allQueries());
        report.setNumberHospitalization(haRepository.allHospitalizations());
        report.setNumberExams(examRepository.allExams());
        report.setNumberPrescriptions(prescriptionRepository.allPrescriptions());
        report.setGenerationDate(LocalDateTime.now());

        if (request != null) {
                report.setObservation(request.getObservation());
        }

        // somando o faturamento pro relatório
        BigDecimal invoicing = examRepository.totalValue().add(consultationRepository.totalValue()).add(haRepository.totalValue());
        report.setInvoicing(invoicing);

        report.setAdmin(admin);

        reportRepository.save(report);
        return new SucessResponse("Report created successfully");
    }
}
