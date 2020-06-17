import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

export interface TopProdPair {
  Barcode1: number;
  Name1: string;
  Barcode2: number;
  Name2: string;
}

@Component({
  selector: 'app-productsstatistics',
  templateUrl: './productsstatistics.component.html',
  styleUrls: ['./productsstatistics.component.css']
})
export class ProductsstatisticsComponent implements OnInit {
  prodStats = null;
  displayedColumns: string[] = ['Barcode1', 'Name1', 'Barcode2', 'Name2'];
  dataSource = null;
  

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.sendGetRequest("productsStats").subscribe((data: any) => {
      console.log(data);
      this.prodStats = data;
      this.dataSource = this.prodStats;
    })
  }



}
