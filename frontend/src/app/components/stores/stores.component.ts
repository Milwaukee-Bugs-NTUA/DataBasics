import { Component, OnInit } from '@angular/core';
import { DataService } from './../../services/data.service';
import { MatDialog } from '@angular/material/dialog';
import { InsertStoreComponent } from '../insert-store/insert-store.component';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-stores',
  templateUrl: './stores.component.html',
  styleUrls: ['./stores.component.css']
})
export class StoresComponent implements OnInit {
    stores = null;
    new_store = null;

    constructor(private dataService: DataService, public dialog: MatDialog) { }

  ngOnInit(): void {
      this.dataService.sendGetRequest("stores").subscribe((data: any) => {
          console.log(data);
          this.stores = data;
      });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(InsertStoreComponent, {
      width: '250px',
      height : 'auto',
      data: null
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog Closed');
      if (result !== undefined) {
        this.new_store = result.value;
        this.submitForm();
      }
    });
  }

  submitForm(): void {
    let httpParams = new HttpParams()
                      .set('AddressCity',this.new_store.AddressCity)
                      .set('AddressStreet',this.new_store.AddressStreet)
                      .set('AddressNumber',this.new_store.AddressNumber)
                      .set('AddressPostalCode',this.new_store.AddressPostalCode)
                      .set('OpeningHour',this.new_store.OpeningHour.toString() + ":00")
                      .set('ClosingHour',this.new_store.ClosingHour.toString() + ":00")
                      .set('Size',this.new_store.Size);
    this.dataService.sendPostRequest("stores/insert",httpParams).subscribe(
      (response) => {console.log(response);location.reload();},
      (error) => console.log(error)
    );
  }

}
