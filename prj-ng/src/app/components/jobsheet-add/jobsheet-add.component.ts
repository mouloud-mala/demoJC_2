import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {JobSheetRepository} from '../../services/repository/jobSheet.repository';
import {JobSheet} from '../../models/jobSheet';

@Component({
  selector: 'app-customer-add',
  templateUrl: './jobsheet-add.component.html',
  styleUrls: ['./jobsheet-add.component.scss']
})
export class JobsheetAddComponent implements OnInit {

  jobSheetForm: FormGroup;

  title = '';
  author = '';
  description = '';
  skills = '';

  titleFormControl = new FormControl('', [
    Validators.required
  ]);
  authorFormControl = new FormControl('', [
    Validators.required
  ]);
  descriptionFormControl = new FormControl('', [
    Validators.required
  ]);
  skillsFormControl = new FormControl('', [
    Validators.required
  ]);

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private jobSheetService: JobSheetRepository
  ) {
    this.jobSheetForm = this.formBuilder.group({
      title: '',
     /* author: this.formBuilder.group({
        id: ''
      }),*/
      description: '',
      skills: ''
    });
  }

  ngOnInit() {
  }

  onSubmit(data: JobSheet) {
    if (this.isFormComplete(data)) {
      this.jobSheetService.add(data).subscribe(() => {
        this.jobSheetForm.reset();
        this.openSnackBar();
      });
    }
  }

  private isFormComplete(data: JobSheet) {
    return data && (data.title /*&& data.author */&& data.description && data.skills);
  }

  private openSnackBar() {

    this.router.navigate(['/jobSheet']);
  }
}
