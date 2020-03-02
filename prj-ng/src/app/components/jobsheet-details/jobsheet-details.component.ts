import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {JobSheet} from '../../models/jobSheet';
import {ActivatedRoute, Router} from '@angular/router';
import {JobSheetRepository} from '../../services/repository/jobSheet.repository';

@Component({
  selector: 'app-customer-details',
  templateUrl: './jobsheet-details.component.html',
  styleUrls: ['./jobsheet-details.component.scss']
})
export class JobsheetDetailsComponent implements OnInit {

  jobSheet: Observable<JobSheet>;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private jobSheetService: JobSheetRepository
  ) {
  }

  ngOnInit() {

    this.route.paramMap.subscribe(params => {
      this.jobSheet = this.jobSheetService.byId(params.get('id'));
    });
  }

  editCustomer(jobsheet: JobSheet): void {
    window.localStorage.removeItem('editJobSheetId');
    window.localStorage.setItem('editJobSheetId', jobsheet.idJobSheet);
    this.router.navigate(['edit']);
  }

}
