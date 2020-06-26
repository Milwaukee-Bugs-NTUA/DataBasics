import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from './../../services/data.service';

@Component({
  selector: 'app-storepage',
  templateUrl: './storepage.component.html',
  styleUrls: ['./storepage.component.css']
})
export class StorepageComponent implements OnInit {
    storepage = null;

    show_transactions = false;
    
    constructor(private dataService: DataService,private route: ActivatedRoute,) { }

    ngOnInit(): void {
        this.route.paramMap.subscribe(params => {
            this.dataService.sendGetRequest("storePage/" + params.get('storeId')).subscribe((data: any) => {
                console.log(data);
                this.storepage = data;
            });
        });
    }

    onClickMe():void {
        this.show_transactions = true;
    }
}
