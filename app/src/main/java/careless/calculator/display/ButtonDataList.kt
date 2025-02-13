package careless.calculator.display

class ButtonDataList {
    val buttonDataList: List<ButtonData>

    init {
        val list = mutableListOf<ButtonData>()
        val buttonDataList = listOf(
            "C", "(", ")", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "+",
            "1", "2", "3", "-",
            "AC", "0", ".", "="
        )
        buttonDataList.forEach {
            list.add(ButtonData(buttonText = it))
        }

        this.buttonDataList = list
    }
}
