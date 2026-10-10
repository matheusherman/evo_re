package org.apache.log4j.pattern;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class CachedDateFormat extends DateFormat {
    private static final String DIGITS = "0123456789";
    private static final int MAGIC1 = 654;
    private static final int MAGIC2 = 987;
    private static final String MAGICSTRING1 = "654";
    private static final String MAGICSTRING2 = "987";
    public static final int NO_MILLISECONDS = -2;
    public static final int UNRECOGNIZED_MILLISECONDS = -1;
    private static final String ZERO_STRING = "000";
    private static final long serialVersionUID = 1;
    private final int expiration;
    private final DateFormat formatter;
    private int millisecondStart;
    private long previousTime;
    private long slotBegin;
    private StringBuffer cache = new StringBuffer(50);
    private final Date tmpDate = new Date(0);

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        format(date.getTime(), stringBuffer);
        return stringBuffer;
    }

    public static int findMillisecondStart(long j10, String str, DateFormat dateFormat) {
        String str2;
        long j11 = (j10 / 1000) * 1000;
        if (j11 > j10) {
            j11 -= 1000;
        }
        int i10 = (int) (j10 - j11);
        int i11 = MAGIC1;
        if (i10 == MAGIC1) {
            i11 = MAGIC2;
            str2 = MAGICSTRING2;
        } else {
            str2 = MAGICSTRING1;
        }
        String str3 = dateFormat.format(new Date(((long) i11) + j11));
        if (str3.length() != str.length()) {
            return -1;
        }
        for (int i12 = 0; i12 < str.length(); i12++) {
            if (str.charAt(i12) != str3.charAt(i12)) {
                StringBuffer stringBuffer = new StringBuffer("ABC");
                millisecondFormat(i10, stringBuffer, 0);
                String str4 = dateFormat.format(new Date(j11));
                if (str4.length() == str.length() && str2.regionMatches(0, str3, i12, str2.length()) && stringBuffer.toString().regionMatches(0, str, i12, str2.length()) && ZERO_STRING.regionMatches(0, str4, i12, 3)) {
                    return i12;
                }
                return -1;
            }
        }
        return -2;
    }

    public static int getMaximumCacheValidity(String str) {
        int iIndexOf = str.indexOf(83);
        return (iIndexOf < 0 || iIndexOf == str.lastIndexOf("SSS")) ? 1000 : 1;
    }

    private static void millisecondFormat(int i10, StringBuffer stringBuffer, int i11) {
        stringBuffer.setCharAt(i11, DIGITS.charAt(i10 / 100));
        stringBuffer.setCharAt(i11 + 1, DIGITS.charAt((i10 / 10) % 10));
        stringBuffer.setCharAt(i11 + 2, DIGITS.charAt(i10 % 10));
    }

    public StringBuffer format(long j10, StringBuffer stringBuffer) {
        if (j10 == this.previousTime) {
            stringBuffer.append(this.cache);
            return stringBuffer;
        }
        int i10 = this.millisecondStart;
        if (i10 != -1) {
            long j11 = this.slotBegin;
            if (j10 < ((long) this.expiration) + j11 && j10 >= j11 && j10 < j11 + 1000) {
                if (i10 >= 0) {
                    millisecondFormat((int) (j10 - j11), this.cache, i10);
                }
                this.previousTime = j10;
                stringBuffer.append(this.cache);
                return stringBuffer;
            }
        }
        this.cache.setLength(0);
        this.tmpDate.setTime(j10);
        this.cache.append(this.formatter.format(this.tmpDate));
        stringBuffer.append(this.cache);
        this.previousTime = j10;
        long j12 = (j10 / 1000) * 1000;
        this.slotBegin = j12;
        if (j12 > j10) {
            this.slotBegin = j12 - 1000;
        }
        if (this.millisecondStart >= 0) {
            this.millisecondStart = findMillisecondStart(j10, this.cache.toString(), this.formatter);
        }
        return stringBuffer;
    }

    @Override // java.text.DateFormat
    public NumberFormat getNumberFormat() {
        return this.formatter.getNumberFormat();
    }

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return this.formatter.parse(str, parsePosition);
    }

    @Override // java.text.DateFormat
    public void setTimeZone(TimeZone timeZone) {
        this.formatter.setTimeZone(timeZone);
        this.previousTime = Long.MIN_VALUE;
        this.slotBegin = Long.MIN_VALUE;
    }

    public CachedDateFormat(DateFormat dateFormat, int i10) {
        if (dateFormat != null) {
            if (i10 >= 0) {
                this.formatter = dateFormat;
                this.expiration = i10;
                this.millisecondStart = 0;
                this.previousTime = Long.MIN_VALUE;
                this.slotBegin = Long.MIN_VALUE;
                return;
            }
            throw new IllegalArgumentException("expiration must be non-negative");
        }
        throw new IllegalArgumentException("dateFormat cannot be null");
    }
}
