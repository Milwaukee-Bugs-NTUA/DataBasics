import { Component, OnInit } from '@angular/core';
import { DataService } from './../../services/data.service';
import { Data } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users = null;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.sendGetRequest("users").subscribe((data: any) => {
      console.log(data);
      this.users = data;
  });
  }

}
