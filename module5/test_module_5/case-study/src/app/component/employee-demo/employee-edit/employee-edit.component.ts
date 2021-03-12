import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../../services/employee.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  public employeeId: number;
  public formEdit: FormGroup;
  constructor(
    public fb: FormBuilder,
    public employeeService: EmployeeService,
    public router: Router,
    public activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.formEdit = this.fb.group({
      firstName: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
    });
    this.activatedRoute.params.subscribe(data => {
      this.employeeId = Number(data.id);
      this.employeeService.getEmployeeById(this.employeeId).subscribe(item => {
        this.formEdit.patchValue(item);
      });
    });
  }
  editEmployee() {
    this.employeeService.editEmployee(this.formEdit.value, this.employeeId)
      .subscribe(data => {
        this.router.navigateByUrl('employee-list');
      });
  }
}
