package com.example.EduAI.repository;

import com.example.EduAI.model.CoursePlan;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursePlanRepository extends JpaRepository<CoursePlan, Long>, ElasticsearchRepository<CoursePlan, Long> {
    List<CoursePlan> search(String query);
}
