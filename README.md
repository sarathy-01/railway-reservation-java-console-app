# railway-reservation-java-console-app
Console-based Railway Ticket Booking System in Java — with RAC, waiting list &amp; cancellation support.
# 🚆 Railway Reservation Java Console App

A simple **Train Ticket Booking System** implemented in Java using the console. This project is designed for learning purposes and demonstrates object-oriented programming concepts like classes, data structures, and control flow.

---

## 📋 Functionality Overview

### ✅ 1. Booking Tickets
A user can book a ticket by providing:
- Name
- Age
- Gender
- Berth Preference: Lower / Middle / Upper

### 🛏️ Berth Allocation Details
- 2 Lower Berth
- 2 Middle Berth
- 2 Upper Berth
- 4 RAC (Reservation Against Cancellation)
- 2 Waiting List

If the preferred berth is not available, the system:
- Suggests alternate available berth
- Allocates RAC or Waiting List if no berths are available

---

### ❌ 2. Cancel Ticket
- Cancel ticket by passenger name
- On cancellation:
  - A passenger from RAC (if any) moves to confirmed berth
  - A passenger from Waiting List (if any) moves to RAC

---

### 📄 3. Display Booked Tickets
- Shows all confirmed, RAC, and waiting list passengers
- Includes:
  - Name
  - Age
  - Gender
  - Allocated Berth

---

### 📦 4. Display Available Tickets
Shows count of:
- Available Lower, Middle, and Upper berths
- RAC slots
- Waiting list slots

---

### 🚪 5. Exit
- Exits the program safely

---

## 🧱 Technical Details

- `Passenger` class: Stores passenger details
- `BookingSystem` class: Handles core logic for booking and cancellation
- Data structures used:
- `ArrayList` for storing passenger records
- Console-based user interface

---
