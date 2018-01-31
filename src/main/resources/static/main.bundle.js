webpackJsonp(["main"],{

/***/ "../../../../../src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "\n<router-outlet></router-outlet>\n\n\n\n"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = (function () {
    function AppComponent() {
        this.title = 'app';
    }
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__splashscreen_splashscreen_component__ = __webpack_require__("../../../../../src/app/splashscreen/splashscreen.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__create_match_create_match_component__ = __webpack_require__("../../../../../src/app/create-match/create-match.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__follow_match_follow_match_component__ = __webpack_require__("../../../../../src/app/follow-match/follow-match.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__remote_control_remote_control_component__ = __webpack_require__("../../../../../src/app/remote-control/remote-control.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__common_custom_http_service__ = __webpack_require__("../../../../../src/app/common/custom-http.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__common_match_service__ = __webpack_require__("../../../../../src/app/common/match.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__remote_control_connect_remote_control_connect_component__ = __webpack_require__("../../../../../src/app/remote-control-connect/remote-control-connect.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__common_matchws_service__ = __webpack_require__("../../../../../src/app/common/matchws.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};














var routes = [
    { path: "create-match", component: __WEBPACK_IMPORTED_MODULE_4__create_match_create_match_component__["a" /* CreateMatchComponent */], },
    { path: "follow-match/:matchId", component: __WEBPACK_IMPORTED_MODULE_5__follow_match_follow_match_component__["a" /* FollowMatchComponent */] },
    { path: "remote-control", component: __WEBPACK_IMPORTED_MODULE_6__remote_control_remote_control_component__["a" /* RemoteControlComponent */] },
    { path: "splash", component: __WEBPACK_IMPORTED_MODULE_3__splashscreen_splashscreen_component__["a" /* SplashscreenComponent */] },
    { path: "remote-connect/:username/:password", component: __WEBPACK_IMPORTED_MODULE_12__remote_control_connect_remote_control_connect_component__["a" /* RemoteControlConnectComponent */] },
    { path: "**", redirectTo: "splash" }
];
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["I" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_2__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_3__splashscreen_splashscreen_component__["a" /* SplashscreenComponent */],
                __WEBPACK_IMPORTED_MODULE_4__create_match_create_match_component__["a" /* CreateMatchComponent */],
                __WEBPACK_IMPORTED_MODULE_5__follow_match_follow_match_component__["a" /* FollowMatchComponent */],
                __WEBPACK_IMPORTED_MODULE_6__remote_control_remote_control_component__["a" /* RemoteControlComponent */],
                __WEBPACK_IMPORTED_MODULE_12__remote_control_connect_remote_control_connect_component__["a" /* RemoteControlConnectComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_10__angular_common_http__["b" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_11__angular_forms__["c" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_11__angular_forms__["d" /* ReactiveFormsModule */],
                __WEBPACK_IMPORTED_MODULE_7__angular_router__["c" /* RouterModule */].forRoot(routes),
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_8__common_custom_http_service__["a" /* CustomHttpService */],
                __WEBPACK_IMPORTED_MODULE_9__common_match_service__["a" /* MatchService */],
                __WEBPACK_IMPORTED_MODULE_13__common_matchws_service__["a" /* MatchWsService */]
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_2__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "../../../../../src/app/common/NewMatchResponse.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NewMatchResponse; });
/**
 * Created by stijn on 22/01/18.
 */
var NewMatchResponse = (function () {
    function NewMatchResponse() {
    }
    return NewMatchResponse;
}());



/***/ }),

/***/ "../../../../../src/app/common/custom-http.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CustomHttpService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};


var CustomHttpService = (function () {
    function CustomHttpService(http, apiUrl) {
        this.http = http;
        this.apiUrl = apiUrl;
    }
    CustomHttpService.prototype.postJson = function (url, data) {
        return this.post(url, data);
    };
    CustomHttpService.prototype.getJson = function (url) {
        return this.get(url);
    };
    CustomHttpService.prototype.post = function (url, data) {
        return this.http.post(this.apiUrl + url, data);
    };
    CustomHttpService.prototype.get = function (url) {
        return this.http.get(this.apiUrl + url);
    };
    CustomHttpService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["A" /* Injectable */])(),
        __param(1, Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["z" /* Inject */])('API_URL')),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */], String])
    ], CustomHttpService);
    return CustomHttpService;
}());



