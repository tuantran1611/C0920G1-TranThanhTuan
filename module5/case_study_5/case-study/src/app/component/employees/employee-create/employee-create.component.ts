import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EmployeeService } from '../../../services/employee.service';
import { Router } from '@angular/router';

interface EducationDegree {
  value: string;
  viewValue: string;
}

interface Division {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {

  public formAddNewEmployee: FormGroup;
  public statusMessage = false;
  public positionList;

  degrees: EducationDegree[] = [
    {value: '1', viewValue: 'Đại học'},
    {value: '2', viewValue: 'Cao đẳng'},
    {value: '3', viewValue: 'Trung cấp'},
    {value: '4', viewValue: 'Sau đại học'}
  ];
  divisionItems: Division[] = [
    {value: '1', viewValue: 'Sale-marketing'},
    {value: '2', viewValue: 'Hành chính'},
    {value: '3', viewValue: 'Phục vụ'},
    {value: '4', viewValue: 'Quản lý'}
  ];

  constructor(
    public formBuilder: FormBuilder,
    public employeeService: EmployeeService,
    public router: Router,
  ) { }

  ngOnInit(): void {
    this.formAddNewEmployee = this.formBuilder.group({
      fullName: ['', [Validators.required ]],
      position: ['', [Validators.required ]],
      educationDegree: ['', [Validators.required ]],
      division: ['', [Validators.required ]],
      dayOfBirth: ['', [Validators.required, this.checkDateOfBirth]],
      idCard: ['', [Validators.required, Validators.pattern('[0-9]{9}')]],
      salary: ['', [Validators.required, Validators.pattern('[0-9]*$') ]],
      phone: ['', [Validators.required, Validators.pattern('(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})')]],
      email: ['', [Validators.required, Validators.pattern('[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)')]],
      address: ['', [Validators.required, ]]
    });
    this.employeeService.getAllPositions().subscribe(data => {
      console.log(data);
      this.positionList = data;
    });
  }
  addNewEmployee(){
    this.employeeService.addNewEmployee(this.formAddNewEmployee.value).subscribe(data => {
      this.statusMessage = true;
      this.router.navigateByUrl('employee-list');
    });
  }

  checkDateOfBirth(absControl: AbstractControl): any {
    const value = absControl.value; // 2021-02-24
    const year = Number(value.substr(0, 4));

    return new Date().getFullYear() - year >= 18 ? null : {AgeGreaterThan18: true};
  }

}
