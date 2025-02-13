package careless.calculator.display

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(buttonData: ButtonData, onClick: () -> Unit, modifier: Modifier = Modifier, isMistake: Boolean = true) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .size(90.dp)
            .padding(5.dp),
        shape = CircleShape,
        enabled = buttonData.isValid(isMistake),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor(buttonData.buttonText),
            disabledContainerColor = Color(0xFFE0E0E0)
        )
    ) {
        Text(
            modifier = modifier,
            text = buttonData.buttonText,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun backgroundColor(buttonText: String): Color {
    if (buttonText == "C" || buttonText == "(" || buttonText == ")") {
        return Color(0xFFFFA726)
    }

    if (buttonText == "AC") {
        return Color.Red
    }

    if (buttonText == "/" || buttonText == "*" || buttonText == "+" || buttonText == "-" || buttonText == "=") {
        return Color(0xFF80DEEA)
    }

    return Color.LightGray
}