/***/ }),

/***/ "../../../../../src/app/common/match.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MatchService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs__ = __webpack_require__("../../../../rxjs/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_rxjs__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__NewMatchResponse__ = __webpack_require__("../../../../../src/app/common/NewMatchResponse.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var MatchService = (function () {
    function MatchService(httpClient) {
        this.httpClient = httpClient;
        this.matchData = { jwtToken: "", matchId: 0 };
        this.apiUrl = __WEBPACK_IMPORTED_MODULE_4__environments_environment__["a" /* environment */].serverUrl;
        this.resetTokenFromLocalStorage();
    }
    MatchService.prototype.resetTokenFromLocalStorage = function () {
        var storedMatch = localStorage.getItem("match");
        if (storedMatch) {
            this.matchData = JSON.parse(storedMatch);
        }
    };
    MatchService.prototype.createMatch = function (match) {
        var _this = this;
        var subject = new __WEBPACK_IMPORTED_MODULE_1_rxjs__["BehaviorSubject"](new __WEBPACK_IMPORTED_MODULE_3__NewMatchResponse__["a" /* NewMatchResponse */]());
        //FIXME there are two subscribers on this post request
        //one here and one in the createMatchComponent
        //this is causing the post to fire two request to the server (one for each subscriber)
        //useing a BehaviorSubject solves this but isnt the best solution
        var post = this.httpClient.post(this.apiUrl + "public/api/match/new", match);
        post.subscribe(function (response) {
            _this.matchData.jwtToken = "Bearer " + response.jwtToken;
            _this.matchData.matchId = response.matchId;
            localStorage.setItem("match", JSON.stringify(_this.matchData));
            subject.next(response);
        });
        return subject.asObservable();
    };
    MatchService.prototype.matchDetails = function (matchId) {
        return this.httpClient.get(this.apiUrl + "public/api/match/" + matchId);
    };
    MatchService.prototype.changeTurn = function () {
        return this.httpClient.put(this.apiUrl + "secure/api/match/" + this.matchData.matchId + "/change-turn", {}, { headers: { 'Authorization': this.matchData.jwtToken } });
    };
    MatchService.prototype.addPoints = function (points) {
        return this.httpClient.put(this.apiUrl + "secure/api/match/" + this.matchData.matchId + "/add-points/" + points, {}, { headers: { 'Authorization': this.matchData.jwtToken } });
    };
    MatchService.prototype.newFrame = function () {
        return this.httpClient.put(this.apiUrl + "secure/api/match/" + this.matchData.matchId + "/new-frame", {}, { headers: { 'Authorization': this.matchData.jwtToken } });
    };
    MatchService.prototype.curentMatchId = function () {
        return this.matchData.matchId;
    };
    MatchService.prototype.loginWith = function (username, password) {
        var _this = this;
        var subject = new __WEBPACK_IMPORTED_MODULE_1_rxjs__["BehaviorSubject"](new __WEBPACK_IMPORTED_MODULE_3__NewMatchResponse__["a" /* NewMatchResponse */]());
        this.httpClient.get(this.apiUrl + "public/api/login/" + username + "/" + password)
            .subscribe(function (response) {
            _this.matchData.jwtToken = "Bearer " + response.jwtToken;
            _this.matchData.matchId = response.matchId;
            subject.next(response);
        });
        return subject.asObservable();
    };
    MatchService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["A" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */]])
    ], MatchService);
    return MatchService;
}());



/***/ }),

