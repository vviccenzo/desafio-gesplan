import { TypeSupplier } from "./type-supplier.model";

export class Supplier {
  public name!: string;
  public phoneNumber!: number;
  public type!: TypeSupplier;
  public email!: string;
  public observation!: string;
  public id!: number;
  public favorite!: boolean;
}
