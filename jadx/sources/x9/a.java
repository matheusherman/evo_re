package x9;

import h9.e;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.k0;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a extends y9.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0474a f22009g = new C0474a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f22010h = new a(1, 0, 7);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f22011i = new a(new int[0]);

    /* JADX INFO: renamed from: x9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0474a {
        public /* synthetic */ C0474a(g gVar) {
            this();
        }

        private C0474a() {
        }

        public final a a(InputStream stream) {
            m.f(stream, "stream");
            DataInputStream dataInputStream = new DataInputStream(stream);
            e eVar = new e(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(r.w(eVar, 10));
            Iterator<Integer> it = eVar.iterator();
            while (it.hasNext()) {
                ((k0) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] iArrN0 = r.N0(arrayList);
            return new a(Arrays.copyOf(iArrN0, iArrN0.length));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int... numbers) {
        super(Arrays.copyOf(numbers, numbers.length));
        m.f(numbers, "numbers");
    }

    public boolean h() {
        return f(f22010h);
    }
}
