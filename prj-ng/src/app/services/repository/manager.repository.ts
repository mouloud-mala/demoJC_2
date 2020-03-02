import {Observable} from 'rxjs';
import {Manager} from '../../models/manager';

export abstract class ManagerRepository {
  abstract all(): Observable<Manager[]>;

  abstract add(recruiter: Manager): Observable<Manager>;

  abstract byId(id: string): Observable<Manager>;

  abstract byMail(mail: string): Observable<Manager>;

  abstract delete(id: string): Observable<Manager>;

  abstract update(id: string, recruiter: Manager): Observable<Manager>;

  /*abstract login(mail: string, password: string);*/
}
