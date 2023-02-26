package com.example.desafiogesplan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.desafiogesplan.domain.entitys.supplier.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.desafiogesplan.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

	private static final Logger logger = Logger.getLogger(SupplierServiceImpl.class.getName());

	@Autowired
	private SupplierRepository supplierRepository;

	private final SupplierParser supplierParser = new SupplierParser();

	@Override
	@Transactional
	public void createSupplier(CreateSupplierDTO createSupplierDTO) {
		Supplier supplier = this.supplierParser.parserCreateSupplierDTOtoSupplier(createSupplierDTO);
		if (supplier != null) {
			this.supplierRepository.save(supplier);
			logger.info("Criando fornecedor: " + supplier.getName());
		}
	}

	@Override
	public List<TableSupplierDTO> listSupplier() {
		List<Supplier> listSupplier = this.supplierRepository.findAll(Sort.by(Sort.Direction.DESC, "favorite"));
		List<TableSupplierDTO> tableSupplierDTOs = new ArrayList<>();
		if (!listSupplier.isEmpty()) {
			for (Supplier supplier : listSupplier) {
				tableSupplierDTOs.add(this.supplierParser.parserSupplierToTableSupplierDTO(supplier));
			}

			logger.info("Listando fornecedores..");
			return tableSupplierDTOs;
		}

		return tableSupplierDTOs;
	}

	@Override
	public void deleteSupplier(DeleteSupplierDTO deleteSupplierDTO) {
		for (Long id : deleteSupplierDTO.getListIds()) {
			if (id != null) {
				this.supplierRepository.deleteById(id);
			}
		}
		logger.info("Deletando fornecedores: " + deleteSupplierDTO.getListIds());
	}

	@Override
	public void updateSupplier(UpdateSupplierDTO updateSupplierDTO) {
		Supplier supplier = this.supplierParser.parseUpdateSupplierToSupplier(updateSupplierDTO);
		if (supplier != null) {
			this.supplierRepository.saveAndFlush(supplier);
			logger.info("Atualizando fornecedor: " + updateSupplierDTO.getId());
		}
	}

	@Override
	public void favoriteSupplier(FavoriteSupplierDTO favoriteSupplierDTO) {
		Supplier supplier = this.supplierRepository.getReferenceById(favoriteSupplierDTO.getId());
		if (supplier != null) {
			supplier.setFavorite(favoriteSupplierDTO.getStatus());

			logger.info("Atualizado favorito do fornecedor " + favoriteSupplierDTO.getId() + " para " + favoriteSupplierDTO.getStatus());
			this.supplierRepository.save(supplier);
		}
	}
}
