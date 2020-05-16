package com.nekor.consulting.ecole.repository;

import com.nekor.consulting.ecole.model.LessonContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LessonContentRepository extends JpaRepository<LessonContent, String>, JpaSpecificationExecutor<LessonContent> {

}
