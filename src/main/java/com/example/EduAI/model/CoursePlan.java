package com.example.EduAI.model;
import org.springframework.data.elasticsearch.annotations.Document;
import jakarta.persistence.*;

@Entity
@Table(name = "course_plans")
@Document(indexName = "course_plans")
public class CoursePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    // Add relationships, getters, setters, and constructors.
}
