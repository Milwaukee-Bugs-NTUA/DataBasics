import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-usersstatistics',
  templateUrl: './usersstatistics.component.html',
  styleUrls: ['./usersstatistics.component.css']
})
export class UsersstatisticsComponent implements OnInit {
  userStats = null;
  nexthour = 0;
  displayedColumns: string[] = ['Hour','Young','Middle','Elder'];
  displayedColumns2: string[] = ['MaritalStatus', 'Percentage'];

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.sendGetRequest("usersStats").subscribe((data: any) => {
      console.log(data);
      this.userStats = data;
      this.nexthour = Number(this.userStats.HourZonewithmaximumsales) + 1;
    })
    
  }

}
