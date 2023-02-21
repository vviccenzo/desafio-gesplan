package com.example.desafiogesplan.infra.parser;

import com.example.desafiogesplan.domain.entitys.supplier.CreateSupplierDTO;
import com.example.desafiogesplan.domain.entitys.supplier.Supplier;
import com.example.desafiogesplan.domain.entitys.supplier.SupplierTypeEnum;
import com.example.desafiogesplan.domain.entitys.supplier.TableSupplierDTO;

import io.micrometer.common.util.StringUtils;

public class SupplierParser {

	public Supplier parserCreateSupplierDTOtoSupplier(CreateSupplierDTO createSupplierDTO) {
		Supplier supplier = new Supplier();
		if (StringUtils.isNotBlank(createSupplierDTO.getEmail())) {
			supplier.setEmail(createSupplierDTO.getEmail());
		}

		if (StringUtils.isNotBlank(createSupplierDTO.getName())) {
			supplier.setName(createSupplierDTO.getName());
		}

		if (StringUtils.isNotBlank(createSupplierDTO.getObservation())) {
			supplier.setObservation(createSupplierDTO.getObservation());
		}

		if (StringUtils.isNotBlank(createSupplierDTO.getSupplierType())) {
			if (SupplierTypeEnum.ATACADISTA.toString().equals(createSupplierDTO.getSupplierType())) {
				supplier.setSupplierTypeEnum(SupplierTypeEnum.ATACADISTA);
			} else if (SupplierTypeEnum.DISTRIBUIDOR.toString().equals(createSupplierDTO.getSupplierType())) {
				supplier.setSupplierTypeEnum(SupplierTypeEnum.DISTRIBUIDOR);
			} else if (SupplierTypeEnum.FABRICANTE.toString().equals(createSupplierDTO.getSupplierType())) {
				supplier.setSupplierTypeEnum(SupplierTypeEnum.FABRICANTE);
			} else if (SupplierTypeEnum.VAREJISTA.toString().equals(createSupplierDTO.getSupplierType())) {
				supplier.setSupplierTypeEnum(SupplierTypeEnum.VAREJISTA);
			}
		}

		return supplier;
	}

	public TableSupplierDTO parserSupplierToTableSupplierDTO(Supplier supplier) {
		TableSupplierDTO tableSupplierDTO = new TableSupplierDTO();
		if (StringUtils.isNotBlank(supplier.getEmail())) {
			tableSupplierDTO.setEmail(supplier.getEmail());
		}

		if (StringUtils.isNotBlank(supplier.getName())) {
			tableSupplierDTO.setName(supplier.getName());
		}

		if (StringUtils.isNotBlank(supplier.getObservation())) {
			tableSupplierDTO.setObservation(supplier.getObservation());
		}

		if (supplier.getSupplierTypeEnum() != null) {
			tableSupplierDTO.setSupplierType(String.valueOf(supplier.getSupplierTypeEnum()));
		}

		if(supplier.getId() != null) {
			tableSupplierDTO.setId(supplier.getId());
		}

		if(supplier.getFavorite() != null) {
			tableSupplierDTO.setFavorite(supplier.getFavorite());
		}

		return tableSupplierDTO;
	}
}
