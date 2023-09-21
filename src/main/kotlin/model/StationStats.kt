package model

class StationStats(
    private val passengerCount: MutableMap<PersonType, Int>,
    private var fareCollected: Int,
    private var discountGiven: Int,
    private var convenienceFee: Double) {

    fun createTicketEntry(personType: PersonType, fare: Int, discount: Int) {
        passengerCount[personType] = passengerCount.getOrDefault(personType, 0) + 1;
        fareCollected += fare
        discountGiven += discount
    }

    fun getPassengerStats(): String {
        val sortedPassengerCount = passengerCount.entries.sortedWith(compareBy(
            {it.value * -1},
            {it.key.sortOrder}
        )).associate { it.toPair() }
        var passengerSummary = "";
        for (entry in sortedPassengerCount) {
            passengerSummary += "PassengerType : ${entry.key}\tPassengerCount : ${entry.value}\n";
        }
        return passengerSummary;
    }

    fun getCollectionSummary(): String {
        return "Total Fare Collected : $fareCollected\nTotal Convenience Fee Collected : $convenienceFee\nTotal Discount Given : $discountGiven"
    }

    fun setConvenienceFee(convenienceFee: Double) {
        this.convenienceFee += convenienceFee;
    }


}
