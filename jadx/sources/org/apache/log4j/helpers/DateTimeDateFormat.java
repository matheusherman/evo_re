package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class DateTimeDateFormat extends AbsoluteTimeDateFormat {
    private static final long serialVersionUID = 5547637772208514971L;
    String[] shortMonths;

    public DateTimeDateFormat() {
        this.shortMonths = new DateFormatSymbols().getShortMonths();
    }

    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }

    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        ((DateFormat) this).calendar.setTime(date);
        int i10 = ((DateFormat) this).calendar.get(5);
        if (i10 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i10);
        stringBuffer.append(' ');
        stringBuffer.append(this.shortMonths[((DateFormat) this).calendar.get(2)]);
        stringBuffer.append(' ');
        stringBuffer.append(((DateFormat) this).calendar.get(1));
        stringBuffer.append(' ');
        return super.format(date, stringBuffer, fieldPosition);
    }

    public DateTimeDateFormat(TimeZone timeZone) {
        this();
        setCalendar(Calendar.getInstance(timeZone));
    }
}
