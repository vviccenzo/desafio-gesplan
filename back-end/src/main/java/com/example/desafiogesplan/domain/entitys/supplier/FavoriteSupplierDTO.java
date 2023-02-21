package com.example.desafiogesplan.domain.entitys.supplier;

import java.io.Serializable;

public class FavoriteSupplierDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean status;
	private Long id;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
