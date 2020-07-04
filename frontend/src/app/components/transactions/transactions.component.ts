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
    minDate:Date;
    maxDate: Date;
    storeId:string;
    // Filter Values
    paymentMethods = ['any', 'cash', 'card'];
    paymentMethod:string = null;
    low:number = null;
    high:number = null;
    startingDate:string = null;
    endingDate:string = null;
    // url for back-end GET request
    url = "/transactions/null/null/any/null/null";
    maximumCost = null;

    constructor(private dataService: DataService, private route: ActivatedRoute,) {
        const currentYear = new Date();
        this.minDate = new Date(currentYear.getFullYear() - 23, 0, 0);
        this.maxDate = new Date(currentYear);
     }

    ngOnInit(): void {
        this.route.paramMap.subscribe(params => {
            this.storeId = params.get('storeId');
        });
        this.dataService.sendGetRequest("storePage/" + this.storeId + this.url).subscribe((data: any) => {
            console.log(data);
            this.transactions = data;
        });
    }

    returnAny(p:string):string {
        if (p === null) return 'any';
        else return p;
    }

    startingDateChange(newdate: string): void {
        if (newdate === null) this.startingDate = null;
        else this.startingDate = moment(newdate).format('yyyy-MM-DD');
        console.log("Starting Change changed: " + this.startingDate);
        this.sendRequest();
    }

    endingDateChange(newdate: string): void {
        if (newdate === null) this.endingDate = null;
        else this.endingDate = moment(newdate).format('yyyy-MM-DD');
        console.log("Ending Change changed: " + this.endingDate);
        this.sendRequest();
    }

    sendRequest():void {
        this.url =  "/transactions/" + 
                    this.startingDate + "/" + 
                    this.endingDate + "/" + 
                    this.returnAny(this.paymentMethod) + "/" + 
                    this.low + "/" + 
                    this.high;
        this.transactions = null;
        this.dataService.sendGetRequest("storePage/" + this.storeId + this.url).subscribe((data: any) => {
            console.log(data);
            this.transactions = data;
        });
    }

}
