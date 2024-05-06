package lld;

public class ParkingLot {
}

enum VehicleType{}

class Vehicle{}

class Bike extends Vehicle{}

class Car extends Vehicle{}

class Truck extends Vehicle{}
class ParkingFloor{}

class ParkingSpot{}

enum SpotStatus{}

class Ticket{}

interface RateStrategy{}

class HourlyRateStrategy implements RateStrategy{}
class DailyRateStrategy implements RateStrategy{}
class MonthlyRateStrategy implements RateStrategy{}

class TicketManager{
    Ticket issueTicket(){return null;}

    Ticket collectTicket(){return null;}
}