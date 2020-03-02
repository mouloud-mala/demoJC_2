import { TestBed } from '@angular/core/testing';

import { JobSheetService } from './jobSheet.service';

describe('CustomerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JobSheetService = TestBed.get(JobSheetService);
    expect(service).toBeTruthy();
  });
});
