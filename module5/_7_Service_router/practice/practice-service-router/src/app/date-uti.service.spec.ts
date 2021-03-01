import { TestBed } from '@angular/core/testing';

import { DateUtiService } from './date-uti.service';

describe('DateUtiService', () => {
  let service: DateUtiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DateUtiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
