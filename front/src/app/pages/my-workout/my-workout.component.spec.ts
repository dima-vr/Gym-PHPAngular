import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyWorkoutComponent } from './my-workout.component';

describe('MyWorkoutComponent', () => {
  let component: MyWorkoutComponent;
  let fixture: ComponentFixture<MyWorkoutComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MyWorkoutComponent]
    });
    fixture = TestBed.createComponent(MyWorkoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
