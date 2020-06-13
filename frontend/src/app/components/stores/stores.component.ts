import { Component, OnInit } from '@angular/core';
import { DataService } from './../../services/data.service';

@Component({
  selector: 'app-stores',
  templateUrl: './stores.component.html',
  styleUrls: ['./stores.component.css']
})
export class StoresComponent implements OnInit {
    stores = [];

    constructor(private dataService: DataService) { }

  ngOnInit(): void {
      this.dataService.sendGetRequest("stores").subscribe((data: any) => {
          console.log(data);
          this.stores = data;
      });
  }

}
