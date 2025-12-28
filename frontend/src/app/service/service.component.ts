import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-service',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './service.component.html'
})
export class ServiceComponent implements OnInit {

  baseUrl = 'http://localhost:8080';

  username = '';
  password = '';

  logins: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.getAllLogins();
  }

  saveLogin() {
    const body = {
      username: this.username,
      password: this.password
    };

    this.http.post(`${this.baseUrl}/post-data`, body)
      .subscribe(() => {
        this.username = '';
        this.password = '';
        this.getAllLogins();
      });
  }

  getAllLogins() {
    this.http.get<any[]>(`${this.baseUrl}/get-data`)
      .subscribe(data => {
        this.logins = data;
      });
  }
}
