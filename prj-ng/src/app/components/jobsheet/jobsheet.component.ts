import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {JobSheet} from '../../models/jobSheet';
import {JobSheetRepository} from '../../services/repository/jobSheet.repository';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './jobsheet.component.html',
  styleUrls: ['./jobsheet.component.scss']
})
export class JobsheetComponent implements OnInit {

  jobSheet: Observable<JobSheet[]>;

  constructor(
    private jobSheetService: JobSheetRepository,
    private router: Router
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
    this.jobSheet = this.jobSheetService.all();
  }

  exportJson() {
    this.jobSheetService.writeJson().subscribe(data => {
      console.log(data);
    });
  }
}
