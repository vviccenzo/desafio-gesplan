package com.example.desafiogesplan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiogesplan.domain.entitys.supplier.CreateSupplierDTO;
import com.example.desafiogesplan.domain.entitys.supplier.FavoriteSupplierDTO;
import com.example.desafiogesplan.domain.entitys.supplier.Supplier;
import com.example.desafiogesplan.domain.entitys.supplier.TableSupplierDTO;
import com.example.desafiogesplan.infra.parser.SupplierParser;
import com.example.desafiogesplan.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	private SupplierParser supplierParser = new SupplierParser();

	@PostMapping
	public void createSupplier(@RequestBody CreateSupplierDTO createSupplierDTO) {
		Supplier supplier = this.supplierParser.parserCreateSupplierDTOtoSupplier(createSupplierDTO);
		if (supplier != null) {
			this.supplierService.createSupplier(supplier);
		}
	}

	@GetMapping
	public List<TableSupplierDTO> getListSupplier() {
		return this.supplierService.listSupplier();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
		this.supplierService.deleteSupplier(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public void updateSupplier(@RequestBody Supplier supplier) {
		this.supplierService.updateSupplier(supplier);
	}

	@PostMapping("/favorite")
	public void favoriteSupplier(@RequestBody FavoriteSupplierDTO favoriteSupplierDTO) {
		this.supplierService.favoriteSupplier(favoriteSupplierDTO);
	}
}
