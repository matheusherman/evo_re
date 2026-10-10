package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class InternalThreadLocalMap extends UnpaddedInternalThreadLocalMap {
    private static final int STRING_BUILDER_INITIAL_SIZE;
    private static final int STRING_BUILDER_MAX_SIZE;
    public static final Object UNSET;
    private static final InternalLogger logger;
    private static final AtomicInteger nextIndex;
    private static final ThreadLocal<InternalThreadLocalMap> slowThreadLocalMap;
    private Map<Charset, CharsetEncoder> charsetEncoderCache;
    private int futureListenerStackDepth;
    private Map<Class<?>, Boolean> handlerSharableCache;
    private Object[] indexedVariables = newIndexedVariableTable();
    private ThreadLocalRandom random;
    private StringBuilder stringBuilder;
    private Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache;
    private Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) InternalThreadLocalMap.class);
        logger = internalLoggerFactory;
        slowThreadLocalMap = new ThreadLocal<>();
        nextIndex = new AtomicInteger();
        UNSET = new Object();
        int i10 = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.initialSize", 1024);
        STRING_BUILDER_INITIAL_SIZE = i10;
        internalLoggerFactory.debug("-Dio.netty.threadLocalMap.stringBuilder.initialSize: {}", Integer.valueOf(i10));
        int i11 = SystemPropertyUtil.getInt("io.netty.threadLocalMap.stringBuilder.maxSize", 4096);
        STRING_BUILDER_MAX_SIZE = i11;
        internalLoggerFactory.debug("-Dio.netty.threadLocalMap.stringBuilder.maxSize: {}", Integer.valueOf(i11));
    }

    private void expandIndexedVariableTableAndSet(int i10, Object obj) {
        int i11;
        Object[] objArr = this.indexedVariables;
        int length = objArr.length;
        if (i10 < 1073741824) {
            int i12 = (i10 >>> 1) | i10;
            int i13 = i12 | (i12 >>> 2);
            int i14 = i13 | (i13 >>> 4);
            int i15 = i14 | (i14 >>> 8);
            i11 = (i15 | (i15 >>> 16)) + 1;
        } else {
            i11 = 2147483639;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, i11);
        Arrays.fill(objArrCopyOf, length, objArrCopyOf.length, UNSET);
        objArrCopyOf[i10] = obj;
        this.indexedVariables = objArrCopyOf;
    }

    private static Object[] newIndexedVariableTable() {
        Object[] objArr = new Object[32];
        Arrays.fill(objArr, UNSET);
        return objArr;
    }

    public static int nextVariableIndex() {
        AtomicInteger atomicInteger = nextIndex;
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement < 2147483639 && andIncrement >= 0) {
            return andIncrement;
        }
        atomicInteger.set(2147483639);
        throw new IllegalStateException("too many thread-local indexed variables");
    }

    private static InternalThreadLocalMap slowGet() {
        ThreadLocal<InternalThreadLocalMap> threadLocal = slowThreadLocalMap;
        InternalThreadLocalMap internalThreadLocalMap = threadLocal.get();
        if (internalThreadLocalMap != null) {
            return internalThreadLocalMap;
        }
        InternalThreadLocalMap internalThreadLocalMap2 = new InternalThreadLocalMap();
        threadLocal.set(internalThreadLocalMap2);
        return internalThreadLocalMap2;
    }

    public Map<Charset, CharsetEncoder> charsetEncoderCache() {
        Map<Charset, CharsetEncoder> map = this.charsetEncoderCache;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.charsetEncoderCache = identityHashMap;
        return identityHashMap;
    }

    public int futureListenerStackDepth() {
        return this.futureListenerStackDepth;
    }

    public Map<Class<?>, Boolean> handlerSharableCache() {
        Map<Class<?>, Boolean> map = this.handlerSharableCache;
        if (map != null) {
            return map;
        }
        WeakHashMap weakHashMap = new WeakHashMap(4);
        this.handlerSharableCache = weakHashMap;
        return weakHashMap;
    }

    public Object indexedVariable(int i10) {
        Object[] objArr = this.indexedVariables;
        return i10 < objArr.length ? objArr[i10] : UNSET;
    }

    public ThreadLocalRandom random() {
        ThreadLocalRandom threadLocalRandom = this.random;
        if (threadLocalRandom != null) {
            return threadLocalRandom;
        }
        ThreadLocalRandom threadLocalRandom2 = new ThreadLocalRandom();
        this.random = threadLocalRandom2;
        return threadLocalRandom2;
    }

    public Object removeIndexedVariable(int i10) {
        Object[] objArr = this.indexedVariables;
        if (i10 >= objArr.length) {
            return UNSET;
        }
        Object obj = objArr[i10];
        objArr[i10] = UNSET;
        return obj;
    }

    public void setFutureListenerStackDepth(int i10) {
        this.futureListenerStackDepth = i10;
    }

    public boolean setIndexedVariable(int i10, Object obj) {
        Object[] objArr = this.indexedVariables;
        if (i10 >= objArr.length) {
            expandIndexedVariableTableAndSet(i10, obj);
            return true;
        }
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2 == UNSET;
    }

    public StringBuilder stringBuilder() {
        StringBuilder sb2 = this.stringBuilder;
        if (sb2 == null) {
            StringBuilder sb3 = new StringBuilder(STRING_BUILDER_INITIAL_SIZE);
            this.stringBuilder = sb3;
            return sb3;
        }
        if (sb2.capacity() > STRING_BUILDER_MAX_SIZE) {
            sb2.setLength(STRING_BUILDER_INITIAL_SIZE);
            sb2.trimToSize();
        }
        sb2.setLength(0);
        return sb2;
    }

    public Map<Class<?>, Map<String, TypeParameterMatcher>> typeParameterMatcherFindCache() {
        Map<Class<?>, Map<String, TypeParameterMatcher>> map = this.typeParameterMatcherFindCache;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.typeParameterMatcherFindCache = identityHashMap;
        return identityHashMap;
    }

    public Map<Class<?>, TypeParameterMatcher> typeParameterMatcherGetCache() {
        Map<Class<?>, TypeParameterMatcher> map = this.typeParameterMatcherGetCache;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.typeParameterMatcherGetCache = identityHashMap;
        return identityHashMap;
    }

    private InternalThreadLocalMap() {
    }

    private static InternalThreadLocalMap fastGet(FastThreadLocalThread fastThreadLocalThread) {
        InternalThreadLocalMap internalThreadLocalMapThreadLocalMap = fastThreadLocalThread.threadLocalMap();
        if (internalThreadLocalMapThreadLocalMap == null) {
            InternalThreadLocalMap internalThreadLocalMap = new InternalThreadLocalMap();
            fastThreadLocalThread.setThreadLocalMap(internalThreadLocalMap);
            return internalThreadLocalMap;
        }
        return internalThreadLocalMapThreadLocalMap;
    }

    public static InternalThreadLocalMap get() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof FastThreadLocalThread) {
            return fastGet((FastThreadLocalThread) threadCurrentThread);
        }
        return slowGet();
    }

    public static InternalThreadLocalMap getIfSet() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof FastThreadLocalThread) {
            return ((FastThreadLocalThread) threadCurrentThread).threadLocalMap();
        }
        return slowThreadLocalMap.get();
    }

    public static void remove() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof FastThreadLocalThread) {
            ((FastThreadLocalThread) threadCurrentThread).setThreadLocalMap(null);
        } else {
            slowThreadLocalMap.remove();
        }
    }
}
