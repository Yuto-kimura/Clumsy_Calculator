package careless.calculator.display

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import careless.calculator.CalculatorViewModel
import careless.calculator.R
import kotlinx.coroutines.delay

val buttonList = listOf(
    "C", "(", ")", "/",
    "7", "8", "9", "*",
    "4", "5", "6", "+",
    "1", "2", "3", "-",
    "AC", "0", ".", "="
)

@Composable
fun CalculatorScreen(
    onNavigateToAboutScreen: () -> Unit,
    modifier: Modifier,
    viewModel: CalculatorViewModel
) {
    val isMistake = viewModel.isMistake.collectAsState().value
    var calculationResults = ""

    if (isMistake) {
        calculationResults = viewModel.falseResult.collectAsState().value
    } else {
        calculationResults = viewModel.trueResult.collectAsState().value
    }

    var backgroundAlpha by remember { mutableStateOf(0f) }
    LaunchedEffect(isMistake) {
        if (isMistake) {
            delay(1000)
            backgroundAlpha = 0f
        } else {
            backgroundAlpha = 1f
        }
    }
    val animatedAlpha by animateFloatAsState(
        targetValue = backgroundAlpha,
        animationSpec = androidx.compose.animation.core.tween(durationMillis = 1000)
    )

    Box(modifier = modifier) {
        if (isMistake) {
            Image(
                painter = painterResource(id = R.drawable.musimegane),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(alpha = animatedAlpha),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End
        ) {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = stringResource(id = com.google.android.gms.base.R.string.common_signin_button_text),
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        onNavigateToAboutScreen()
                    }
            )

            if (isMistake) {
                Card {
                    CardContents(
                        title = "おっとっと!! 正しい値は・・・",
                        resultText = viewModel.trueResult.collectAsState().value
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = calculationResults,
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
                    CalculatorButton(
                        buttonText = it,
                        onClick = {
                            viewModel.onButtonClick(it)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(buttonText: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.padding(8.dp)) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .size(90.dp),
            shape = CircleShape,
            // TODO
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroubdColor(buttonText),
                disabledContainerColor = Color(0xFFE0E0E0)
            )
        ) {
            Text(
                modifier = modifier,
                text = buttonText,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun backgroubdColor(buttonText: String): Color {
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

@Preview
@Composable
fun CalculatorScreenPreview() {
    CalculatorScreen(
        onNavigateToAboutScreen = {},
        modifier = Modifier,
        viewModel = CalculatorViewModel()
    )
}
