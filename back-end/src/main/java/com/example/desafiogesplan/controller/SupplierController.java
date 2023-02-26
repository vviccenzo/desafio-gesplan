package com.example.desafiogesplan.controller;

import java.util.List;

import com.example.desafiogesplan.domain.entitys.supplier.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiogesplan.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping
	public void createSupplier(@RequestBody CreateSupplierDTO createSupplierDTO) {
		this.supplierService.createSupplier(createSupplierDTO);
	}

	@GetMapping
	public List<TableSupplierDTO> getListSupplier() {
		return this.supplierService.listSupplier();
	}

	@PostMapping("/delete")
	public void deleteSupplier(@RequestBody DeleteSupplierDTO deleteSupplierDTO) {
		this.supplierService.deleteSupplier(deleteSupplierDTO);
	}

	@PutMapping
	public void updateSupplier(@RequestBody UpdateSupplierDTO updateSupplierDTO) {
		this.supplierService.updateSupplier(updateSupplierDTO);
	}

	@PostMapping("/favorite")
	public void favoriteSupplier(@RequestBody FavoriteSupplierDTO favoriteSupplierDTO) {
		this.supplierService.favoriteSupplier(favoriteSupplierDTO);
	}
}
