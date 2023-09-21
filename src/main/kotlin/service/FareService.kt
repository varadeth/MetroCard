package service

import util.Constants
import model.PersonType
import model.TicketType

class FareService(private val fareMap: Map<PersonType, Int>) {
    companion object {
        private var instance: FareService? = null

        fun getInstance(): FareService {
            if (instance == null) {
                val fareMap = HashMap<PersonType, Int>()

                fareMap[PersonType.ADULT] = 200
                fareMap[PersonType.KIDS] = 50
                fareMap[PersonType.SENIOR] = 100

                instance = FareService(fareMap)
            }
            return instance!!
        }
    }

    fun getFare(personType: PersonType, ticketType: TicketType): Int {
        val fare = this.fareMap.getOrDefault(personType, 0)
        if(ticketType == TicketType.RETURN) {
            return (fare * ((100.0 + Constants.DISCOUNT)/100)).toInt();
        }
        return fare
    }

    fun getDiscount(ticketType: TicketType, personType: PersonType): Int {
        val fare = this.getFare(personType, ticketType)
        val regularFare = this.getFare(personType, TicketType.REGULAR);
        return fare - regularFare;
    }
}