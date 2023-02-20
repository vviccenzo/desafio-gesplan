package com.example.desafiogesplan.repository;

import org.springframework.stereotype.Repository;

import com.example.desafiogesplan.domain.entitys.supplier.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{
}
