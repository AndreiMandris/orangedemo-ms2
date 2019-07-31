package com.orangedemo.ms2.controller;

import com.orangedemo.ms2.dto.FullReport;
import com.orangedemo.ms2.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    @GetMapping("/{cnp}")
    public FullReport getReport(@PathVariable String cnp) {
        return reportService.getReportByCnp(cnp);
    }
}