/***/ "../../../../../src/app/common/matchws.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MatchWsService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_stompjs__ = __webpack_require__("../../../../stompjs/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_stompjs___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_stompjs__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_sockjs_client__ = __webpack_require__("../../../../sockjs-client/lib/entry.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_sockjs_client___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_sockjs_client__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var MatchWsService = (function () {
    function MatchWsService() {
        this.serverUrl = __WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].wsEndpoint;
        this.initializeWebSocketConnection();
    }
    MatchWsService.prototype.initializeWebSocketConnection = function () {
        var ws = new __WEBPACK_IMPORTED_MODULE_2_sockjs_client___default.a(this.serverUrl);
        this.stompClient = __WEBPACK_IMPORTED_MODULE_1_stompjs___default.a.over(ws);
        console.log("initialized");
    };
    MatchWsService.prototype.connect = function (matchId, funct) {
        var _this = this;
        console.log("connect");
        // let that = this;
        // this.stompClient.connect({}, function(frame) {
        //   that.stompClient.subscribe("/topic/currentframe/" + matchId, funct);
        // });
        this.stompClient.connect({}, function (frame) {
            _this.stompClient.subscribe("/topic/currentframe/" + matchId, funct);
        });
    };
    MatchWsService.prototype.disconnect = function () {
        this.stompClient.disconnect();
    };
    MatchWsService.prototype.addPoints = function (points, matchId) {
        this.sendMessage(matchId, { action: "ADD_POINTS", matchId: matchId, points: points });
    };
    MatchWsService.prototype.changeTurn = function (matchId) {
        this.sendMessage(matchId, { action: "CHANGE_TURN", matchId: matchId });
    };
    MatchWsService.prototype.startNewFrame = function (matchId) {
        this.sendMessage(matchId, { action: "START_NEW_FRAME", matchId: matchId });
    };
    MatchWsService.prototype.sendMessage = function (matchId, message) {
        this.stompClient.send("/app/match/" + matchId, {}, JSON.stringify(message));
    };
    MatchWsService.prototype.isConnected = function () {
        return this.stompClient.connected;
    };
    MatchWsService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["A" /* Injectable */])(),
        __metadata("design:paramtypes", [])
    ], MatchWsService);
    return MatchWsService;
}());



/***/ }),

/***/ "../../../../../src/app/create-match/create-match.component.html":
/***/ (function(module, exports) {

module.exports = "<div style=\"text-align:center\">\n  <h1>\n    Create Match\n  </h1>\n</div>\n<form class=\"match\"  [formGroup]=\"matchForm\" (ngSubmit)=\"createMatch()\">\n\n\n  <div class=\"player row\">\n    <span>Player 1</span>\n    <input type=\"text\" formControlName=\"firstNamePlayer1\">\n    <input type=\"text\" formControlName=\"lastNamePlayer1\">\n  </div>\n\n  <div class=\"player row\">\n    <span>Player 2</span>\n    <input type=\"text\" formControlName=\"firstNamePlayer2\">\n    <input type=\"text\" formControlName=\"lastNamePlayer2\">\n  </div>\n\n\n  <div class=\"games row\">\n    <span># Games</span>\n    <input type=\"number\" formControlName=\"numberOfFrames\">\n  </div>\n\n\n    <button type=\"submit\" class=\"form-link\" >Submit</button>\n\n</form>\n"

/***/ }),

/***/ "../../../../../src/app/create-match/create-match.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".match {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: vertical;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: column;\n          flex-direction: column; }\n\n.row {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  padding: 5px 0; }\n\n.row input {\n  -webkit-box-flex: 1;\n      -ms-flex: 1;\n          flex: 1;\n  margin: 0 2px; }\n\nform input {\n  border: 1px solid white;\n  background-color: transparent;\n  border-radius: 5px;\n  padding: 10px;\n  font-size: 1.1em;\n  color: white; }\n  form input:focus {\n    border: 1px solid red; }\n  form input.ng-invalid {\n    border: 1px solid mediumvioletred; }\n\nform .form-link {\n  width: 100%;\n  border: none;\n  color: white;\n  background-color: #1c94c4;\n  font-size: 2em;\n  padding: 10px;\n  text-align: center;\n  margin: 5px 0; }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/create-match/create-match.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CreateMatchComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__common_match_service__ = __webpack_require__("../../../../../src/app/common/match.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var CreateMatchComponent = (function () {
    function CreateMatchComponent(matchService, router, route) {
        this.matchService = matchService;
        this.router = router;
        this.route = route;
        this.matchForm = new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["b" /* FormGroup */]({
            firstNamePlayer1: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            lastNamePlayer1: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            firstNamePlayer2: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            lastNamePlayer2: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
            numberOfFrames: new __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormControl */]('', __WEBPACK_IMPORTED_MODULE_2__angular_forms__["e" /* Validators */].required),
        });
    }
    CreateMatchComponent.prototype.ngOnInit = function () {
    };
    CreateMatchComponent.prototype.createMatch = function () {
        var _this = this;
        if (this.matchForm.valid) {
            this.matchService.createMatch(this.matchForm.value).subscribe(function (data) {
                console.log("/remote-control-connect/" + data.username + '/' + data.password, data);
                if (data.matchId) {
                    _this.router.navigate(['../follow-match/', data.matchId], { relativeTo: _this.route });
                }
            });
        }
    };
    CreateMatchComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-create-match',
            template: __webpack_require__("../../../../../src/app/create-match/create-match.component.html"),
            styles: [__webpack_require__("../../../../../src/app/create-match/create-match.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__common_match_service__["a" /* MatchService */], __WEBPACK_IMPORTED_MODULE_3__angular_router__["b" /* Router */], __WEBPACK_IMPORTED_MODULE_3__angular_router__["a" /* ActivatedRoute */]])
    ], CreateMatchComponent);
    return CreateMatchComponent;
}());



