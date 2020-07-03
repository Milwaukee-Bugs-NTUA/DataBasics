import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import { MatDialog } from '@angular/material/dialog';
import { InsertProductComponent } from '../insert-product/insert-product.component';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products = null;
  new_product = null;

  constructor(private dataService: DataService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.dataService.sendGetRequest("products").subscribe((data: any) => {
      console.log(data);
      this.products = data;
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(InsertProductComponent, {
      width: '250px',
      height : 'auto',
      data: null
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog Closed');
      if (result !== undefined) {
        this.new_product = result.value;
        this.submitForm();
      }
    });
  }

  submitForm(): void {
    let httpParams = new HttpParams()
                      .set('Name',this.new_product.Name)
                      .set('Brand',this.new_product.Brand)
                      .set('Price',this.new_product.Price)
                      .set('CategoryId',this.new_product.CategoryId)
                      .set('OfferedInStore',this.new_product.OfferedInStore)
                      .set('AlleyNumber',this.new_product.AlleyNumber)
                      .set('ShelfNumber',this.new_product.ShelfNumber);
    this.dataService.sendPostRequest("products/insert",httpParams).subscribe(
      (response) => {console.log(response);location.reload();},
      (error) => console.log(error)
    );
  }
}
