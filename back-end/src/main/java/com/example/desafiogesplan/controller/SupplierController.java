package com.example.desafiogesplan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiogesplan.domain.entitys.supplier.Supplier;
import com.example.desafiogesplan.service.SupplierService;
import com.example.desafiogesplan.service.SupplierServiceImpl;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping
	@Transactional
	public void createSupplier(@RequestBody Supplier supplier) {
		this.supplierService.createSupplier(supplier);
	}

	@GetMapping
	public List<Supplier> listSupplier() {
		List<Supplier> listSupplier = new ArrayList<Supplier>();
		listSupplier = this.supplierService.listSupplier();
		if(listSupplier == null || !listSupplier.isEmpty()) {
			return null;
		}

		return listSupplier;
	}
}
