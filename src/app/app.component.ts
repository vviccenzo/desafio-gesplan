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
    const dialogRef = this._dialog.open(DialogNewSupplierComponent);
    dialogRef.afterClosed().subscribe(result => {
    });
  }

  populateTableSupplier() {
    this._supplierService.getListSuppliers().subscribe((response) => {
      this.dataSource = new MatTableDataSource(<any>response);
    });
  }

  favoriteSupplier(status: boolean, id: number) {
    this._supplierService.postFavoriteSupplier(status, id).subscribe(result => {
        this.populateTableSupplier()
    })
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
