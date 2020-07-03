import {Component, OnInit, Inject} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-update-store',
  templateUrl: './update-store.component.html',
  styleUrls: ['./update-store.component.css']
})
export class UpdateStoreComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<UpdateStoreComponent>,
              @Inject(MAT_DIALOG_DATA) public data: FormGroup) {
  }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
