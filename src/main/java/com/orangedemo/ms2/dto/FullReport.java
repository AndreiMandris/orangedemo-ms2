package com.orangedemo.ms2.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FullReport {
    private final List<ReportLineDto> report;

    public FullReport(List<ReportLineDto> report) {
        this.report = cloneDeep(report);
    }

    public List<ReportLineDto> getReport() {
        return cloneDeep(report);
    }

    private List cloneDeep(List<ReportLineDto> report) {
        List toReturnList = new ArrayList<>();
        for (ReportLineDto line : report) {
            toReturnList.add(line.clone());
        }
        return toReturnList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullReport that = (FullReport) o;
        return Objects.equals(report, that.report);
    }

    @Override
    public int hashCode() {
        return Objects.hash(report);
    }
}
