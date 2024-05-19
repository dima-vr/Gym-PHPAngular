import { Component } from '@angular/core';

@Component({
  selector: 'app-user-schedule',
  templateUrl: './user-schedule.component.html',
  styleUrls: ['./user-schedule.component.scss']
})
export class UserScheduleComponent {
  schedule = [
    { day: 'Monday', activity: 'Stretch', duration: '45 min', time: '08:00' },
    { day: 'Tuesday', activity: 'Back Stretch', duration: '30 min', time: '08:00' },
    { day: 'Wednesday', activity: 'Yoga', duration: '20 min', time: '08:00' }
  ];

  trainers = [
    { name: 'Trainer 1', image: 'path/to/image1.jpg' },
    { name: 'Trainer 2', image: 'path/to/image2.jpg' },
    { name: 'Trainer 3', image: 'path/to/image3.jpg' },
    { name: 'Trainer 4', image: 'path/to/image4.jpg' }
  ];

  goals = ['Lose weight', 'Raise the form', 'Improve health'];

  goalProgress = [
    { day: 'Mon', progress: 20 },
    { day: 'Tue', progress: 40 },
    { day: 'Wed', progress: 100 },
    { day: 'Thu', progress: 60 },
    { day: 'Fri', progress: 40 },
    { day: 'Sat', progress: 20 },
    { day: 'Sun', progress: 0 }
  ];

  currentGoal = this.goals[0];
}
