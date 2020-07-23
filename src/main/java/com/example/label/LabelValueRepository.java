package com.example.label;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LabelValueRepository extends JpaRepository<LabelValueEntity, UUID>  {


}


