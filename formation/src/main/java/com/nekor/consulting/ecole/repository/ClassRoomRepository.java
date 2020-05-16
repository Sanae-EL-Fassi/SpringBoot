package com.nekor.consulting.ecole.repository;

import com.nekor.consulting.ecole.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, String>, JpaSpecificationExecutor<ClassRoom> {

}
