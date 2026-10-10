package okhttp3;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 %2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\"%B\u0017\b\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u000eJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0013H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0016¢\u0006\u0004\b \u0010!R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b$\u0010\u001f¨\u0006&"}, d2 = {"Lokhttp3/u;", "", "Lr8/p;", "", "", "namesAndValues", "<init>", "([Ljava/lang/String;)V", "name", "e", "(Ljava/lang/String;)Ljava/lang/String;", "", "index", "f", "(I)Ljava/lang/String;", "k", "", "m", "(Ljava/lang/String;)Ljava/util/List;", "", "iterator", "()Ljava/util/Iterator;", "Lokhttp3/u$a;", "h", "()Lokhttp3/u$a;", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "a", "[Ljava/lang/String;", "size", "b", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class u implements Iterable<r8.p<? extends String, ? extends String>>, d9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String[] namesAndValues;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0007J \u0010\u0013\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u000bJ\r\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lokhttp3/u$a;", "", "<init>", "()V", "", "line", "c", "(Ljava/lang/String;)Lokhttp3/u$a;", "name", "value", "a", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/u$a;", "e", "Lokhttp3/u;", "headers", "b", "(Lokhttp3/u;)Lokhttp3/u$a;", "d", "h", "i", "f", "()Lokhttp3/u;", "", "Ljava/util/List;", "g", "()Ljava/util/List;", "namesAndValues", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<String> namesAndValues = new ArrayList(20);

        public final a a(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(value, "value");
            Companion companion = u.INSTANCE;
            companion.d(name);
            companion.e(value, name);
            d(name, value);
            return this;
        }

        public final a b(u headers) {
            kotlin.jvm.internal.m.f(headers, "headers");
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                d(headers.f(i10), headers.k(i10));
            }
            return this;
        }

        public final a c(String line) {
            kotlin.jvm.internal.m.f(line, "line");
            int iA0 = ua.n.a0(line, ':', 1, false, 4, null);
            if (iA0 != -1) {
                String strSubstring = line.substring(0, iA0);
                kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = line.substring(iA0 + 1);
                kotlin.jvm.internal.m.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                d(strSubstring, strSubstring2);
                return this;
            }
            if (line.charAt(0) != ':') {
                d("", line);
                return this;
            }
            String strSubstring3 = line.substring(1);
            kotlin.jvm.internal.m.e(strSubstring3, "this as java.lang.String).substring(startIndex)");
            d("", strSubstring3);
            return this;
        }

        public final a d(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(value, "value");
            this.namesAndValues.add(name);
            this.namesAndValues.add(ua.n.Q0(value).toString());
            return this;
        }

        public final a e(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(value, "value");
            u.INSTANCE.d(name);
            d(name, value);
            return this;
        }

        public final u f() {
            return new u((String[]) this.namesAndValues.toArray(new String[0]), null);
        }

        public final List<String> g() {
            return this.namesAndValues;
        }

        public final a h(String name) {
            kotlin.jvm.internal.m.f(name, "name");
            int i10 = 0;
            while (i10 < this.namesAndValues.size()) {
                if (ua.n.w(name, this.namesAndValues.get(i10), true)) {
                    this.namesAndValues.remove(i10);
                    this.namesAndValues.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public final a i(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(value, "value");
            Companion companion = u.INSTANCE;
            companion.d(name);
            companion.e(value, name);
            h(name);
            d(name, value);
            return this;
        }
    }

    /* JADX INFO: renamed from: okhttp3.u$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lokhttp3/u$b;", "", "<init>", "()V", "", "", "namesAndValues", "name", "f", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lr8/z;", "d", "(Ljava/lang/String;)V", "value", "e", "(Ljava/lang/String;Ljava/lang/String;)V", "Lokhttp3/u;", "g", "([Ljava/lang/String;)Lokhttp3/u;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(String[] namesAndValues, String name) {
            int length = namesAndValues.length - 2;
            int iB = x8.c.b(length, 0, -2);
            if (iB > length) {
                return null;
            }
            while (!ua.n.w(name, namesAndValues[length], true)) {
                if (length == iB) {
                    return null;
                }
                length -= 2;
            }
            return namesAndValues[length + 1];
        }

        private Companion() {
        }

        public final u g(String... namesAndValues) {
            kotlin.jvm.internal.m.f(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] strArr = (String[]) namesAndValues.clone();
            int length = strArr.length;
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                String str = strArr[i11];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr[i11] = ua.n.Q0(str).toString();
            }
            int iB = x8.c.b(0, strArr.length - 1, 2);
            if (iB >= 0) {
                while (true) {
                    String str2 = strArr[i10];
                    String str3 = strArr[i10 + 1];
                    d(str2);
                    e(str3, str2);
                    if (i10 == iB) {
                        break;
                    }
                    i10 += 2;
                }
            }
            return new u(strArr, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(String name) {
            if (name.length() > 0) {
                int length = name.length();
                for (int i10 = 0; i10 < length; i10++) {
                    char cCharAt = name.charAt(i10);
                    if ('!' > cCharAt || cCharAt >= 127) {
                        throw new IllegalArgumentException(hb.d.t("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), name).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(String value, String name) {
            String str;
            int length = value.length();
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = value.charAt(i10);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(hb.d.t("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i10), name));
                    if (hb.d.G(name)) {
                        str = "";
                    } else {
                        str = ": " + value;
                    }
                    sb2.append(str);
                    throw new IllegalArgumentException(sb2.toString().toString());
                }
            }
        }
    }

    public /* synthetic */ u(String[] strArr, kotlin.jvm.internal.g gVar) {
        this(strArr);
    }

    private u(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static final u i(String... strArr) {
        return INSTANCE.g(strArr);
    }

    public final String e(String name) {
        kotlin.jvm.internal.m.f(name, "name");
        return INSTANCE.f(this.namesAndValues, name);
    }

    public boolean equals(Object other) {
        return (other instanceof u) && Arrays.equals(this.namesAndValues, ((u) other).namesAndValues);
    }

    public final String f(int index) {
        return this.namesAndValues[index * 2];
    }

    public final a h() {
        a aVar = new a();
        kotlin.collections.r.D(aVar.g(), this.namesAndValues);
        return aVar;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public final String k(int index) {
        return this.namesAndValues[(index * 2) + 1];
    }

    public final List<String> m(String name) {
        kotlin.jvm.internal.m.f(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            if (ua.n.w(name, f(i10), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(k(i10));
            }
        }
        if (arrayList == null) {
            return kotlin.collections.r.l();
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        kotlin.jvm.internal.m.e(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String strF = f(i10);
            String strK = k(i10);
            sb2.append(strF);
            sb2.append(": ");
            if (hb.d.G(strF)) {
                strK = "██";
            }
            sb2.append(strK);
            sb2.append("\n");
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // java.lang.Iterable
    public Iterator<r8.p<? extends String, ? extends String>> iterator() {
        int size = size();
        r8.p[] pVarArr = new r8.p[size];
        for (int i10 = 0; i10 < size; i10++) {
            pVarArr[i10] = r8.v.a(f(i10), k(i10));
        }
        return kotlin.jvm.internal.b.a(pVarArr);
    }
}
