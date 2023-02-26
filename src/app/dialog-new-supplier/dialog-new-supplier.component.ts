import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Supplier } from 'models/supplier.model';
import { SupplierService } from 'services/supplier.service';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import { SupplierForm } from 'models/supplier-form.model';
import { Converter } from 'utils/format-utils';

@Component({
  selector: 'app-dialog-new-supplier',
  templateUrl: './dialog-new-supplier.component.html',
  styleUrls: ['./dialog-new-supplier.component.sass'],
})
export class DialogNewSupplierComponent implements OnInit {

  formNewSupplier!: FormGroup;
  listPhoneUsers: string[] = [];
  canCreateOrSaveSupplier: boolean = false;
  isEditSupplier: boolean = false;

  constructor(
    private _dialogRef: MatDialogRef<DialogNewSupplierComponent>,
    private _formBuilder: FormBuilder,
    private _supplierService: SupplierService,
    @Inject(MAT_DIALOG_DATA) public data: {supplier: Supplier}
  ) { }

  ngOnInit(): void {
    if(this.data) {
      this.isEditSupplier = true;
      if(this.data.supplier.phoneNumbers.length > 0) {
        this.data.supplier.phoneNumbers.forEach((phone) => {
          this.listPhoneUsers.push(phone);
        })
      }
      this.canCreateOrSaveSupplier = this.listPhoneUsers.length > 0;
      this.createForm(this.data.supplier);
    } else {
      this.createForm(new Supplier());
    }
  }

  onNoClick(): void {
    this._dialogRef.close();
  }

  checkPhoneUser() {
    let phoneNumberUser: string = this.formNewSupplier.getRawValue().phoneNumbers;
    this.canCreateOrSaveSupplier = phoneNumberUser.length >= 10;
    if(this.listPhoneUsers.length > 0) {
      this.canCreateOrSaveSupplier = true;
    }
  }

  addPhoneToUser() {
    let phoneNumberUser: string = this.formNewSupplier.getRawValue().phoneNumbers;
    this.listPhoneUsers.push(phoneNumberUser);
    this.canCreateOrSaveSupplier = this.listPhoneUsers.length > 0;
  }

  deletePhoneOfUser(indexPhoneNumber: number) {
    this.listPhoneUsers.splice(indexPhoneNumber, 1)
    this.canCreateOrSaveSupplier = this.listPhoneUsers.length > 0;

    let phoneNumberUser: string[] = this.formNewSupplier.getRawValue().phoneNumbers;
    this.canCreateOrSaveSupplier = phoneNumberUser.length > 0;
  }

  createForm(supplier: Supplier) {
    this.formNewSupplier = this._formBuilder.group({
      name: [supplier.name, Validators.required],
      email: [supplier.email, [Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"),Validators.required]],
      phoneNumbers: [this.listPhoneUsers],
      supplierType: [supplier.supplierType, Validators.required],
      observation: [supplier.observation],
      creationDate: [new Date()],
      id: [supplier.id]
    })
  }

  save() {
    let supplier: SupplierForm = this.formNewSupplier.getRawValue();
    if(this.listPhoneUsers.includes(supplier.phoneNumbers)) {
      alert('Não é possível, cadastrar duas vezes o mesmo número de telefone.');
      return;
    }

    let supplierToSend: Supplier = Converter.parseSupplierFormToSuppler(supplier, this.listPhoneUsers);

    if (this.isEditSupplier) {
      this._supplierService.putUpdateSupplier(supplierToSend).subscribe((response) => {
        alert('Fornecedor ' + supplier.name + ' atualizado com sucesso!')
      });
    } else {
      this._supplierService.postCreateSupplier(supplierToSend).subscribe((response) => {
        alert('Fornecedor ' + supplier.name + ' criado com sucesso!')
      });
    }

    this.onNoClick();
  }
}


