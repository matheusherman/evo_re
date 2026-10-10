package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class AbsoluteTimeDateFormat extends DateFormat {
    public static final String ABS_TIME_DATE_FORMAT = "ABSOLUTE";
    public static final String DATE_AND_TIME_DATE_FORMAT = "DATE";
    public static final String ISO8601_DATE_FORMAT = "ISO8601";
    private static long previousTime = 0;
    private static char[] previousTimeWithoutMillis = new char[9];
    private static final long serialVersionUID = -388856345976723342L;

    public AbsoluteTimeDateFormat() {
        setCalendar(Calendar.getInstance());
    }

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }

    public AbsoluteTimeDateFormat(TimeZone timeZone) {
        setCalendar(Calendar.getInstance(timeZone));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0034  */
    /* JADX WARN: Code duplicated, block: B:13:0x0049  */
    /* JADX WARN: Code duplicated, block: B:16:0x005c  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int i10;
        int i11;
        int i12;
        long time = date.getTime();
        int i13 = (int) (time % 1000);
        long j10 = time - ((long) i13);
        if (j10 == previousTime) {
            char[] cArr = previousTimeWithoutMillis;
            if (cArr[0] != 0) {
                stringBuffer.append(cArr);
            } else {
                ((DateFormat) this).calendar.setTime(date);
                int length = stringBuffer.length();
                i10 = ((DateFormat) this).calendar.get(11);
                if (i10 < 10) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(i10);
                stringBuffer.append(':');
                i11 = ((DateFormat) this).calendar.get(12);
                if (i11 < 10) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(i11);
                stringBuffer.append(':');
                i12 = ((DateFormat) this).calendar.get(13);
                if (i12 < 10) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(i12);
                stringBuffer.append(',');
                stringBuffer.getChars(length, stringBuffer.length(), previousTimeWithoutMillis, 0);
                previousTime = j10;
            }
        } else {
            ((DateFormat) this).calendar.setTime(date);
            int length2 = stringBuffer.length();
            i10 = ((DateFormat) this).calendar.get(11);
            if (i10 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i10);
            stringBuffer.append(':');
            i11 = ((DateFormat) this).calendar.get(12);
            if (i11 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i11);
            stringBuffer.append(':');
            i12 = ((DateFormat) this).calendar.get(13);
            if (i12 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i12);
            stringBuffer.append(',');
            stringBuffer.getChars(length2, stringBuffer.length(), previousTimeWithoutMillis, 0);
            previousTime = j10;
        }
        if (i13 < 100) {
            stringBuffer.append('0');
        }
        if (i13 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i13);
        return stringBuffer;
    }
}
