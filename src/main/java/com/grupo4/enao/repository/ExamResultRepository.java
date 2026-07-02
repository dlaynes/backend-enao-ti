package com.grupo4.enao.repository;

import com.grupo4.enao.model.Applicant;
import com.grupo4.enao.model.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {
    Optional<ExamResult> findByApplicant(Applicant applicant);
    Optional<ExamResult> findByApplicant_DocNumber(String docNumber);
}
