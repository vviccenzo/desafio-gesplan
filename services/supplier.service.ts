import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Supplier } from 'models/supplier.model';

@Injectable({ providedIn: 'root' })
export class SupplierService {
  static http: HttpClient;
  API_URL: string = "http://localhost:8080/supplier";

  constructor(
    private http: HttpClient
  ) { }

  postCreateSupplier(supplier: Supplier) {
    return this.http.post(this.API_URL, supplier);
  }

  getListSuppliers() {
    return this.http.get(this.API_URL);
  }

  postFavoriteSupplier(statusNew: boolean, idSupplier: number) {
    const response = {
      status: statusNew,
      id: idSupplier
    }

    return this.http.post("http://localhost:8080/supplier/favorite", response)
  }

  deleteSuppliers(listIds: number[]) {
    const request = {
      listIds: listIds
    }

    return this.http.post("http://localhost:8080/supplier/delete", request)
  }

  putUpdateSupplier(supplier: Supplier) {
    return this.http.put(this.API_URL, supplier);
  }
}


