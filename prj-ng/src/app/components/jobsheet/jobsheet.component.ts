import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {JobSheet} from '../../models/jobSheet';
import {JobSheetRepository} from '../../services/repository/jobSheet.repository';
import {ActivatedRoute, Router} from '@angular/router';
import {Skill} from '../../models/skill';
import {SkillsRepository} from '../../services/repository/skills.repository';

@Component({
  selector: 'app-customer',
  templateUrl: './jobsheet.component.html',
  styleUrls: ['./jobsheet.component.scss']
})
export class JobsheetComponent implements OnInit {

  jobSheet: Observable<JobSheet[]>;
  skill: Observable<Skill>;

  constructor(
    private jobSheetService: JobSheetRepository,
    private skillsService: SkillsRepository,
    private router: Router,
    private route: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.reloadData();
  }

  onDelete(id) {
    this.jobSheetService.delete(id).subscribe(() => {
      this.reloadData();
    });
  }

  updateJobsheet(id: string): void {
    this.router.navigate(['edit', id]);
  }

  reloadData() {
    this.route.paramMap.subscribe(params => {
      console.log(params);
      this.jobSheet = this.jobSheetService.all();
      this.skill = this.skillsService.byId(params.get('id'));
    });
  }

  exportJson() {
    this.jobSheetService.writeJson().subscribe(data => {
      console.log(data);
    });
  }
}