/***/ }),

/***/ "../../../../../src/app/follow-match/follow-match.component.html":
/***/ (function(module, exports) {

module.exports = "\n<div class=\"scoreboard\" style=\"display: flex;\">\n  <div>\n    <div style=\"display: flex; flex-direction: column\">\n      <div style=\"color:black;background-color: cornflowerblue; width: 20px; height: 30px\">\n        {{match?.currentFrame?.minMax?.maxScore}}\n      </div>\n      <div style=\"color:black;display:flex;align-items: center ;background-color:yellowgreen; width: 20px; height: 100px\">\n        {{match?.currentFrame?.minMax?.saveScore}}\n      </div>\n      <div style=\"color:black;background-color: cornflowerblue; width: 20px; height: 30px\">\n        {{match?.currentFrame?.minMax?.minScore}}\n      </div>\n    </div>\n\n  </div>\n  <div style=\"display:flex; flex:1; justify-content: center; \">\n    <div style=\"display:flex; flex-direction: column; justify-content: center\">\n      <div style=\"display: flex; flex-direction: row; justify-content: center\">\n        <div style=\"margin: 3px 15px; font-size: 1.2em; \" [ngClass]=\"{'active' : match?.currentFrame?.currentPlayer === 1}\">\n          {{match?.player1?.firstName + ' ' + match?.player1?.lastName}}</div>\n        <div style=\"margin: 3px 15px; color:tomato\">Best of {{match?.numberOfFrames}}</div>\n        <div style=\"margin: 3px 15px;  font-size: 1.2em\" [ngClass]=\"{'active' : match?.currentFrame?.currentPlayer === 2}\">\n          {{match?.player2?.firstName + ' ' + match?.player2?.lastName}}</div>\n      </div>\n\n\n\n      <div style=\"display: flex; flex-direction: row; justify-content: center\">\n        <div style=\"margin: 3px 15px\">{{match?.currentFrame?.latestBreakPlayer1}}</div>\n        <div style=\"margin: 3px 15px; \">Last break</div>\n        <div style=\"margin: 3px 15px\">{{match?.currentFrame?.latestBreakPlayer2}}</div>\n      </div>\n\n      <div style=\"display: flex; flex-direction: row; justify-content: center\">\n        <div style=\"margin: 3px 15px; font-size: 5em\">{{match?.currentFrame?.scorePlayer1}}</div>\n        <div style=\"margin: 3px 15px; \">{{match?.framesWonPlayer1}} Frame {{match?.framesWonPlayer2}}</div>\n        <div style=\"margin: 3px 15px; font-size: 5em\">{{match?.currentFrame?.scorePlayer2}}</div>\n      </div>\n\n      <div style=\"display: flex; flex-direction: row; justify-content: center\">\n        <div style=\"margin: 3px 15px\">{{match?.currentFrame?.highestBreakPlayer1}}</div>\n        <div style=\"margin: 3px 15px; \">Highest break</div>\n        <div style=\"margin: 3px 15px\">{{match?.currentFrame?.highestBreakPlayer2}}</div>\n      </div>\n\n      <div style=\"display: flex; flex-direction: row; \">\n        <div style=\"display:flex; flex:1; justify-content: flex-start\">{{match?.currentFrame?.scoreDifference}} {{match?.currentFrame?.currentPlayerAhead?'Ahead':'Behind'}}</div>\n        <div style=\"display:flex; flex:1; justify-content: flex-end\">{{match?.currentFrame?.pointsLeft}} remaining</div>\n      </div>\n    </div>\n\n  </div>\n\n\n\n  <div class=\"status\">\n    <div>\n      <span class=\"fa fa-globe\"></span>\n      <div [ngClass]=\"{'connected' : isConnected()}\">Connected? {{isConnected()}}</div>\n    </div>\n    <div>\n      <span [routerLink]=\"['/follow-match/', matchId]\">follow match</span>\n      <span [routerLink]=\"['/create-match']\">new match</span>\n      <span [routerLink]=\"['/remote-control']\">remote</span>\n    </div>\n\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/follow-match/follow-match.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".scoreboard {\n  color: lightblue; }\n  .scoreboard .status {\n    position: fixed;\n    bottom: 0;\n    left: 0;\n    right: 0; }\n    .scoreboard .status .connected {\n      color: greenyellow; }\n  .scoreboard .active {\n    color: yellowgreen; }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/follow-match/follow-match.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FollowMatchComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__common_match_service__ = __webpack_require__("../../../../../src/app/common/match.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__common_matchws_service__ = __webpack_require__("../../../../../src/app/common/matchws.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var FollowMatchComponent = (function () {
    function FollowMatchComponent(route, matchService, matchWsService) {
        this.route = route;
        this.matchService = matchService;
        this.matchWsService = matchWsService;
    }
    FollowMatchComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.params.subscribe(function (param) {
            if (param) {
                var matchId = param["matchId"];
                _this.matchWsService.connect(matchId, function (match) {
                    _this.match = JSON.parse(match.body);
                });
                _this.matchService.matchDetails(matchId).subscribe(function (data) {
                    _this.match = data;
                });
            }
        });
    };
    FollowMatchComponent.prototype.disconnect = function () {
        this.matchWsService.disconnect();
    };
    FollowMatchComponent.prototype.isConnected = function () {
        return this.matchWsService.isConnected();
    };
    FollowMatchComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-follow-match',
            template: __webpack_require__("../../../../../src/app/follow-match/follow-match.component.html"),
            styles: [__webpack_require__("../../../../../src/app/follow-match/follow-match.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* ActivatedRoute */],
            __WEBPACK_IMPORTED_MODULE_2__common_match_service__["a" /* MatchService */],
            __WEBPACK_IMPORTED_MODULE_3__common_matchws_service__["a" /* MatchWsService */]])
    ], FollowMatchComponent);
    return FollowMatchComponent;
}());



