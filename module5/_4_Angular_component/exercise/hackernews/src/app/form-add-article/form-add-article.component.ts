import {Component, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-form-add-article',
  templateUrl: './form-add-article.component.html',
  styleUrls: ['./form-add-article.component.css']
})
export class FormAddArticleComponent implements OnInit {

  @Input()
  formTitle: string;
  @Input()
  formUrl: string;
  @Output()

  title: string;
  url: string;

  constructor() { }

  ngOnInit(): void {
  }

}
