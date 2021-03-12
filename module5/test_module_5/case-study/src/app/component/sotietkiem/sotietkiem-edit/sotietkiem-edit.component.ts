import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {SotietkiemService} from '../../../services/sotietkiem.service';
import {KhachhangService} from '../../../services/khachhang.service';

interface KiHan {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-sotietkiem-edit',
  templateUrl: './sotietkiem-edit.component.html',
  styleUrls: ['./sotietkiem-edit.component.css']
})
export class SotietkiemEditComponent implements OnInit {

  private sotietkiemId;
  public formEdit: FormGroup;
  public khachHang: any[];
  items: KiHan[] = [
    {value: '1', viewValue: '6 tháng'},
    {value: '2', viewValue: '3 tháng'},
    {value: '3', viewValue: '1 năm'},
    {value: '4', viewValue: '5 năm'},
    {value: '5', viewValue: 'Không kỳ hạn'},
  ];

  constructor(
    public fb: FormBuilder,
    public sotietkiemService: SotietkiemService,
    public khachhangService: KhachhangService,
    public router: Router,
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.getKhachHang();
    this.formEdit = this.fb.group({
      id: ['', [Validators.required ]],
      khachHang: ['', [Validators.required]],
      ngayMo: ['', [Validators.required]],
      ngayGui: ['', [Validators.required]],
      kiHan: ['', [Validators.required]],
      soTien: ['', [Validators.required, Validators.pattern('[1-9][0-9]{7}[0-9]*')]],
      laiSuat: ['', [Validators.required, Validators.pattern('[0-9]+|-[0-9]+') ]],
      uuDai: ['', [Validators.required]],
    });
    this.activatedRoute.params.subscribe(data => {
      this.sotietkiemId = data.id;
      this.sotietkiemService.laySoById(this.sotietkiemId).subscribe(item => {
        this.formEdit.patchValue(item);
      });
    });
  }
  checkDateOfBirth(absControl: AbstractControl): any {
    const value = absControl.value; // 2021-02-24
    const year = Number(value.substr(0, 4));

    return new Date().getFullYear() - year >= 18 ? null : {AgeGreaterThan18: true};
  }

  editEmployee() {
    this.sotietkiemService.editSo(this.formEdit.value, this.sotietkiemId)
      .subscribe(data => {
        this.router.navigateByUrl('sotietkiem-list');
      });
  }
  getKhachHang() {
    this.sotietkiemService.layKhachHang().subscribe(data => {
      this.khachHang = data;
    });
  }

}
