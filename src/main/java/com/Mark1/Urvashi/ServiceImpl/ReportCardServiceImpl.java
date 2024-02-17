package com.Mark1.Urvashi.ServiceImpl;

import com.Mark1.Urvashi.db1Dao.ReportCardPOJO;

import com.Mark1.Urvashi.db1Repository.ReportCardRepository;
import com.Mark1.Urvashi.Service.ReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportCardServiceImpl implements ReportCardService {

    @Autowired
    private ReportCardRepository reportCardRepository;

    public ReportCardServiceImpl(ReportCardRepository reportCardRepository) {
        this.reportCardRepository = reportCardRepository;
    }

    @Override
    public double getMarksBySubject(int rollNo, String subject) {
        Optional<ReportCardPOJO> report=reportCardRepository.findById(rollNo);
        return report.isPresent()?report.get().getEnglish():null;
    }

    @Override
    public List<ReportCardPOJO> getMarksBOfAllStudents() {
        List<ReportCardPOJO> report= (List<ReportCardPOJO>) reportCardRepository.findAll();
        return report;
    }

    @Override
    public ReportCardPOJO getReportCard(int rollNo) {
        return null;
    }

    @Override
    public void saveReportCard(ReportCardPOJO reportCardPOJO) {

    }

    @Override
    public void deleteReportCard(int rollNo) {

    }
}


