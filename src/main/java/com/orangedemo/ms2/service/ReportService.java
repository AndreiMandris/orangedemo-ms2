package com.orangedemo.ms2.service;

import com.orangedemo.ms2.dto.FullReport;

public interface ReportService {
    FullReport getReportByCnp(String cnp);
}
