## Problem Definition
A **BookMyShow System** is an online ticket booking platform that allows users to search for movies, view showtimes, book seats, and make payments for movie tickets across multiple theatres and cities. The system manages movie listings, theatres, shows, seat availability, bookings, and payments.

## Requirements
1. **Movies**: Manage multiple movies, each with a name and duration, available in different cities.
2. **Theatres**: Multiple theatres in each city, each containing multiple screens and shows.
3. **Shows**: Each show is associated with a movie, screen, start time, and tracks booked seats.
4. **Screens & Seats**: Each screen has a set of seats that can be booked for a show.
5. **Bookings**: Users can book seats for a show, and the system tracks bookings and payments.
6. **Payments**: Support for payment processing for confirmed bookings.
7. **Cities**: System supports multiple cities, each with its own set of theatres and movies.

## System Design

### Class Structure
- **Main**: Entry point for the application. Initializes the system and simulates bookings.
- **Movie**: Represents a movie with ID, name, and duration.
- **MovieController**: Manages movies by city and supports searching and adding movies.
- **Theatre**: Represents a theatre with address, city, screens, and shows.
- **TheatreController**: Manages theatres by city and supports adding theatres and retrieving shows.
- **Screen**: Represents a screen in a theatre with a list of seats.
- **Seat**: Represents a seat in a screen.
- **Show**: Represents a show for a movie on a screen at a specific time, tracks booked seats.
- **Booking**: Handles booking details, associated show, payment, and booked seats.
- **Payment**: Represents payment details for a booking.
- **Enums**: City and SeatCategory enums for city names and seat types.

### System Flow
1. User searches for movies by city.
2. User selects a movie, city, and showtime.
3. User selects seats and creates a booking.
4. System marks selected seats as booked for the show.
5. User completes payment for the booking.
6. System tracks bookings and payments.

### Design Patterns Used
- **MVC**: Separation of models (Movie, Theatre, Show, Booking), controllers (MovieController, TheatreController), and main application logic.
- **Factory Pattern**: For creating entities like Movie, Theatre, Show, and Booking.