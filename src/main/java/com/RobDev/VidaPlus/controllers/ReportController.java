package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.report.ReportRequest;
import com.RobDev.VidaPlus.dto.report.ReportResponse;
import com.RobDev.VidaPlus.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public ResponseEntity<List<ReportResponse>> getAllReports(){
        return ResponseEntity.ok().body(reportService.getAllReports());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReportResponse> getReport(@PathVariable long id){
        return ResponseEntity.ok().body(reportService.getReport(id));
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<ReportResponse> create(@PathVariable long id, @RequestBody(required = false) ReportRequest request){
        return ResponseEntity.ok().body(reportService.create(id, request));
    }
}
