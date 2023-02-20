import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {
  static http: HttpClient;

  constructor(private http: HttpClient) { }

  getData(username: string, password: string) {
    let response = { login: username, senha: password };
    return this.http.post('http://localhost:8080/login', response).subscribe(response => {
      console.log(response)
    });
  }
}


