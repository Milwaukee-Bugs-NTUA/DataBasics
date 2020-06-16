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
    low = 0;
    high = 0;
    startingDate = '0000-01-01';
    endingDate = '0000-01-01';
    // url for back-end GET request
    url = "/transactions/0000-01-01/0000-01-01/any/0/0";

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

    setLow(newvalue: string): void {
        this.low = Number(newvalue);
        console.log("Low threshold changed: " + this.low);
        this.sendRequest();
    }

    setHigh(newvalue: string): void {
        this.high = Number(newvalue);
        console.log("High threshold changed: " + this.high);
        this.sendRequest();
    }

    startingDateChange(newdate: string): void {
        if (newdate === null) {
            this.startingDate = "0000-01-01"
        }
        else this.startingDate = moment(newdate).format('yyyy-MM-DD');
        console.log("Starting Change changed: " + this.startingDate);
        this.sendRequest();
    }

    endingDateChange(newdate: string): void {
        if (newdate === null) {
            this.endingDate = "0000-01-01"
        }
        else this.endingDate = moment(newdate).format('yyyy-MM-DD');
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
