package careless.calculator.display

data class ButtonData(
    val buttonText: String
) {
    fun isValid(isMistake: Boolean): Boolean {
        if (isMistake) {
            return buttonText == "AC"
        }

        return true
    }
}
