package model

import org.junit.Test
import org.mockito.Mockito.*

class PersonTest {
    @Test
    fun shouldBuyATicketForPersonWhenBalanceIsSufficient() {
        val personType = PersonType.ADULT
        val person = Person(personType, 200)
        val stationCentral = mock(Station::class.java)
        val stationAirport = mock(Station::class.java)

        person.buyTicket(stationCentral, stationAirport, TicketType.REGULAR)

        verify(stationCentral, times(1)).createTicketEntry(personType, fare = 200, discount = 0)
        verify(stationCentral, times(0)).collectFee(200, 200)
    }

    @Test
    fun shouldBuyATicketForPersonWhenBalanceIsInsufficient() {
        val personType = PersonType.ADULT
        val person = Person(personType, 100)
        val stationCentral = mock(Station::class.java)
        val stationAirport = mock(Station::class.java)

        person.buyTicket(stationCentral, stationAirport, TicketType.RETURN)

        verify(stationCentral, times(1)).createTicketEntry(personType, fare = 300, discount = 100)
        verify(stationCentral, times(1)).collectFee(300, 100)
    }
}