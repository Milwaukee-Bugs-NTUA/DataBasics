import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import { ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import { UpdateUserComponent } from '../update-user/update-user.component';
import { HttpParams } from '@angular/common/http';
import * as moment from 'moment';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
    user = null;
    new_user = null;
    show_user_info=false;
    constructor(private dataService: DataService,private route: ActivatedRoute,public dialog: MatDialog) { }

  ngOnInit(): void {
      this.route.paramMap.subscribe(params => {
          this.dataService.sendGetRequest("profile/" + params.get('cardNumber')).subscribe((data: any) => {
              console.log(data);
              this.user = data;
          });
      });
  }
  
  onClickMe():void {
    this.show_user_info = true;
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(UpdateUserComponent, {
        width: '250px',
        height : 'auto',
        data: new FormGroup({
                CardNumber: new FormControl({value: this.user.CardNumber, disabled: true}, [Validators.required]),
                Email: new FormControl(this.user.Email, [Validators.required, Validators.email]),
                FirstName: new FormControl(this.user.FirstName, [Validators.required]),
                LastName: new FormControl(this.user.LastName, [Validators.required]),
                DateOfBirth: new FormControl(this.user.DateOfBirth, [Validators.required]),
                Sex: new FormControl(this.user.Sex, [Validators.required]),
                AddressCity: new FormControl(this.user.AddressCity, [Validators.required]),
                AddressStreet: new FormControl(this.user.AddressStreet, [Validators.required]),
                AddressNumber: new FormControl(this.user.AddressNumber, [Validators.required]),
                AddressPostalCode: new FormControl(this.user.AddressPostalCode, [Validators.required]),
                PhoneNumber: new FormControl(this.user.PhoneNumber, [Validators.required,Validators.pattern('30-[0-9]{3}-[0-9]{3}-[0-9]{4}')]),
                MaritalStatus: new FormControl(this.user.MaritalStatus, [Validators.required]),
                NumberOfChildren: new FormControl(this.user.NumberOfChildren, [Validators.required]),
                Points: new FormControl(this.user.Points, [Validators.required]),
              })
    });

    dialogRef.afterClosed().subscribe(result => {
        console.log('Dialog Closed');
        if (result !== undefined) {
        this.new_user = result.value;
        this.submitForm();
        }
    });
    }
    
    submitForm(): void {
        let httpParams = new HttpParams()
                            .set('Email',this.new_user.Email)
                            .set('FirstName',this.new_user.FirstName)
                            .set('LastName',this.new_user.LastName)
                            .set('DateOfBirth',moment(this.new_user.DateOfBirth).format('yyyy-MM-DD'))
                            .set('Sex',this.new_user.Sex)
                            .set('AddressCity',this.new_user.AddressCity)
                            .set('AddressStreet',this.new_user.AddressStreet)
                            .set('AddressNumber',this.new_user.AddressNumber)
                            .set('AddressPostalCode',this.new_user.AddressPostalCode)
                            .set('PhoneNumber',this.new_user.PhoneNumber)
                            .set('MaritalStatus',this.new_user.MaritalStatus)
                            .set('NumberOfChildren',this.new_user.NumberOfChildren)
                            .set('Points',this.new_user.Points);
        this.dataService.sendPutRequest("profile/" + this.user.CardNumber + "/update",httpParams).subscribe(
            (response) => {console.log(response);this.ngOnInit();},
            (error) => console.log(error)
        );
    }

}
