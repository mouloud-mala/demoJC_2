import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Manager} from '../models/manager';
import {ManagerRepository} from './repository/manager.repository';

@Injectable({
  providedIn: 'root'
})
export class ManagerService implements ManagerRepository {

  /*private url: string = window['cfgApiBaseUrl'] + '/recruiter';*/

  private url: string = 'http://localhost:8080/recruiter';

  constructor(private http: HttpClient) {
  }

  add(recruiter: Manager): Observable<Manager> {
    return this.http.post<Manager>(`${this.url}`, recruiter);
  }

  all(): Observable<Manager[]> {
    return this.http.get<Manager[]>(`${this.url}`);
  }

  byId(id: string): Observable<Manager> {
    return this.http.get<Manager>(`${this.url}/${id}`);
  }

  byMail(mail: string): Observable<Manager> {
    return this.http.post<Manager>(`${this.url}`, mail);
  }

  update(id: string, recruiter: Manager): Observable<Manager> {
    return this.http.put<Manager>(`${this.url}/${id}`, recruiter);
  }

  delete(id: string): Observable<Manager> {
    return this.http.delete<Manager>(`${this.url}/${id}`);
  }

  /*login(mail: string, password: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(mail + ':' + password)

      })
    };
    return this.http.post('http://localhost:8080/login', httpOptions);
  }*/
}
