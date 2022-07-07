package br.com.edsonmoretti.rest.converters

object NumberConverter {
    fun convertDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",", ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",", ".")
        return number.matches("-?\\d+(\\.\\d+)?".toRegex())
    }
}