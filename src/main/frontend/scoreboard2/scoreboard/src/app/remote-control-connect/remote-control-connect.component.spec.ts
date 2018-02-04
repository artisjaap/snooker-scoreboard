import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoteControlConnectComponent } from './remote-control-connect.component';

describe('RemoteControlConnectComponent', () => {
  let component: RemoteControlConnectComponent;
  let fixture: ComponentFixture<RemoteControlConnectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemoteControlConnectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemoteControlConnectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
