package org.apache.log4j;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class DailyRollingFileAppender extends FileAppender {
    static final int HALF_DAY = 2;
    static final int TOP_OF_DAY = 3;
    static final int TOP_OF_HOUR = 1;
    static final int TOP_OF_MINUTE = 0;
    static final int TOP_OF_MONTH = 5;
    static final int TOP_OF_TROUBLE = -1;
    static final int TOP_OF_WEEK = 4;
    static final TimeZone gmtTimeZone = TimeZone.getTimeZone("GMT");
    int checkPeriod;
    private String datePattern;
    private long nextCheck;
    Date now;

    /* JADX INFO: renamed from: rc, reason: collision with root package name */
    RollingCalendar f17062rc;
    private String scheduledFilename;
    SimpleDateFormat sdf;

    public DailyRollingFileAppender() {
        this.datePattern = "'.'yyyy-MM-dd";
        this.nextCheck = System.currentTimeMillis() - 1;
        this.now = new Date();
        this.f17062rc = new RollingCalendar();
        this.checkPeriod = -1;
    }

    int computeCheckPeriod() {
        RollingCalendar rollingCalendar = new RollingCalendar(gmtTimeZone, Locale.getDefault());
        Date date = new Date(0L);
        if (this.datePattern == null) {
            return -1;
        }
        for (int i10 = 0; i10 <= 5; i10++) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.datePattern);
            simpleDateFormat.setTimeZone(gmtTimeZone);
            String str = simpleDateFormat.format(date);
            rollingCalendar.setType(i10);
            String str2 = simpleDateFormat.format(new Date(rollingCalendar.getNextCheckMillis(date)));
            if (str != null && str2 != null && !str.equals(str2)) {
                return i10;
            }
        }
        return -1;
    }

    public String getDatePattern() {
        return this.datePattern;
    }

    void printPeriodicity(int i10) {
        if (i10 == 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Appender [");
            stringBuffer.append(this.name);
            stringBuffer.append("] to be rolled every minute.");
            LogLog.debug(stringBuffer.toString());
            return;
        }
        if (i10 == 1) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Appender [");
            stringBuffer2.append(this.name);
            stringBuffer2.append("] to be rolled on top of every hour.");
            LogLog.debug(stringBuffer2.toString());
            return;
        }
        if (i10 == 2) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Appender [");
            stringBuffer3.append(this.name);
            stringBuffer3.append("] to be rolled at midday and midnight.");
            LogLog.debug(stringBuffer3.toString());
            return;
        }
        if (i10 == 3) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Appender [");
            stringBuffer4.append(this.name);
            stringBuffer4.append("] to be rolled at midnight.");
            LogLog.debug(stringBuffer4.toString());
            return;
        }
        if (i10 == 4) {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Appender [");
            stringBuffer5.append(this.name);
            stringBuffer5.append("] to be rolled at start of week.");
            LogLog.debug(stringBuffer5.toString());
            return;
        }
        if (i10 != 5) {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Unknown periodicity for appender [");
            stringBuffer6.append(this.name);
            stringBuffer6.append("].");
            LogLog.warn(stringBuffer6.toString());
            return;
        }
        StringBuffer stringBuffer7 = new StringBuffer();
        stringBuffer7.append("Appender [");
        stringBuffer7.append(this.name);
        stringBuffer7.append("] to be rolled at start of every month.");
        LogLog.debug(stringBuffer7.toString());
    }

    void rollOver() {
        if (this.datePattern == null) {
            this.errorHandler.error("Missing DatePattern option in rollOver().");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fileName);
        stringBuffer.append(this.sdf.format(this.now));
        String string = stringBuffer.toString();
        if (this.scheduledFilename.equals(string)) {
            return;
        }
        closeFile();
        File file = new File(this.scheduledFilename);
        if (file.exists()) {
            file.delete();
        }
        if (new File(this.fileName).renameTo(file)) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(this.fileName);
            stringBuffer2.append(" -> ");
            stringBuffer2.append(this.scheduledFilename);
            LogLog.debug(stringBuffer2.toString());
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Failed to rename [");
            stringBuffer3.append(this.fileName);
            stringBuffer3.append("] to [");
            stringBuffer3.append(this.scheduledFilename);
            stringBuffer3.append("].");
            LogLog.error(stringBuffer3.toString());
        }
        try {
            setFile(this.fileName, true, this.bufferedIO, this.bufferSize);
        } catch (IOException unused) {
            ErrorHandler errorHandler = this.errorHandler;
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("setFile(");
            stringBuffer4.append(this.fileName);
            stringBuffer4.append(", true) call failed.");
            errorHandler.error(stringBuffer4.toString());
        }
        this.scheduledFilename = string;
    }

    public void setDatePattern(String str) {
        this.datePattern = str;
    }

    @Override // org.apache.log4j.FileAppender, org.apache.log4j.WriterAppender, org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
        super.activateOptions();
        if (this.datePattern != null && this.fileName != null) {
            this.now.setTime(System.currentTimeMillis());
            this.sdf = new SimpleDateFormat(this.datePattern);
            int iComputeCheckPeriod = computeCheckPeriod();
            printPeriodicity(iComputeCheckPeriod);
            this.f17062rc.setType(iComputeCheckPeriod);
            File file = new File(this.fileName);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.fileName);
            stringBuffer.append(this.sdf.format(new Date(file.lastModified())));
            this.scheduledFilename = stringBuffer.toString();
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Either File or DatePattern options are not set for appender [");
        stringBuffer2.append(this.name);
        stringBuffer2.append("].");
        LogLog.error(stringBuffer2.toString());
    }

    @Override // org.apache.log4j.WriterAppender
    protected void subAppend(LoggingEvent loggingEvent) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis >= this.nextCheck) {
            this.now.setTime(jCurrentTimeMillis);
            this.nextCheck = this.f17062rc.getNextCheckMillis(this.now);
            try {
                rollOver();
            } catch (IOException e10) {
                if (e10 instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                LogLog.error("rollOver() failed.", e10);
            }
        }
        super.subAppend(loggingEvent);
    }

    public DailyRollingFileAppender(Layout layout, String str, String str2) {
        super(layout, str, true);
        this.datePattern = "'.'yyyy-MM-dd";
        this.nextCheck = System.currentTimeMillis() - 1;
        this.now = new Date();
        this.f17062rc = new RollingCalendar();
        this.checkPeriod = -1;
        this.datePattern = str2;
        activateOptions();
    }
}
