import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManytomanyComponent } from './manytomany.component';

describe('ManytomanyComponent', () => {
  let component: ManytomanyComponent;
  let fixture: ComponentFixture<ManytomanyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManytomanyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManytomanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
