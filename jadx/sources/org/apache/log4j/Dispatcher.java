package org.apache.log4j;

import org.apache.log4j.helpers.AppenderAttachableImpl;
import org.apache.log4j.helpers.BoundedFIFO;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class Dispatcher extends Thread {
    private AppenderAttachableImpl aai;

    /* JADX INFO: renamed from: bf, reason: collision with root package name */
    private BoundedFIFO f17063bf;
    AsyncAppender container;
    private boolean interrupted = false;

    void close() {
        synchronized (this.f17063bf) {
            try {
                this.interrupted = true;
                if (this.f17063bf.length() == 0) {
                    this.f17063bf.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        r2 = r3.container.aai;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        monitor-enter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        r0 = r3.aai;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        if (r1 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        r0.appendLoopOnAppenders(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        monitor-exit(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:
    
        throw r0;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        while (true) {
            synchronized (this.f17063bf) {
                if (this.f17063bf.length() == 0) {
                    if (this.interrupted) {
                        break;
                    } else {
                        try {
                            this.f17063bf.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                    this.aai.removeAllAppenders();
                }
                LoggingEvent loggingEvent = this.f17063bf.get();
                if (this.f17063bf.wasFull()) {
                    this.f17063bf.notify();
                }
            }
        }
        this.aai.removeAllAppenders();
    }

    Dispatcher(BoundedFIFO boundedFIFO, AsyncAppender asyncAppender) {
        this.f17063bf = boundedFIFO;
        this.container = asyncAppender;
        this.aai = asyncAppender.aai;
        setDaemon(true);
        setPriority(1);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Dispatcher-");
        stringBuffer.append(getName());
        setName(stringBuffer.toString());
    }
}
