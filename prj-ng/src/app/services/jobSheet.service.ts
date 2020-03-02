import {Injectable} from '@angular/core';
import {JobSheetRepository} from './repository/jobSheet.repository';
import {JobSheet} from '../models/jobSheet';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JobSheetService implements JobSheetRepository {

  /*private url: string = window['cfgApiBaseUrl'] + '/jobSheet';*/

  private url: string = 'http://localhost:8080/jobSheet';

  constructor(private http: HttpClient) {
  }

  add(jobSheet: JobSheet): Observable<JobSheet> {
    return this.http.post<JobSheet>(this.url, jobSheet);
  }

  all(): Observable<JobSheet[]> {
    return this.http.get<JobSheet[]>(this.url);
  }

  byId(id: string): Observable<JobSheet> {
    return this.http.get<JobSheet>(`${this.url}/${id}`);
  }

  update(id: string, jobSheet: JobSheet): Observable<JobSheet> {
    return this.http.put<JobSheet>(`${this.url}/${id}`, jobSheet);
  }

  delete(id: string): Observable<JobSheet> {
    return this.http.delete<JobSheet>(`${this.url}/${id}`);
  }

  writeJson() {
    return this.http.get(`${this.url}/write`);
  }
}
