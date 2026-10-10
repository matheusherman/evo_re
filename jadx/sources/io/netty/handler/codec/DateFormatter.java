package io.netty.handler.codec;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import java.util.BitSet;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class DateFormatter {
    private static final String[] CALENDAR_MONTH_TO_SHORT_NAME;
    private static final String[] DAY_OF_WEEK_TO_SHORT_NAME;
    private static final BitSet DELIMITERS;
    private static final FastThreadLocal<DateFormatter> INSTANCES;
    private final GregorianCalendar cal;
    private int dayOfMonth;
    private boolean dayOfMonthFound;
    private int hours;
    private int minutes;
    private int month;
    private boolean monthFound;

    /* JADX INFO: renamed from: sb, reason: collision with root package name */
    private final StringBuilder f11362sb;
    private int seconds;
    private boolean timeFound;
    private int year;
    private boolean yearFound;

    public void reset() {
        this.timeFound = false;
        this.hours = -1;
        this.minutes = -1;
        this.seconds = -1;
        this.dayOfMonthFound = false;
        this.dayOfMonth = -1;
        this.monthFound = false;
        this.month = -1;
        this.yearFound = false;
        this.year = -1;
        this.cal.clear();
        this.f11362sb.setLength(0);
    }

    static {
        BitSet bitSet = new BitSet();
        DELIMITERS = bitSet;
        bitSet.set(9);
        for (char c10 = ' '; c10 <= '/'; c10 = (char) (c10 + 1)) {
            DELIMITERS.set(c10);
        }
        for (char c11 = ';'; c11 <= '@'; c11 = (char) (c11 + 1)) {
            DELIMITERS.set(c11);
        }
        for (char c12 = '['; c12 <= '`'; c12 = (char) (c12 + 1)) {
            DELIMITERS.set(c12);
        }
        for (char c13 = '{'; c13 <= '~'; c13 = (char) (c13 + 1)) {
            DELIMITERS.set(c13);
        }
        DAY_OF_WEEK_TO_SHORT_NAME = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        CALENDAR_MONTH_TO_SHORT_NAME = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        INSTANCES = new FastThreadLocal<DateFormatter>() { // from class: io.netty.handler.codec.DateFormatter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public DateFormatter initialValue() {
                return new DateFormatter();
            }
        };
    }

    private DateFormatter() {
        this.cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        this.f11362sb = new StringBuilder(29);
        reset();
    }

    private StringBuilder append0(Date date, StringBuilder sb2) {
        this.cal.setTime(date);
        sb2.append(DAY_OF_WEEK_TO_SHORT_NAME[this.cal.get(7) - 1]);
        sb2.append(", ");
        appendZeroLeftPadded(this.cal.get(5), sb2).append(' ');
        sb2.append(CALENDAR_MONTH_TO_SHORT_NAME[this.cal.get(2)]);
        sb2.append(' ');
        sb2.append(this.cal.get(1));
        sb2.append(' ');
        appendZeroLeftPadded(this.cal.get(11), sb2).append(':');
        appendZeroLeftPadded(this.cal.get(12), sb2).append(':');
        StringBuilder sbAppendZeroLeftPadded = appendZeroLeftPadded(this.cal.get(13), sb2);
        sbAppendZeroLeftPadded.append(" GMT");
        return sbAppendZeroLeftPadded;
    }

    private static StringBuilder appendZeroLeftPadded(int i10, StringBuilder sb2) {
        if (i10 < 10) {
            sb2.append('0');
        }
        sb2.append(i10);
        return sb2;
    }

    private String format0(Date date) {
        append0(date, this.f11362sb);
        return this.f11362sb.toString();
    }

    private static DateFormatter formatter() {
        DateFormatter dateFormatter = INSTANCES.get();
        dateFormatter.reset();
        return dateFormatter;
    }

    public static String format(Date date) {
        return formatter().format0((Date) ObjectUtil.checkNotNull(date, "date"));
    }
}
