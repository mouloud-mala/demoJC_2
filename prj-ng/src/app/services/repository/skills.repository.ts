import {Observable} from 'rxjs';
import {Skill} from '../../models/skill';

export abstract class SkillsRepository {
  abstract all(): Observable<Skill[]>;
}
