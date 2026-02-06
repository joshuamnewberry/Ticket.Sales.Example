package app.ticketsalesexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import app.ticketsalesexample.ui.theme.TicketSalesExampleTheme
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myViewModel: TicketViewModel by viewModels<TicketViewModel>()
        enableEdgeToEdge()
        setContent {
            TicketSalesExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TicketScreen(myViewModel, Modifier.padding(innerPadding))
                }
            }
        }
    }
}