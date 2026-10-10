package org.apache.log4j.spi;

import java.io.Serializable;
import org.apache.log4j.Category;
import org.apache.log4j.DefaultThrowableRenderer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ThrowableInformation implements Serializable {
    static final long serialVersionUID = -4748765566864322735L;
    private transient Category category;
    private String[] rep;
    private transient Throwable throwable;

    public ThrowableInformation(Throwable th) {
        this.throwable = th;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    public synchronized String[] getThrowableStrRep() {
        ThrowableRenderer throwableRenderer;
        try {
            if (this.rep == null) {
                Category category = this.category;
                if (category != null) {
                    LoggerRepository loggerRepository = category.getLoggerRepository();
                    if (loggerRepository instanceof ThrowableRendererSupport) {
                        throwableRenderer = ((ThrowableRendererSupport) loggerRepository).getThrowableRenderer();
                    } else {
                        throwableRenderer = null;
                    }
                } else {
                    throwableRenderer = null;
                }
                if (throwableRenderer == null) {
                    this.rep = DefaultThrowableRenderer.render(this.throwable);
                } else {
                    this.rep = throwableRenderer.doRender(this.throwable);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String[]) this.rep.clone();
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public ThrowableInformation(Throwable th, Category category) {
        this.throwable = th;
        this.category = category;
    }

    public ThrowableInformation(String[] strArr) {
        if (strArr != null) {
            this.rep = (String[]) strArr.clone();
        }
    }
}
