package org.apache.log4j.pattern;

import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class RelativeTimePatternConverter extends LoggingEventPatternConverter {
    private CachedTimestamp lastTimestamp;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class CachedTimestamp {
        private final String formatted;
        private final long timestamp;

        public boolean format(long j10, StringBuffer stringBuffer) {
            if (j10 != this.timestamp) {
                return false;
            }
            stringBuffer.append(this.formatted);
            return true;
        }

        public CachedTimestamp(long j10, String str) {
            this.timestamp = j10;
            this.formatted = str;
        }
    }

    public RelativeTimePatternConverter() {
        super("Time", "time");
        this.lastTimestamp = new CachedTimestamp(0L, "");
    }

    public static RelativeTimePatternConverter newInstance(String[] strArr) {
        return new RelativeTimePatternConverter();
    }

    @Override // org.apache.log4j.pattern.LoggingEventPatternConverter
    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        long j10 = loggingEvent.timeStamp;
        if (this.lastTimestamp.format(j10, stringBuffer)) {
            return;
        }
        String string = Long.toString(j10 - LoggingEvent.getStartTime());
        stringBuffer.append(string);
        this.lastTimestamp = new CachedTimestamp(j10, string);
    }
}
