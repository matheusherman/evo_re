package com.live.evo.util;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.live.evo.MyApplication;
import com.live.evo.R$array;
import com.live.evo.R$string;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@SuppressLint({"SimpleDateFormat"})
public class q1 {
    public static int j(long j10, long j11) {
        long j12 = j11 - j10;
        if (j12 <= 0) {
            return 0;
        }
        return (int) Math.ceil((j12 * 1.0d) / TimeUnit.HOURS.toMillis(1L));
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        MyApplication myApplicationA = MyApplication.a();
        try {
            Date date = o1.a(x1.j(R$string.yyyymmdd)).parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return myApplicationA.getResources().getTextArray(R$array.month)[calendar.get(2)].toString() + " " + String.valueOf(calendar.get(5));
        } catch (ParseException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static long b() {
        return x1.f1.lb.util.d1.d();
    }

    public static Calendar c(long j10, int i10) {
        Calendar calendarA = g.a();
        calendarA.setTimeInMillis(j10);
        calendarA.set(calendarA.get(1), calendarA.get(2), calendarA.get(5) + i10, 0, 0, 0);
        o(calendarA.get(7));
        return calendarA;
    }

    public static long d(long j10, int i10) {
        Calendar calendarA = g.a();
        calendarA.setTimeInMillis(j10);
        calendarA.set(calendarA.get(1), calendarA.get(2), calendarA.get(5) + i10, 0, 0, 0);
        return calendarA.getTimeInMillis();
    }

    public static Calendar e(long j10, int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(l.d().c());
        calendar.setTimeInMillis(j10);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5) + i10, 0, 0, 0);
        return calendar;
    }

    public static long f(long j10, int i10) {
        Calendar calendarA = g.a();
        calendarA.setTimeInMillis(j10);
        calendarA.set(calendarA.get(1), calendarA.get(2), calendarA.get(5) + i10);
        return calendarA.getTimeInMillis();
    }

    public static long g(long j10) {
        SimpleDateFormat simpleDateFormatA = o1.a(x1.j(R$string.ddMMyyyy));
        try {
            return simpleDateFormatA.parse(simpleDateFormatA.format(new Date(j10))).getTime();
        } catch (ParseException e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public static long h() {
        return i(b());
    }

    public static long i(long j10) {
        SimpleDateFormat simpleDateFormatA = o1.a(x1.j(R$string.ddMMyyyy));
        try {
            return simpleDateFormatA.parse(simpleDateFormatA.format(new Date(j10))).getTime();
        } catch (ParseException e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public static String k() {
        try {
            return o1.a(x1.j(R$string.yyyymmdd)).format(new Date(h()));
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String l(long j10) {
        MyApplication.a();
        o1.a(x1.j(R$string.ddMMyyyy));
        String[] strArr = {x1.j(R$string.sun), x1.j(R$string.mon), x1.j(R$string.tue), x1.j(R$string.wed), x1.j(R$string.the), x1.j(R$string.fri), x1.j(R$string.sat)};
        Calendar calendarA = g.a();
        calendarA.setTime(new Date(j10));
        int i10 = calendarA.get(7) - 1;
        if (i10 < 0) {
            i10 = 0;
        }
        return strArr[i10];
    }

    public static String m(long j10, String str) {
        return o1.a(str).format(new Date(j10));
    }

    public static long n(String str) {
        try {
            return o1.a(x1.j(R$string.ddMMyyyy)).parse(str).getTime();
        } catch (ParseException e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public static String o(int i10) {
        MyApplication.a();
        String[] strArr = {x1.j(R$string.sun), x1.j(R$string.mon), x1.j(R$string.tue), x1.j(R$string.wed), x1.j(R$string.the), x1.j(R$string.fri), x1.j(R$string.sat)};
        int i11 = i10 - 1;
        if (i11 < 0) {
            i11 = 0;
        }
        return strArr[i11];
    }
}
