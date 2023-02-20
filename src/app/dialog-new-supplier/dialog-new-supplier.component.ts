import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Supplier } from 'models/supplier.model';

@Component({
  selector: 'app-dialog-new-supplier',
  templateUrl: './dialog-new-supplier.component.html',
  styleUrls: ['./dialog-new-supplier.component.sass']
})
export class DialogNewSupplierComponent implements OnInit {

  formNewSupplier!: FormGroup;

  constructor(
    private _dialogRef: MatDialogRef<DialogNewSupplierComponent>,
    private _formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.createForm(new Supplier());
  }

  onNoClick(): void {
    this._dialogRef.close();
  }

  createForm(supplier: Supplier) {
    this.formNewSupplier = this._formBuilder.group({
      name: [supplier.name],
      email: [supplier.email],
      phoneNumber: [supplier.phoneNumber],
      type: [supplier.type],
      observation: [supplier.observation]
    })
  }

  save() {
    let supplier: Supplier = this.formNewSupplier.getRawValue();
    this.createForm(supplier);

    console.log(this.formNewSupplier.getRawValue());
  }
}


