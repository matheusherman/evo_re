package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.ea;
import com.google.android.gms.internal.measurement.ea.b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class ea<MessageType extends ea<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends n8<MessageType, BuilderType> {
    private static Map<Class<?>, ea<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected uc zzb = uc.k();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class b<MessageType extends ea<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends o8<MessageType, BuilderType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MessageType f2632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected MessageType f2633b;

        @Override // com.google.android.gms.internal.measurement.o8
        public final /* synthetic */ o8 j(byte[] bArr, int i10, int i11) {
            return u(bArr, 0, i11, q9.f2964c);
        }

        @Override // com.google.android.gms.internal.measurement.o8
        public final /* synthetic */ o8 k(byte[] bArr, int i10, int i11, q9 q9Var) {
            return u(bArr, 0, i11, q9Var);
        }

        private final BuilderType u(byte[] bArr, int i10, int i11, q9 q9Var) throws ma {
            if (!this.f2633b.J()) {
                t();
            }
            try {
                cc.a().c(this.f2633b).h(this.f2633b, bArr, 0, i11, new u8(q9Var));
                return this;
            } catch (ma e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e11);
            } catch (IndexOutOfBoundsException unused) {
                throw ma.g();
            }
        }

        @Override // com.google.android.gms.internal.measurement.o8
        public /* synthetic */ Object clone() {
            b bVar = (b) this.f2632a.s(e.f2638e, null, null);
            bVar.f2633b = (MessageType) B();
            return bVar;
        }

        @Override // com.google.android.gms.internal.measurement.qb
        public final boolean i() {
            return ea.x(this.f2633b, false);
        }

        public final BuilderType n(MessageType messagetype) {
            if (this.f2632a.equals(messagetype)) {
                return this;
            }
            if (!this.f2633b.J()) {
                t();
            }
            o(this.f2633b, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.measurement.nb
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public MessageType B() {
            if (!this.f2633b.J()) {
                return this.f2633b;
            }
            this.f2633b.H();
            return this.f2633b;
        }

        protected final void s() {
            if (this.f2633b.J()) {
                return;
            }
            t();
        }

        protected void t() {
            MessageType messagetype = (MessageType) this.f2632a.D();
            o(messagetype, this.f2633b);
            this.f2633b = messagetype;
        }

        protected b(MessageType messagetype) {
            this.f2632a = messagetype;
            if (!messagetype.J()) {
                this.f2633b = (MessageType) messagetype.D();
                return;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private static <MessageType> void o(MessageType messagetype, MessageType messagetype2) {
            cc.a().c(messagetype).f(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.measurement.nb
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public final MessageType w() {
            MessageType messagetype = (MessageType) B();
            if (messagetype.i()) {
                return messagetype;
            }
            throw new sc(messagetype);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c implements z9<c> {
        @Override // com.google.android.gms.internal.measurement.z9
        public final nb I(nb nbVar, ob obVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.z9
        public final sb K(sb sbVar, sb sbVar2) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.z9
        public final int b() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.z9
        public final ed c() {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.z9
        public final ld d() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.z9
        public final boolean e() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.z9
        public final boolean g() {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends ea<MessageType, BuilderType> implements qb {
        protected x9<c> zzc = x9.i();

        final x9<c> K() {
            if (this.zzc.r()) {
                this.zzc = (x9) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final enum e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f2634a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f2635b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f2636c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f2637d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f2638e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f2639f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f2640g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ int[] f2641h = {1, 2, 3, 4, 5, 6, 7};

        public static int[] a() {
            return (int[]) f2641h.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class f<ContainingType extends ob, Type> extends r9<ContainingType, Type> {
    }

    static /* synthetic */ boolean x(ea eaVar, boolean z10) {
        return z(eaVar, false);
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final int e() {
        return f(null);
    }

    @Override // com.google.android.gms.internal.measurement.qb
    public final boolean i() {
        return z(this, true);
    }

    protected abstract Object s(int i10, Object obj, Object obj2);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    protected static class a<T extends ea<T, ?>> extends q8<T> {
        public a(T t10) {
        }
    }

    static <T extends ea<?, ?>> T p(Class<T> cls) {
        T t10 = (T) zzc.get(cls);
        if (t10 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t10 = (T) zzc.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) ((ea) xc.b(cls)).s(e.f2639f, null, null);
        if (t11 == null) {
            throw new IllegalStateException();
        }
        zzc.put((Class<?>) cls, t11);
        return t11;
    }

    protected static Object t(ob obVar, String str, Object[] objArr) {
        return new dc(obVar, str, objArr);
    }

    private final int y(fc<?> fcVar) {
        return fcVar == null ? cc.a().c(this).a(this) : fcVar.a(this);
    }

    private static final <T extends ea<T, ?>> boolean z(T t10, boolean z10) {
        byte bByteValue = ((Byte) t10.s(e.f2634a, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = cc.a().c(t10).c(t10);
        if (z10) {
            t10.s(e.f2635b, zC ? t10 : null, null);
        }
        return zC;
    }

    protected final <MessageType extends ea<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType A() {
        return (BuilderType) s(e.f2638e, null, null);
    }

    public final BuilderType C() {
        return (BuilderType) ((b) s(e.f2638e, null, null)).n(this);
    }

    final MessageType D() {
        return (MessageType) s(e.f2637d, null, null);
    }

    final void I() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final boolean J() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final /* synthetic */ nb c() {
        return ((b) s(e.f2638e, null, null)).n(this);
    }

    @Override // com.google.android.gms.internal.measurement.qb
    public final /* synthetic */ ob d() {
        return (ea) s(e.f2639f, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return cc.a().c(this).i(this, (ea) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final /* synthetic */ nb g() {
        return (b) s(e.f2638e, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.n8
    final void k(int i10) {
        if (i10 >= 0) {
            this.zzd = (i10 & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.n8
    final int l() {
        return this.zzd & Integer.MAX_VALUE;
    }

    protected static la E() {
        return ha.g();
    }

    protected static ka F() {
        return za.g();
    }

    protected static <E> na<E> G() {
        return bc.h();
    }

    private final int n() {
        return cc.a().c(this).e(this);
    }

    protected static ka q(ka kaVar) {
        return kaVar.a(kaVar.size() << 1);
    }

    protected static <E> na<E> r(na<E> naVar) {
        return naVar.a(naVar.size() << 1);
    }

    static Object u(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    protected static <T extends ea<?, ?>> void v(Class<T> cls, T t10) {
        t10.I();
        zzc.put(cls, t10);
    }

    protected final void H() {
        cc.a().c(this).d(this);
        I();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final void a(m9 m9Var) {
        cc.a().c(this).g(this, p9.P(m9Var));
    }

    @Override // com.google.android.gms.internal.measurement.n8
    final int f(fc fcVar) {
        if (J()) {
            int iY = y(fcVar);
            if (iY >= 0) {
                return iY;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iY);
        }
        if (l() != Integer.MAX_VALUE) {
            return l();
        }
        int iY2 = y(fcVar);
        k(iY2);
        return iY2;
    }

    public int hashCode() {
        if (J()) {
            return n();
        }
        if (this.zza == 0) {
            this.zza = n();
        }
        return this.zza;
    }

    protected final <MessageType extends ea<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType o(MessageType messagetype) {
        return (BuilderType) A().n(messagetype);
    }

    public String toString() {
        return pb.a(this, super.toString());
    }
}
