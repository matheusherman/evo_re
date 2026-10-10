package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4566a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f4567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4568b;

        /* synthetic */ a(h hVar, String str, g gVar) {
            this(hVar, str);
        }

        private a(h hVar, String str) {
            this.f4567a = hVar;
            this.f4568b = (String) m.i(str);
        }

        public String d(Iterator<? extends Map.Entry<?, ?>> it) {
            return b(new StringBuilder(), it).toString();
        }

        public <A extends Appendable> A a(A a10, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            m.i(a10);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a10.append(this.f4567a.c(next.getKey()));
                a10.append(this.f4568b);
                a10.append(this.f4567a.c(next.getValue()));
                while (it.hasNext()) {
                    a10.append(this.f4567a.f4566a);
                    Map.Entry<?, ?> next2 = it.next();
                    a10.append(this.f4567a.c(next2.getKey()));
                    a10.append(this.f4568b);
                    a10.append(this.f4567a.c(next2.getValue()));
                }
            }
            return a10;
        }

        public StringBuilder b(StringBuilder sb2, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                a(sb2, it);
                return sb2;
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        public String c(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return d(iterable.iterator());
        }

        public String e(Map<?, ?> map) {
            return c(map.entrySet());
        }
    }

    public static h b(String str) {
        return new h(str);
    }

    public a d(String str) {
        return new a(this, str, null);
    }

    private h(String str) {
        this.f4566a = (String) m.i(str);
    }

    CharSequence c(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }
}
