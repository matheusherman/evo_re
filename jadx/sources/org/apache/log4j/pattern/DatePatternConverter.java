package org.apache.log4j.pattern;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class DatePatternConverter extends LoggingEventPatternConverter {
    private static final String ABSOLUTE_FORMAT = "ABSOLUTE";
    private static final String ABSOLUTE_TIME_PATTERN = "HH:mm:ss,SSS";
    private static final String DATE_AND_TIME_FORMAT = "DATE";
    private static final String DATE_AND_TIME_PATTERN = "dd MMM yyyy HH:mm:ss,SSS";
    private static final String ISO8601_FORMAT = "ISO8601";
    private static final String ISO8601_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";

    /* JADX INFO: renamed from: df, reason: collision with root package name */
    private final CachedDateFormat f17070df;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class DefaultZoneDateFormat extends DateFormat {
        private static final long serialVersionUID = 1;
        private final DateFormat dateFormat;

        @Override // java.text.DateFormat
        public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            this.dateFormat.setTimeZone(TimeZone.getDefault());
            return this.dateFormat.format(date, stringBuffer, fieldPosition);
        }

        @Override // java.text.DateFormat
        public Date parse(String str, ParsePosition parsePosition) {
            this.dateFormat.setTimeZone(TimeZone.getDefault());
            return this.dateFormat.parse(str, parsePosition);
        }

        public DefaultZoneDateFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }
    }

    @Override // org.apache.log4j.pattern.LoggingEventPatternConverter
    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        synchronized (this) {
            this.f17070df.format(loggingEvent.timeStamp, stringBuffer);
        }
    }

    private DatePatternConverter(String[] strArr) {
        DateFormat simpleDateFormat;
        int maximumCacheValidity;
        super("Date", "date");
        String str = (strArr == null || strArr.length == 0) ? null : strArr[0];
        String str2 = (str == null || str.equalsIgnoreCase("ISO8601")) ? ISO8601_PATTERN : str.equalsIgnoreCase("ABSOLUTE") ? ABSOLUTE_TIME_PATTERN : str.equalsIgnoreCase("DATE") ? DATE_AND_TIME_PATTERN : str;
        try {
            simpleDateFormat = new SimpleDateFormat(str2);
            maximumCacheValidity = CachedDateFormat.getMaximumCacheValidity(str2);
        } catch (IllegalArgumentException e10) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not instantiate SimpleDateFormat with pattern ");
            stringBuffer.append(str);
            LogLog.warn(stringBuffer.toString(), e10);
            simpleDateFormat = new SimpleDateFormat(ISO8601_PATTERN);
            maximumCacheValidity = 1000;
        }
        if (strArr == null || strArr.length <= 1) {
            simpleDateFormat = new DefaultZoneDateFormat(simpleDateFormat);
        } else {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(strArr[1]));
        }
        this.f17070df = new CachedDateFormat(simpleDateFormat, maximumCacheValidity);
    }

    public static DatePatternConverter newInstance(String[] strArr) {
        return new DatePatternConverter(strArr);
    }

    @Override // org.apache.log4j.pattern.LoggingEventPatternConverter, org.apache.log4j.pattern.PatternConverter
    public void format(Object obj, StringBuffer stringBuffer) {
        if (obj instanceof Date) {
            format((Date) obj, stringBuffer);
        }
        super.format(obj, stringBuffer);
    }

    public void format(Date date, StringBuffer stringBuffer) {
        synchronized (this) {
            this.f17070df.format(date.getTime(), stringBuffer);
        }
    }
}
