package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class w implements Iterator<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3175a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ u f3176b;

    w(u uVar) {
        this.f3176b = uVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3175a < this.f3176b.f3091a.length();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ s next() {
        if (this.f3175a >= this.f3176b.f3091a.length()) {
            throw new NoSuchElementException();
        }
        String str = this.f3176b.f3091a;
        int i10 = this.f3175a;
        this.f3175a = i10 + 1;
        return new u(String.valueOf(str.charAt(i10)));
    }
}
