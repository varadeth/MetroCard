package model

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class StationStatsTest {

    private lateinit var stats: StationStats

    @Before
    fun setUp() {
        stats = StationStats(HashMap(), 0, 0, 0.0)
        stats.createTicketEntry(PersonType.SENIOR, 150, 50)
        stats.createTicketEntry(PersonType.ADULT, 200, 0)
        stats.setConvenienceFee(1.0)
    }

    @Test
    fun shouldGetPassengerStats() {
        val expectedStats = "PassengerType : SENIOR\tPassengerCount : 1\nPassengerType : ADULT\tPassengerCount : 1\n"
        val actualStats = stats.getPassengerStats()
        assertEquals(expectedStats, actualStats)
    }

    @Test
    fun shouldGetCollectionSummary() {
        val expectedStats = "Total Fare Collected : 350\nTotal Convenience Fee Collected : 1.0\nTotal Discount Given : 50"

        val actualStats = stats.getCollectionSummary()

        assertEquals(expectedStats, actualStats)
    }
}