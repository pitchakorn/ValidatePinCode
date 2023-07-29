fun main() {
        val pins = listOf(
            "17283",
            "172839",
            "111822",
            "112762",
            "123743",
            "321895",
            "124578",
            "112233",
            "882211",
            "887712"
        )
        for (pin in pins) {
            val isValidPinCode = validatePinCode(pin)
            val result = if (isValidPinCode) "Correct" else "Incorrect"
            println("$pin $result")
        }
}

private fun validatePinCode(pin: String): Boolean {
    // Condition 1
    if (pin.length < 6) {
        return false
    }
    // Condition 2
    for (i in 0 until pin.length - 2) {
        if (pin[i] == pin[i + 1] && pin[i] == pin[i + 2]) {
            return false
        }
    }
    // Condition 3
    for (i in 0 until pin.length - 2) {
        if ((pin[i].toInt() + 1 == pin[i + 1].toInt() && pin[i + 1].toInt() + 1 == pin[i + 2].toInt()) ||
            (pin[i].toInt() - 1 == pin[i + 1].toInt() && pin[i + 1].toInt() - 1 == pin[i + 2].toInt())
        ) {
            return false
        }
    }
    // Condition 4
    if (pin[0] == pin[1] && pin[2] == pin[3] && pin[4] == pin[5]) {
        return false
    }
    return true
}
