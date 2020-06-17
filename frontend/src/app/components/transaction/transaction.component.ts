import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
    cardNumber:number=null;
    date:string=null;
    time:string=null;
    products=null;

    constructor(private dataService: DataService, private route: ActivatedRoute,) { }

    ngOnInit(): void {
        this.route.paramMap.subscribe(params => {
            this.cardNumber = Number(params.get('cardNumber'));
            this.date = params.get('date');
            this.time = params.get('time');
        });
        this.dataService.sendGetRequest("transactionProducts/" + this.date + "/" + this.time + "/" + this.cardNumber).subscribe((data: any) => {
            console.log(data);
            this.products = data;
        });
    }

}
