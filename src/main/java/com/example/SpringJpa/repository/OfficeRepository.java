package com.example.SpringJpa.repository;

import com.example.SpringJpa.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office,Integer> {

}
