import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Supplier } from 'models/supplier.model';
import { SupplierService } from 'services/supplier.service';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-new-supplier',
  templateUrl: './dialog-new-supplier.component.html',
  styleUrls: ['./dialog-new-supplier.component.sass'],
})
export class DialogNewSupplierComponent implements OnInit {

  formNewSupplier!: FormGroup;
  listPhoneUsers: string[] = [];

  constructor(
    private _dialogRef: MatDialogRef<DialogNewSupplierComponent>,
    private _formBuilder: FormBuilder,
    private _supplierService: SupplierService,
    @Inject(MAT_DIALOG_DATA) public data: {supplier: Supplier}
  ) { }

  ngOnInit(): void {
    if(this.data) {
      this.createForm(this.data.supplier);
    } else {
      this.createForm(new Supplier());
    }
  }

  onNoClick(): void {
    this._dialogRef.close();
  }

  addPhoneToUser() {
    let phoneNumberUser: string = this.formNewSupplier.getRawValue().phoneNumbers;
    this.listPhoneUsers.push(phoneNumberUser);
  }

  deletePhoneOfUser(indexPhoneNumber: number) {
    this.listPhoneUsers.splice(indexPhoneNumber, 1)
  }

  createForm(supplier: Supplier) {
    this.formNewSupplier = this._formBuilder.group({
      name: [supplier.name, Validators.required],
      email: [supplier.email, [Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"),Validators.required]],
      phoneNumbers: [this.listPhoneUsers, Validators.required],
      supplierType: [supplier.supplierType, Validators.required],
      observation: [supplier.observation]
    })
  }

  save() {
    let supplier: Supplier = this.formNewSupplier.getRawValue();
    supplier.phoneNumbers = this.listPhoneUsers;
    this._supplierService.postCreateSupplier(supplier).subscribe((response) => {
    });
  }
}


