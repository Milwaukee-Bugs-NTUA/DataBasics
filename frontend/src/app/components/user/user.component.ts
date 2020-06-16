import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
    userDummy = { 
                    "CardNumber": "", 
                    "Email": "", 
                    "FirstName": "", 
                    "LastName": "", 
                    "DateOfBirth": "", 
                    "Sex": "", 
                    "AddressStreet": "", 
                    "AddressNumber": "", 
                    "AddressPostalCode": "", 
                    "AddressCity": "", 
                    "PhoneNumber": "", 
                    "MaritalStatus": "", 
                    "NumberOfChildren": "", 
                    "Points": "" 
                };
    user = this.userDummy;
    constructor(private dataService: DataService,private route: ActivatedRoute,) { }

  ngOnInit(): void {
      this.route.paramMap.subscribe(params => {
          this.dataService.sendGetRequest("profile/" + params.get('cardNumber')).subscribe((data: any) => {
              console.log(data);
              this.user = data;
          });
      });
  }

}
