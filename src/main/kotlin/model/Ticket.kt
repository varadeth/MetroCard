package model

import service.FareService

data class Ticket(
    private val ticketType: TicketType,
    private val personType: PersonType,
    private val stationFrom: Station,
    private val stationTo: Station,
    private var fare: Int? = null,
) {

    fun calculateFare(): Int {
        fare = FareService.getInstance().getFare(personType, ticketType)
        return this.fare!!
    }

    fun getDiscount(): Int {
        return FareService.getInstance().getDiscount(ticketType, personType);
    }
}