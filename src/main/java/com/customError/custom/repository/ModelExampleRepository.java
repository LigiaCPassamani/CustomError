package com.customError.custom.repository;

import com.customError.custom.model.ModelExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelExampleRepository extends JpaRepository<ModelExample, Long> {
}
