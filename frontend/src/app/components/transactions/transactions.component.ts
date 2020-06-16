import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from 'src/app/services/data.service';
import * as moment from 'moment';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
    transactions = null;
    storeId:string;
    // Filter Values
    paymentMethods = ['any', 'cash', 'card'];
    paymentMethod = 'any';
    low:number;
    high:number;
    startingDate:string;
    endingDate:string;
    // url for back-end GET request
    url = "/transactions/null/null/any/null/null";

    constructor(private dataService: DataService, private route: ActivatedRoute,) { }

    ngOnInit(): void {
        this.route.paramMap.subscribe(params => {
            this.storeId = params.get('storeId');
        });
        this.dataService.sendGetRequest("storePage/" + this.storeId + this.url).subscribe((data: any) => {
            console.log(data);
            this.transactions = data;
        });
    }

    paymentMethodChange(): void {
        console.log("Payment method changed: " + this.paymentMethod);
        this.sendRequest();
    }

    startingDateChange(newdate: string): void {
        this.startingDate = moment(newdate).format('yyyy-MM-DD');
        console.log("Starting Change changed: " + this.startingDate);
        this.sendRequest();
    }

    endingDateChange(newdate: string): void {
        this.endingDate = moment(newdate).format('yyyy-MM-DD');
        console.log("Ending Change changed: " + this.endingDate);
        this.sendRequest();
    }

    sendRequest():void {
        this.url =  "/transactions/" + 
                    this.startingDate + "/" + 
                    this.endingDate + "/" + 
                    this.paymentMethod + "/" + 
                    this.low + "/" + 
                    this.high;
        this.dataService.sendGetRequest("storePage/" + this.storeId + this.url).subscribe((data: any) => {
            console.log(data);
            this.transactions = data;
        });
    }

}
