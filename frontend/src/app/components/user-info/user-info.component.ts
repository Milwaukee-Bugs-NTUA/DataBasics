import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import { ActivatedRoute } from '@angular/router';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {
  info = null;
  displayedColumnsT1: string[] = ['Barcode', 'Name', 'Brand'];
  displayedColumnsT2: string[] = ['StoreID','Location'];
  whichStore = null;
  stores = null;
  happyHours = null;
  HappyHoursArray: number[] = [0,0,0,0,0,0,0,0,0,0,0,0,0];
  public barChartLabels: Label[] = ['7:00 - 8:00','8:00 - 9:00','9:00 - 10:00','10:00 - 11:00','11:00 - 12:00','12:00 - 13:00','13:00 - 14:00','14:00 - 15:00','15:00 - 16:00','16:00 - 17:00','17:00 - 18:00','18:00 - 19:00','19:00 - 20:00'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [pluginDataLabels];

  public barChartData: ChartDataSets[] = [
    { data: [0,0,0,0,0,0,0,0,0,0,0,0,0], label: 'Dataset: Percentages of Transactions' }
  ];

  constructor(private dataService: DataService,private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.dataService.sendGetRequest("profile/" + params.get('cardNumber') + "/userInfo").subscribe((data: any) => {
        console.log(data);
        this.info = data;
      });
    });
    this.dataService.sendGetRequest("stores").subscribe((data: any) => {
      console.log(data);
      this.stores = data;
      this.whichStore = this.stores[0]['StoreId'];
      this.sendHappyHoursRequest();     
    });
  }

  sendHappyHoursRequest(): void {
    this.route.paramMap.subscribe(params => {
      this.dataService.sendGetRequest("profile/" + params.get('cardNumber') + "/userInfo/" + this.whichStore).subscribe((data: any) => {
        console.log(data);
        this.happyHours = data.HappyHour;
        this.formatDataset();
      });
    });
  }

  formatDataset(): void {
    this.HappyHoursArray = [0,0,0,0,0,0,0,0,0,0,0,0,0];
    for (var el in this.happyHours) {
      if (this.happyHours[el].hasOwnProperty('Count')) {
        this.HappyHoursArray[Number(this.happyHours[el]['Hour']) - 7] = this.happyHours[el]['Count'];
      }
    }
    this.barChartData[0].data = this.HappyHoursArray;
    console.log(this.HappyHoursArray);
  }

  public barChartOptions: ChartOptions = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: { xAxes: [{}], yAxes: [{}] },
    plugins: {
      datalabels: {
        anchor: 'end',
        align: 'end',
      }
    }
  };

  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

}
