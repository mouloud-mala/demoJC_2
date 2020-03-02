import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JobsheetDetailsComponent } from './jobsheet-details.component';

describe('CustomerDetailsComponent', () => {
  let component: JobsheetDetailsComponent;
  let fixture: ComponentFixture<JobsheetDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JobsheetDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JobsheetDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
