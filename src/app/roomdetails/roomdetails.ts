import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../services/auth';

@Component({
  selector: 'app-roomdetails',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './roomdetails.html',
  styleUrl: './roomdetails.css'
})
export class RoomdetailsComponent implements OnInit {
  roomId!: number;
  room: any;
  loading = true;
  message = '';

  booking = {
    checkInDate: '',
    checkOutDate: '',
    guests: 1
  };

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private auth: AuthService,
    private router: Router
  ) {}

  ngOnInit() {
    this.roomId = Number(this.route.snapshot.paramMap.get('id'));
    this.fetchRoomDetails();
  }

  fetchRoomDetails() {
    this.http.get(`http://localhost:8080/api/rooms/${this.roomId}`).subscribe({
      next: (data) => {
        this.room = data;
        this.loading = false;
      },
      error: () => {
        this.message = 'Room not found!';
        this.loading = false;
      }
    });
  }

  bookRoom() {
    if (!this.auth.isLoggedIn()) {
      alert('Please login to continue booking.');
      this.router.navigate(['/login']);
      return;
    }

    const token = localStorage.getItem('jwtToken');
    const bookingData = {
      roomId: this.roomId,
      ...this.booking
    };

    this.http.post('http://localhost:8080/api/bookings', bookingData, {
      headers: { Authorization: `Bearer ${token}` }
    }).subscribe({
      next: () => {
        this.message = '✅ Booking successful!';
        this.resetForm();
      },
      error: (err) => {
        console.error(err);
        this.message = '❌ Failed to book room.';
      }
    });
  }

  resetForm() {
    this.booking = {
      checkInDate: '',
      checkOutDate: '',
      guests: 1
    };
  }
}
