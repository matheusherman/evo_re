package retrofit2;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class j0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i0 f18037a = new j0();

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    static Annotation[] a(Annotation[] annotationArr) {
        if (k0.l(annotationArr, i0.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = f18037a;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return i0.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof i0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + i0.class.getName() + "()";
    }

    j0() {
    }
}
