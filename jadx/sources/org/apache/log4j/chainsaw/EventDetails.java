package org.apache.log4j.chainsaw;

import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class EventDetails {
    private final String mCategoryName;
    private final String mLocationDetails;
    private final String mMessage;
    private final String mNDC;
    private final Priority mPriority;
    private final String mThreadName;
    private final String[] mThrowableStrRep;
    private final long mTimeStamp;

    EventDetails(long j10, Priority priority, String str, String str2, String str3, String str4, String[] strArr, String str5) {
        this.mTimeStamp = j10;
        this.mPriority = priority;
        this.mCategoryName = str;
        this.mNDC = str2;
        this.mThreadName = str3;
        this.mMessage = str4;
        this.mThrowableStrRep = strArr;
        this.mLocationDetails = str5;
    }

    String getCategoryName() {
        return this.mCategoryName;
    }

    String getLocationDetails() {
        return this.mLocationDetails;
    }

    String getMessage() {
        return this.mMessage;
    }

    String getNDC() {
        return this.mNDC;
    }

    Priority getPriority() {
        return this.mPriority;
    }

    String getThreadName() {
        return this.mThreadName;
    }

    String[] getThrowableStrRep() {
        return this.mThrowableStrRep;
    }

    long getTimeStamp() {
        return this.mTimeStamp;
    }

    EventDetails(LoggingEvent loggingEvent) {
        this(loggingEvent.timeStamp, loggingEvent.getLevel(), loggingEvent.getLoggerName(), loggingEvent.getNDC(), loggingEvent.getThreadName(), loggingEvent.getRenderedMessage(), loggingEvent.getThrowableStrRep(), loggingEvent.getLocationInformation() == null ? null : loggingEvent.getLocationInformation().fullInfo);
    }
}
