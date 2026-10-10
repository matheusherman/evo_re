package org.apache.log4j;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class RollingCalendar extends GregorianCalendar {
    private static final long serialVersionUID = -3560331770601814177L;
    int type;

    RollingCalendar() {
        this.type = -1;
    }

    void setType(int i10) {
        this.type = i10;
    }

    RollingCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
        this.type = -1;
    }

    public Date getNextCheckDate(Date date) {
        setTime(date);
        int i10 = this.type;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 == 5) {
                                set(5, 1);
                                set(11, 0);
                                set(12, 0);
                                set(13, 0);
                                set(14, 0);
                                add(2, 1);
                            } else {
                                throw new IllegalStateException("Unknown periodicity type.");
                            }
                        } else {
                            set(7, getFirstDayOfWeek());
                            set(11, 0);
                            set(12, 0);
                            set(13, 0);
                            set(14, 0);
                            add(3, 1);
                        }
                    } else {
                        set(11, 0);
                        set(12, 0);
                        set(13, 0);
                        set(14, 0);
                        add(5, 1);
                    }
                } else {
                    set(12, 0);
                    set(13, 0);
                    set(14, 0);
                    if (get(11) < 12) {
                        set(11, 12);
                    } else {
                        set(11, 0);
                        add(5, 1);
                    }
                }
            } else {
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(11, 1);
            }
        } else {
            set(13, 0);
            set(14, 0);
            add(12, 1);
        }
        return getTime();
    }

    public long getNextCheckMillis(Date date) {
        return getNextCheckDate(date).getTime();
    }
}
