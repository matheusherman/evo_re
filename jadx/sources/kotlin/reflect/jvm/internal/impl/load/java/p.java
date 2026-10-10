package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface p {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ba.b f13413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f13414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final u9.g f13415c;

        public a(ba.b classId, byte[] bArr, u9.g gVar) {
            kotlin.jvm.internal.m.f(classId, "classId");
            this.f13413a = classId;
            this.f13414b = bArr;
            this.f13415c = gVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.m.a(this.f13413a, aVar.f13413a) && kotlin.jvm.internal.m.a(this.f13414b, aVar.f13414b) && kotlin.jvm.internal.m.a(this.f13415c, aVar.f13415c);
        }

        public final ba.b a() {
            return this.f13413a;
        }

        public int hashCode() {
            int iHashCode = this.f13413a.hashCode() * 31;
            byte[] bArr = this.f13414b;
            int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            u9.g gVar = this.f13415c;
            return iHashCode2 + (gVar != null ? gVar.hashCode() : 0);
        }

        public String toString() {
            return "Request(classId=" + this.f13413a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.f13414b) + ", outerClass=" + this.f13415c + ')';
        }

        public /* synthetic */ a(ba.b bVar, byte[] bArr, u9.g gVar, int i10, kotlin.jvm.internal.g gVar2) {
            this(bVar, (i10 & 2) != 0 ? null : bArr, (i10 & 4) != 0 ? null : gVar);
        }
    }

    u9.g a(a aVar);

    Set<String> b(ba.c cVar);

    u9.u c(ba.c cVar, boolean z10);
}
