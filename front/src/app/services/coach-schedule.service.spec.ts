import { TestBed } from '@angular/core/testing';

import { CoachScheduleService } from './coach-schedule.service';

describe('CoachScheduleService', () => {
  let service: CoachScheduleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CoachScheduleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
