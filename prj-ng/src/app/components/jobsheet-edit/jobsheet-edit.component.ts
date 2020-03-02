import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {JobSheetRepository} from '../../services/repository/jobSheet.repository';
import {JobSheet} from '../../models/jobSheet';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './jobsheet-edit.component.html',
  styleUrls: ['./jobsheet-edit.component.scss']
})
export class JobsheetEditComponent implements OnInit {

  idJobSheet: string;
  jobSheet: JobSheet;
  editForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private customerService: JobSheetRepository) {
  }

  ngOnInit() {
    this.jobSheet = new JobSheet();
    this.idJobSheet = this.route.snapshot.params.id;
    this.customerService.byId(this.idJobSheet).subscribe(data => {
      this.jobSheet = data;
    });
  }

  onSubmit() {
    this.customerService.update(this.idJobSheet, this.jobSheet).subscribe(data => {
      this.jobSheet = new JobSheet();
      this.router.navigate(['/jobSheet']);
    });
  }
}
