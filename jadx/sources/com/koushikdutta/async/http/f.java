package com.koushikdutta.async.http;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class f implements l, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5092b;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            f fVar = (f) obj;
            if (this.f5091a.equals(fVar.f5091a) && TextUtils.equals(this.f5092b, fVar.f5092b)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.koushikdutta.async.http.l
    public String getName() {
        return this.f5091a;
    }

    @Override // com.koushikdutta.async.http.l
    public String getValue() {
        return this.f5092b;
    }

    public int hashCode() {
        return this.f5091a.hashCode() ^ this.f5092b.hashCode();
    }

    public String toString() {
        return this.f5091a + "=" + this.f5092b;
    }

    public f(String str, String str2) {
        if (str != null) {
            this.f5091a = str;
            this.f5092b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public Object clone() {
        return super.clone();
    }
}
