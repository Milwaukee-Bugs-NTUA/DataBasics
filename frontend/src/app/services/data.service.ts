import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private REST_API_SERVER = 'https://localhost:8765/datastore/api/HealthCheck';

  constructor(private httpClient: HttpClient) {}

  public sendGetRequest() {
    return this.httpClient.get(this.REST_API_SERVER);
  }
}
