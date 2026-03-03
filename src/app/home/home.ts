import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
    hotelName = 'Grand Paradise Hotel';
  features = [
    { icon: '🛏️', title: 'Luxury Rooms', desc: 'Comfortable and spacious rooms for your stay.' },
    { icon: '🍽️', title: 'Restaurant', desc: 'Multi-cuisine dining experience with 24x7 service.' },
    { icon: '🏊', title: 'Swimming Pool', desc: 'Relax and refresh in our crystal clear pool.' },
    { icon: '🚗', title: 'Free Parking', desc: 'Secure parking for all guests.' }
  ];
}
