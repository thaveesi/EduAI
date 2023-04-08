package com.example.EduAI.repository;

import com.example.EduAI.model.CoursePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursePlanRepository extends JpaRepository<CoursePlan, Long> {
}
