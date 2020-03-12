import {Observable} from 'rxjs';
import {Skill} from '../../models/skill';
import {JobSheet} from '../../models/jobSheet';

export abstract class SkillsRepository {
  abstract all(): Observable<Skill[]>;

  abstract byId(id: string): Observable<Skill>;
}
