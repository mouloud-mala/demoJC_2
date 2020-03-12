import {Skill} from './skill';

export class JobSheet {
  idJobSheet: string;
  title: string;
  /*author: Manager;*/
  description: string;
  skillList: Array<Skill>;
}
