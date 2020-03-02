import {Observable} from 'rxjs';
import {Agent} from '../../models/agent';

export abstract class AgentRepository {
  abstract all(): Observable<Agent[]>;

  abstract add(agent: Agent): Observable<Agent>;

  abstract byId(id: string): Observable<Agent>;

  abstract delete(id: string): Observable<Agent>;

  abstract update(id: string, agent: Agent): Observable<Agent>;
}
