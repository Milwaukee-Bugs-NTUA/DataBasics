import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  statistics = null;

  show_prods_stats = true;
  show_users_stats = false;

  constructor(private dataService: DataService, private route: ActivatedRoute) { }

  ngOnInit(): void {

  }

  changeFocus():void {
    this.show_prods_stats = true;//!this.show_prods_stats;
    this.show_users_stats = true;//!this.show_users_stats;
  }

}
