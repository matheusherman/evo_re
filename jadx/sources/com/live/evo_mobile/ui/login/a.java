package com.live.evo_mobile.ui.login;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/live/evo_mobile/ui/login/a;", "", "<init>", "()V", "Lr8/z;", "e", "", "Lcom/live/evo_mobile/ui/login/c;", "c", "()Ljava/util/List;", "", "accountStr", "", "g", "(Ljava/lang/String;)Z", "emailStr", "f", "phoneStr", "phonePreCode", "h", "(Ljava/lang/String;Ljava/lang/String;)Z", "d", "(Ljava/lang/String;)Ljava/lang/String;", "", "a", "Ljava/util/List;", "countryCodeList", "b", "Ljava/lang/String;", "DEFAULT_REGEX", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f8004d;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<c> countryCodeList = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String DEFAULT_REGEX = "^\\+\\d{5,20}$";

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.login.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/live/evo_mobile/ui/login/a$a;", "", "<init>", "()V", "Lcom/live/evo_mobile/ui/login/a;", "a", "()Lcom/live/evo_mobile/ui/login/a;", "instance", "Lcom/live/evo_mobile/ui/login/a;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final a a() {
            a aVar;
            a aVar2 = a.f8004d;
            if (aVar2 == null) {
                synchronized (this) {
                    aVar = a.f8004d;
                    if (aVar == null) {
                        aVar = new a();
                        a.f8004d = aVar;
                    }
                }
                return aVar;
            }
            return aVar2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return t8.a.a(Integer.valueOf(((c) t11).getSeq()), Integer.valueOf(((c) t10).getSeq()));
        }
    }

    private final void e() {
        if (this.countryCodeList.isEmpty()) {
            this.countryCodeList.add(new c("+55", "BR", "BR", 1, ""));
        }
        List<c> list = this.countryCodeList;
        if (list.size() > 1) {
            kotlin.collections.r.B(list, new b());
        }
        for (c cVar : this.countryCodeList) {
            if (TextUtils.isEmpty(cVar.getReg())) {
                cVar.f(this.DEFAULT_REGEX);
            }
        }
    }

    public final List<c> c() {
        return this.countryCodeList;
    }

    public final String d(String phoneStr) {
        kotlin.jvm.internal.m.f(phoneStr, "phoneStr");
        String strS = ac.g.s(phoneStr);
        kotlin.jvm.internal.m.c(strS);
        String strE = ua.n.E(ua.n.E(strS, "-", "", false, 4, null), " ", "", false, 4, null);
        Iterator<c> it = this.countryCodeList.iterator();
        while (it.hasNext()) {
            String phonePreCode = it.next().getPhonePreCode();
            if (phonePreCode != null) {
                kotlin.jvm.internal.m.c(strE);
                if (ua.n.O(strE, phonePreCode, false, 2, null)) {
                    kotlin.jvm.internal.m.c(strE);
                    strE = ua.n.C(strE, phonePreCode, "", true);
                    break;
                }
            }
        }
        kotlin.jvm.internal.m.c(strE);
        return strE;
    }

    public final boolean f(String emailStr) {
        kotlin.jvm.internal.m.f(emailStr, "emailStr");
        return ua.n.O(emailStr, "@", false, 2, null) && ua.n.O(emailStr, ".", false, 2, null) && !ua.n.I(emailStr, "@", false, 2, null) && !ua.n.v(emailStr, "@", false, 2, null);
    }

    public final boolean g(String accountStr) {
        kotlin.jvm.internal.m.f(accountStr, "accountStr");
        return h(accountStr, "");
    }

    public final boolean h(String phoneStr, String phonePreCode) {
        kotlin.jvm.internal.m.f(phoneStr, "phoneStr");
        kotlin.jvm.internal.m.f(phonePreCode, "phonePreCode");
        if (TextUtils.isEmpty(phoneStr)) {
            return false;
        }
        String strE = ua.n.E(phoneStr, " ", "", false, 4, null);
        String phonePreCode2 = this.DEFAULT_REGEX;
        if (!TextUtils.isEmpty(phonePreCode)) {
            for (c cVar : this.countryCodeList) {
                if (ua.n.w(cVar.getPhonePreCode(), phonePreCode, true) && (phonePreCode2 = cVar.getPhonePreCode()) == null) {
                    phonePreCode2 = "";
                }
            }
        }
        return Pattern.matches(phonePreCode2, strE);
    }

    public a() {
        e();
    }
}
