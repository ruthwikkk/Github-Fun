package com.ruthwikkk.githubapi.presentation

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {
    const val DATE_FORMAT_ISO_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss'Z'"

    fun timeStampToPrettyTime(dateString: String?): String? {
        return try {
            val simpleDateFormat = SimpleDateFormat(DATE_FORMAT_ISO_TIMEZONE)
            val date = simpleDateFormat.parse(dateString)
            DateUtils.getRelativeTimeSpanString(
                date.time,
                Calendar.getInstance().timeInMillis,
                DateUtils.SECOND_IN_MILLIS
            ).toString()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }
}