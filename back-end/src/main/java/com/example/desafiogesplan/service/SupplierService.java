package com.example.desafiogesplan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.desafiogesplan.domain.entitys.supplier.DeleteSupplierDTO;
import com.example.desafiogesplan.domain.entitys.supplier.FavoriteSupplierDTO;
import com.example.desafiogesplan.domain.entitys.supplier.Supplier;
import com.example.desafiogesplan.domain.entitys.supplier.TableSupplierDTO;

@Service
public interface SupplierService {

	public void createSupplier(Supplier supplier);

	public List<TableSupplierDTO> listSupplier();

  public void deleteSupplier(DeleteSupplierDTO deleteSupplierDTO);

  public void updateSupplier(Supplier supplier);

  public void favoriteSupplier(FavoriteSupplierDTO favoriteSupplierDTO);
}
