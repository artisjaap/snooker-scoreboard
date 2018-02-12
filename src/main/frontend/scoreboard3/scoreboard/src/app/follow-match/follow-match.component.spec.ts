import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FollowMatchComponent } from './follow-match.component';

describe('FollowMatchComponent', () => {
  let component: FollowMatchComponent;
  let fixture: ComponentFixture<FollowMatchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FollowMatchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FollowMatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
