package com.Mark1.Urvashi.Service;

import com.Mark1.Urvashi.db1Dao.ReportCardPOJO;

import java.util.List;

public interface ReportCardService {

    public double getMarksBySubject(int rollNo, String subject);
    public List<ReportCardPOJO> getMarksBOfAllStudents();
    public ReportCardPOJO getReportCard(int rollNo);
    public void saveReportCard(ReportCardPOJO reportCardPOJO);
    public void deleteReportCard(int rollNo);
}


