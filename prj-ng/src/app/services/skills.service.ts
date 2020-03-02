import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {SkillsRepository} from './repository/skills.repository';
import {Skill} from '../models/skill';

@Injectable({
  providedIn: 'root'
})
export class SkillsService implements SkillsRepository {

  /*private url: string = window['cfgApiBaseUrl'] + '/api/skills';*/

  private url: string = 'http://localhost:8080/api/skills';

  constructor(private http: HttpClient) {
  }

  all(): Observable<Skill[]> {
    return this.http.get<Skill[]>(this.url);
  }
}
