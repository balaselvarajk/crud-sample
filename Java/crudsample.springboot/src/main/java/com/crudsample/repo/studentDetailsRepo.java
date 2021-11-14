package com.crudsample.repo;

import org.springframework.stereotype.Repository;
import com.crudsample.model.studentDetails;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface studentDetailsRepo extends JpaRepository<studentDetails, Long>{

}
