import { Component, OnInit, Inject } from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-insert-user',
  templateUrl: './insert-user.component.html',
  styleUrls: ['./insert-user.component.css']
})
export class InsertUserComponent implements OnInit {
  maxDate: Date;
  
  constructor(public dialogRef: MatDialogRef<InsertUserComponent>,
    @Inject(MAT_DIALOG_DATA) public data: FormGroup) {

    this.data = new FormGroup({
      Email: new FormControl('', [Validators.required, Validators.email]),
      FirstName: new FormControl('', [Validators.required]),
      LastName: new FormControl('', [Validators.required]),
      DateOfBirth: new FormControl('', [Validators.required]),
      Sex: new FormControl('', [Validators.required]),
      AddressCity: new FormControl('', [Validators.required]),
      AddressStreet: new FormControl('', [Validators.required]),
      AddressNumber: new FormControl('', [Validators.required]),
      AddressPostalCode: new FormControl('', [Validators.required]),
      PhoneNumber: new FormControl('', [Validators.required,Validators.pattern('30-[0-9]{3}-[0-9]{3}-[0-9]{4}')]),
      MaritalStatus: new FormControl('', [Validators.required]),
      NumberOfChildren: new FormControl('', [Validators.required]),
      Points: new FormControl('', [Validators.required]),
    })
  }

  ngOnInit(): void {
    this.maxDate = new Date();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
