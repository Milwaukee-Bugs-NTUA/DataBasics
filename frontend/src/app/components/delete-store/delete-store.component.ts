import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

export interface DialogData {
  answer:string;
}

@Component({
  selector: 'app-delete-store',
  templateUrl: './delete-store.component.html',
  styleUrls: ['./delete-store.component.css']
})
export class DeleteStoreComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DeleteStoreComponent>) {}

  ngOnInit(): void {
  }

  onClick(button_action: string): void {
    this.dialogRef.close({event: button_action});
  }

}
