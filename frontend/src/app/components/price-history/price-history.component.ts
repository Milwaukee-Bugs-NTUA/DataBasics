import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-price-history',
  templateUrl: './price-history.component.html',
  styleUrls: ['./price-history.component.css']
})
export class PriceHistoryComponent implements OnInit {
  history_table = null;
  displayedColumnsT: string[] = ['StartingDate', 'EndingDate', 'Price'];

  constructor(private dataService: DataService,private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.dataService.sendGetRequest("product/" + params.get('barcode') + "/priceHistory").subscribe((data: any) => {
          console.log(data);
          this.history_table = data;
      });
  });
  }

}
