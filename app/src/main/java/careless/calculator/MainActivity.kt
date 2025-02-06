package careless.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import careless.calculator.display.CalculatorScreen
import careless.calculator.ui.theme.CarelessCalculatorTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            CarelessCalculatorTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Nav.Calculator.name) {
                    composable(route = Nav.Calculator.name) {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            CalculatorScreen(
                                onNavigateToAboutScreen = { navController.navigate(Nav.About.name) },
                                modifier = Modifier.padding(innerPadding),
                                calculatorViewModel
                            )
                        }
                    }
                    composable(route = Nav.About.name) {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            AboutScreen(modifier = Modifier.padding(innerPadding))
                        }
                    }
                }
            }
        }
    }
}
