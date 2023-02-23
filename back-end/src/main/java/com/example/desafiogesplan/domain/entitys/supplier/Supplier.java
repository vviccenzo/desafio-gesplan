package com.example.desafiogesplan.domain.entitys.supplier;

import java.util.List;

import com.example.desafiogesplan.domain.entitys.phonenumber.PhoneNumber;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

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
	@Column(name = "OBSERVATION")
	private String observation;

	@Basic
	@Column(name = "NAME")
	private String name;

	@Basic
	@Column(name = "FAVORITE")
	private Boolean favorite;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPPLIER_ID")
	private List<PhoneNumber> phoneNumbers;

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

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
