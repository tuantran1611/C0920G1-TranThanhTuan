import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SotietkiemDeleteComponent } from './sotietkiem-delete.component';

describe('SotietkiemDeleteComponent', () => {
  let component: SotietkiemDeleteComponent;
  let fixture: ComponentFixture<SotietkiemDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SotietkiemDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SotietkiemDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