/***/ }),

/***/ "../../../../../src/app/remote-control-connect/remote-control-connect.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/remote-control-connect/remote-control-connect.component.html":
/***/ (function(module, exports) {

module.exports = "<p>\n  remote-control-connect works!\n</p>\n"

/***/ }),

/***/ "../../../../../src/app/remote-control-connect/remote-control-connect.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RemoteControlConnectComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__common_match_service__ = __webpack_require__("../../../../../src/app/common/match.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var RemoteControlConnectComponent = (function () {
    function RemoteControlConnectComponent(route, router, matchService) {
        var _this = this;
        this.route = route;
        this.router = router;
        this.matchService = matchService;
        this.route.params.subscribe(function (param) {
            var username = param["username"];
            var password = param["password"];
            matchService.loginWith(username, password).subscribe(function (data) {
                if (data.matchId) {
                    _this.router.navigate(['/remote-control']);
                }
            });
        });
    }
    RemoteControlConnectComponent.prototype.ngOnInit = function () {
    };
    RemoteControlConnectComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-remote-control-connect',
            template: __webpack_require__("../../../../../src/app/remote-control-connect/remote-control-connect.component.html"),
            styles: [__webpack_require__("../../../../../src/app/remote-control-connect/remote-control-connect.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* ActivatedRoute */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */], __WEBPACK_IMPORTED_MODULE_2__common_match_service__["a" /* MatchService */]])
    ], RemoteControlConnectComponent);
    return RemoteControlConnectComponent;
}());



/***/ }),

