import { Component, OnInit, Input } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-user-transactions',
  templateUrl: './user-transactions.component.html',
  styleUrls: ['./user-transactions.component.css']
})
export class UserTransactionsComponent implements OnInit {
  transactions = null;
  @Input() userId: number;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.sendGetRequest("profile/" + this.userId + "/transactions").subscribe((data: any) => {
        console.log(data);
        this.transactions = data;
    });
  }

}
