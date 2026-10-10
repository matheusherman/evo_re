package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class DateLayout extends Layout {
    public static final String DATE_FORMAT_OPTION = "DateFormat";
    public static final String NULL_DATE_FORMAT = "NULL";
    public static final String RELATIVE_TIME_DATE_FORMAT = "RELATIVE";
    public static final String TIMEZONE_OPTION = "TimeZone";
    protected DateFormat dateFormat;
    private String dateFormatOption;
    private String timeZoneID;
    protected FieldPosition pos = new FieldPosition(0);
    protected Date date = new Date();

    public void setDateFormat(String str) {
        if (str != null) {
            this.dateFormatOption = str;
        }
        setDateFormat(this.dateFormatOption, TimeZone.getDefault());
    }

    @Override // org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
        DateFormat dateFormat;
        setDateFormat(this.dateFormatOption);
        String str = this.timeZoneID;
        if (str == null || (dateFormat = this.dateFormat) == null) {
            return;
        }
        dateFormat.setTimeZone(TimeZone.getTimeZone(str));
    }

    public void dateFormat(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
        if (this.dateFormat != null) {
            this.date.setTime(loggingEvent.timeStamp);
            this.dateFormat.format(this.date, stringBuffer, this.pos);
            stringBuffer.append(' ');
        }
    }

    public String getDateFormat() {
        return this.dateFormatOption;
    }

    public String[] getOptionStrings() {
        return new String[]{DATE_FORMAT_OPTION, TIMEZONE_OPTION};
    }

    public String getTimeZone() {
        return this.timeZoneID;
    }

    public void setOption(String str, String str2) {
        if (str.equalsIgnoreCase(DATE_FORMAT_OPTION)) {
            this.dateFormatOption = str2.toUpperCase();
        } else if (str.equalsIgnoreCase(TIMEZONE_OPTION)) {
            this.timeZoneID = str2;
        }
    }

    public void setTimeZone(String str) {
        this.timeZoneID = str;
    }

    public void setDateFormat(DateFormat dateFormat, TimeZone timeZone) {
        this.dateFormat = dateFormat;
        dateFormat.setTimeZone(timeZone);
    }

    public void setDateFormat(String str, TimeZone timeZone) {
        if (str == null) {
            this.dateFormat = null;
            return;
        }
        if (str.equalsIgnoreCase(NULL_DATE_FORMAT)) {
            this.dateFormat = null;
            return;
        }
        if (str.equalsIgnoreCase(RELATIVE_TIME_DATE_FORMAT)) {
            this.dateFormat = new RelativeTimeDateFormat();
            return;
        }
        if (str.equalsIgnoreCase(AbsoluteTimeDateFormat.ABS_TIME_DATE_FORMAT)) {
            this.dateFormat = new AbsoluteTimeDateFormat(timeZone);
            return;
        }
        if (str.equalsIgnoreCase(AbsoluteTimeDateFormat.DATE_AND_TIME_DATE_FORMAT)) {
            this.dateFormat = new DateTimeDateFormat(timeZone);
        } else {
            if (str.equalsIgnoreCase(AbsoluteTimeDateFormat.ISO8601_DATE_FORMAT)) {
                this.dateFormat = new ISO8601DateFormat(timeZone);
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(timeZone);
        }
    }
}
