package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class xc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Unsafe f3230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f3231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f3232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f3233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final b f3234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f3235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f3236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f3237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final boolean f3238i;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a extends b {
        @Override // com.google.android.gms.internal.measurement.xc.b
        public final void b(Object obj, long j10, byte b10) {
            if (xc.f3238i) {
                xc.u(obj, j10, b10);
            } else {
                xc.y(obj, j10, b10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final void g(Object obj, long j10, boolean z10) {
            if (xc.f3238i) {
                xc.k(obj, j10, z10);
            } else {
                xc.r(obj, j10, z10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final boolean k(Object obj, long j10) {
            return xc.f3238i ? xc.D(obj, j10) : xc.E(obj, j10);
        }

        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final double a(Object obj, long j10) {
            return Double.longBitsToDouble(m(obj, j10));
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final void c(Object obj, long j10, double d10) {
            f(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final void d(Object obj, long j10, float f10) {
            e(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final float i(Object obj, long j10) {
            return Float.intBitsToFloat(l(obj, j10));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Unsafe f3239a;

        public abstract double a(Object obj, long j10);

        public abstract void b(Object obj, long j10, byte b10);

        public abstract void c(Object obj, long j10, double d10);

        public abstract void d(Object obj, long j10, float f10);

        public abstract void g(Object obj, long j10, boolean z10);

        public abstract float i(Object obj, long j10);

        public abstract boolean k(Object obj, long j10);

        public final void e(Object obj, long j10, int i10) {
            this.f3239a.putInt(obj, j10, i10);
        }

        public final void f(Object obj, long j10, long j11) {
            this.f3239a.putLong(obj, j10, j11);
        }

        public final boolean h() {
            Unsafe unsafe = this.f3239a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                xc.l(th);
                return false;
            }
        }

        public final boolean j() {
            Unsafe unsafe = this.f3239a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return xc.C() != null;
            } catch (Throwable th) {
                xc.l(th);
                return false;
            }
        }

        public final int l(Object obj, long j10) {
            return this.f3239a.getInt(obj, j10);
        }

        public final long m(Object obj, long j10) {
            return this.f3239a.getLong(obj, j10);
        }

        b(Unsafe unsafe) {
            this.f3239a = unsafe;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c extends b {
        @Override // com.google.android.gms.internal.measurement.xc.b
        public final void b(Object obj, long j10, byte b10) {
            if (xc.f3238i) {
                xc.u(obj, j10, b10);
            } else {
                xc.y(obj, j10, b10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final void g(Object obj, long j10, boolean z10) {
            if (xc.f3238i) {
                xc.k(obj, j10, z10);
            } else {
                xc.r(obj, j10, z10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final boolean k(Object obj, long j10) {
            return xc.f3238i ? xc.D(obj, j10) : xc.E(obj, j10);
        }

        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final double a(Object obj, long j10) {
            return Double.longBitsToDouble(m(obj, j10));
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final void c(Object obj, long j10, double d10) {
            f(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final void d(Object obj, long j10, float f10) {
            e(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.android.gms.internal.measurement.xc.b
        public final float i(Object obj, long j10) {
            return Float.intBitsToFloat(l(obj, j10));
        }
    }

    static /* synthetic */ void k(Object obj, long j10, boolean z10) {
        u(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    static /* synthetic */ void r(Object obj, long j10, boolean z10) {
        y(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    private static boolean A(Class<?> cls) {
        try {
            Class<?> cls2 = f3231b;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static Object B(Object obj, long j10) {
        return f3234e.f3239a.getObject(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field C() {
        Field fieldD = d(Buffer.class, "effectiveDirectAddress");
        if (fieldD != null) {
            return fieldD;
        }
        Field fieldD2 = d(Buffer.class, "address");
        if (fieldD2 == null || fieldD2.getType() != Long.TYPE) {
            return null;
        }
        return fieldD2;
    }

    static /* synthetic */ boolean D(Object obj, long j10) {
        return ((byte) (t(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3)))) != 0;
    }

    static /* synthetic */ boolean E(Object obj, long j10) {
        return ((byte) (t(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3)))) != 0;
    }

    static boolean F(Object obj, long j10) {
        return f3234e.k(obj, j10);
    }

    static double a(Object obj, long j10) {
        return f3234e.a(obj, j10);
    }

    static <T> T b(Class<T> cls) {
        try {
            return (T) f3230a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    static void f(Object obj, long j10, double d10) {
        f3234e.c(obj, j10, d10);
    }

    static void g(Object obj, long j10, float f10) {
        f3234e.d(obj, j10, f10);
    }

    static void h(Object obj, long j10, int i10) {
        f3234e.e(obj, j10, i10);
    }

    static void i(Object obj, long j10, long j11) {
        f3234e.f(obj, j10, j11);
    }

    static void j(Object obj, long j10, Object obj2) {
        f3234e.f3239a.putObject(obj, j10, obj2);
    }

    static /* synthetic */ void l(Throwable th) {
        Logger.getLogger(xc.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + String.valueOf(th));
    }

    static void m(byte[] bArr, long j10, byte b10) {
        f3234e.b(bArr, f3237h + j10, b10);
    }

    static float n(Object obj, long j10) {
        return f3234e.i(obj, j10);
    }

    private static int o(Class<?> cls) {
        if (f3236g) {
            return f3234e.f3239a.arrayBaseOffset(cls);
        }
        return -1;
    }

    static Unsafe p() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zc());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int s(Class<?> cls) {
        if (f3236g) {
            return f3234e.f3239a.arrayIndexScale(cls);
        }
        return -1;
    }

    static int t(Object obj, long j10) {
        return f3234e.l(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int iT = t(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        h(obj, j11, ((255 & b10) << i10) | (iT & (~(255 << i10))));
    }

    static void v(Object obj, long j10, boolean z10) {
        f3234e.g(obj, j10, z10);
    }

    static boolean w() {
        return f3236g;
    }

    static long x(Object obj, long j10) {
        return f3234e.m(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        h(obj, j11, ((255 & b10) << i10) | (t(obj, j11) & (~(255 << i10))));
    }

    static boolean z() {
        return f3235f;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002e  */
    static {
        b aVar;
        boolean zJ;
        boolean zH;
        Unsafe unsafeP = p();
        f3230a = unsafeP;
        f3231b = s8.a();
        boolean zA = A(Long.TYPE);
        f3232c = zA;
        boolean zA2 = A(Integer.TYPE);
        f3233d = zA2;
        if (unsafeP != null) {
            if (zA) {
                aVar = new c(unsafeP);
            } else if (zA2) {
                aVar = new a(unsafeP);
            } else {
                aVar = null;
            }
        } else {
            aVar = null;
        }
        f3234e = aVar;
        boolean z10 = false;
        if (aVar == null) {
            zJ = false;
        } else {
            zJ = aVar.j();
        }
        f3235f = zJ;
        if (aVar == null) {
            zH = false;
        } else {
            zH = aVar.h();
        }
        f3236g = zH;
        f3237h = o(byte[].class);
        o(boolean[].class);
        s(boolean[].class);
        o(int[].class);
        s(int[].class);
        o(long[].class);
        s(long[].class);
        o(float[].class);
        s(float[].class);
        o(double[].class);
        s(double[].class);
        o(Object[].class);
        s(Object[].class);
        Field fieldC = C();
        if (fieldC != null && aVar != null) {
            aVar.f3239a.objectFieldOffset(fieldC);
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z10 = true;
        }
        f3238i = z10;
    }

    private xc() {
    }

    private static Field d(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
