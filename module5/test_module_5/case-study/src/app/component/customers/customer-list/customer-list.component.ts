import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../../services/customer.service';
import {MatDialog} from '@angular/material/dialog';
import {CustomerDeleteComponent} from '../customer-delete/customer-delete.component';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  public customers: any;
  term: string;
  p: number;

  constructor(
    public customerService: CustomerService,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.customerService.getAllCustomer().subscribe(data => {
      this.customers = data;
    });
  }

  openDialog(idCustomer): void {
    this.customerService.getCustomerById(idCustomer).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(CustomerDeleteComponent, {
        width: '500px',
        data: { data1: dataCustomer },
        // disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

}
