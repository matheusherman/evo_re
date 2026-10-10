package org.apache.log4j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Priority {
    public static final int ALL_INT = Integer.MIN_VALUE;
    public static final int DEBUG_INT = 10000;
    public static final int INFO_INT = 20000;
    public static final int OFF_INT = Integer.MAX_VALUE;
    transient int level;
    transient String levelStr;
    transient int syslogEquivalent;
    public static final int FATAL_INT = 50000;
    public static final Priority FATAL = new Level(FATAL_INT, "FATAL", 0);
    public static final int ERROR_INT = 40000;
    public static final Priority ERROR = new Level(ERROR_INT, "ERROR", 3);
    public static final int WARN_INT = 30000;
    public static final Priority WARN = new Level(WARN_INT, "WARN", 4);
    public static final Priority INFO = new Level(20000, "INFO", 6);
    public static final Priority DEBUG = new Level(10000, "DEBUG", 7);

    protected Priority() {
        this.level = 10000;
        this.levelStr = "DEBUG";
        this.syslogEquivalent = 7;
    }

    public static Priority[] getAllPossiblePriorities() {
        return new Priority[]{FATAL, ERROR, Level.WARN, INFO, DEBUG};
    }

    public static Priority toPriority(String str) {
        return Level.toLevel(str);
    }

    public static Priority toPriority(int i10) {
        return toPriority(i10, DEBUG);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Priority) && this.level == ((Priority) obj).level;
    }

    public final int getSyslogEquivalent() {
        return this.syslogEquivalent;
    }

    public boolean isGreaterOrEqual(Priority priority) {
        return this.level >= priority.level;
    }

    public final int toInt() {
        return this.level;
    }

    public final String toString() {
        return this.levelStr;
    }

    public static Priority toPriority(int i10, Priority priority) {
        return Level.toLevel(i10, (Level) priority);
    }

    public static Priority toPriority(String str, Priority priority) {
        return Level.toLevel(str, (Level) priority);
    }

    protected Priority(int i10, String str, int i11) {
        this.level = i10;
        this.levelStr = str;
        this.syslogEquivalent = i11;
    }
}
