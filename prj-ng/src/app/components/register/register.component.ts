import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ManagerRepository} from '../../services/repository/manager.repository';
import {Manager} from '../../models/manager';

@Component({
  selector: 'app-subscribe',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;

  lastName = '';
  firstName = '';
  mail = '';
  password = '';
  city = '';
  country = '';

  lastNameFormControl = new FormControl('', [
    Validators.required
  ]);
  firstNameFormControl = new FormControl('', [
    Validators.required
  ]);
  mailFormControl = new FormControl('', [
    Validators.required
  ]);
  passwordFormControl = new FormControl('', [
    Validators.required
  ]);
  cityFormControl = new FormControl('', [
    Validators.required
  ]);
  countryFormControl = new FormControl('', [
    Validators.required
  ]);

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private managerService: ManagerRepository
  ) {
    this.registerForm = this.formBuilder.group({
      lastName: '',
      firstName: '',
      mail: '',
      password: '',
      city: '',
      country: ''
    });
  }

  ngOnInit() {
  }

  onSubmit(data: Manager) {
    if (this.isFormComplete(data)) {
      this.managerService.add(data).subscribe(() => {
        this.registerForm.reset();
        this.openSnackBar();
      });
    }
  }

  private isFormComplete(data: Manager) {
    return data && (data.lastName && data.firstName && data.mail && data.password && data.city && data.country);
  }

  private openSnackBar() {

    this.router.navigate(['']);
  }
}
