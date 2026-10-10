package io.reactivex.rxjava3.internal.util;

import g8.g;
import j8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f11484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f11485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object[] f11486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f11487d;

    /* JADX INFO: renamed from: io.reactivex.rxjava3.internal.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface InterfaceC0195a<T> extends f<T> {
        @Override // j8.f
        boolean test(T t10);
    }

    public <U> boolean a(g<? super U> gVar) {
        Object[] objArr = this.f11485b;
        int i10 = this.f11484a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    break;
                }
                if (c.a(objArr2, gVar)) {
                    return true;
                }
            }
            objArr = objArr[i10];
        }
    }

    public void b(T t10) {
        int i10 = this.f11484a;
        int i11 = this.f11487d;
        if (i11 == i10) {
            Object[] objArr = new Object[i10 + 1];
            this.f11486c[i10] = objArr;
            this.f11486c = objArr;
            i11 = 0;
        }
        this.f11486c[i11] = t10;
        this.f11487d = i11 + 1;
    }

    public void c(InterfaceC0195a<? super T> interfaceC0195a) {
        int i10 = this.f11484a;
        for (Object[] objArr = this.f11485b; objArr != null; objArr = (Object[]) objArr[i10]) {
            for (int i11 = 0; i11 < i10; i11++) {
                Object obj = objArr[i11];
                if (obj == null) {
                    break;
                } else {
                    if (interfaceC0195a.test(obj)) {
                        return;
                    }
                }
            }
        }
    }

    public void d(T t10) {
        this.f11485b[0] = t10;
    }

    public a(int i10) {
        this.f11484a = i10;
        Object[] objArr = new Object[i10 + 1];
        this.f11485b = objArr;
        this.f11486c = objArr;
    }
}
