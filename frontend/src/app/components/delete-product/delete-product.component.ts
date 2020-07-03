import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-delete-product',
  templateUrl: './delete-product.component.html',
  styleUrls: ['./delete-product.component.css']
})
export class DeleteProductComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DeleteProductComponent>) { }

  ngOnInit(): void {
  }

  onClick(button_action: string): void {
    this.dialogRef.close({event: button_action});
  }
}
