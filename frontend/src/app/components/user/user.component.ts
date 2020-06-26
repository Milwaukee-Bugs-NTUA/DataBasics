import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
    user = null;
    show_user_info=false;
    constructor(private dataService: DataService,private route: ActivatedRoute,) { }

  ngOnInit(): void {
      this.route.paramMap.subscribe(params => {
          this.dataService.sendGetRequest("profile/" + params.get('cardNumber')).subscribe((data: any) => {
              console.log(data);
              this.user = data;
          });
      });
  }
  
  onClickMe():void {
    this.show_user_info = true;
  }
}
