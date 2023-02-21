import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Supplier } from 'models/supplier.model';
import { SupplierService } from 'services/supplier.service';

@Component({
  selector: 'app-dialog-new-supplier',
  templateUrl: './dialog-new-supplier.component.html',
  styleUrls: ['./dialog-new-supplier.component.sass'],
})
export class DialogNewSupplierComponent implements OnInit {

  formNewSupplier!: FormGroup;

  constructor(
    private _dialogRef: MatDialogRef<DialogNewSupplierComponent>,
    private _formBuilder: FormBuilder,
    private _supplierService: SupplierService
  ) { }

  ngOnInit(): void {
    this.createForm(new Supplier());
  }

  onNoClick(): void {
    this._dialogRef.close();
  }

  createForm(supplier: Supplier) {
    this.formNewSupplier = this._formBuilder.group({
      name: [supplier.name, Validators.required],
      email: [supplier.email, [Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"),Validators.required]],
      phoneNumber: [supplier.phoneNumber, [Validators.pattern(/^\(\d{3}\)\s\d{3}-\d{4}$/),Validators.required]],
      supplierType: [supplier.type, Validators.required],
      observation: [supplier.observation]
    })
  }

  save() {
    let supplier: Supplier = this.formNewSupplier.getRawValue();
    this._supplierService.postCreateSupplier(supplier).subscribe((response) => {
      console.log("deu boa")
    });
  }
}


