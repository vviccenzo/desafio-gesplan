package com.example.desafiogesplan.domain.entitys.supplier;

import java.util.ArrayList;
import java.util.List;

import com.example.desafiogesplan.domain.entitys.phonenumber.PhoneNumber;

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

		if(createSupplierDTO.getPhoneNumbers() != null && !createSupplierDTO.getPhoneNumbers().isEmpty()) {
			List<PhoneNumber> listPhoneNumbers = new ArrayList<>();
			for(String phoneNumberUser : createSupplierDTO.getPhoneNumbers()) {
				PhoneNumber phoneNumber = new PhoneNumber();
				phoneNumber.setNumber(phoneNumberUser);
				listPhoneNumbers.add(phoneNumber);
			}

			supplier.setPhoneNumbers(listPhoneNumbers);
		}

		if (createSupplierDTO.getCreationDate() != null) {
			supplier.setCreationDate(createSupplierDTO.getCreationDate());
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

		if(supplier.getPhoneNumbers() != null && !supplier.getPhoneNumbers().isEmpty()) {
			List<String> listPhoneNumberUser = new ArrayList<>();
			for(PhoneNumber phoneNumber : supplier.getPhoneNumbers()) {
				listPhoneNumberUser.add(phoneNumber.getNumber());
			}
			tableSupplierDTO.setPhoneNumbers(listPhoneNumberUser);
		}

		if (supplier.getCreationDate() != null) {
			tableSupplierDTO.setCreationDate(supplier.getCreationDate());
		}

		return tableSupplierDTO;
	}

	public Supplier parseUpdateSupplierToSupplier(UpdateSupplierDTO updateSupplierDTO) {
		Supplier supplier = new Supplier();
		if (StringUtils.isNotBlank(updateSupplierDTO.getEmail())) {
			supplier.setEmail(updateSupplierDTO.getEmail());
		}

		if (StringUtils.isNotBlank(updateSupplierDTO.getName())) {
			supplier.setName(updateSupplierDTO.getName());
		}

		if (StringUtils.isNotBlank(updateSupplierDTO.getObservation())) {
			supplier.setObservation(updateSupplierDTO.getObservation());
		}

		if (StringUtils.isNotBlank(updateSupplierDTO.getSupplierType())) {
			if (SupplierTypeEnum.ATACADISTA.toString().equals(updateSupplierDTO.getSupplierType())) {
				supplier.setSupplierTypeEnum(SupplierTypeEnum.ATACADISTA);
			} else if (SupplierTypeEnum.DISTRIBUIDOR.toString().equals(updateSupplierDTO.getSupplierType())) {
				supplier.setSupplierTypeEnum(SupplierTypeEnum.DISTRIBUIDOR);
			} else if (SupplierTypeEnum.FABRICANTE.toString().equals(updateSupplierDTO.getSupplierType())) {
				supplier.setSupplierTypeEnum(SupplierTypeEnum.FABRICANTE);
			} else if (SupplierTypeEnum.VAREJISTA.toString().equals(updateSupplierDTO.getSupplierType())) {
				supplier.setSupplierTypeEnum(SupplierTypeEnum.VAREJISTA);
			}
		}

		if (updateSupplierDTO.getPhoneNumbers() != null && !updateSupplierDTO.getPhoneNumbers().isEmpty()) {
			List<PhoneNumber> listPhoneNumbers = new ArrayList<>();
			for (String phoneNumberUser : updateSupplierDTO.getPhoneNumbers()) {
				PhoneNumber phoneNumber = new PhoneNumber();
				phoneNumber.setNumber(phoneNumberUser);
				listPhoneNumbers.add(phoneNumber);
			}

			supplier.setPhoneNumbers(listPhoneNumbers);

			if (updateSupplierDTO.getCreationDate() != null) {
				supplier.setCreationDate(updateSupplierDTO.getCreationDate());
			}

			if (updateSupplierDTO.getId() != null) {
				supplier.setId(updateSupplierDTO.getId());
			}

		}

		return supplier;
	}
}
