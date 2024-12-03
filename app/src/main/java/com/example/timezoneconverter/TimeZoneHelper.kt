package com.example.timezoneconverter

import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.Duration

object TimeZoneHelper {

    fun getTimeInZone(timeZone: String): String {
        val zoneId = ZoneId.of(timeZone)
        val currentTime = ZonedDateTime.now(zoneId)
        return currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss z"))
    }

    fun getTimeDifferenceInHours(timeZone1: String, timeZone2: String): Long {
        val zone1 = ZoneId.of(timeZone1)
        val zone2 = ZoneId.of(timeZone2)

        val currentTimeZone1 = ZonedDateTime.now(zone1)
        val currentTimeZone2 = ZonedDateTime.now(zone2)

        return Duration.between(currentTimeZone1, currentTimeZone2).toHours()
    }
}
