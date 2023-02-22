import { TypeSupplier } from "./type-supplier.model";

export class Supplier {
  public name!: string;
  public phoneNumber!: number;
  public supplierType!: TypeSupplier;
  public email!: string;
  public observation!: string;
  public id!: number;
  public favorite!: boolean;
}
