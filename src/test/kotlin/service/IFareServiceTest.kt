package service

import model.PersonType
import model.TicketType
import org.junit.Test
import kotlin.test.assertEquals

class FareServiceTest {
    @Test
    fun shouldCalculateFareForSeniorRegularTicket() {
        val personType = PersonType.SENIOR
        val ticketType = TicketType.REGULAR
        val expectedFare = 100

        val actualFare = FareService.getInstance().getFare(personType, ticketType);

        assertEquals(expectedFare, actualFare)
    }

    @Test
    fun shouldCalculateFareForSeniorReturnTicket() {
        val personType = PersonType.SENIOR
        val ticketType = TicketType.RETURN
        val expectedFare = 150

        val actualFare = FareService.getInstance().getFare(personType, ticketType);

        assertEquals(expectedFare, actualFare)
    }

    @Test
    fun shouldCalculateFareForAdultRegularTicket() {
        val personType = PersonType.ADULT
        val ticketType = TicketType.REGULAR
        val expectedFare = 200

        val actualFare = FareService.getInstance().getFare(personType, ticketType);

        assertEquals(expectedFare, actualFare)
    }

    @Test
    fun shouldCalculateFareForAdultReturnTicket() {
        val personType = PersonType.ADULT
        val ticketType = TicketType.RETURN
        val expectedFare = 300

        val actualFare = FareService.getInstance().getFare(personType, ticketType);

        assertEquals(expectedFare, actualFare)
    }

    @Test
    fun shouldCalculateForKidRegularTicket() {
        val personType = PersonType.KIDS
        val ticketType = TicketType.REGULAR
        val expectedFare = 50

        val actualFare = FareService.getInstance().getFare(personType, ticketType);

        assertEquals(expectedFare, actualFare)
    }

    @Test
    fun shouldCalculateForKidReturnTicket() {
        val personType = PersonType.KIDS
        val ticketType = TicketType.RETURN
        val expectedFare = 75

        val actualFare = FareService.getInstance().getFare(personType, ticketType);

        assertEquals(expectedFare, actualFare)
    }
}