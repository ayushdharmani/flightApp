package org.flight;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static Instant parseDateTime(String dateTime) {
        return OffsetDateTime.parse(dateTime).toInstant();
    }

    public static String formatDateTime(Instant instant) {
        return OffsetDateTime.ofInstant(instant, ZoneOffset.UTC).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}
