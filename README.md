# Hotel Management System

This repository now contains:

- **Angular frontend** (existing app in repository root)
- **Spring Boot backend** (new app under `backend/`)

## Frontend (Angular)

Run from repository root:

```bash
npm install
npm start
```

The Angular app runs at `http://localhost:4200`.

## Backend (Spring Boot)

Run from `backend/`:

```bash
mvn spring-boot:run
```

The API runs at `http://localhost:8080`.

### API endpoints

- `GET /api/rooms` – list rooms
- `POST /api/rooms` – create room
- `GET /api/guests` – list guests
- `POST /api/guests` – create guest
- `GET /api/bookings` – list bookings
- `POST /api/bookings` – create booking with room/guest/date validation

### Storage

- Uses in-memory **H2** database
- H2 console enabled at `/h2-console`

### Run tests

```bash
cd backend
mvn test
```
