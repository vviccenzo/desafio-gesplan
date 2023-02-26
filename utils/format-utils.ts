import { SupplierForm } from "models/supplier-form.model";
import { Supplier } from "models/supplier.model";

export class Converter {

  static parseSupplierFormToSuppler = (supplierForm: SupplierForm, listPhoneUser: string[]): Supplier => {
    let supplier: Supplier = new Supplier();
    supplier.creationDate = supplierForm.creationDate;
    supplier.email = supplierForm.email;
    supplier.favorite = supplierForm.favorite;
    supplier.name = supplierForm.name;
    supplier.observation = supplierForm.observation;
    supplier.supplierType = supplierForm.supplierType;
    supplier.id = supplierForm.id;
    supplierForm.phoneNumbers
    if(typeof supplierForm.phoneNumbers === "string") {
      supplier.phoneNumbers.push(supplierForm.phoneNumbers);
    }

    listPhoneUser.forEach((phone) => {
      supplier.phoneNumbers.push(phone);
    })

    return supplier;
  }
}
