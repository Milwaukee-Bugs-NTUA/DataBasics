import { Component, OnInit, Inject } from '@angular/core';
import {FormGroup} from '@angular/forms';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  maxDate: Date;
  
  constructor(public dialogRef: MatDialogRef<UpdateUserComponent>,
    @Inject(MAT_DIALOG_DATA) public data: FormGroup) {
  }

  ngOnInit(): void {
    this.maxDate = new Date();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
