package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f9090a = "GBK";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f9091b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f9092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9093b;
    }

    public k() {
    }

    private boolean b(int i10) {
        int i11;
        try {
            a aVar = new a();
            while (true) {
                int iA = a(aVar, this.f9091b.duplicate());
                i11 = aVar.f9093b;
                if (i10 <= i11 || aVar.f9092a == 11) {
                    break;
                    break;
                }
                a(iA);
                a(aVar.f9092a);
            }
            return i10 == i11;
        } catch (h | BufferUnderflowException unused) {
        }
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f9091b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f9091b = ByteBuffer.wrap(bArr);
    }

    public k(byte[] bArr) {
        this.f9091b = ByteBuffer.wrap(bArr);
    }

    private boolean[] d(int i10, boolean z10) {
        if (b(i10)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f9092a == 9) {
                int iA = a(0, 0, true);
                if (iA >= 0) {
                    boolean[] zArr = new boolean[iA];
                    for (int i11 = 0; i11 < iA; i11++) {
                        zArr[i11] = a(0, true);
                    }
                    return zArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(iA)));
            }
            throw new h("type mismatch.");
        }
        if (!z10) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private short[] e(int i10, boolean z10) {
        if (b(i10)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f9092a == 9) {
                int iA = a(0, 0, true);
                if (iA >= 0) {
                    short[] sArr = new short[iA];
                    for (int i11 = 0; i11 < iA; i11++) {
                        sArr[i11] = a(sArr[0], 0, true);
                    }
                    return sArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(iA)));
            }
            throw new h("type mismatch.");
        }
        if (!z10) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private int[] f(int i10, boolean z10) {
        if (b(i10)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f9092a == 9) {
                int iA = a(0, 0, true);
                if (iA >= 0) {
                    int[] iArr = new int[iA];
                    for (int i11 = 0; i11 < iA; i11++) {
                        iArr[i11] = a(iArr[0], 0, true);
                    }
                    return iArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(iA)));
            }
            throw new h("type mismatch.");
        }
        if (!z10) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private long[] g(int i10, boolean z10) {
        if (b(i10)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f9092a == 9) {
                int iA = a(0, 0, true);
                if (iA >= 0) {
                    long[] jArr = new long[iA];
                    for (int i11 = 0; i11 < iA; i11++) {
                        jArr[i11] = a(jArr[0], 0, true);
                    }
                    return jArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(iA)));
            }
            throw new h("type mismatch.");
        }
        if (!z10) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private float[] h(int i10, boolean z10) {
        if (b(i10)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f9092a == 9) {
                int iA = a(0, 0, true);
                if (iA >= 0) {
                    float[] fArr = new float[iA];
                    for (int i11 = 0; i11 < iA; i11++) {
                        fArr[i11] = a(fArr[0], 0, true);
                    }
                    return fArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(iA)));
            }
            throw new h("type mismatch.");
        }
        if (!z10) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private double[] i(int i10, boolean z10) {
        if (b(i10)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f9092a == 9) {
                int iA = a(0, 0, true);
                if (iA >= 0) {
                    double[] dArr = new double[iA];
                    for (int i11 = 0; i11 < iA; i11++) {
                        dArr[i11] = a(dArr[0], 0, true);
                    }
                    return dArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(iA)));
            }
            throw new h("type mismatch.");
        }
        if (!z10) {
            return null;
        }
        throw new h("require field not exist.");
    }

    public final byte[] c(int i10, boolean z10) {
        if (b(i10)) {
            a aVar = new a();
            a(aVar);
            byte b10 = aVar.f9092a;
            if (b10 != 9) {
                if (b10 == 13) {
                    a aVar2 = new a();
                    a(aVar2);
                    if (aVar2.f9092a == 0) {
                        int iA = a(0, 0, true);
                        if (iA >= 0) {
                            byte[] bArr = new byte[iA];
                            this.f9091b.get(bArr);
                            return bArr;
                        }
                        throw new h("invalid size, tag: " + i10 + ", type: " + ((int) aVar.f9092a) + ", " + ((int) aVar2.f9092a) + ", size: " + iA);
                    }
                    throw new h("type mismatch, tag: " + i10 + ", type: " + ((int) aVar.f9092a) + ", " + ((int) aVar2.f9092a));
                }
                throw new h("type mismatch.");
            }
            int iA2 = a(0, 0, true);
            if (iA2 >= 0) {
                byte[] bArr2 = new byte[iA2];
                for (int i11 = 0; i11 < iA2; i11++) {
                    bArr2[i11] = a(bArr2[0], 0, true);
                }
                return bArr2;
            }
            throw new h("size invalid: ".concat(String.valueOf(iA2)));
        }
        if (!z10) {
            return null;
        }
        throw new h("require field not exist.");
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b10 = byteBuffer.get();
        aVar.f9092a = (byte) (b10 & 15);
        int i10 = (b10 & 240) >> 4;
        aVar.f9093b = i10;
        if (i10 != 15) {
            return 1;
        }
        aVar.f9093b = byteBuffer.get();
        return 2;
    }

    public k(byte[] bArr, byte b10) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f9091b = byteBufferWrap;
        byteBufferWrap.position(4);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.f9092a);
    }

    private void a(a aVar) {
        a(aVar, this.f9091b);
    }

    private void a(int i10) {
        ByteBuffer byteBuffer = this.f9091b;
        byteBuffer.position(byteBuffer.position() + i10);
    }

    public final String b(int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f9092a;
        if (b10 == 6) {
            int i11 = this.f9091b.get();
            if (i11 < 0) {
                i11 += 256;
            }
            byte[] bArr = new byte[i11];
            this.f9091b.get(bArr);
            try {
                return new String(bArr, this.f9090a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b10 == 7) {
            int i12 = this.f9091b.getInt();
            if (i12 <= 104857600 && i12 >= 0) {
                byte[] bArr2 = new byte[i12];
                this.f9091b.get(bArr2);
                try {
                    return new String(bArr2, this.f9090a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new h("String too long: ".concat(String.valueOf(i12)));
        }
        throw new h("type mismatch.");
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.f9092a);
        } while (aVar.f9092a != 11);
    }

    private void a(byte b10) {
        int i10 = 0;
        switch (b10) {
            case 0:
                a(1);
                return;
            case 1:
                a(2);
                return;
            case 2:
                a(4);
                return;
            case 3:
                a(8);
                return;
            case 4:
                a(4);
                return;
            case 5:
                a(8);
                return;
            case 6:
                int i11 = this.f9091b.get();
                if (i11 < 0) {
                    i11 += 256;
                }
                a(i11);
                return;
            case 7:
                a(this.f9091b.getInt());
                return;
            case 8:
                int iA = a(0, 0, true);
                while (i10 < iA * 2) {
                    b();
                    i10++;
                }
                return;
            case 9:
                int iA2 = a(0, 0, true);
                while (i10 < iA2) {
                    b();
                    i10++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                a(aVar);
                if (aVar.f9092a == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new h("skipField with invalid type, type value: " + ((int) b10) + ", " + ((int) aVar.f9092a));
            default:
                throw new h("invalid type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t10, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f9092a == 9) {
            int iA = a(0, 0, true);
            if (iA >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t10.getClass(), iA));
                for (int i11 = 0; i11 < iA; i11++) {
                    tArr[i11] = a((Object) t10, 0, true);
                }
                return tArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(iA)));
        }
        throw new h("type mismatch.");
    }

    public final boolean a(int i10, boolean z10) {
        return a((byte) 0, i10, z10) != 0;
    }

    public final byte a(byte b10, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return b10;
        }
        a aVar = new a();
        a(aVar);
        byte b11 = aVar.f9092a;
        if (b11 == 0) {
            return this.f9091b.get();
        }
        if (b11 == 12) {
            return (byte) 0;
        }
        throw new h("type mismatch.");
    }

    public final short a(short s10, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return s10;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f9092a;
        if (b10 == 0) {
            return this.f9091b.get();
        }
        if (b10 == 1) {
            return this.f9091b.getShort();
        }
        if (b10 == 12) {
            return (short) 0;
        }
        throw new h("type mismatch.");
    }

    public final int a(int i10, int i11, boolean z10) {
        if (!b(i11)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return i10;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f9092a;
        if (b10 == 0) {
            return this.f9091b.get();
        }
        if (b10 == 1) {
            return this.f9091b.getShort();
        }
        if (b10 == 2) {
            return this.f9091b.getInt();
        }
        if (b10 == 12) {
            return 0;
        }
        throw new h("type mismatch.");
    }

    public final long a(long j10, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return j10;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f9092a;
        if (b10 == 0) {
            return this.f9091b.get();
        }
        if (b10 == 1) {
            return this.f9091b.getShort();
        }
        if (b10 == 2) {
            return this.f9091b.getInt();
        }
        if (b10 == 3) {
            return this.f9091b.getLong();
        }
        if (b10 == 12) {
            return 0L;
        }
        throw new h("type mismatch.");
    }

    private float a(float f10, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return f10;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f9092a;
        if (b10 == 4) {
            return this.f9091b.getFloat();
        }
        if (b10 == 12) {
            return 0.0f;
        }
        throw new h("type mismatch.");
    }

    private double a(double d10, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return d10;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f9092a;
        if (b10 == 4) {
            return this.f9091b.getFloat();
        }
        if (b10 == 5) {
            return this.f9091b.getDouble();
        }
        if (b10 == 12) {
            return 0.0d;
        }
        throw new h("type mismatch.");
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i10, boolean z10) {
        return (HashMap) a(new HashMap(), map, i10, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i10, boolean z10) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (b(i10)) {
                a aVar = new a();
                a(aVar);
                if (aVar.f9092a == 8) {
                    int iA = a(0, 0, true);
                    if (iA < 0) {
                        throw new h("size invalid: ".concat(String.valueOf(iA)));
                    }
                    for (int i11 = 0; i11 < iA; i11++) {
                        map.put(a(key, 0, true), a(value, 1, true));
                    }
                } else {
                    throw new h("type mismatch.");
                }
            } else if (z10) {
                throw new h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    private <T> T[] a(T[] tArr, int i10, boolean z10) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i10, z10);
        }
        throw new h("unable to get type of key and value.");
    }

    private <T> List<T> a(List<T> list, int i10, boolean z10) {
        if (list != null && !list.isEmpty()) {
            Object[] objArrB = b(list.get(0), i10, z10);
            if (objArrB == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : objArrB) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public final m a(m mVar, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        try {
            m mVar2 = (m) mVar.getClass().newInstance();
            a aVar = new a();
            a(aVar);
            if (aVar.f9092a == 10) {
                mVar2.a(this);
                a();
                return mVar2;
            }
            throw new h("type mismatch.");
        } catch (Exception e10) {
            throw new h(e10.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t10, int i10, boolean z10) {
        if (t10 instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i10, z10));
        }
        if (t10 instanceof Boolean) {
            return Boolean.valueOf(a(i10, z10));
        }
        if (t10 instanceof Short) {
            return Short.valueOf(a((short) 0, i10, z10));
        }
        if (t10 instanceof Integer) {
            return Integer.valueOf(a(0, i10, z10));
        }
        if (t10 instanceof Long) {
            return Long.valueOf(a(0L, i10, z10));
        }
        if (t10 instanceof Float) {
            return Float.valueOf(a(0.0f, i10, z10));
        }
        if (t10 instanceof Double) {
            return Double.valueOf(a(0.0d, i10, z10));
        }
        if (t10 instanceof String) {
            return String.valueOf(b(i10, z10));
        }
        if (t10 instanceof Map) {
            return a((Map) t10, i10, z10);
        }
        if (t10 instanceof List) {
            return a((List) t10, i10, z10);
        }
        if (t10 instanceof m) {
            return a((m) t10, i10, z10);
        }
        if (t10.getClass().isArray()) {
            if (!(t10 instanceof byte[]) && !(t10 instanceof Byte[])) {
                if (t10 instanceof boolean[]) {
                    return d(i10, z10);
                }
                if (t10 instanceof short[]) {
                    return e(i10, z10);
                }
                if (t10 instanceof int[]) {
                    return f(i10, z10);
                }
                if (t10 instanceof long[]) {
                    return g(i10, z10);
                }
                if (t10 instanceof float[]) {
                    return h(i10, z10);
                }
                if (t10 instanceof double[]) {
                    return i(i10, z10);
                }
                return a((Object[]) t10, i10, z10);
            }
            return c(i10, z10);
        }
        throw new h("read object error: unsupport type.");
    }

    public final int a(String str) {
        this.f9090a = str;
        return 0;
    }
}
