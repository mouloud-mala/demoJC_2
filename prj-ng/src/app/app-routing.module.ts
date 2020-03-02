import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {JobsheetComponent} from './components/jobsheet/jobsheet.component';
import {JobsheetDetailsComponent} from './components/jobsheet-details/jobsheet-details.component';
import {JobsheetAddComponent} from './components/jobsheet-add/jobsheet-add.component';
import {JobsheetEditComponent} from './components/jobsheet-edit/jobsheet-edit.component';
import {RegisterComponent} from './components/register/register.component';


const routes: Routes = [
  {path: 'jobSheet', component: JobsheetComponent},
  {path: 'jobSheet/:id', component: JobsheetDetailsComponent},
  {path: 'add', component: JobsheetAddComponent},
  {path: 'edit/:id', component: JobsheetEditComponent},
  /*{path: '', redirectTo: 'login', pathMatch: 'full'},*/
  {path: 'register', component: RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
