import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JobsheetComponent } from './jobsheet.component';

describe('CustomerComponent', () => {
  let component: JobsheetComponent;
  let fixture: ComponentFixture<JobsheetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JobsheetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JobsheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
