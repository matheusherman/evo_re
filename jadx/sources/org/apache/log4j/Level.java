package org.apache.log4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Level extends Priority implements Serializable {
    public static final int TRACE_INT = 5000;
    static /* synthetic */ Class class$org$apache$log4j$Level = null;
    static final long serialVersionUID = 3491141966387921974L;
    public static final Level OFF = new Level(Integer.MAX_VALUE, "OFF", 0);
    public static final Level FATAL = new Level(Priority.FATAL_INT, "FATAL", 0);
    public static final Level ERROR = new Level(Priority.ERROR_INT, "ERROR", 3);
    public static final Level WARN = new Level(Priority.WARN_INT, "WARN", 4);
    public static final Level INFO = new Level(20000, "INFO", 6);
    public static final Level DEBUG = new Level(10000, "DEBUG", 7);
    public static final Level TRACE = new Level(5000, "TRACE", 7);
    public static final Level ALL = new Level(Integer.MIN_VALUE, "ALL", 7);

    public static Level toLevel(String str) {
        return toLevel(str, DEBUG);
    }

    public static Level toLevel(int i10) {
        return toLevel(i10, DEBUG);
    }

    protected Level(int i10, String str, int i11) {
        super(i10, str, i11);
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.level = objectInputStream.readInt();
        this.syslogEquivalent = objectInputStream.readInt();
        String utf = objectInputStream.readUTF();
        this.levelStr = utf;
        if (utf == null) {
            this.levelStr = "";
        }
    }

    private Object readResolve() throws Throwable {
        Class<?> cls = getClass();
        Class<?> clsClass$ = class$org$apache$log4j$Level;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = clsClass$;
        }
        if (cls == clsClass$) {
            return toLevel(this.level);
        }
        return this;
    }

    public static Level toLevel(int i10, Level level) {
        if (i10 == Integer.MIN_VALUE) {
            return ALL;
        }
        if (i10 == 5000) {
            return TRACE;
        }
        if (i10 == 10000) {
            return DEBUG;
        }
        if (i10 == 20000) {
            return INFO;
        }
        if (i10 == 30000) {
            return WARN;
        }
        if (i10 == 40000) {
            return ERROR;
        }
        if (i10 != 50000) {
            return i10 != Integer.MAX_VALUE ? level : OFF;
        }
        return FATAL;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.level);
        objectOutputStream.writeInt(this.syslogEquivalent);
        objectOutputStream.writeUTF(this.levelStr);
    }

    public static Level toLevel(String str, Level level) {
        if (str != null) {
            String upperCase = str.toUpperCase();
            if (upperCase.equals("ALL")) {
                return ALL;
            }
            if (upperCase.equals("DEBUG")) {
                return DEBUG;
            }
            if (upperCase.equals("INFO")) {
                return INFO;
            }
            if (upperCase.equals("WARN")) {
                return WARN;
            }
            if (upperCase.equals("ERROR")) {
                return ERROR;
            }
            if (upperCase.equals("FATAL")) {
                return FATAL;
            }
            if (upperCase.equals("OFF")) {
                return OFF;
            }
            if (upperCase.equals("TRACE")) {
                return TRACE;
            }
            if (upperCase.equals("İNFO")) {
                return INFO;
            }
        }
        return level;
    }
}
