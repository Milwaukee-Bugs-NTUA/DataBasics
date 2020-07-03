import {Component, OnInit, Inject} from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-insert-store',
  templateUrl: './insert-store.component.html',
  styleUrls: ['./insert-store.component.css']
})
export class InsertStoreComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<InsertStoreComponent>,
              @Inject(MAT_DIALOG_DATA) public data: FormGroup) {

    this.data = new FormGroup({
      AddressCity: new FormControl('', [Validators.required]),
      AddressStreet: new FormControl('', [Validators.required]),
      AddressNumber: new FormControl('', [Validators.required]),
      AddressPostalCode: new FormControl('', [Validators.required]),
      Size: new FormControl('', [Validators.required]),
      OpeningHour: new FormControl('', [Validators.required]),
      ClosingHour: new FormControl('', [Validators.required]),
    })
  }

  ngOnInit(): void {
    
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
