package io.netty.util;

import androidx.core.location.LocationRequestCompat;
import androidx.p000lifecycle.h;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ResourceLeakDetector<T> {
    private static final Level DEFAULT_LEVEL;
    static final int SAMPLING_INTERVAL;
    private static final int TARGET_RECORDS;
    private static final AtomicReference<String[]> excludedMethods;
    private static Level level;
    private static final InternalLogger logger;
    private final Set<DefaultResourceLeak<?>> allLeaks;
    private final ReferenceQueue<Object> refQueue;
    private final Set<String> reportedLeaks;
    private final String resourceType;
    private final int samplingInterval;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class DefaultResourceLeak<T> extends WeakReference<Object> implements ResourceLeakTracker<T> {
        private final Set<DefaultResourceLeak<?>> allLeaks;
        private volatile int droppedRecords;
        private volatile TraceRecord head;
        private final int trackedHash;
        private static final AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, TraceRecord> headUpdater = AtomicReferenceFieldUpdater.newUpdater(DefaultResourceLeak.class, TraceRecord.class, "head");
        private static final AtomicIntegerFieldUpdater<DefaultResourceLeak<?>> droppedRecordsUpdater = AtomicIntegerFieldUpdater.newUpdater(DefaultResourceLeak.class, "droppedRecords");

        public boolean close() {
            if (!this.allLeaks.remove(this)) {
                return false;
            }
            clear();
            headUpdater.set(this, null);
            return true;
        }

        @Override // io.netty.util.ResourceLeakTracker
        public void record() {
            record0(null);
        }

        private String generateReport(TraceRecord traceRecord) {
            if (traceRecord == null) {
                return "";
            }
            int i10 = droppedRecordsUpdater.get(this);
            int i11 = 1;
            int i12 = traceRecord.pos + 1;
            StringBuilder sb2 = new StringBuilder(i12 * 2048);
            String str = StringUtil.NEWLINE;
            sb2.append(str);
            sb2.append("Recent access records: ");
            sb2.append(str);
            HashSet hashSet = new HashSet(i12);
            int i13 = 0;
            while (traceRecord != TraceRecord.BOTTOM) {
                String string = traceRecord.toString();
                if (!hashSet.add(string)) {
                    i13++;
                } else if (traceRecord.next == TraceRecord.BOTTOM) {
                    sb2.append("Created at:");
                    sb2.append(StringUtil.NEWLINE);
                    sb2.append(string);
                } else {
                    sb2.append('#');
                    sb2.append(i11);
                    sb2.append(':');
                    sb2.append(StringUtil.NEWLINE);
                    sb2.append(string);
                    i11++;
                }
                traceRecord = traceRecord.next;
            }
            if (i13 > 0) {
                sb2.append(": ");
                sb2.append(i13);
                sb2.append(" leak records were discarded because they were duplicates");
                sb2.append(StringUtil.NEWLINE);
            }
            if (i10 > 0) {
                sb2.append(": ");
                sb2.append(i10);
                sb2.append(" leak records were discarded because the leak record count is targeted to ");
                sb2.append(ResourceLeakDetector.TARGET_RECORDS);
                sb2.append(". Use system property ");
                sb2.append("io.netty.leakDetection.targetRecords");
                sb2.append(" to increase the limit.");
                sb2.append(StringUtil.NEWLINE);
            }
            sb2.setLength(sb2.length() - StringUtil.NEWLINE.length());
            return sb2.toString();
        }

        private static void reachabilityFence0(Object obj) {
            if (obj != null) {
                synchronized (obj) {
                }
            }
        }

        String getReportAndClearRecords() {
            return generateReport(headUpdater.getAndSet(this, null));
        }

        @Override // io.netty.util.ResourceLeakTracker
        public void record(Object obj) {
            record0(obj);
        }

        public String toString() {
            return generateReport(headUpdater.get(this));
        }

        DefaultResourceLeak(Object obj, ReferenceQueue<Object> referenceQueue, Set<DefaultResourceLeak<?>> set, Object obj2) {
            TraceRecord traceRecord;
            super(obj, referenceQueue);
            this.trackedHash = System.identityHashCode(obj);
            set.add(this);
            AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, TraceRecord> atomicReferenceFieldUpdater = headUpdater;
            if (obj2 == null) {
                traceRecord = new TraceRecord(TraceRecord.BOTTOM);
            } else {
                traceRecord = new TraceRecord(TraceRecord.BOTTOM, obj2);
            }
            atomicReferenceFieldUpdater.set(this, traceRecord);
            this.allLeaks = set;
        }

        private void record0(Object obj) {
            AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, TraceRecord> atomicReferenceFieldUpdater;
            TraceRecord traceRecord;
            boolean z10;
            TraceRecord traceRecord2;
            TraceRecord traceRecord3;
            if (ResourceLeakDetector.TARGET_RECORDS > 0) {
                do {
                    atomicReferenceFieldUpdater = headUpdater;
                    traceRecord = atomicReferenceFieldUpdater.get(this);
                    if (traceRecord != null) {
                        boolean z11 = true;
                        int i10 = traceRecord.pos + 1;
                        z10 = false;
                        if (i10 >= ResourceLeakDetector.TARGET_RECORDS) {
                            if (PlatformDependent.threadLocalRandom().nextInt(1 << Math.min(i10 - ResourceLeakDetector.TARGET_RECORDS, 30)) == 0) {
                                z11 = false;
                            }
                            if (z11) {
                                traceRecord2 = traceRecord.next;
                            } else {
                                traceRecord2 = traceRecord;
                            }
                            z10 = z11;
                        } else {
                            traceRecord2 = traceRecord;
                        }
                        if (obj != null) {
                            traceRecord3 = new TraceRecord(traceRecord2, obj);
                        } else {
                            traceRecord3 = new TraceRecord(traceRecord2);
                        }
                    } else {
                        return;
                    }
                } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, traceRecord, traceRecord3));
                if (z10) {
                    droppedRecordsUpdater.incrementAndGet(this);
                }
            }
        }

        boolean dispose() {
            clear();
            return this.allLeaks.remove(this);
        }

        @Override // io.netty.util.ResourceLeakTracker
        public boolean close(T t10) {
            try {
                return close();
            } finally {
                reachabilityFence0(t10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class TraceRecord extends Throwable {
        private static final TraceRecord BOTTOM = new TraceRecord() { // from class: io.netty.util.ResourceLeakDetector.TraceRecord.1
            private static final long serialVersionUID = 7396077602074694571L;

            @Override // java.lang.Throwable
            public Throwable fillInStackTrace() {
                return this;
            }
        };
        private static final long serialVersionUID = 6065153674892850720L;
        private final String hintString;
        private final TraceRecord next;
        private final int pos;

        /* synthetic */ TraceRecord(a aVar) {
            this();
        }

        TraceRecord(TraceRecord traceRecord, Object obj) {
            this.hintString = obj instanceof ResourceLeakHint ? ((ResourceLeakHint) obj).toHintString() : obj.toString();
            this.next = traceRecord;
            this.pos = traceRecord.pos + 1;
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder sb2 = new StringBuilder(2048);
            if (this.hintString != null) {
                sb2.append("\tHint: ");
                sb2.append(this.hintString);
                sb2.append(StringUtil.NEWLINE);
            }
            StackTraceElement[] stackTrace = getStackTrace();
            for (int i10 = 3; i10 < stackTrace.length; i10++) {
                StackTraceElement stackTraceElement = stackTrace[i10];
                String[] strArr = (String[]) ResourceLeakDetector.excludedMethods.get();
                int i11 = 0;
                while (true) {
                    if (i11 >= strArr.length) {
                        sb2.append('\t');
                        sb2.append(stackTraceElement.toString());
                        sb2.append(StringUtil.NEWLINE);
                        break;
                    }
                    if (strArr[i11].equals(stackTraceElement.getClassName()) && strArr[i11 + 1].equals(stackTraceElement.getMethodName())) {
                        break;
                    }
                    i11 += 2;
                }
            }
            return sb2.toString();
        }

        TraceRecord(TraceRecord traceRecord) {
            this.hintString = null;
            this.next = traceRecord;
            this.pos = traceRecord.pos + 1;
        }

        private TraceRecord() {
            this.hintString = null;
            this.next = null;
            this.pos = -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    @Deprecated
    public ResourceLeakDetector(Class<?> cls, int i10, long j10) {
        this(cls, i10);
    }

    protected Object getInitialHint(String str) {
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Level {
        DISABLED,
        SIMPLE,
        ADVANCED,
        PARANOID;

        static Level parseLevel(String str) {
            String strTrim = str.trim();
            for (Level level : values()) {
                if (strTrim.equalsIgnoreCase(level.name()) || strTrim.equals(String.valueOf(level.ordinal()))) {
                    return level;
                }
            }
            return ResourceLeakDetector.DEFAULT_LEVEL;
        }
    }

    static {
        Level level2 = Level.SIMPLE;
        DEFAULT_LEVEL = level2;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) ResourceLeakDetector.class);
        logger = internalLoggerFactory;
        boolean z10 = false;
        if (SystemPropertyUtil.get("io.netty.noResourceLeakDetection") != null) {
            z10 = SystemPropertyUtil.getBoolean("io.netty.noResourceLeakDetection", false);
            internalLoggerFactory.debug("-Dio.netty.noResourceLeakDetection: {}", Boolean.valueOf(z10));
            internalLoggerFactory.warn("-Dio.netty.noResourceLeakDetection is deprecated. Use '-D{}={}' instead.", "io.netty.leakDetection.level", level2.name().toLowerCase());
        }
        if (z10) {
            level2 = Level.DISABLED;
        }
        Level level3 = Level.parseLevel(SystemPropertyUtil.get("io.netty.leakDetection.level", SystemPropertyUtil.get("io.netty.leakDetectionLevel", level2.name())));
        int i10 = SystemPropertyUtil.getInt("io.netty.leakDetection.targetRecords", 4);
        TARGET_RECORDS = i10;
        SAMPLING_INTERVAL = SystemPropertyUtil.getInt("io.netty.leakDetection.samplingInterval", 128);
        level = level3;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", "io.netty.leakDetection.level", level3.name().toLowerCase());
            internalLoggerFactory.debug("-D{}: {}", "io.netty.leakDetection.targetRecords", Integer.valueOf(i10));
        }
        excludedMethods = new AtomicReference<>(EmptyArrays.EMPTY_STRINGS);
    }

    public ResourceLeakDetector(Class<?> cls, int i10) {
        this(StringUtil.simpleClassName(cls), i10, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public static void addExclusions(Class cls, String... strArr) {
        String[] strArr2;
        String[] strArr3;
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        for (int i10 = 0; i10 < length && (!hashSet.remove(declaredMethods[i10].getName()) || !hashSet.isEmpty()); i10++) {
        }
        if (!hashSet.isEmpty()) {
            throw new IllegalArgumentException("Can't find '" + hashSet + "' in " + cls.getName());
        }
        do {
            strArr2 = excludedMethods.get();
            strArr3 = (String[]) Arrays.copyOf(strArr2, strArr2.length + (strArr.length * 2));
            for (int i11 = 0; i11 < strArr.length; i11++) {
                int i12 = i11 * 2;
                strArr3[strArr2.length + i12] = cls.getName();
                strArr3[strArr2.length + i12 + 1] = strArr[i11];
            }
        } while (!h.a(excludedMethods, strArr2, strArr3));
    }

    private void clearRefQueue() {
        while (true) {
            DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
            if (defaultResourceLeak == null) {
                return;
            } else {
                defaultResourceLeak.dispose();
            }
        }
    }

    public static Level getLevel() {
        return level;
    }

    private DefaultResourceLeak track0(T t10) {
        Level level2 = level;
        if (level2 == Level.DISABLED) {
            return null;
        }
        if (level2.ordinal() >= Level.PARANOID.ordinal()) {
            reportLeak();
            return new DefaultResourceLeak(t10, this.refQueue, this.allLeaks, getInitialHint(this.resourceType));
        }
        if (PlatformDependent.threadLocalRandom().nextInt(this.samplingInterval) != 0) {
            return null;
        }
        reportLeak();
        return new DefaultResourceLeak(t10, this.refQueue, this.allLeaks, getInitialHint(this.resourceType));
    }

    protected boolean needReport() {
        return logger.isErrorEnabled();
    }

    protected void reportTracedLeak(String str, String str2) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. See https://netty.io/wiki/reference-counted-objects.html for more information.{}", str, str2);
    }

    protected void reportUntracedLeak(String str) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option '-D{}={}' or call {}.setLevel() See https://netty.io/wiki/reference-counted-objects.html for more information.", str, "io.netty.leakDetection.level", Level.ADVANCED.name().toLowerCase(), StringUtil.simpleClassName(this));
    }

    @Deprecated
    public ResourceLeakDetector(String str, int i10, long j10) {
        this.allLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.refQueue = new ReferenceQueue<>();
        this.reportedLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.resourceType = (String) ObjectUtil.checkNotNull(str, "resourceType");
        this.samplingInterval = i10;
    }

    public static boolean isEnabled() {
        if (getLevel().ordinal() > Level.DISABLED.ordinal()) {
            return true;
        }
        return false;
    }

    private void reportLeak() {
        if (!needReport()) {
            clearRefQueue();
            return;
        }
        while (true) {
            DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
            if (defaultResourceLeak == null) {
                return;
            }
            if (defaultResourceLeak.dispose()) {
                String reportAndClearRecords = defaultResourceLeak.getReportAndClearRecords();
                if (this.reportedLeaks.add(reportAndClearRecords)) {
                    if (reportAndClearRecords.isEmpty()) {
                        reportUntracedLeak(this.resourceType);
                    } else {
                        reportTracedLeak(this.resourceType, reportAndClearRecords);
                    }
                }
            }
        }
    }

    public final ResourceLeakTracker<T> track(T t10) {
        return track0(t10);
    }
}
