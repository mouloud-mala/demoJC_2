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

@NgModule({
  declarations: [
    AppComponent
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
    {provide: ManagerRepository, useFactory: (http: HttpClient) => new ManagerService(http), deps: [HttpClient]}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
