package com.orangedemo.ms2.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FullReport {
    private final List<ReportLine> report;

    public FullReport(List<ReportLine> report) {
        this.report = cloneDeep(report);
    }

    public List<ReportLine> getReport() {
        return cloneDeep(report);
    }

    private List cloneDeep(List<ReportLine> report) {
        List toReturnList = new ArrayList<>();
        for (ReportLine line : report) {
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
