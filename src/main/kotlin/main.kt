fun main() {
    println(calcCommission(card = "Mastercard", transferInMount = 76_000, transferInDay = 10_000))
}

fun calcCommission(card: String = "Mir", transferInMount: Int = 0, transferInDay: Int): String {
    val commission: Double

    if (checkLimit(transferInMount, transferInDay)) {
        when (card) {
            "Mastercard" -> {
                if (transferInMount + transferInDay > 75_000) {
                    if (transferInMount < 75_000) {
                        commission = (transferInDay + transferInMount - 75_000) * 0.006 + 20
                        return "Комиссия составляет $commission руб"
                    } else {
                        commission = transferInDay * 0.006 + 20
                        return "Комиссия составляет $commission руб"
                    }
                } else {
                    return "Комиссия не взимается"
                }
            }

            "Visa" -> {
                commission = if (transferInDay * 0.0075 < 35) 35.0 else transferInDay * 0.0075
                return "Комиссия составляет $commission руб"
            }

            "Mir" -> {
                return "Комиссия не взимается"
            }

            else -> {
                return "Неизвестный тип карты"
            }
        }
    }
    return "Операция заблокирована. Превышен лимит перевода ${whatReason(transferInMount, transferInDay)}."
}

fun checkLimit(transferInMount: Int, transferInDay: Int): Boolean {
    return when {
        transferInDay > 150_000 -> false
        transferInMount + transferInDay > 600_000 -> false
        else -> true
    }
}

fun whatReason(transferInMount: Int, transferInDay: Int): String {
    return when {
        transferInDay > 150_000 -> "в сутки"
        transferInMount + transferInDay > 600_000 -> "в месяц"
        else -> "ЛИМИТ НЕ ПРЕВЫШЕН"
    }
}
