import { Component, OnInit } from '@angular/core';
import {Employee} from '../../../employee';
import {EmployeeService} from '../../../services/employee.service';
import {EmployeeDeleteComponent} from '../employee-delete/employee-delete.component';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  public employees = [];
  nameSorting = false;
  size = 5;
  pageClicked = 0;
  pages = [];
  totalPages = 1;
  name: string;

  constructor(
    public employeeService: EmployeeService,
    public dialog: MatDialog,
    public router: Router
  ) { }

  ngOnInit(): void {
    this.onSubmit(0);
  }

  onSubmit(page) {
    this.employeeService.getAllEmployees(page, this.size, this.nameSorting).subscribe(
      data => {
          this.employees = data.content;
          console.log(data);
          this.pageClicked = page;
          this.totalPages = data.totalPages;
          this.pages = Array.apply(null, {length: this.totalPages}).map(Number.call, Number);
        }
    );
  }

  search(page) {
    this.employeeService.getAllEmployeeByName(this.name , this.size).subscribe(data => {
      this.employees = data.content;
      console.log(data);
      this.pageClicked = page;
      this.totalPages = data.totalPages;
      this.pages = Array.apply(null, {length: this.totalPages}).map(Number.call, Number);
    });
  }

  onLastNameSortingChange(value: any){
    this.nameSorting = !this.nameSorting;
    this.ngOnInit();
  }

  onNext() {
    if (this.pageClicked < this.totalPages - 1) {
      this.pageClicked++;
      this.onSubmit(this.pageClicked);
    }
  }

  onPrevious() {
    if (this.pageClicked > 0) {
      this.pageClicked--;
      this.onSubmit(this.pageClicked);
    }
  }

  onFirst() {
    this.pageClicked = 0;
    this.onSubmit(this.pageClicked);
  }

  onLast() {
    this.pageClicked = this.totalPages - 1;
    this.onSubmit(this.pageClicked);
  }

  openDialog(idEmployee): void {
    this.employeeService.getEmployeeById(idEmployee).subscribe(dataEmployee => {
      const dialogRef = this.dialog.open(EmployeeDeleteComponent, {
        width: '500px',
        data: { data1: dataEmployee },
        // disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}
