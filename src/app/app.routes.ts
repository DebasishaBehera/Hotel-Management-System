import { Routes } from '@angular/router';
import { Home } from './home/home';
import { LoginComponent } from './login/login';
import { SignupComponent } from './signup/signup';
import { RoomsComponent } from './rooms/rooms';
import { RoomdetailsComponent } from './roomdetails/roomdetails';
import { Contact } from './contact/contact';
import { AboutComponent } from './about/about';

export const routes: Routes = [
  { path: 'home', component: Home },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'rooms', component: RoomsComponent },
  { path: 'rooms/:id', component: RoomdetailsComponent },
  { path: 'about', component: AboutComponent },
  { path: 'contact', component: Contact },
  { path: '**', redirectTo: 'home' }
];
