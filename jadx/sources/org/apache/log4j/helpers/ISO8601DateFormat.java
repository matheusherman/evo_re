package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ISO8601DateFormat extends AbsoluteTimeDateFormat {
    private static long lastTime = 0;
    private static char[] lastTimeString = new char[20];
    private static final long serialVersionUID = -759840745298755296L;

    public ISO8601DateFormat() {
    }

    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }

    public ISO8601DateFormat(TimeZone timeZone) {
        super(timeZone);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003f  */
    /* JADX WARN: Code duplicated, block: B:11:0x0042  */
    /* JADX WARN: Code duplicated, block: B:12:0x0045  */
    /* JADX WARN: Code duplicated, block: B:13:0x0048  */
    /* JADX WARN: Code duplicated, block: B:14:0x004b  */
    /* JADX WARN: Code duplicated, block: B:15:0x004e  */
    /* JADX WARN: Code duplicated, block: B:16:0x0051  */
    /* JADX WARN: Code duplicated, block: B:17:0x0054  */
    /* JADX WARN: Code duplicated, block: B:18:0x0057  */
    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    /* JADX WARN: Code duplicated, block: B:20:0x005d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0060  */
    /* JADX WARN: Code duplicated, block: B:22:0x0063  */
    /* JADX WARN: Code duplicated, block: B:25:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x0086  */
    /* JADX WARN: Code duplicated, block: B:31:0x009b  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        String str;
        int i10;
        int i11;
        int i12;
        int i13;
        long time = date.getTime();
        int i14 = (int) (time % 1000);
        long j10 = time - ((long) i14);
        if (j10 == lastTime) {
            char[] cArr = lastTimeString;
            if (cArr[0] != 0) {
                stringBuffer.append(cArr);
            } else {
                ((DateFormat) this).calendar.setTime(date);
                int length = stringBuffer.length();
                stringBuffer.append(((DateFormat) this).calendar.get(1));
                switch (((DateFormat) this).calendar.get(2)) {
                    case 0:
                        str = "-01-";
                        break;
                    case 1:
                        str = "-02-";
                        break;
                    case 2:
                        str = "-03-";
                        break;
                    case 3:
                        str = "-04-";
                        break;
                    case 4:
                        str = "-05-";
                        break;
                    case 5:
                        str = "-06-";
                        break;
                    case 6:
                        str = "-07-";
                        break;
                    case 7:
                        str = "-08-";
                        break;
                    case 8:
                        str = "-09-";
                        break;
                    case 9:
                        str = "-10-";
                        break;
                    case 10:
                        str = "-11-";
                        break;
                    case 11:
                        str = "-12-";
                        break;
                    default:
                        str = "-NA-";
                        break;
                }
                stringBuffer.append(str);
                i10 = ((DateFormat) this).calendar.get(5);
                if (i10 < 10) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(i10);
                stringBuffer.append(' ');
                i11 = ((DateFormat) this).calendar.get(11);
                if (i11 < 10) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(i11);
                stringBuffer.append(':');
                i12 = ((DateFormat) this).calendar.get(12);
                if (i12 < 10) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(i12);
                stringBuffer.append(':');
                i13 = ((DateFormat) this).calendar.get(13);
                if (i13 < 10) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(i13);
                stringBuffer.append(',');
                stringBuffer.getChars(length, stringBuffer.length(), lastTimeString, 0);
                lastTime = j10;
            }
        } else {
            ((DateFormat) this).calendar.setTime(date);
            int length2 = stringBuffer.length();
            stringBuffer.append(((DateFormat) this).calendar.get(1));
            switch (((DateFormat) this).calendar.get(2)) {
                case 0:
                    str = "-01-";
                    break;
                case 1:
                    str = "-02-";
                    break;
                case 2:
                    str = "-03-";
                    break;
                case 3:
                    str = "-04-";
                    break;
                case 4:
                    str = "-05-";
                    break;
                case 5:
                    str = "-06-";
                    break;
                case 6:
                    str = "-07-";
                    break;
                case 7:
                    str = "-08-";
                    break;
                case 8:
                    str = "-09-";
                    break;
                case 9:
                    str = "-10-";
                    break;
                case 10:
                    str = "-11-";
                    break;
                case 11:
                    str = "-12-";
                    break;
                default:
                    str = "-NA-";
                    break;
            }
            stringBuffer.append(str);
            i10 = ((DateFormat) this).calendar.get(5);
            if (i10 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i10);
            stringBuffer.append(' ');
            i11 = ((DateFormat) this).calendar.get(11);
            if (i11 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i11);
            stringBuffer.append(':');
            i12 = ((DateFormat) this).calendar.get(12);
            if (i12 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i12);
            stringBuffer.append(':');
            i13 = ((DateFormat) this).calendar.get(13);
            if (i13 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i13);
            stringBuffer.append(',');
            stringBuffer.getChars(length2, stringBuffer.length(), lastTimeString, 0);
            lastTime = j10;
        }
        if (i14 < 100) {
            stringBuffer.append('0');
        }
        if (i14 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i14);
        return stringBuffer;
    }
}
