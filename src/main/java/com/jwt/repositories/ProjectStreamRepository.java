package com.jwt.repositories;

import com.jwt.model.ProjectStream;
import com.jwt.model.ProjectStreamId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectStreamRepository extends JpaRepository<ProjectStream, Long> {
}
