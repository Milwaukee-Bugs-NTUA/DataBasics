import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { concat } from 'rxjs';

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
}
