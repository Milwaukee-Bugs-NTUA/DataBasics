import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-storepage',
  templateUrl: './storepage.component.html',
  styleUrls: ['./storepage.component.css']
})
export class StorepageComponent implements OnInit {

    constructor(private route: ActivatedRoute,) { }

  ngOnInit(): void {
      this.route.paramMap.subscribe(params => {
          console.log(+params.get('storeId'));
      });   
  }

}
