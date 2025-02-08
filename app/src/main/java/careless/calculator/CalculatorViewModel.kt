package careless.calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.mozilla.javascript.Context
import kotlin.random.Random

class CalculatorViewModel : ViewModel() {

    private val _trueResult = MutableStateFlow("")
    val trueResult = _trueResult.asStateFlow()

    private val _isMistake = MutableStateFlow(false)
    val isMistake = _isMistake.asStateFlow()

    private val _falseResult = MutableStateFlow<String>("")
    val falseResult = _falseResult.asStateFlow()

    fun onButtonClick(button: String) {
        _trueResult.value.let {
            if (button == "AC") {
                _trueResult.value = "0"
                _isMistake.value = false
                return
            }

            if (button == "C") {
                if (it.isNotEmpty()) {
                    _trueResult.value = it.substring(0, it.length - 1)
                }
                return
            }

            if (button == "=") {
                try {
                    val trueResult = calculateResult(trueResult.value)
                    _trueResult.value = trueResult

                    _isMistake.value = isMistake(trueResult)
                    if (isMistake.value) {
                        _falseResult.value = createFalseResult(trueResult)
                    }
                } catch (_: Exception) {
                }
                return
            }
            _trueResult.value = it + button
        }
    }

    /*
    実際の結果に対して、1.1 ~ 1.5を掛け算する
     */
    fun createFalseResult(trueResult: String): String {
        // 1.1から1.5の範囲の乱数を生成
        val randomValue = 1.1 + (Random.nextDouble() * 0.4)
        val trueFloatResult = trueResult.toFloat()
        return (randomValue * trueFloatResult).toInt().toString()
    }

    /**
     * 計算結果が3桁以上の時に、20%の確率で間違える
     */
    private fun isMistake(result: String): Boolean {
        if (result.length < 2) {
            return false
        }

        val probability = 0.2 // 20%の確率
        val randomValue = Random.nextDouble() // 0.0 ～ 1.0 のランダムな数値を生成

        if (randomValue < probability) {
            return true
        }

        return false
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
