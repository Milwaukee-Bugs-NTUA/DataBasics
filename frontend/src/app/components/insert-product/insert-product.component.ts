import { Component, OnInit, Inject } from '@angular/core';
import { DataService } from './../../services/data.service';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-insert-product',
  templateUrl: './insert-product.component.html',
  styleUrls: ['./insert-product.component.css']
})
export class InsertProductComponent implements OnInit {
  stores = null;

  constructor(private dataService: DataService,public dialogRef: MatDialogRef<InsertProductComponent>,
    @Inject(MAT_DIALOG_DATA) public data: FormGroup) {

    this.data = new FormGroup({
    Name: new FormControl('', [Validators.required]),
    Brand: new FormControl('', [Validators.required]),
    Price: new FormControl('', [Validators.required]),
    CategoryId: new FormControl('', [Validators.required]),
    OfferedInStore: new FormControl('', [Validators.required]),
    AlleyNumber: new FormControl('', [Validators.required, Validators.pattern('^[A-Z][0-9]+$')]),
    ShelfNumber: new FormControl('', [Validators.required, Validators.pattern('^[A-Z][0-9]+$')]),
    })
  }

  ngOnInit(): void {
      this.dataService.sendGetRequest("stores").subscribe((data: any) => {
        console.log(data);
        this.stores = data;
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
