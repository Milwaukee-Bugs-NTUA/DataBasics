import {Component, OnInit, Inject} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-update-product-price',
  templateUrl: './update-product-price.component.html',
  styleUrls: ['./update-product-price.component.css']
})
export class UpdateProductPriceComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<UpdateProductPriceComponent>,
              @Inject(MAT_DIALOG_DATA) public data: FormGroup) {
  }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
