import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JobsheetAddComponent } from './jobsheet-add.component';

describe('CustomerAddComponent', () => {
  let component: JobsheetAddComponent;
  let fixture: ComponentFixture<JobsheetAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JobsheetAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JobsheetAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
