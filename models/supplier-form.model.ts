import { TypeSupplier } from "./type-supplier.model";

export class SupplierForm {
  public name!: string;
  public phoneNumbers!: string;
  public supplierType!: TypeSupplier;
  public email!: string;
  public observation!: string;
  public id!: number;
  public favorite!: boolean;
  public creationDate!: Date;
}
