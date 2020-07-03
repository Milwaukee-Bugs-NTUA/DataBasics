import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from './../../services/data.service';
import { MatDialog } from '@angular/material/dialog';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import { UpdateStoreComponent } from '../update-store/update-store.component';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-storepage',
  templateUrl: './storepage.component.html',
  styleUrls: ['./storepage.component.css']
})
export class StorepageComponent implements OnInit {
    storepage = null;
    new_store = null;

    show_transactions = false;
    
    constructor(private dataService: DataService,private route: ActivatedRoute,public dialog: MatDialog) { }

    ngOnInit(): void {
        this.route.paramMap.subscribe(params => {
            this.dataService.sendGetRequest("storePage/" + params.get('storeId')).subscribe((data: any) => {
                console.log(data);
                this.storepage = data;
            });
        });
    }

    onClickMe():void {
        this.show_transactions = true;
    }

    openDialog(): void {
    const dialogRef = this.dialog.open(UpdateStoreComponent, {
        width: '250px',
        height : 'auto',
        data: new FormGroup({
                AddressCity: new FormControl(this.storepage.AddressCity, [Validators.required]),
                AddressStreet: new FormControl(this.storepage.AddressStreet, [Validators.required]),
                AddressNumber: new FormControl(this.storepage.AddressNumber, [Validators.required]),
                AddressPostalCode: new FormControl(this.storepage.AddressPostalCode, [Validators.required]),
                Size: new FormControl(this.storepage.Size, [Validators.required]),
                OpeningHour: new FormControl(this.storepage.OpeningHour, [Validators.required]),
                ClosingHour: new FormControl(this.storepage.ClosingHour, [Validators.required]),
                })
    });

    dialogRef.afterClosed().subscribe(result => {
        console.log('Dialog Closed');
        if (result !== undefined) {
        this.new_store = result.value;
        this.submitForm();
        }
    });
    }
    
    submitForm(): void {
        let httpParams = new HttpParams()
                            .set('AddressCity',this.new_store.AddressCity)
                            .set('AddressStreet',this.new_store.AddressStreet)
                            .set('AddressNumber',this.new_store.AddressNumber)
                            .set('AddressPostalCode',this.new_store.AddressPostalCode)
                            .set('OpeningHour',this.new_store.OpeningHour.toString())
                            .set('ClosingHour',this.new_store.ClosingHour.toString())
                            .set('Size',this.new_store.Size);
        this.dataService.sendPutRequest("storePage/" + this.storepage.StoreId + "/update",httpParams).subscribe(
            (response) => {console.log(response);this.ngOnInit();},
            (error) => console.log(error)
        );
    }
}
