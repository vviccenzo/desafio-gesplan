import { DialogNewSupplierComponent } from './dialog-new-supplier/dialog-new-supplier.component';
import {SelectionModel} from '@angular/cdk/collections';
import {Component} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { Supplier } from 'models/supplier.model';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {

  constructor(
    public dialog: MatDialog
  ) {}
  displayedColumns: string[] = ['demo-select', 'demo-name', 'demo-weight', 'demo-tel', 'demo-type', 'demo-observation', 'demo-symbol'];
  dataSource = new MatTableDataSource<Supplier>;
  selection = new SelectionModel<Supplier>(true, []);

  openDialog(): void {
    const dialogRef = this.dialog.open(DialogNewSupplierComponent, {
      data: {
        name: "",
        animal: ""
      },
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
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

  //checkboxLabel(row?: Supplier): string {
    //if (!row) {
    //  return `${this.isAllSelected() ? 'deselect' : 'select'} all`;
    //}
    //return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.position + 1}`;
  //}
}
