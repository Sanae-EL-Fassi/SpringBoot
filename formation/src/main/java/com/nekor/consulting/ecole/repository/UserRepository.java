package com.nekor.consulting.ecole.repository;

import com.nekor.consulting.ecole.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<UserModel, String>, JpaSpecificationExecutor<UserModel> {

}
