package careless.calculator.display

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import careless.calculator.CalculatorViewModel


val buttonList = listOf(
    "C", "(", ")", "/",
    "7", "8", "9", "*",
    "4", "5", "6", "+",
    "1", "2", "3", "-",
    "AC", "0", ".", "=",
)

@Composable
fun CalculatorScreen(modifier: Modifier, viewModel: CalculatorViewModel) {

    Box(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = viewModel.equationText.collectAsState().value,
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = viewModel.resultText.collectAsState().value,
                style = TextStyle(
                    fontSize = 60.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(4)
            ) {
                items(buttonList) {
                    CalculatorButton(buttonText = it, onClick = {
                        viewModel.onButtonClick(it)
                    }
                    )
                }
            }

        }
    }
}

@Composable
fun CalculatorButton(buttonText: String, onClick: () -> Unit) {
    Box(modifier = Modifier.padding(8.dp)) {
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier.size(80.dp),
            shape = CircleShape,
            containerColor = getColor(buttonText)
        ) {
            Text(
                text = buttonText,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun getColor(buttonText: String): Color {
    if (buttonText == "C" || buttonText == "AC") {
        return Color(0xFFF45336)
    }

    if (buttonText == "(" || buttonText == ")") {
        return Color.Gray
    }

    if (buttonText == "/" || buttonText == "*" || buttonText == "+" || buttonText == "-" || buttonText == "=") {
        return Color(0xFFFF9800)
    }

    return Color(0xFF00C8C9)
}