package model

import org.junit.Test
import org.mockito.Mockito.mock
import kotlin.test.assertEquals

class TicketTest {

    @Test
    fun shouldReturnTicketFareForRegularTicket() {
        val centralStation = mock(Station::class.java)
        val airportStation = mock(Station::class.java)
        val ticket = Ticket(TicketType.REGULAR, PersonType.SENIOR, centralStation, airportStation)
        val expectedFare = 100
        val expectedDiscount = 0

        val actualFare = ticket.calculateFare()
        val actualDiscount = ticket.getDiscount()

        assertEquals(expectedFare, actualFare)
        assertEquals(expectedDiscount, actualDiscount)
    }

    @Test
    fun shouldReturnTicketFareForReturnTicket() {
        val centralStation = mock(Station::class.java)
        val airportStation = mock(Station::class.java)
        val ticket = Ticket(TicketType.RETURN, PersonType.ADULT, centralStation, airportStation)
        val expectedFare = 300
        val expectedDiscount = 100

        val actualFare = ticket.calculateFare()
        val actualDiscount = ticket.getDiscount()

        assertEquals(expectedFare, actualFare)
        assertEquals(expectedDiscount, actualDiscount)
    }
}