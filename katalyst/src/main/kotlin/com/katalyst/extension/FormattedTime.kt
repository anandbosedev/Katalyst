package com.katalyst.extension

import com.katalyst.dom.BodyContext
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

fun BodyContext.formattedTime(
    id: String? = null,
    className: String? = null,
    epochMillis: Long,
    dateFormat: FormatStyle? = FormatStyle.FULL,
    timeFormat: FormatStyle? = FormatStyle.FULL,
    timeZoneId: ZoneId = ZoneId.systemDefault(),
    customAttributes: Map<String, String?>? = null,
) {
    val zonedTime = Instant.ofEpochMilli(epochMillis)
        .atZone(timeZoneId)
    val isoFormattedTime = zonedTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    val humanReadableTimeFormatter = when {
        dateFormat == null && timeFormat == null -> DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.FULL)
        dateFormat == null && timeFormat != null -> DateTimeFormatter.ofLocalizedTime(timeFormat)
        dateFormat != null && timeFormat == null -> DateTimeFormatter.ofLocalizedDate(dateFormat)
        else -> DateTimeFormatter.ofLocalizedDateTime(dateFormat, timeFormat)
    }
    val humanReadableTime = zonedTime.format(humanReadableTimeFormatter)
    time(
        id = id,
        className = className,
        dateTime = isoFormattedTime,
        customAttributes = customAttributes,
        text = humanReadableTime,
    )
}

fun BodyContext.formattedTime(
    id: String? = null,
    className: String? = null,
    epochMillis: Long,
    pattern: String,
    timeZoneId: ZoneId = ZoneId.systemDefault(),
    customAttributes: Map<String, String?>? = null,
) {
    val zonedTime = Instant.ofEpochMilli(epochMillis)
        .atZone(timeZoneId)
    val isoFormattedTime = zonedTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    val humanReadableTimeFormatter = DateTimeFormatter.ofPattern(pattern)
    val humanReadableTime = zonedTime.format(humanReadableTimeFormatter)
    time(
        id = id,
        className = className,
        dateTime = isoFormattedTime,
        customAttributes = customAttributes,
        text = humanReadableTime,
    )
}