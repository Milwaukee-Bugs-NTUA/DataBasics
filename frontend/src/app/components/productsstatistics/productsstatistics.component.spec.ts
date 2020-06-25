import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsstatisticsComponent } from './productsstatistics.component';

describe('ProductsstatisticsComponent', () => {
  let component: ProductsstatisticsComponent;
  let fixture: ComponentFixture<ProductsstatisticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductsstatisticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsstatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
