import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { SplashscreenComponent } from './splashscreen/splashscreen.component';
import { CreateMatchComponent } from './create-match/create-match.component';
import { FollowMatchComponent } from './follow-match/follow-match.component';
import {RemoteControlComponent} from './remote-control/remote-control.component';
import {RouterModule, Routes} from "@angular/router";

const routes:Routes = [
  {path: "create-match", component: CreateMatchComponent, },
  {path: "follow-match", component: FollowMatchComponent },
  {path: "remote-control", component: RemoteControlComponent },
  {path: "splash", component: SplashscreenComponent},
  {path: "**", redirectTo: "splash"}
  ]

@NgModule({
  declarations: [
    AppComponent,
    SplashscreenComponent,
    CreateMatchComponent,
    FollowMatchComponent,
    RemoteControlComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
