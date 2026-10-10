package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f9088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9089b;

    private void a(String str) {
        for (int i10 = 0; i10 < this.f9089b; i10++) {
            this.f9088a.append('\t');
        }
        if (str != null) {
            StringBuilder sb2 = this.f9088a;
            sb2.append(str);
            sb2.append(": ");
        }
    }

    public i(StringBuilder sb2, int i10) {
        this.f9088a = sb2;
        this.f9089b = i10;
    }

    public final i a(boolean z10, String str) {
        a(str);
        StringBuilder sb2 = this.f9088a;
        sb2.append(z10 ? 'T' : 'F');
        sb2.append('\n');
        return this;
    }

    public final i a(byte b10, String str) {
        a(str);
        StringBuilder sb2 = this.f9088a;
        sb2.append((int) b10);
        sb2.append('\n');
        return this;
    }

    private i a(char c10, String str) {
        a(str);
        StringBuilder sb2 = this.f9088a;
        sb2.append(c10);
        sb2.append('\n');
        return this;
    }

    public final i a(short s10, String str) {
        a(str);
        StringBuilder sb2 = this.f9088a;
        sb2.append((int) s10);
        sb2.append('\n');
        return this;
    }

    public final i a(int i10, String str) {
        a(str);
        StringBuilder sb2 = this.f9088a;
        sb2.append(i10);
        sb2.append('\n');
        return this;
    }

    public final i a(long j10, String str) {
        a(str);
        StringBuilder sb2 = this.f9088a;
        sb2.append(j10);
        sb2.append('\n');
        return this;
    }

    private i a(float f10, String str) {
        a(str);
        StringBuilder sb2 = this.f9088a;
        sb2.append(f10);
        sb2.append('\n');
        return this;
    }

    private i a(double d10, String str) {
        a(str);
        StringBuilder sb2 = this.f9088a;
        sb2.append(d10);
        sb2.append('\n');
        return this;
    }

    public final i a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.f9088a.append("null\n");
            return this;
        }
        StringBuilder sb2 = this.f9088a;
        sb2.append(str);
        sb2.append('\n');
        return this;
    }

    public final i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.f9088a.append("null\n");
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb2 = this.f9088a;
            sb2.append(bArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f9088a;
        sb3.append(bArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f9088a, this.f9089b + 1);
        for (byte b10 : bArr) {
            iVar.a(b10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            this.f9088a.append("null\n");
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb2 = this.f9088a;
            sb2.append(sArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f9088a;
        sb3.append(sArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f9088a, this.f9089b + 1);
        for (short s10 : sArr) {
            iVar.a(s10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            this.f9088a.append("null\n");
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb2 = this.f9088a;
            sb2.append(iArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f9088a;
        sb3.append(iArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f9088a, this.f9089b + 1);
        for (int i10 : iArr) {
            iVar.a(i10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            this.f9088a.append("null\n");
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb2 = this.f9088a;
            sb2.append(jArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f9088a;
        sb3.append(jArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f9088a, this.f9089b + 1);
        for (long j10 : jArr) {
            iVar.a(j10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            this.f9088a.append("null\n");
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb2 = this.f9088a;
            sb2.append(fArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f9088a;
        sb3.append(fArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f9088a, this.f9089b + 1);
        for (float f10 : fArr) {
            iVar.a(f10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            this.f9088a.append("null\n");
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb2 = this.f9088a;
            sb2.append(dArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f9088a;
        sb3.append(dArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f9088a, this.f9089b + 1);
        for (double d10 : dArr) {
            iVar.a(d10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public final <K, V> i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.f9088a.append("null\n");
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb2 = this.f9088a;
            sb2.append(map.size());
            sb2.append(", {}\n");
            return this;
        }
        StringBuilder sb3 = this.f9088a;
        sb3.append(map.size());
        sb3.append(", {\n");
        i iVar = new i(this.f9088a, this.f9089b + 1);
        i iVar2 = new i(this.f9088a, this.f9089b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            iVar.a('(', (String) null);
            iVar2.a(entry.getKey(), (String) null);
            iVar2.a(entry.getValue(), (String) null);
            iVar.a(')', (String) null);
        }
        a('}', (String) null);
        return this;
    }

    private <T> i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.f9088a.append("null\n");
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb2 = this.f9088a;
            sb2.append(tArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f9088a;
        sb3.append(tArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f9088a, this.f9089b + 1);
        for (T t10 : tArr) {
            iVar.a(t10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(Collection<T> collection, String str) {
        if (collection == null) {
            a(str);
            this.f9088a.append("null\t");
            return this;
        }
        return a(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(T t10, String str) {
        if (t10 == 0) {
            this.f9088a.append("null\n");
            return this;
        }
        if (t10 instanceof Byte) {
            a(((Byte) t10).byteValue(), str);
            return this;
        }
        if (t10 instanceof Boolean) {
            a(((Boolean) t10).booleanValue(), str);
            return this;
        }
        if (t10 instanceof Short) {
            a(((Short) t10).shortValue(), str);
            return this;
        }
        if (t10 instanceof Integer) {
            a(((Integer) t10).intValue(), str);
            return this;
        }
        if (t10 instanceof Long) {
            a(((Long) t10).longValue(), str);
            return this;
        }
        if (t10 instanceof Float) {
            a(((Float) t10).floatValue(), str);
            return this;
        }
        if (t10 instanceof Double) {
            a(((Double) t10).doubleValue(), str);
            return this;
        }
        if (t10 instanceof String) {
            a((String) t10, str);
            return this;
        }
        if (t10 instanceof Map) {
            a((Map) t10, str);
            return this;
        }
        if (t10 instanceof List) {
            a((Collection) t10, str);
            return this;
        }
        if (t10 instanceof m) {
            a((m) t10, str);
            return this;
        }
        if (t10 instanceof byte[]) {
            a((byte[]) t10, str);
            return this;
        }
        if (t10 instanceof boolean[]) {
            a((boolean[]) t10, str);
            return this;
        }
        if (t10 instanceof short[]) {
            a((short[]) t10, str);
            return this;
        }
        if (t10 instanceof int[]) {
            a((int[]) t10, str);
            return this;
        }
        if (t10 instanceof long[]) {
            a((long[]) t10, str);
            return this;
        }
        if (t10 instanceof float[]) {
            a((float[]) t10, str);
            return this;
        }
        if (t10 instanceof double[]) {
            a((double[]) t10, str);
            return this;
        }
        if (t10.getClass().isArray()) {
            a((Object[]) t10, str);
            return this;
        }
        throw new j("write object error: unsupport type.");
    }

    public final i a(m mVar, String str) {
        a('{', str);
        if (mVar == null) {
            StringBuilder sb2 = this.f9088a;
            sb2.append('\t');
            sb2.append(Configurator.NULL);
        } else {
            mVar.a(this.f9088a, this.f9089b + 1);
        }
        a('}', (String) null);
        return this;
    }
}
