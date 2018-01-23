import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RequestOptions} from "@angular/http";

@Injectable()
export class CustomHttpService {

  constructor(private http:HttpClient, @Inject('API_URL') private apiUrl: string) { }

  public postJson(url:string, data:any): Observable<any> {
    return this.post(url, data);
  }

  public getJson(url:string): Observable<any> {
    return this.get(url);
  }

  private post(url:string, data:any): Observable<any> {
    return this.http.post(this.apiUrl + url, data);
  }

  private get(url:string): Observable<any>{
    return this.http.get(this.apiUrl + url);
  }



}
