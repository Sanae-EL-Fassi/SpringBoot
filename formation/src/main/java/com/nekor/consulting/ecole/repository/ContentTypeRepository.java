package com.nekor.consulting.ecole.repository;

import com.nekor.consulting.ecole.model.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContentTypeRepository extends JpaRepository<ContentType, String>, JpaSpecificationExecutor<ContentType> {

}
