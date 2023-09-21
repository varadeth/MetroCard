package model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StationTest {
    lateinit var stationAirport: Station
    lateinit var stationCentral: Station

    @BeforeEach
    internal fun setUp() {
        stationCentral = Station("Central", StationStats(HashMap(), 0, 0, 0.0));
        stationAirport = Station("Airport", StationStats(HashMap(), 0, 0, 0.0));
    }

    @Test
    internal fun shouldReturnACollectionSummary() {
        val seniorPerson = Person(PersonType.SENIOR, 100);
        val adultPerson = Person(PersonType.ADULT, 150);
        val ticketType = TicketType.RETURN;
        seniorPerson.buyTicket(stationCentral, stationAirport, ticketType);
        adultPerson.buyTicket(stationCentral, stationAirport, ticketType);

        val collectionSummary = "Station Name : Central\n" +
                "Total Fare Collected : 450\n" +
                "Total Convinience Fee Collected : 4.0\n" +
                "Total Discount Given : 150"
        assertEquals(collectionSummary, stationCentral.getCollectionSummary());
    }

    @Test
    internal fun shouldReturnAPassengerSummaryWithDescendingOrderOfPassengerCount() {
        val seniorPerson1 = Person(PersonType.SENIOR, 100);
        val seniorPerson2 = Person(PersonType.SENIOR, 100);
        val adultPerson1 = Person(PersonType.ADULT, 150);
        val adultPerson2 = Person(PersonType.ADULT, 300);
        val adultPerson3 = Person(PersonType.ADULT, 500);
        val ticketType = TicketType.RETURN;
        seniorPerson1.buyTicket(stationCentral, stationAirport, ticketType);
        seniorPerson2.buyTicket(stationCentral, stationAirport, ticketType);
        adultPerson1.buyTicket(stationCentral, stationAirport, ticketType);
        adultPerson2.buyTicket(stationCentral, stationAirport, ticketType);
        adultPerson3.buyTicket(stationCentral, stationAirport, ticketType);

        val collectionSummary = "Station Name : Central\nPassengerType : ADULT\tPassengerCount : 3\nPassengerType : SENIOR\tPassengerCount : 2\n"
        assertEquals(collectionSummary, stationCentral.getPassengerSummary());
    }

    @Test
    internal fun shouldReturnNoStatsForAirportStation() {
        val seniorPerson = Person(PersonType.SENIOR, 100);
        val adultPerson = Person(PersonType.ADULT, 150);
        val ticketType = TicketType.RETURN;
        seniorPerson.buyTicket(stationCentral, stationAirport, ticketType);
        adultPerson.buyTicket(stationCentral, stationAirport, ticketType);

        val collectionSummary = "Station Name : Airport\n" +
                "Total Fare Collected : 0\n" +
                "Total Convinience Fee Collected : 0.0\n" +
                "Total Discount Given : 0"
        assertEquals(collectionSummary, stationAirport.getCollectionSummary());
    }
}