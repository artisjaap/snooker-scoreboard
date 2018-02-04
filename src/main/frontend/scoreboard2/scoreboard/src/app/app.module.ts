import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { SplashscreenComponent } from './splashscreen/splashscreen.component';
import { CreateMatchComponent } from './create-match/create-match.component';
import { FollowMatchComponent } from './follow-match/follow-match.component';
import {RemoteControlComponent} from './remote-control/remote-control.component';
import {RouterModule, Routes} from "@angular/router";
import {CustomHttpService} from "./common/custom-http.service";
import {MatchService} from "./common/match.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { RemoteControlConnectComponent } from './remote-control-connect/remote-control-connect.component';
import {MatchWsService} from "./common/matchws.service";
import {NgxQRCodeModule} from "@techiediaries/ngx-qrcode";
import { QrPopupComponent } from './follow-match/qr-popup/qr-popup.component';
import {MatDialogModule} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";



const routes:Routes = [
  {path: "create-match", component: CreateMatchComponent, },
  {path: "follow-match/:matchId", component: FollowMatchComponent },
  {path: "remote-control", component: RemoteControlComponent },
  {path: "splash", component: SplashscreenComponent},
  {path: "remote-connect/:username/:password", component: RemoteControlConnectComponent},
  {path: "**", redirectTo: "splash"}
  ]

@NgModule({
  declarations: [
    AppComponent,
    SplashscreenComponent,
    CreateMatchComponent,
    FollowMatchComponent,
    RemoteControlComponent,
    RemoteControlConnectComponent,
    QrPopupComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgxQRCodeModule,
    RouterModule.forRoot(routes),
    MatDialogModule,BrowserAnimationsModule

  ],
  providers: [CustomHttpService,
    MatchService,
    MatchWsService
  ],
  bootstrap: [AppComponent],
  entryComponents: [QrPopupComponent]
})
export class AppModule { }
