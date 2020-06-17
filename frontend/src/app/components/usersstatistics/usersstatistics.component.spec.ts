import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersstatisticsComponent } from './usersstatistics.component';

describe('UsersstatisticsComponent', () => {
  let component: UsersstatisticsComponent;
  let fixture: ComponentFixture<UsersstatisticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsersstatisticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersstatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
