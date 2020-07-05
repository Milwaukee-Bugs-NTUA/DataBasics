import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from './../../services/data.service';
import { MatDialog } from '@angular/material/dialog';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UpdateProductComponent } from '../update-product/update-product.component';
import { DeleteProductComponent } from '../delete-product/delete-product.component';
import { UpdateProductPriceComponent } from '../update-product-price/update-product-price.component';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
    product = null;
    show_price_history = null;
    new_product = null;
    new_price = null;

  constructor(private dataService: DataService,private route: ActivatedRoute, private router: Router,public dialog: MatDialog) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.dataService.sendGetRequest("product/" + params.get('barcode')).subscribe((data: any) =>{
        console.log(data);
        this.product = data;
        this.show_price_history = false;
      });
    });
  }

  onClickMe():void {
    this.show_price_history = true;
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(UpdateProductComponent, {
        width: '250px',
        height : 'auto',
        data: new FormGroup({
                Barcode: new FormControl({value:this.product.Barcode,disabled: true}, [Validators.required]),
                Name: new FormControl(this.product.ProductName, [Validators.required]),
                Brand: new FormControl(this.product.ProductBrandName, [Validators.required]),
                Price: new FormControl({value:this.product.Price,disabled: true}, [Validators.required]),
                CategoryId: new FormControl(this.product.CategoryId, [Validators.required]),
              })
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
                            .set('CategoryId',this.new_product.CategoryId);
      this.dataService.sendPutRequest("product/" + this.product.Barcode + "/update",httpParams).subscribe(
          (response) => {console.log(response);this.ngOnInit();},
          (error) => console.log(error)
      );
  }

  openPriceDialog(): void {
    const dialogRef = this.dialog.open(UpdateProductPriceComponent, {
        width: '250px',
        height : 'auto',
        data: new FormGroup({
                Price: new FormControl(this.product.Price, [Validators.required]),
              })
    });

    dialogRef.afterClosed().subscribe(result => {
        console.log('Dialog Closed');
        if (result !== undefined) {
          this.new_price = result.value.Price;
          this.submitNewPrice();
        }
    });
  }

  submitNewPrice(): void {
    let httpParams = new HttpParams()
                          .set('Price',this.new_price);
    this.dataService.sendPostRequest("product/" + this.product.Barcode + "/updatePrice",httpParams).subscribe(
        (response) => {console.log(response);this.ngOnInit();},
        (error) => console.log(error)
    );
  }

  openDeleteDialog(): void {
    const dialogRef = this.dialog.open(DeleteProductComponent, {
        width: '400px',
        height : 'auto',
        data: null
    });

    dialogRef.afterClosed().subscribe(result => {
        console.log('Dialog Closed');
        if (result !== undefined && result.event === 'Delete') {
            this.delete();
        }
    });
    }
        
    delete(): void {
        this.dataService.sendDeleteRequest("product/" + this.product.Barcode + "/delete").subscribe(
            (response) => {console.log(response);  this.router.navigate(['/products']);},
            (error) => console.log(error)
        );
    }

}
