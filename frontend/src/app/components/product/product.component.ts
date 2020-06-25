import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from './../../services/data.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
    productDummy = { 
                    "Barcode": "", 
                    "ProductName": "", 
                    "ProductBrandName": "", 
                    "Price": "", 
                    "CategoryId": "", 
                    "CategoryName": "" 
                    };
    product = this.productDummy;

  constructor(private dataService: DataService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.dataService.sendGetRequest("product/" + params.get('barcode')).subscribe((data: any) =>{
        console.log(data);
        this.product = data;
      });
    });
  }

}
