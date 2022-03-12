import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hero-list',
  templateUrl: './hero-list.component.html',
  styleUrls: ['./hero-list.component.css']
})
export class HeroListComponent implements OnInit {

  title = "Danh Sach Hero";
  heroList = [
    { id: 1, name: 'supperman', gender: 1, img: 'https://cf.shopee.vn/file/772fd50d1039af103ad1fd354273cfce' },
    { id: 2, name: 'spiderman', gender: 1, img: 'https://suckhoedoisong.qltns.mediacdn.vn/thumb_w/640/324455921873985536/2021/12/20/nguoinhen-1639982903115922037303.jpeg' },
    { id: 3, name: 'ironman', gender: 0, img: 'https://genk.mediacdn.vn/thumb_w/660/139269124445442048/2020/5/4/photo-1-1588541968324891829550.jpg' },
    { id: 4, name: 'antman', gender: 1, img: 'https://genk.mediacdn.vn/thumb_w/660/139269124445442048/2020/5/4/photo-1-1588541968324891829550.jpg' }
  ];


  
  customerHero ={
    id: null,
    name: null, 
    img: null, 
    gender: 1,
  }
  // changeHeroName(event: any){
  //   this.customerHero = event.target.value;
  //   console.log(event);
  // }
  removeHerro(hero: { name: any; }){
    this.heroList  = this.heroList.filter(function(item){
      return item != hero;
    })
  }
  constructor() { }

  ngOnInit(): void {
  }

}