/***/ "../../../../../src/app/remote-control/remote-control.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"remote\">\n  <div class=\"info\">\n    <div>\n      <span [ngClass]=\"{'active' : matchDetail?.currentFrame?.currentPlayer === 1}\">\n        {{matchDetail?.player1?.firstName}}\n        {{matchDetail?.player1?.lastName}}\n        ({{matchDetail?.framesWonPlayer1}})\n\n        {{matchDetail?.currentFrame?.scorePlayer1}}\n      </span>\n      Vs\n      <span [ngClass]=\"{'active' : matchDetail?.currentFrame?.currentPlayer === 2}\">\n\n        {{matchDetail?.currentFrame?.scorePlayer2}}\n\n        ({{matchDetail?.framesWonPlayer2}})\n        {{matchDetail?.player1?.firstName}}\n        {{matchDetail?.player1?.lastName}}\n\n      </span>\n    </div>\n    <div>\n      Break: {{matchDetail?.currentFrame?.currentBreak}} points left: {{matchDetail?.currentFrame?.pointsLeft}}\n    </div>\n  </div>\n  <div class=\"controls\">\n    <div class=\"scorebtn red\" (click)=\"addPoints(1)\">1</div>\n    <div class=\"scorebtn yellow\" (click)=\"addPoints(2)\">2</div>\n    <div class=\"scorebtn green\" (click)=\"addPoints(3)\">3</div>\n    <div class=\"scorebtn brown\" (click)=\"addPoints(4)\">4</div>\n    <div class=\"scorebtn blue\" (click)=\"addPoints(5)\">5</div>\n    <div class=\"scorebtn pink\" (click)=\"addPoints(6)\">6</div>\n    <div class=\"scorebtn black\" (click)=\"addPoints(7)\">7</div>\n  </div>\n  <div class=\"controls\">\n    <div class=\"scorebtn cornflower\" (click)=\"changeTurn()\">Turn</div>\n    <div class=\"scorebtn cornflower\" (click)=\"newFrame()\">New</div>\n\n  </div>\n  <div class=\"status\">\n    <div>\n      <span class=\"fa fa-globe\"></span>\n      <div [ngClass]=\"{'connected' : isConnected()}\">Connected? {{isConnected()}}</div>\n    </div>\n    <div>\n      Match # {{matchId}}\n    </div>\n    <div>\n      <span [routerLink]=\"['/follow-match/', matchId]\">follow match</span>\n      <span [routerLink]=\"['/create-match']\">new match</span>\n    </div>\n\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/remote-control/remote-control.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".remote {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: vertical;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: column;\n          flex-direction: column; }\n  .remote .info {\n    display: -webkit-box;\n    display: -ms-flexbox;\n    display: flex;\n    border-bottom: 1px solid deeppink;\n    -webkit-box-orient: vertical;\n    -webkit-box-direction: normal;\n        -ms-flex-direction: column;\n            flex-direction: column; }\n    .remote .info div {\n      display: -webkit-box;\n      display: -ms-flexbox;\n      display: flex;\n      -webkit-box-flex: 1;\n          -ms-flex: 1;\n              flex: 1;\n      -webkit-box-pack: center;\n          -ms-flex-pack: center;\n              justify-content: center; }\n    .remote .info span {\n      margin: 0 10px; }\n    .remote .info .active {\n      color: yellowgreen; }\n  .remote .controls {\n    display: -webkit-box;\n    display: -ms-flexbox;\n    display: flex;\n    -ms-flex-wrap: wrap;\n        flex-wrap: wrap;\n    -webkit-box-orient: horizontal;\n    -webkit-box-direction: normal;\n        -ms-flex-direction: row;\n            flex-direction: row;\n    -webkit-box-pack: center;\n        -ms-flex-pack: center;\n            justify-content: center; }\n    .remote .controls .scorebtn {\n      border-radius: 50%;\n      width: 150px;\n      height: 150px;\n      display: -webkit-box;\n      display: -ms-flexbox;\n      display: flex;\n      font-size: 2em;\n      -webkit-box-pack: center;\n          -ms-flex-pack: center;\n              justify-content: center;\n      -webkit-box-align: center;\n          -ms-flex-align: center;\n              align-items: center;\n      margin: 5px;\n      box-shadow: 1px 1px 15px white; }\n      .remote .controls .scorebtn.red {\n        background-color: red;\n        color: white; }\n      .remote .controls .scorebtn.yellow {\n        border-color: yellow;\n        background-color: yellow;\n        color: black; }\n      .remote .controls .scorebtn.green {\n        border-color: green;\n        background-color: green;\n        color: white; }\n      .remote .controls .scorebtn.brown {\n        border-color: saddlebrown;\n        background-color: saddlebrown;\n        color: white; }\n      .remote .controls .scorebtn.blue {\n        border-color: blue;\n        background-color: blue;\n        color: white; }\n      .remote .controls .scorebtn.pink {\n        border-color: deeppink;\n        background-color: deeppink;\n        color: white; }\n      .remote .controls .scorebtn.black {\n        border-color: black;\n        background-color: black;\n        color: white; }\n      .remote .controls .scorebtn.cornflower {\n        background-color: cornflowerblue;\n        color: white; }\n  .remote .status {\n    position: fixed;\n    bottom: 0;\n    left: 0;\n    right: 0; }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/remote-control/remote-control.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RemoteControlComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__common_match_service__ = __webpack_require__("../../../../../src/app/common/match.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__common_matchws_service__ = __webpack_require__("../../../../../src/app/common/matchws.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var RemoteControlComponent = (function () {
    function RemoteControlComponent(matchService, matchWsService) {
        var _this = this;
        this.matchService = matchService;
        this.matchWsService = matchWsService;
        this.matchId = matchService.curentMatchId();
        matchService.matchDetails(this.matchId).subscribe(function (data) {
            console.log("connection...", data);
            _this.matchDetail = data;
        });
        matchWsService.connect(this.matchId, function (matchDetail) {
            // console.log("score", newScore.body)
            _this.matchDetail = JSON.parse(matchDetail.body);
        });
    }
    RemoteControlComponent.prototype.ngOnInit = function () {
    };
    RemoteControlComponent.prototype.addPoints = function (points) {
        // this.matchService.addPoints(points).subscribe((data:CurrentFrameResponse)=>{
        //   this.currentFrame = data;
        // });
        this.matchWsService.addPoints(points, this.matchId);
    };
    RemoteControlComponent.prototype.changeTurn = function () {
        this.matchWsService.changeTurn(this.matchId);
    };
    RemoteControlComponent.prototype.newFrame = function () {
        this.matchWsService.startNewFrame(this.matchId);
    };
    RemoteControlComponent.prototype.isConnected = function () {
        return this.matchWsService.isConnected();
    };
    RemoteControlComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-remote-control',
            template: __webpack_require__("../../../../../src/app/remote-control/remote-control.component.html"),
            styles: [__webpack_require__("../../../../../src/app/remote-control/remote-control.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__common_match_service__["a" /* MatchService */], __WEBPACK_IMPORTED_MODULE_2__common_matchws_service__["a" /* MatchWsService */]])
    ], RemoteControlComponent);
    return RemoteControlComponent;
}());



/***/ }),

