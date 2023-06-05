package com.miu.ansuman.assignment.first.lab.repo;

import com.miu.ansuman.assignment.first.lab.domain.ExceptionLogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionLoggerRepo extends JpaRepository<ExceptionLogger, Long> {
}
