package com.example.desafiogesplan.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.desafiogesplan.domain.entitys.supplier.Supplier;
import com.example.desafiogesplan.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

	private static final Logger logger = Logger.getLogger(SupplierServiceImpl.class.getName());

	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	@Transactional
	public void createSupplier(Supplier supplier) {
		this.supplierRepository.save(supplier);
		logger.info("Criando fornecedor: " + supplier.getName());
	}

	@Override
	public List<Supplier> listSupplier() {
		return this.supplierRepository.findAll();
	}
}