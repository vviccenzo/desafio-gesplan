import { DialogNewSupplierComponent } from './dialog-new-supplier/dialog-new-supplier.component';
import { SelectionModel } from '@angular/cdk/collections';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Supplier } from 'models/supplier.model';
import { MatDialog } from '@angular/material/dialog';
import { SupplierService } from 'services/supplier.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {

  canShowDeleteButton: boolean = false;
  canShowEditButton: boolean = false;

  constructor(
    private _dialog: MatDialog,
    private _supplierService: SupplierService
  ) { }

  ngOnInit(): void {
    this.populateTableSupplier();
  }

  displayedColumns: string[] = ['select', 'name', 'email', 'supplierType', 'observation', 'favorite'];
  selection = new SelectionModel<Supplier>(true, []);
  dataSource = new MatTableDataSource<Supplier>;

  openDialog(): void {

    if (this.selection.selected.length === 1) {
      let supplier: Supplier = this.selection.selected[0];
      const dialogRef = this._dialog.open(DialogNewSupplierComponent, {
        data: {
          supplier: supplier
        }
      });

      dialogRef.afterClosed().subscribe(result => {
      });
    } else if (!this.selection.selected.length) {
      const dialogRef = this._dialog.open(DialogNewSupplierComponent);
      dialogRef.afterClosed().subscribe(result => {
        if(result === "true") {
          this.populateTableSupplier();
        }
      });
    }
  }

  showOrHideButtons() {
    this.canShowEditButton = this.selection.selected.length === 1;
    this.canShowDeleteButton = this.selection.selected.length === 1 || this.selection.selected.length > 1;
    if(this.selection.selected.length === 0){
      this.canShowEditButton = false;
      this.canShowEditButton = false;
    }
  }

  populateTableSupplier() {
    this._supplierService.getListSuppliers().subscribe((response) => {
      this.dataSource = new MatTableDataSource(<any>response);
    });
  }

  favoriteSupplier(status: boolean, id: number) {
    this._supplierService.postFavoriteSupplier(status, id).subscribe(result => {
      let supplierToChangeStatus: Supplier = this.dataSource.data.find(supplier => supplier.id === id) as Supplier;
      supplierToChangeStatus.favorite = status;
    })
  }

  deleteSupplier() {
    if (this.selection.selected.length > 0) {
      let rowsSelecteds: number[] = [];
      this.selection.selected.forEach((row) => {
        rowsSelecteds.push(row.id)
      })

      this._supplierService.deleteSuppliers(rowsSelecteds).subscribe((response) => {
        rowsSelecteds.forEach((row) => {
          let supplierToRemove: Supplier = this.dataSource.data.find((supplier) => supplier.id === row) as Supplier;
          let indexSupplierToRemove: number = this.dataSource.data.indexOf(supplierToRemove);
          this.dataSource.data.splice(indexSupplierToRemove, 1);
        })
      })
    }
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  toggleAllRows() {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }

    this.selection.select(...this.dataSource.data);
  }
}
