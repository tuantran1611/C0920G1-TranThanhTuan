import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../services/customer.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  public formCreateCustomer: FormGroup;
  constructor(
    public fb: FormBuilder,
    public customerService: CustomerService,
    public router: Router,
  ) { }

  ngOnInit(): void {
    this.formCreateCustomer = this.fb.group({
      customerType: ['', [Validators.required ]],
      fullName: ['', [Validators.required ]],
      dayOfBirth: ['', [Validators.required, this.checkDateOfBirth]],
      idCard: ['', [Validators.required, Validators.pattern('[0-9]{9}')]],
      phone: ['', [Validators.required, Validators.pattern('^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$')]],
      email: ['', [Validators.required, Validators.pattern('[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)')]],
      address: ['', [Validators.required, ]]
    });
  }
  checkDateOfBirth(absControl: AbstractControl): any {
    const value = absControl.value; // 2021-02-24
    const year = Number(value.substr(0, 4));

    return new Date().getFullYear() - year >= 18 ? null : {AgeGreaterThan18: true};
  }

  addNewCustomer() {
    this.customerService.addNewCustomer(this.formCreateCustomer.value)
      .subscribe(data => {
        this.router.navigateByUrl('customer-list');
      });
  }

}
