import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-productsstatistics',
  templateUrl: './productsstatistics.component.html',
  styleUrls: ['./productsstatistics.component.css']
})
export class ProductsstatisticsComponent implements OnInit {
  prodStats = null;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.sendGetRequest("productsStatistics").subscribe((data: any) => {
      console.log(data);
      this.prodStats = data;
    })
  }

}