/***/ "../../../../../src/app/splashscreen/splashscreen.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".splash-link {\n  background-color: #1c94c4;\n  font-size:2em;\n  padding: 10px;\n  text-align: center;\n  margin: 5px 0;\n}\n\n\n.splash-link a {\n  color: white;\n  text-decoration: none;\n\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/splashscreen/splashscreen.component.html":
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<div style=\"text-align:center\">\n  <h1>\n    The snooker scoreboard\n  </h1>\n</div>\n<div class=\"splash-link\">\n  <a [routerLink]=\"['/create-match']\">Start new match</a>\n</div>\n<div class=\"splash-link\">\n  <a [routerLink]=\"['/follow-match']\">Follow a match</a>\n</div>\n<div class=\"splash-link\">\n  <a [routerLink]=\"['/remote-control']\">Create remote control</a>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/splashscreen/splashscreen.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SplashscreenComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var SplashscreenComponent = (function () {
    function SplashscreenComponent() {
    }
    SplashscreenComponent.prototype.ngOnInit = function () {
    };
    SplashscreenComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-splashscreen',
            template: __webpack_require__("../../../../../src/app/splashscreen/splashscreen.component.html"),
            styles: [__webpack_require__("../../../../../src/app/splashscreen/splashscreen.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], SplashscreenComponent);
    return SplashscreenComponent;
}());



/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
var environment = {
    production: true,
    wsEndpoint: '/matchsocket',
    serverUrl: '/'
};


/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_13" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map