import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:8020/employee";
  constructor(private httpClient: HttpClient) { }

  getEmployeeList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}` + '/getEmployees');
  }

  createEmployee(employee: Employee):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}` + '/saveEmployee', employee);
  }

  getEmployeeById(id: any): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/getEmployee/${id}`);
  }
  updateEmployee(id: any, employee: Employee):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/updateEmployee/${id}`,employee);
  }

  deleteEmployee(id: any): Observable<Object>{
    return  this.httpClient.delete(`${this.baseURL}/deleteEmployee/${id}`)
  }
}
