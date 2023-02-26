package com.example.desafiogesplan.service;

import java.util.List;

import com.example.desafiogesplan.domain.entitys.supplier.*;
import org.springframework.stereotype.Service;

@Service
public interface SupplierService {

	public void createSupplier(CreateSupplierDTO createSupplierDTO);

	public List<TableSupplierDTO> listSupplier();

  public void deleteSupplier(DeleteSupplierDTO deleteSupplierDTO);

  public void updateSupplier(UpdateSupplierDTO updateSupplierDTO);

  public void favoriteSupplier(FavoriteSupplierDTO favoriteSupplierDTO);
}
