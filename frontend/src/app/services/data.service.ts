import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders ,HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private REST_API_SERVER : string;

  constructor(private httpClient: HttpClient) {}

  public sendGetRequest(url: String) {
    this.REST_API_SERVER = 'https://localhost:8765/datastore/api/' + url;
    return this.httpClient.get(this.REST_API_SERVER);
  }

  public sendPostRequest(url: String, httpParams: HttpParams) {
    this.REST_API_SERVER = 'https://localhost:8765/datastore/api/' + url;
    console.log(httpParams.toString());
    return this.httpClient.post(this.REST_API_SERVER,
                                httpParams.toString(),
                                {
                                  headers: new HttpHeaders()
                                    .set('Content-Type', 'application/x-www-form-urlencoded')
                                });
  }

  public sendPutRequest(url: String, httpParams: HttpParams) {
    this.REST_API_SERVER = 'https://localhost:8765/datastore/api/' + url;
    console.log(httpParams.toString());
    return this.httpClient.put(this.REST_API_SERVER, 
                                httpParams.toString(),
                                {
                                  headers: new HttpHeaders()
                                    .set('Content-Type', 'application/x-www-form-urlencoded')
                                });
  }

  public sendDeleteRequest(url: String) {
    this.REST_API_SERVER = 'https://localhost:8765/datastore/api/' + url;
    return this.httpClient.delete(this.REST_API_SERVER);
  }

}
