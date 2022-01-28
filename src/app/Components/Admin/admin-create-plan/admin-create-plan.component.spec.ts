import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreatePlanComponent } from './admin-create-plan.component';

describe('AdminCreatePlanComponent', () => {
  let component: AdminCreatePlanComponent;
  let fixture: ComponentFixture<AdminCreatePlanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCreatePlanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreatePlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
