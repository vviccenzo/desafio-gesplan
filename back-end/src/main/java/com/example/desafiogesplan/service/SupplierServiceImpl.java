package com.example.desafiogesplan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.desafiogesplan.domain.entitys.supplier.FavoriteSupplierDTO;
import com.example.desafiogesplan.domain.entitys.supplier.Supplier;
import com.example.desafiogesplan.domain.entitys.supplier.TableSupplierDTO;
import com.example.desafiogesplan.infra.parser.SupplierParser;
import com.example.desafiogesplan.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

	private static final Logger logger = Logger.getLogger(SupplierServiceImpl.class.getName());

	@Autowired
	private SupplierRepository supplierRepository;

	private SupplierParser supplierParser = new SupplierParser();

	@Override
	@Transactional
	public void createSupplier(Supplier supplier) {
		this.supplierRepository.save(supplier);
		logger.info("Criando fornecedor: " + supplier.getName());
	}

	@Override
	public List<TableSupplierDTO> listSupplier() {
		List<Supplier> listSupplier = this.supplierRepository.findAll();
		List<TableSupplierDTO> tableSupplierDTOs = new ArrayList<TableSupplierDTO>();
		if(listSupplier != null && !listSupplier.isEmpty()) {
			for(Supplier supplier : listSupplier) {
				tableSupplierDTOs.add(this.supplierParser.parserSupplierToTableSupplierDTO(supplier));
			}

			return tableSupplierDTOs;
		}
	
		return tableSupplierDTOs;
	}

	@Override
	public void deleteSupplier(Long id) {
		this.supplierRepository.deleteById(null);
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		this.supplierRepository.save(supplier);
	}

	@Override
	public void favoriteSupplier(FavoriteSupplierDTO favoriteSupplierDTO) {
		Supplier supplier = this.supplierRepository.getReferenceById(favoriteSupplierDTO.getId());
		supplier.setFavorite(favoriteSupplierDTO.getStatus());

		this.supplierRepository.save(supplier);
	}
}
