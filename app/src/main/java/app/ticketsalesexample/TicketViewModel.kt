package app.ticketsalesexample

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TicketViewModel: ViewModel() {
    private val _availableTickets = MutableStateFlow(50)
    val availableTickets = _availableTickets.asStateFlow()

    fun purchaseTickets(ticketCount: Int): String {
        if(ticketCount <= _availableTickets.value) {
            _availableTickets.value -= ticketCount
            return ""
        }
        return ticketCount.toString()
    }
}