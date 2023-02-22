package com.example.desafiogesplan.domain.entitys.supplier;

import java.io.Serializable;
import java.util.List;

public class DeleteSupplierDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Long> listIds;

	public List<Long> getListIds() {
		return listIds;
	}

	public void setListIds(List<Long> listIds) {
		this.listIds = listIds;
	}
}
