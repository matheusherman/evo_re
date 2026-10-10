package org.apache.log4j;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.helpers.AppenderAttachableImpl;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class AsyncAppender extends AppenderSkeleton implements AppenderAttachable {
    public static final int DEFAULT_BUFFER_SIZE = 128;
    AppenderAttachableImpl aai;
    private final AppenderAttachableImpl appenders;
    private boolean blocking;
    private final List buffer;
    private int bufferSize;
    private final Map discardMap;
    private final Thread dispatcher;
    private boolean locationInfo;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class DiscardSummary {
        private int count = 1;
        private LoggingEvent maxEvent;

        public LoggingEvent createEvent() {
            return new LoggingEvent("org.apache.log4j.AsyncAppender.DONT_REPORT_LOCATION", Logger.getLogger(this.maxEvent.getLoggerName()), this.maxEvent.getLevel(), MessageFormat.format("Discarded {0} messages due to full event buffer including: {1}", new Integer(this.count), this.maxEvent.getMessage()), null);
        }

        public DiscardSummary(LoggingEvent loggingEvent) {
            this.maxEvent = loggingEvent;
        }

        public void add(LoggingEvent loggingEvent) {
            if (loggingEvent.getLevel().toInt() > this.maxEvent.getLevel().toInt()) {
                this.maxEvent = loggingEvent;
            }
            this.count++;
        }
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void removeAppender(Appender appender) {
        synchronized (this.appenders) {
            this.appenders.removeAppender(appender);
        }
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class Dispatcher implements Runnable {
        private final AppenderAttachableImpl appenders;
        private final List buffer;
        private final Map discardMap;
        private final AsyncAppender parent;

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            LoggingEvent[] loggingEventArr;
            boolean z11 = true;
            while (z11) {
                try {
                    synchronized (this.buffer) {
                        try {
                            int size = this.buffer.size();
                            boolean z12 = this.parent.closed;
                            while (true) {
                                z10 = !z12;
                                if (size != 0 || !z10) {
                                    break;
                                }
                                this.buffer.wait();
                                size = this.buffer.size();
                                z12 = this.parent.closed;
                            }
                            if (size > 0) {
                                loggingEventArr = new LoggingEvent[this.discardMap.size() + size];
                                this.buffer.toArray(loggingEventArr);
                                Iterator it = this.discardMap.values().iterator();
                                while (it.hasNext()) {
                                    loggingEventArr[size] = ((DiscardSummary) it.next()).createEvent();
                                    size++;
                                }
                                this.buffer.clear();
                                this.discardMap.clear();
                                this.buffer.notifyAll();
                            } else {
                                loggingEventArr = null;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (loggingEventArr != null) {
                        for (LoggingEvent loggingEvent : loggingEventArr) {
                            synchronized (this.appenders) {
                                this.appenders.appendLoopOnAppenders(loggingEvent);
                            }
                        }
                    }
                    z11 = z10;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        public Dispatcher(AsyncAppender asyncAppender, List list, Map map, AppenderAttachableImpl appenderAttachableImpl) {
            this.parent = asyncAppender;
            this.buffer = list;
            this.appenders = appenderAttachableImpl;
            this.discardMap = map;
        }
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void addAppender(Appender appender) {
        synchronized (this.appenders) {
            this.appenders.addAppender(appender);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006f A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x0029, B:16:0x0033, B:18:0x003a, B:34:0x007d, B:21:0x0042, B:23:0x0046, B:25:0x004c, B:27:0x0054, B:29:0x005a, B:30:0x0061, B:32:0x006f, B:33:0x007a), top: B:46:0x0029, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x007a A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:14:0x0029, B:16:0x0033, B:18:0x003a, B:34:0x007d, B:21:0x0042, B:23:0x0046, B:25:0x004c, B:27:0x0054, B:29:0x005a, B:30:0x0061, B:32:0x006f, B:33:0x007a), top: B:46:0x0029, inners: #2 }] */
    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        String loggerName;
        DiscardSummary discardSummary;
        Thread thread = this.dispatcher;
        if (thread == null || !thread.isAlive() || this.bufferSize <= 0) {
            synchronized (this.appenders) {
                this.appenders.appendLoopOnAppenders(loggingEvent);
            }
            return;
        }
        loggingEvent.getNDC();
        loggingEvent.getThreadName();
        loggingEvent.getMDCCopy();
        if (this.locationInfo) {
            loggingEvent.getLocationInformation();
        }
        loggingEvent.getRenderedMessage();
        loggingEvent.getThrowableStrRep();
        synchronized (this.buffer) {
            while (true) {
                try {
                    int size = this.buffer.size();
                    if (size < this.bufferSize) {
                        this.buffer.add(loggingEvent);
                        if (size == 0) {
                            this.buffer.notifyAll();
                        }
                    } else {
                        if (!this.blocking || Thread.interrupted() || Thread.currentThread() == this.dispatcher) {
                            break;
                        }
                        try {
                            this.buffer.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            loggerName = loggingEvent.getLoggerName();
                            discardSummary = (DiscardSummary) this.discardMap.get(loggerName);
                            if (discardSummary == null) {
                                this.discardMap.put(loggerName, new DiscardSummary(loggingEvent));
                            } else {
                                discardSummary.add(loggingEvent);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            loggerName = loggingEvent.getLoggerName();
            discardSummary = (DiscardSummary) this.discardMap.get(loggerName);
            if (discardSummary == null) {
                this.discardMap.put(loggerName, new DiscardSummary(loggingEvent));
            } else {
                discardSummary.add(loggingEvent);
            }
        }
    }

    @Override // org.apache.log4j.Appender
    public void close() {
        synchronized (this.buffer) {
            this.closed = true;
            this.buffer.notifyAll();
        }
        try {
            this.dispatcher.join();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            LogLog.error("Got an InterruptedException while waiting for the dispatcher to finish.", e10);
        }
        synchronized (this.appenders) {
            try {
                Enumeration allAppenders = this.appenders.getAllAppenders();
                if (allAppenders != null) {
                    while (allAppenders.hasMoreElements()) {
                        Object objNextElement = allAppenders.nextElement();
                        if (objNextElement instanceof Appender) {
                            ((Appender) objNextElement).close();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public Enumeration getAllAppenders() {
        Enumeration allAppenders;
        synchronized (this.appenders) {
            allAppenders = this.appenders.getAllAppenders();
        }
        return allAppenders;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public Appender getAppender(String str) {
        Appender appender;
        synchronized (this.appenders) {
            appender = this.appenders.getAppender(str);
        }
        return appender;
    }

    public boolean getBlocking() {
        return this.blocking;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public boolean isAttached(Appender appender) {
        boolean zIsAttached;
        synchronized (this.appenders) {
            zIsAttached = this.appenders.isAttached(appender);
        }
        return zIsAttached;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void removeAllAppenders() {
        synchronized (this.appenders) {
            this.appenders.removeAllAppenders();
        }
    }

    public void setBlocking(boolean z10) {
        synchronized (this.buffer) {
            this.blocking = z10;
            this.buffer.notifyAll();
        }
    }

    public void setBufferSize(int i10) {
        if (i10 < 0) {
            throw new NegativeArraySizeException("size");
        }
        synchronized (this.buffer) {
            if (i10 < 1) {
                i10 = 1;
            }
            this.bufferSize = i10;
            this.buffer.notifyAll();
        }
    }

    public void setLocationInfo(boolean z10) {
        this.locationInfo = z10;
    }

    public AsyncAppender() {
        ArrayList arrayList = new ArrayList();
        this.buffer = arrayList;
        HashMap map = new HashMap();
        this.discardMap = map;
        this.bufferSize = 128;
        this.locationInfo = false;
        this.blocking = true;
        AppenderAttachableImpl appenderAttachableImpl = new AppenderAttachableImpl();
        this.appenders = appenderAttachableImpl;
        this.aai = appenderAttachableImpl;
        Thread thread = new Thread(new Dispatcher(this, arrayList, map, appenderAttachableImpl));
        this.dispatcher = thread;
        thread.setDaemon(true);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AsyncAppender-Dispatcher-");
        stringBuffer.append(thread.getName());
        thread.setName(stringBuffer.toString());
        thread.start();
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void removeAppender(String str) {
        synchronized (this.appenders) {
            this.appenders.removeAppender(str);
        }
    }
}
