package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CyclicBuffer {

    /* JADX INFO: renamed from: ea, reason: collision with root package name */
    LoggingEvent[] f17065ea;
    int first;
    int last;
    int maxSize;
    int numElems;

    public LoggingEvent get(int i10) {
        if (i10 < 0 || i10 >= this.numElems) {
            return null;
        }
        return this.f17065ea[(this.first + i10) % this.maxSize];
    }

    public void add(LoggingEvent loggingEvent) {
        LoggingEvent[] loggingEventArr = this.f17065ea;
        int i10 = this.last;
        loggingEventArr[i10] = loggingEvent;
        int i11 = i10 + 1;
        this.last = i11;
        int i12 = this.maxSize;
        if (i11 == i12) {
            this.last = 0;
        }
        int i13 = this.numElems;
        if (i13 < i12) {
            this.numElems = i13 + 1;
            return;
        }
        int i14 = this.first + 1;
        this.first = i14;
        if (i14 == i12) {
            this.first = 0;
        }
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int length() {
        return this.numElems;
    }

    public void resize(int i10) {
        if (i10 < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Negative array size [");
            stringBuffer.append(i10);
            stringBuffer.append("] not allowed.");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        int i11 = this.numElems;
        if (i10 == i11) {
            return;
        }
        LoggingEvent[] loggingEventArr = new LoggingEvent[i10];
        if (i10 < i11) {
            i11 = i10;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            LoggingEvent[] loggingEventArr2 = this.f17065ea;
            int i13 = this.first;
            loggingEventArr[i12] = loggingEventArr2[i13];
            loggingEventArr2[i13] = null;
            int i14 = i13 + 1;
            this.first = i14;
            if (i14 == this.numElems) {
                this.first = 0;
            }
        }
        this.f17065ea = loggingEventArr;
        this.first = 0;
        this.numElems = i11;
        this.maxSize = i10;
        if (i11 == i10) {
            this.last = 0;
        } else {
            this.last = i11;
        }
    }

    public CyclicBuffer(int i10) {
        if (i10 >= 1) {
            this.maxSize = i10;
            this.f17065ea = new LoggingEvent[i10];
            this.first = 0;
            this.last = 0;
            this.numElems = 0;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The maxSize argument (");
        stringBuffer.append(i10);
        stringBuffer.append(") is not a positive integer.");
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public LoggingEvent get() {
        int i10 = this.numElems;
        if (i10 <= 0) {
            return null;
        }
        this.numElems = i10 - 1;
        LoggingEvent[] loggingEventArr = this.f17065ea;
        int i11 = this.first;
        LoggingEvent loggingEvent = loggingEventArr[i11];
        loggingEventArr[i11] = null;
        int i12 = i11 + 1;
        this.first = i12;
        if (i12 == this.maxSize) {
            this.first = 0;
        }
        return loggingEvent;
    }
}
