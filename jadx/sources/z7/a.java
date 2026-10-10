package z7;

import com.google.gson.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import s7.AdItem;
import s7.AdList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lz7/a;", "", "a", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: z7.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lz7/a$a;", "", "<init>", "()V", "", "value", "adType", "", "Ls7/a;", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "b", "(Ljava/lang/String;)Ljava/util/List;", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final List<AdItem> a(String value, String adType) {
            kotlin.jvm.internal.m.f(value, "value");
            kotlin.jvm.internal.m.f(adType, "adType");
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    Object objN = new com.google.gson.f().h(v.f4935c).b().n(value, AdList.class);
                    kotlin.jvm.internal.m.e(objN, "fromJson(...)");
                    AdList adList = (AdList) objN;
                    List<AdItem> listB = kotlin.jvm.internal.m.a(adType, "start_up") ? adList.b() : kotlin.jvm.internal.m.a(adType, "channel_page") ? adList.a() : null;
                    if (listB != null) {
                        for (AdItem adItem : listB) {
                            String source = adItem.getSource();
                            if (source != null && source.length() != 0 && (adItem.getExpireTs() == 0 || System.currentTimeMillis() <= adItem.getExpireTs())) {
                                arrayList.add(adItem);
                            }
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } catch (Exception unused) {
                Iterator it = ua.n.z0(value, new String[]{","}, false, 0, 6, null).iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    int i11 = i10 + 1;
                    arrayList.add(new AdItem((String) it.next(), "", "", 6, 0L, i10));
                    i10 = i11;
                }
            }
            return arrayList;
        }

        public final List<AdItem> b(String value) {
            kotlin.jvm.internal.m.f(value, "value");
            return a(value, "start_up");
        }
    }
}
