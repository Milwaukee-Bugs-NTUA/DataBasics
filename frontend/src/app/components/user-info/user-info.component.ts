import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {
  info = null;
  displayedColumnsT1: string[] = ['Barcode', 'Name', 'Brand'];
  displayedColumnsT2: string[] = ['StoreID','Location'];

  constructor(private dataService: DataService,private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.dataService.sendGetRequest("profile/" + params.get('cardNumber') + "/userInfo").subscribe((data: any) => {
        console.log(data);
        this.info = data;
      });
    });
  }

}
