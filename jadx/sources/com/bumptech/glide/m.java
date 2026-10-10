package com.bumptech.glide;

import com.bumptech.glide.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class m<CHILD extends m<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c0.c<? super TranscodeType> f1402a = c0.a.b();

    final c0.c<? super TranscodeType> c() {
        return this.f1402a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            return e0.l.d(this.f1402a, ((m) obj).f1402a);
        }
        return false;
    }

    public int hashCode() {
        c0.c<? super TranscodeType> cVar = this.f1402a;
        if (cVar != null) {
            return cVar.hashCode();
        }
        return 0;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }
}
