import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-usersstatistics',
  templateUrl: './usersstatistics.component.html',
  styleUrls: ['./usersstatistics.component.css']
})
export class UsersstatisticsComponent implements OnInit {
  userStats = null;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.sendGetRequest("usersStats").subscribe((data: any) => {
      console.log(data);
      this.userStats = data;
    })
  }

}
