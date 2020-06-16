import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from './../../services/data.service';
import * as moment from 'moment';

@Component({
  selector: 'app-storepage',
  templateUrl: './storepage.component.html',
  styleUrls: ['./storepage.component.css']
})
export class StorepageComponent implements OnInit {
    storepage = {   
                    "StoreId": "", 
                    "Size": "", 
                    "AddressCity": "", 
                    "AddressStreet": "", 
                    "AddressNumber": "", 
                    "AddressPostalCode": "", 
                    "OpeningHour": "", 
                    "ClosingHour": "" 
                };
    payment = ['any','cash','card'];
    paymentMethod = 'any';
    low = 0;
    high = 0;
    startingDate = '0000-01-01';
    endingDate = '0000-01-01';

    constructor(private dataService: DataService,private route: ActivatedRoute,) { }

    ngOnInit(): void {
        this.route.paramMap.subscribe(params => {
            this.dataService.sendGetRequest("storePage/" + params.get('storeId')).subscribe((data: any) => {
                console.log(data);
                this.storepage = data;
            });
        });
    }

    paymentMethodChange():void {
        console.log("Payment method changed: " + this.paymentMethod);
    }

    setLow(newvalue:number): void {
        if (newvalue === null) {
            this.low = 0;
        }
        else this.low = newvalue;
        console.log("Low threshold changed: " + this.low);
    }

    setHigh(newvalue: number): void {
        if (newvalue === null) {
            this.high = 0;
        }
        else this.high = newvalue;
        console.log("High threshold changed: " + this.high);
    }

    startingDateChange(newdate: string): void {
        if (newdate === null) {
            this.startingDate = "0000-00-01"
        }
        else this.startingDate = moment(newdate).format('yyyy-MM-DD');
        console.log("Starting Change changed: " + this.startingDate);
    }

    endingDateChange(newdate:string):void {
        if (newdate === null) {
            this.endingDate = "0000-00-01"
        }
        else this.endingDate = moment(newdate).format('yyyy-MM-DD');
        console.log("Ending Change changed: " + this.endingDate);
    }

}
