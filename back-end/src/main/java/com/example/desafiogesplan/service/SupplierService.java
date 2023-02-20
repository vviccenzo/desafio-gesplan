package com.example.desafiogesplan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.desafiogesplan.domain.entitys.supplier.Supplier;


@Service
public interface SupplierService {

	public void createSupplier(Supplier supplier);

	public List<Supplier> listSupplier();
}
