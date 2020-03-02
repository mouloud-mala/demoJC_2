import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Agent} from '../models/agent';
import {AgentRepository} from './repository/agent.repository';

@Injectable({
  providedIn: 'root'
})
export class AgentService implements AgentRepository {

  /*private url: string = window['cfgApiBaseUrl'] + '/api/agents';*/

  private url: string = 'http://localhost:8080/api/agents';

  constructor(private http: HttpClient) {
  }

  add(agent: Agent): Observable<Agent> {
    return this.http.post<Agent>(this.url, agent);
  }

  all(): Observable<Agent[]> {
    return this.http.get<Agent[]>(this.url);
  }

  byId(id: string): Observable<Agent> {
    return this.http.get<Agent>(`${this.url}/${id}`);
  }

  update(id: string, agent: Agent): Observable<Agent> {
    return this.http.put<Agent>(`${this.url}/${id}`, agent);
  }

  delete(id: string): Observable<Agent> {
    return this.http.delete<Agent>(`${this.url}/${id}`);
  }
}
