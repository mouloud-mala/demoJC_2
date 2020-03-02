import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JobsheetEditComponent } from './jobsheet-edit.component';

describe('CustomerEditComponent', () => {
  let component: JobsheetEditComponent;
  let fixture: ComponentFixture<JobsheetEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JobsheetEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JobsheetEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
