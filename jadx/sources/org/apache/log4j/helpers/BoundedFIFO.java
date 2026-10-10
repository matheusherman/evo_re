package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class BoundedFIFO {
    LoggingEvent[] buf;
    int maxSize;
    int numElements = 0;
    int first = 0;
    int next = 0;

    public synchronized void resize(int i10) {
        int iMin;
        try {
            int i11 = this.maxSize;
            if (i10 == i11) {
                return;
            }
            LoggingEvent[] loggingEventArr = new LoggingEvent[i10];
            int iMin2 = min(min(i11 - this.first, i10), this.numElements);
            System.arraycopy(this.buf, this.first, loggingEventArr, 0, iMin2);
            int i12 = this.numElements;
            if (iMin2 >= i12 || iMin2 >= i10) {
                iMin = 0;
            } else {
                iMin = min(i12 - iMin2, i10 - iMin2);
                System.arraycopy(this.buf, 0, loggingEventArr, iMin2, iMin);
            }
            this.buf = loggingEventArr;
            this.maxSize = i10;
            this.first = 0;
            int i13 = iMin2 + iMin;
            this.numElements = i13;
            this.next = i13;
            if (i13 == i10) {
                this.next = 0;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public LoggingEvent get() {
        int i10 = this.numElements;
        if (i10 == 0) {
            return null;
        }
        LoggingEvent[] loggingEventArr = this.buf;
        int i11 = this.first;
        LoggingEvent loggingEvent = loggingEventArr[i11];
        loggingEventArr[i11] = null;
        int i12 = i11 + 1;
        this.first = i12;
        if (i12 == this.maxSize) {
            this.first = 0;
        }
        this.numElements = i10 - 1;
        return loggingEvent;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public boolean isFull() {
        return this.numElements == this.maxSize;
    }

    public int length() {
        return this.numElements;
    }

    int min(int i10, int i11) {
        return i10 < i11 ? i10 : i11;
    }

    public void put(LoggingEvent loggingEvent) {
        int i10 = this.numElements;
        int i11 = this.maxSize;
        if (i10 != i11) {
            LoggingEvent[] loggingEventArr = this.buf;
            int i12 = this.next;
            loggingEventArr[i12] = loggingEvent;
            int i13 = i12 + 1;
            this.next = i13;
            if (i13 == i11) {
                this.next = 0;
            }
            this.numElements = i10 + 1;
        }
    }

    public boolean wasEmpty() {
        return this.numElements == 1;
    }

    public boolean wasFull() {
        return this.numElements + 1 == this.maxSize;
    }

    public BoundedFIFO(int i10) {
        if (i10 >= 1) {
            this.maxSize = i10;
            this.buf = new LoggingEvent[i10];
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The maxSize argument (");
            stringBuffer.append(i10);
            stringBuffer.append(") is not a positive integer.");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }
}
