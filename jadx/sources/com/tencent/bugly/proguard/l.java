package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f9094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f9095b;

    public l(int i10) {
        this.f9095b = "GBK";
        this.f9094a = ByteBuffer.allocate(i10);
    }

    private void a(int i10) {
        if (this.f9094a.remaining() < i10) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((this.f9094a.capacity() + i10) * 2);
            byteBufferAllocate.put(this.f9094a.array(), 0, this.f9094a.position());
            this.f9094a = byteBufferAllocate;
        }
    }

    private void b(byte b10, int i10) {
        if (i10 < 15) {
            this.f9094a.put((byte) (b10 | (i10 << 4)));
        } else {
            if (i10 >= 256) {
                throw new j("tag is too large: ".concat(String.valueOf(i10)));
            }
            this.f9094a.put((byte) (b10 | 240));
            this.f9094a.put((byte) i10);
        }
    }

    public l() {
        this(128);
    }

    public final void a(boolean z10, int i10) {
        a(z10 ? (byte) 1 : (byte) 0, i10);
    }

    public final void a(byte b10, int i10) {
        a(3);
        if (b10 == 0) {
            b((byte) 12, i10);
        } else {
            b((byte) 0, i10);
            this.f9094a.put(b10);
        }
    }

    public final void a(short s10, int i10) {
        a(4);
        if (s10 >= -128 && s10 <= 127) {
            a((byte) s10, i10);
        } else {
            b((byte) 1, i10);
            this.f9094a.putShort(s10);
        }
    }

    public final void a(int i10, int i11) {
        a(6);
        if (i10 >= -32768 && i10 <= 32767) {
            a((short) i10, i11);
        } else {
            b((byte) 2, i11);
            this.f9094a.putInt(i10);
        }
    }

    public final void a(long j10, int i10) {
        a(10);
        if (j10 >= -2147483648L && j10 <= 2147483647L) {
            a((int) j10, i10);
        } else {
            b((byte) 3, i10);
            this.f9094a.putLong(j10);
        }
    }

    private void a(float f10, int i10) {
        a(6);
        b((byte) 4, i10);
        this.f9094a.putFloat(f10);
    }

    private void a(double d10, int i10) {
        a(10);
        b((byte) 5, i10);
        this.f9094a.putDouble(d10);
    }

    public final void a(String str, int i10) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f9095b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i10);
            this.f9094a.putInt(bytes.length);
            this.f9094a.put(bytes);
        } else {
            b((byte) 6, i10);
            this.f9094a.put((byte) bytes.length);
            this.f9094a.put(bytes);
        }
    }

    public final <K, V> void a(Map<K, V> map, int i10) {
        a(8);
        b((byte) 8, i10);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    private void a(boolean[] zArr, int i10) {
        a(8);
        b((byte) 9, i10);
        a(zArr.length, 0);
        for (boolean z10 : zArr) {
            a(z10, 0);
        }
    }

    public final void a(byte[] bArr, int i10) {
        a(bArr.length + 8);
        b((byte) 13, i10);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f9094a.put(bArr);
    }

    private void a(short[] sArr, int i10) {
        a(8);
        b((byte) 9, i10);
        a(sArr.length, 0);
        for (short s10 : sArr) {
            a(s10, 0);
        }
    }

    private void a(int[] iArr, int i10) {
        a(8);
        b((byte) 9, i10);
        a(iArr.length, 0);
        for (int i11 : iArr) {
            a(i11, 0);
        }
    }

    private void a(long[] jArr, int i10) {
        a(8);
        b((byte) 9, i10);
        a(jArr.length, 0);
        for (long j10 : jArr) {
            a(j10, 0);
        }
    }

    private void a(float[] fArr, int i10) {
        a(8);
        b((byte) 9, i10);
        a(fArr.length, 0);
        for (float f10 : fArr) {
            a(f10, 0);
        }
    }

    private void a(double[] dArr, int i10) {
        a(8);
        b((byte) 9, i10);
        a(dArr.length, 0);
        for (double d10 : dArr) {
            a(d10, 0);
        }
    }

    private void a(Object[] objArr, int i10) {
        a(8);
        b((byte) 9, i10);
        a(objArr.length, 0);
        for (Object obj : objArr) {
            a(obj, 0);
        }
    }

    public final <T> void a(Collection<T> collection, int i10) {
        a(8);
        b((byte) 9, i10);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                a(it.next(), 0);
            }
        }
    }

    public final void a(m mVar, int i10) {
        a(2);
        b((byte) 10, i10);
        mVar.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i10) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i10);
            return;
        }
        if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i10);
            return;
        }
        if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i10);
            return;
        }
        if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i10);
            return;
        }
        if (obj instanceof Long) {
            a(((Long) obj).longValue(), i10);
            return;
        }
        if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i10);
            return;
        }
        if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i10);
            return;
        }
        if (obj instanceof String) {
            a((String) obj, i10);
            return;
        }
        if (obj instanceof Map) {
            a((Map) obj, i10);
            return;
        }
        if (obj instanceof List) {
            a((Collection) obj, i10);
            return;
        }
        if (obj instanceof m) {
            a((m) obj, i10);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i10);
            return;
        }
        if (obj instanceof boolean[]) {
            a((boolean[]) obj, i10);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj, i10);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj, i10);
            return;
        }
        if (obj instanceof long[]) {
            a((long[]) obj, i10);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj, i10);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj, i10);
            return;
        }
        if (obj.getClass().isArray()) {
            a((Object[]) obj, i10);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i10);
        } else {
            throw new j("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final int a(String str) {
        this.f9095b = str;
        return 0;
    }
}
