package com.poc.sr.dao.recruitement.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.sr.entities.RecruitementRequest;

@Repository
public interface RecruitementRequestRepository extends JpaRepository<RecruitementRequest, String>{

}
