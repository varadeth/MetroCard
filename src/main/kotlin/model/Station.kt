package model

class Station(
    private val stationName: String,
    private val stats: StationStats
) {

    fun createTicketEntry(personType: PersonType, fare: Int, discount: Int) {
        stats.createTicketEntry(personType, fare, discount);
    }

    fun collectFee(fare: Int, balance: Int) {
        val convenienceFee = (fare - balance) * 0.02;
        stats.setConvenienceFee(convenienceFee);
    }

    fun getCollectionSummary(): String {
        return "Station Name : ${stationName}\n${stats.getCollectionSummary()}";
    }

    fun getPassengerSummary(): String {
        return "Station Name : $stationName\n${stats.getPassengerStats()}"
    }
}