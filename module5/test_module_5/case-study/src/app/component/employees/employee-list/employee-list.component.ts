import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../../services/employee.service';
import { MatDialog } from '@angular/material/dialog';
import {EmployeeDeleteComponent} from '../employee-delete/employee-delete.component';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  public employees: any;
  term: string;
  p: number;
  size = 5;
  private direction = 'asc';
  name: string;


  constructor(
    public employeeService: EmployeeService,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.employeeService.getAllEmployees(0, this.size).subscribe(data => {
      this.employees = data;
      console.log(this.employees);
    });
  }

  openDialog(idEmployee): void {
    this.employeeService.getEmployeeById(idEmployee).subscribe(dataEmployee => {
      const dialogRef = this.dialog.open(EmployeeDeleteComponent, {
        width: '500px',
        data: { data1: dataEmployee },
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

  sort(name: string){
    if (this.direction === 'asc'){
      this.direction = 'desc';
    }else {
      this.direction = 'asc';
    }
    this.employeeService.sort(name, this.direction).subscribe(data => {
      this.employees = data;
    });
  }
  search(){
    this.employeeService.searchByName(this.name).subscribe(data => {
      console.log(data);
      this.p = 0;
      this.employees = data;
    });
  }

}
