import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calcCommissionMaster() {
        val result = calcCommission("Mastercard", 70000, 10000)
        assertEquals("Комиссия составляет 50.0 руб", result)
    }

    @Test
    fun calcCommissionMasterElse() {
        val result = calcCommission("Mastercard", 76000, 10000)
        assertEquals("Комиссия составляет 50.0 руб", result)
    }

    @Test
    fun calcCommissionMasterElseNoCommission() {
        val result = calcCommission("Mastercard", 1000, 1000)
        assertEquals("Комиссия не взимается", result)
    }

    @Test
    fun calcCommissionVisa() {
        val result = calcCommission("Visa", 76000, 10000)
        assertEquals("Комиссия составляет 75.0 руб", result)
    }

    @Test
    fun calcCommissionVisaElse() {
        val result = calcCommission("Visa", 1000, 1000)
        assertEquals("Комиссия составляет 35.0 руб", result)
    }

    @Test
    fun calcCommissionMir() {
        val result = calcCommission("Mir", 76000, 10000)
        assertEquals("Комиссия не взимается", result)
    }

    @Test
    fun calcCommissionNotTrueCard() {
        val result = calcCommission("PayPal", 76000, 10000)
        assertEquals("Неизвестный тип карты", result)
    }

    @Test
    fun calcCommissionNotCheckLimitDay() {
        val result = calcCommission("Mir", 76000, 160000)
        assertEquals("Операция заблокирована. Превышен лимит перевода в сутки.", result)
    }

    @Test
    fun calcCommissionNotCheckLimitMonth() {
        val result = calcCommission("Mir", 510000, 100000)
        assertEquals("Операция заблокирована. Превышен лимит перевода в месяц.", result)
    }


}