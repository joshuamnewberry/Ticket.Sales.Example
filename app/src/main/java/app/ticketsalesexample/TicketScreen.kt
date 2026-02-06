package app.ticketsalesexample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly

@Composable
fun TicketScreen(viewMod: TicketViewModel, modifier: Modifier = Modifier) {
    var numTix by remember { mutableStateOf("") }
    val availableTickets by viewMod.availableTickets.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text("Purchase Tickets? (${availableTickets} available)")
        OutlinedTextField(
            onValueChange = {numTix = it},
            value = numTix,
             label = { Text("Quantity")
             }
        )

        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                if(numTix.isNotEmpty() && numTix.isDigitsOnly()) {
                    numTix = viewMod.purchaseTickets(numTix.toInt())
                }
            }
        ) {
            Text("Buy")
        }

    }
}