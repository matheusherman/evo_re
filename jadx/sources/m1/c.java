package m1;

import android.accounts.Account;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Account f15466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f15467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f15468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f15469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f15471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f15472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f15473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c2.a f15474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Integer f15475j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Account f15476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArraySet f15477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f15478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f15479d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final c2.a f15480e = c2.a.f1099j;

        @NonNull
        public c a() {
            return new c(this.f15476a, this.f15477b, null, 0, null, this.f15478c, this.f15479d, this.f15480e, false);
        }

        @NonNull
        public a b(@NonNull String str) {
            this.f15478c = str;
            return this;
        }

        @NonNull
        public final a c(@NonNull Collection collection) {
            if (this.f15477b == null) {
                this.f15477b = new ArraySet();
            }
            this.f15477b.addAll(collection);
            return this;
        }

        @NonNull
        public final a d(Account account) {
            this.f15476a = account;
            return this;
        }

        @NonNull
        public final a e(@NonNull String str) {
            this.f15479d = str;
            return this;
        }
    }

    @Nullable
    public Account a() {
        return this.f15466a;
    }

    @NonNull
    public Account b() {
        Account account = this.f15466a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    @NonNull
    public Set<Scope> c() {
        return this.f15468c;
    }

    @NonNull
    public String d() {
        return this.f15472g;
    }

    @NonNull
    public Set<Scope> e() {
        return this.f15467b;
    }

    @NonNull
    public final c2.a f() {
        return this.f15474i;
    }

    @Nullable
    public final Integer g() {
        return this.f15475j;
    }

    @Nullable
    public final String h() {
        return this.f15473h;
    }

    public final void i(@NonNull Integer num) {
        this.f15475j = num;
    }

    public c(Account account, @NonNull Set set, @NonNull Map map, int i10, View view, @NonNull String str, @NonNull String str2, c2.a aVar, boolean z10) {
        Set setUnmodifiableSet;
        this.f15466a = account;
        if (set == null) {
            setUnmodifiableSet = Collections.EMPTY_SET;
        } else {
            setUnmodifiableSet = Collections.unmodifiableSet(set);
        }
        this.f15467b = setUnmodifiableSet;
        map = map == null ? Collections.EMPTY_MAP : map;
        this.f15469d = map;
        this.f15471f = view;
        this.f15470e = i10;
        this.f15472g = str;
        this.f15473h = str2;
        this.f15474i = aVar == null ? c2.a.f1099j : aVar;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(((r) it.next()).f15504a);
        }
        this.f15468c = Collections.unmodifiableSet(hashSet);
    }
}
