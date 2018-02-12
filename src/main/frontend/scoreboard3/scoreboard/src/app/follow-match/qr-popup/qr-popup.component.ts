import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-qr-popup',
  templateUrl: './qr-popup.component.html',
  styleUrls: ['./qr-popup.component.css']
})
export class QrPopupComponent implements OnInit {

  constructor(public dialogRef:MatDialogRef<QrPopupComponent>, @Inject(MAT_DIALOG_DATA) public data: any) {

  }

  ngOnInit() {
  }

  public close() {
    console.log("close");
    this.dialogRef.close();
  }
}
