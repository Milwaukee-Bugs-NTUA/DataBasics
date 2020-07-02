import { Component, OnInit } from '@angular/core';
import { DataService } from './../../services/data.service';
import { MatDialog } from '@angular/material/dialog';
import { InsertUserComponent } from '../insert-user/insert-user.component';
import { HttpParams } from '@angular/common/http';
import * as moment from 'moment';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users = null;
  new_user = null;

  constructor(private dataService: DataService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.dataService.sendGetRequest("users").subscribe((data: any) => {
      console.log(data);
      this.users = data;
  });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(InsertUserComponent, {
      width: '250px',
      height : 'auto',
      data: {}
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
    this.dataService.sendPostRequest("users/insert",httpParams).subscribe(
      (response) => {console.log(response);location.reload();},
      (error) => console.log(error)
    );
  }

}
