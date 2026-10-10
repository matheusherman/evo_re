package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class j0<K, V> extends q<K, V> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final q<Object, Object> f4619h = new j0(null, new Object[0], 0);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final transient Object f4620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient Object[] f4621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient int f4622g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a<K, V> extends s<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient q<K, V> f4623c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient Object[] f4624d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final transient int f4625e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final transient int f4626f;

        /* JADX INFO: renamed from: com.google.common.collect.j0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0049a extends p<Map.Entry<K, V>> {
            @Override // com.google.common.collect.o
            public boolean k() {
                return true;
            }

            C0049a() {
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> get(int i10) {
                com.google.common.base.m.g(i10, a.this.f4626f);
                int i11 = i10 * 2;
                Object obj = a.this.f4624d[a.this.f4625e + i11];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f4624d[i11 + (a.this.f4625e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f4626f;
            }

            @Override // com.google.common.collect.p, com.google.common.collect.o
            Object writeReplace() {
                return super.writeReplace();
            }
        }

        @Override // com.google.common.collect.o
        boolean k() {
            return true;
        }

        @Override // com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value != null && value.equals(this.f4623c.get(key))) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4626f;
        }

        @Override // com.google.common.collect.s
        p<Map.Entry<K, V>> u() {
            return new C0049a();
        }

        a(q<K, V> qVar, Object[] objArr, int i10, int i11) {
            this.f4623c = qVar;
            this.f4624d = objArr;
            this.f4625e = i10;
            this.f4626f = i11;
        }

        @Override // com.google.common.collect.o
        int f(Object[] objArr, int i10) {
            return e().f(objArr, i10);
        }

        @Override // com.google.common.collect.s, com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: m */
        public s0<Map.Entry<K, V>> iterator() {
            return e().iterator();
        }

        @Override // com.google.common.collect.s, com.google.common.collect.o
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b<K> extends s<K> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient q<K, ?> f4627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient p<K> f4628d;

        @Override // com.google.common.collect.o
        boolean k() {
            return true;
        }

        @Override // com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f4627c.get(obj) != null;
        }

        @Override // com.google.common.collect.s, com.google.common.collect.o
        public p<K> e() {
            return this.f4628d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4627c.size();
        }

        b(q<K, ?> qVar, p<K> pVar) {
            this.f4627c = qVar;
            this.f4628d = pVar;
        }

        @Override // com.google.common.collect.o
        int f(Object[] objArr, int i10) {
            return e().f(objArr, i10);
        }

        @Override // com.google.common.collect.s, com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: m */
        public s0<K> iterator() {
            return e().iterator();
        }

        @Override // com.google.common.collect.s, com.google.common.collect.o
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends p<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient Object[] f4629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient int f4630d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final transient int f4631e;

        @Override // com.google.common.collect.o
        boolean k() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i10) {
            com.google.common.base.m.g(i10, this.f4631e);
            Object obj = this.f4629c[(i10 * 2) + this.f4630d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4631e;
        }

        c(Object[] objArr, int i10, int i11) {
            this.f4629c = objArr;
            this.f4630d = i10;
            this.f4631e = i11;
        }

        @Override // com.google.common.collect.p, com.google.common.collect.o
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    static <K, V> j0<K, V> n(int i10, Object[] objArr) {
        return o(i10, objArr, null);
    }

    static Object q(Object obj, Object[] objArr, int i10, int i11, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i10 == 1) {
            Object obj3 = objArr[i11];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i11 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iB = n.b(obj2.hashCode());
            while (true) {
                int i12 = iB & length;
                int i13 = bArr[i12] & 255;
                if (i13 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i13])) {
                    return objArr[i13 ^ 1];
                }
                iB = i12 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iB2 = n.b(obj2.hashCode());
            while (true) {
                int i14 = iB2 & length2;
                int i15 = sArr[i14] & 65535;
                if (i15 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i15])) {
                    return objArr[i15 ^ 1];
                }
                iB2 = i14 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iB3 = n.b(obj2.hashCode());
            while (true) {
                int i16 = iB3 & length3;
                int i17 = iArr[i16];
                if (i17 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i17])) {
                    return objArr[i17 ^ 1];
                }
                iB3 = i16 + 1;
            }
        }
    }

    static <K, V> j0<K, V> o(int i10, Object[] objArr, q.a<K, V> aVar) {
        if (i10 == 0) {
            return (j0) f4619h;
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            g.a(obj, obj2);
            return new j0<>(null, objArr, 1);
        }
        com.google.common.base.m.k(i10, objArr.length >> 1);
        Object objP = p(objArr, i10, s.q(i10), 0);
        if (objP instanceof Object[]) {
            Object[] objArr2 = (Object[]) objP;
            q.a.C0051a c0051a = (q.a.C0051a) objArr2[2];
            if (aVar == null) {
                throw c0051a.a();
            }
            aVar.f4670e = c0051a;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objP = obj3;
            i10 = iIntValue;
        }
        return new j0<>(objP, objArr, i10);
    }

    private static Object p(Object[] objArr, int i10, int i11, int i12) {
        q.a.C0051a c0051a = null;
        int i13 = 1;
        if (i10 == 1) {
            Object obj = objArr[i12];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i12 ^ 1];
            Objects.requireNonNull(obj2);
            g.a(obj, obj2);
            return null;
        }
        int i14 = i11 - 1;
        if (i11 <= 128) {
            byte[] bArr = new byte[i11];
            Arrays.fill(bArr, (byte) -1);
            int i15 = 0;
            for (int i16 = 0; i16 < i10; i16++) {
                int i17 = (i16 * 2) + i12;
                int i18 = (i15 * 2) + i12;
                Object obj3 = objArr[i17];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i17 ^ 1];
                Objects.requireNonNull(obj4);
                g.a(obj3, obj4);
                int iB = n.b(obj3.hashCode());
                while (true) {
                    int i19 = iB & i14;
                    int i20 = bArr[i19] & 255;
                    if (i20 == 255) {
                        bArr[i19] = (byte) i18;
                        if (i15 < i16) {
                            objArr[i18] = obj3;
                            objArr[i18 ^ 1] = obj4;
                        }
                        i15++;
                        break;
                    }
                    if (obj3.equals(objArr[i20])) {
                        int i21 = i20 ^ 1;
                        Object obj5 = objArr[i21];
                        Objects.requireNonNull(obj5);
                        c0051a = new q.a.C0051a(obj3, obj4, obj5);
                        objArr[i21] = obj4;
                        break;
                    }
                    iB = i19 + 1;
                }
            }
            return i15 == i10 ? bArr : new Object[]{bArr, Integer.valueOf(i15), c0051a};
        }
        if (i11 <= 32768) {
            short[] sArr = new short[i11];
            Arrays.fill(sArr, (short) -1);
            int i22 = 0;
            for (int i23 = 0; i23 < i10; i23++) {
                int i24 = (i23 * 2) + i12;
                int i25 = (i22 * 2) + i12;
                Object obj6 = objArr[i24];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i24 ^ 1];
                Objects.requireNonNull(obj7);
                g.a(obj6, obj7);
                int iB2 = n.b(obj6.hashCode());
                while (true) {
                    int i26 = iB2 & i14;
                    int i27 = sArr[i26] & 65535;
                    if (i27 == 65535) {
                        sArr[i26] = (short) i25;
                        if (i22 < i23) {
                            objArr[i25] = obj6;
                            objArr[i25 ^ 1] = obj7;
                        }
                        i22++;
                        break;
                    }
                    if (obj6.equals(objArr[i27])) {
                        int i28 = i27 ^ 1;
                        Object obj8 = objArr[i28];
                        Objects.requireNonNull(obj8);
                        c0051a = new q.a.C0051a(obj6, obj7, obj8);
                        objArr[i28] = obj7;
                        break;
                    }
                    iB2 = i26 + 1;
                }
            }
            return i22 == i10 ? sArr : new Object[]{sArr, Integer.valueOf(i22), c0051a};
        }
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        int i29 = 0;
        int i30 = 0;
        while (i29 < i10) {
            int i31 = (i29 * 2) + i12;
            int i32 = (i30 * 2) + i12;
            Object obj9 = objArr[i31];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i31 ^ i13];
            Objects.requireNonNull(obj10);
            g.a(obj9, obj10);
            int iB3 = n.b(obj9.hashCode());
            while (true) {
                int i33 = iB3 & i14;
                int i34 = iArr[i33];
                if (i34 == -1) {
                    iArr[i33] = i32;
                    if (i30 < i29) {
                        objArr[i32] = obj9;
                        objArr[i32 ^ 1] = obj10;
                    }
                    i30++;
                    break;
                }
                if (obj9.equals(objArr[i34])) {
                    int i35 = i34 ^ 1;
                    Object obj11 = objArr[i35];
                    Objects.requireNonNull(obj11);
                    c0051a = new q.a.C0051a(obj9, obj10, obj11);
                    objArr[i35] = obj10;
                    break;
                }
                iB3 = i33 + 1;
            }
            i29++;
            i13 = 1;
        }
        return i30 == i10 ? iArr : new Object[]{iArr, Integer.valueOf(i30), c0051a};
    }

    @Override // com.google.common.collect.q
    s<Map.Entry<K, V>> c() {
        return new a(this, this.f4621f, 0, this.f4622g);
    }

    @Override // com.google.common.collect.q
    s<K> d() {
        return new b(this, new c(this.f4621f, 0, this.f4622g));
    }

    @Override // com.google.common.collect.q
    o<V> e() {
        return new c(this.f4621f, 1, this.f4622g);
    }

    @Override // com.google.common.collect.q, java.util.Map
    public V get(Object obj) {
        V v10 = (V) q(this.f4620e, this.f4621f, this.f4622g, 0, obj);
        if (v10 == null) {
            return null;
        }
        return v10;
    }

    @Override // java.util.Map
    public int size() {
        return this.f4622g;
    }

    private j0(Object obj, Object[] objArr, int i10) {
        this.f4620e = obj;
        this.f4621f = objArr;
        this.f4622g = i10;
    }

    @Override // com.google.common.collect.q
    Object writeReplace() {
        return super.writeReplace();
    }
}
