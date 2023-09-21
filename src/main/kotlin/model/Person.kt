package model

class Person(val personType: PersonType, var balance: Int) {

    fun buyTicket(stationFrom: Station, stationTo: Station, ticketType: TicketType) {
        val ticket = Ticket(ticketType, personType, stationFrom, stationTo);
        val fare = ticket.calculateFare();
        val discount = ticket.getDiscount()
        if(fare > balance) {
            stationFrom.collectFee(fare, balance);
            balance = 0;
        }
        stationFrom.createTicketEntry(personType, fare, discount);
    }
}