import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {JobSheetRepository} from '../../services/repository/jobSheet.repository';
import {JobSheet} from '../../models/jobSheet';
import {Observable} from 'rxjs';
import {Skill} from '../../models/skill';
import {SkillsRepository} from '../../services/repository/skills.repository';

@Component({
  selector: 'app-customer-add',
  templateUrl: './jobsheet-add.component.html',
  styleUrls: ['./jobsheet-add.component.scss']
})
export class JobsheetAddComponent implements OnInit {

  jobSheetForm: FormGroup;
  listeSkill: Observable<Skill[]>;

  /*title = '';
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
  ]);*/

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private jobSheetService: JobSheetRepository,
    private skillsService: SkillsRepository
  ) {
    /*this.jobSheetForm = this.formBuilder.group({
      title: '',
      /!* author: this.formBuilder.group({
         id: ''
       }),*!/
      description: '',
      skills: ''
    });*/
  }

  ngOnInit() {
    this.listeSkill = this.skillsService.all();
    console.log(this.listeSkill);
    this.initForm();
  }

  initForm() {
    this.jobSheetForm = this.formBuilder.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      skillList: this.formBuilder.array([this.formBuilder.group({skill: ''})]),
    });
  }

  onSubmit(data: JobSheet) {
    if (this.isFormComplete(data)) {
      this.jobSheetService.add(data).subscribe(() => {
        this.jobSheetForm.reset();
        this.openSnackBar();
      });
    }
  }

  getSkills(): FormArray {
    return this.jobSheetForm.get('skillList') as FormArray;
  }

  onAddSkill() {
    const newSkillControl = this.formBuilder.control(this.listeSkill, Validators.required);
    this.getSkills().push(newSkillControl);
  }

  private isFormComplete(data: JobSheet) {
    return data && (data.title /*&& data.author */ && data.description && data.skillList);
  }

  private openSnackBar() {
    this.router.navigate(['/jobSheet']);
  }
}
