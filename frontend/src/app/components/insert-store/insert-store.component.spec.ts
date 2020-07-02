import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertStoreComponent } from './insert-store.component';

describe('InsertStoreComponent', () => {
  let component: InsertStoreComponent;
  let fixture: ComponentFixture<InsertStoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertStoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
