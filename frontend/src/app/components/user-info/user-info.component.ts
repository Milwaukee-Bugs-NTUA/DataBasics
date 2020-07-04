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
      this.route.paramMap.subscribe(params => {
        this.dataService.sendGetRequest("profile/" + params.get('cardNumber') + "/userInfo/" + this.stores[0]['StoreId']).subscribe((data: any) => {
          console.log(data);
          this.happyHours = data;
        });
      });
    });
  }

  sendHappyHoursRequest(): void {
    this.route.paramMap.subscribe(params => {
      this.dataService.sendGetRequest("profile/" + params.get('cardNumber') + "/userInfo/" + this.whichStore).subscribe((data: any) => {
        console.log(data);
        this.happyHours = data;
      });
    });
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

  public barChartLabels: Label[] = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [pluginDataLabels];

  public barChartData: ChartDataSets[] = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
    { data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B' }
  ];

  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }


}
