package com.example.desafiogesplan.domain.entitys.supplier;

import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "SUPPLIER", schema = "database_gesplan")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic
	@Column(name = "EMAIL")
	private String email;

	@Basic
	@Column(name = "SUPPLIERTYPE")
	private SupplierTypeEnum supplierTypeEnum;

	@Basic
	@Column(name = "PHONENUMBER")
	private Set<String> phoneNumber;

	@Basic
	@Column(name = "OBSERVATION")
	private String observation;

	@Basic
	@Column(name = "NAME")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SupplierTypeEnum getSupplierTypeEnum() {
		return supplierTypeEnum;
	}

	public void setSupplierTypeEnum(SupplierTypeEnum supplierTypeEnum) {
		this.supplierTypeEnum = supplierTypeEnum;
	}

	public Set<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Set<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
