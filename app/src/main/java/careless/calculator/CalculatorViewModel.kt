package careless.calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.mozilla.javascript.Context

class CalculatorViewModel : ViewModel() {

    private val _equationText = MutableStateFlow("")
    val equationText = _equationText.asStateFlow()

    private val _resultText = MutableStateFlow("0")
    val resultText = _resultText.asStateFlow()

    fun onButtonClick(button: String) {
        equationText.value.let {
            if (button == "AC") {
                _equationText.value = ""
                _resultText.value = "0"
                return
            }

            if (button == "C") {
                if (it.isNotEmpty()) {
                    _equationText.value = it.substring(0, it.length - 1)
                }
                return
            }

            if (button == "=") {
                _equationText.value = resultText.value
                return
            }

            _equationText.value = it + button

            try {
                _resultText.value = calculateResult(equationText.value)
            } catch (_: Exception) {
            }

        }
    }

    fun calculateResult(equation: String): String {
        val context = Context.enter()
        context.optimizationLevel = -1
        val scriptable = context.initStandardObjects()
        var finalResult =
            context.evaluateString(scriptable, equation, "JavaScript", 1, null).toString()
        if (finalResult.endsWith(".0")) {
            finalResult = finalResult.replace(".0", "")
        }
        return finalResult
    }
}