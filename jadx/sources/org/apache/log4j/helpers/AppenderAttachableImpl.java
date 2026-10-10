package org.apache.log4j.helpers;

import java.util.Enumeration;
import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class AppenderAttachableImpl implements AppenderAttachable {
    protected Vector appenderList;

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void removeAppender(Appender appender) {
        Vector vector;
        if (appender == null || (vector = this.appenderList) == null) {
            return;
        }
        vector.removeElement(appender);
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void addAppender(Appender appender) {
        if (appender == null) {
            return;
        }
        if (this.appenderList == null) {
            this.appenderList = new Vector(1);
        }
        if (this.appenderList.contains(appender)) {
            return;
        }
        this.appenderList.addElement(appender);
    }

    public int appendLoopOnAppenders(LoggingEvent loggingEvent) {
        Vector vector = this.appenderList;
        if (vector == null) {
            return 0;
        }
        int size = vector.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((Appender) this.appenderList.elementAt(i10)).doAppend(loggingEvent);
        }
        return size;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public Enumeration getAllAppenders() {
        Vector vector = this.appenderList;
        if (vector == null) {
            return null;
        }
        return vector.elements();
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public Appender getAppender(String str) {
        Vector vector = this.appenderList;
        if (vector != null && str != null) {
            int size = vector.size();
            for (int i10 = 0; i10 < size; i10++) {
                Appender appender = (Appender) this.appenderList.elementAt(i10);
                if (str.equals(appender.getName())) {
                    return appender;
                }
            }
        }
        return null;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public boolean isAttached(Appender appender) {
        Vector vector = this.appenderList;
        if (vector != null && appender != null) {
            int size = vector.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((Appender) this.appenderList.elementAt(i10)) == appender) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void removeAllAppenders() {
        Vector vector = this.appenderList;
        if (vector != null) {
            int size = vector.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((Appender) this.appenderList.elementAt(i10)).close();
            }
            this.appenderList.removeAllElements();
            this.appenderList = null;
        }
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void removeAppender(String str) {
        Vector vector;
        if (str == null || (vector = this.appenderList) == null) {
            return;
        }
        int size = vector.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equals(((Appender) this.appenderList.elementAt(i10)).getName())) {
                this.appenderList.removeElementAt(i10);
                return;
            }
        }
    }
}
