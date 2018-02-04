import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoteControllComponent } from './remote-control.component';

describe('RemoteControllComponent', () => {
  let component: RemoteControllComponent;
  let fixture: ComponentFixture<RemoteControllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemoteControllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemoteControllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
