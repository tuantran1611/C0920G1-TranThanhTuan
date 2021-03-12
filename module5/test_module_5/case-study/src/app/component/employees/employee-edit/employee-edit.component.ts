import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EmployeeService } from '../../../services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';

interface Position {
  value: string;
  viewValue: string;
}

interface EducationDegree {
  value: string;
  viewValue: string;
}

interface Division {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  private employeeId;
  public formEditEmployee: FormGroup;
  public positionList;
  items: Position[] = [
    {value: '1', viewValue: 'Lễ tân'},
    {value: '2', viewValue: 'Phục vụ'},
    {value: '3', viewValue: 'Chuyên viên'},
    {value: '4', viewValue: 'Giám sát'},
    {value: '5', viewValue: 'Quản lý'},
    {value: '6', viewValue: 'Giám đốc'},
  ];
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
    public fb: FormBuilder,
    public employeeService: EmployeeService,
    public router: Router,
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.formEditEmployee = this.fb.group({
      fullName: ['', [Validators.required ]],
      position: ['', [Validators.required, ]],
      educationDegree: ['', [Validators.required, ]],
      division: ['', [Validators.required, ]],
      dayOfBirth: ['', [Validators.required, this.checkDateOfBirth]],
      idCard: ['', [Validators.required, Validators.pattern('[0-9]{9}')]],
      salary: ['', [Validators.required, Validators.pattern('^[0-9]*$') ]],
      phone: ['', [Validators.required, Validators.pattern('^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$')]],
      email: ['', [Validators.required, Validators.pattern('[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)')]],
      address: ['', [Validators.required, ]]
    });
    this.activatedRoute.params.subscribe(data => {
      this.employeeId = data.id;
      this.employeeService.getEmployeeById(this.employeeId).subscribe(item => {
        this.formEditEmployee.patchValue(item);
      });
    });
  }
  checkDateOfBirth(absControl: AbstractControl): any {
    const value = absControl.value; // 2021-02-24
    const year = Number(value.substr(0, 4));

    return new Date().getFullYear() - year >= 18 ? null : {AgeGreaterThan18: true};
  }

  editEmployee() {
    this.employeeService.editEmployee(this.formEditEmployee.value, this.employeeId)
      .subscribe(data => {
        this.router.navigateByUrl('employee-list');
      });
  }
}
