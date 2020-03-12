import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ManagerRepository} from './services/repository/manager.repository';
import {AgentRepository} from './services/repository/agent.repository';
import {JobSheetRepository} from './services/repository/jobSheet.repository';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {JobSheetService} from './services/jobSheet.service';
import {AgentService} from './services/agent.service';
import {ManagerService} from './services/manager.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {JobsheetDetailsComponent} from './components/jobsheet-details/jobsheet-details.component';
import {JobsheetComponent} from './components/jobsheet/jobsheet.component';
import {JobsheetAddComponent} from './components/jobsheet-add/jobsheet-add.component';
import {JobsheetEditComponent} from './components/jobsheet-edit/jobsheet-edit.component';
import {RegisterComponent} from './components/register/register.component';
import {SkillsRepository} from './services/repository/skills.repository';
import {SkillsService} from './services/skills.service';

@NgModule({
  declarations: [
    AppComponent,
    JobsheetComponent,
    JobsheetDetailsComponent,
    JobsheetAddComponent,
    JobsheetEditComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    {provide: JobSheetRepository, useFactory: (http: HttpClient) => new JobSheetService(http), deps: [HttpClient]},
    {provide: AgentRepository, useFactory: (http: HttpClient) => new AgentService(http), deps: [HttpClient]},
    {provide: ManagerRepository, useFactory: (http: HttpClient) => new ManagerService(http), deps: [HttpClient]},
    {provide: SkillsRepository, useFactory: (http: HttpClient) => new SkillsService(http), deps: [HttpClient]}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
