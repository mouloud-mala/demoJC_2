import {Observable} from 'rxjs';
import {JobSheet} from '../../models/jobSheet';

export abstract class JobSheetRepository {
  abstract all(): Observable<JobSheet[]>;

  abstract add(jobSheet: JobSheet): Observable<JobSheet>;

  abstract byId(id: string): Observable<JobSheet>;

  abstract delete(id: string): Observable<JobSheet>;

  abstract update(id: string, jobSheet: JobSheet): Observable<JobSheet>;

  abstract writeJson();
}
