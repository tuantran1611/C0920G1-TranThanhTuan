import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {EmployeeService} from '../../../services/employee.service';
import {SotietkiemService} from '../../../services/sotietkiem.service';

@Component({
  selector: 'app-sotietkiem-delete',
  templateUrl: './sotietkiem-delete.component.html',
  styleUrls: ['./sotietkiem-delete.component.css']
})
export class SotietkiemDeleteComponent implements OnInit {

  public employeeFullName;
  public employeeId;

  constructor(
    public dialogRef: MatDialogRef<SotietkiemDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public sotietkiemService: SotietkiemService
  ) {}

  ngOnInit(): void {
    this.employeeFullName = this.data.data1.id;
    this.employeeId = this.data.data1.id;
  }

  deleteEmployee() {
    this.sotietkiemService.deleteSo(this.employeeId).subscribe(data => {
      this.dialogRef.close();
    });
  }

}
