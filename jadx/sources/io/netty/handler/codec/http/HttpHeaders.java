package io.netty.handler.codec.http;

import io.netty.handler.codec.HeadersUtils;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class HttpHeaders implements Iterable<Map.Entry<String, String>> {

    @Deprecated
    public static final HttpHeaders EMPTY_HEADERS = EmptyHttpHeaders.instance();

    private static boolean containsCommaSeparatedTrimmed(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        if (z10) {
            int iIndexOf = AsciiString.indexOf(charSequence, ',', 0);
            if (iIndexOf != -1) {
                int i10 = 0;
                while (!AsciiString.contentEqualsIgnoreCase(AsciiString.trim(charSequence.subSequence(i10, iIndexOf)), charSequence2)) {
                    i10 = iIndexOf + 1;
                    iIndexOf = AsciiString.indexOf(charSequence, ',', i10);
                    if (iIndexOf == -1) {
                        if (i10 < charSequence.length() && AsciiString.contentEqualsIgnoreCase(AsciiString.trim(charSequence.subSequence(i10, charSequence.length())), charSequence2)) {
                            return true;
                        }
                    }
                }
                return true;
            }
            if (AsciiString.contentEqualsIgnoreCase(AsciiString.trim(charSequence), charSequence2)) {
                return true;
            }
        } else {
            int iIndexOf2 = AsciiString.indexOf(charSequence, ',', 0);
            if (iIndexOf2 != -1) {
                int i11 = 0;
                while (!AsciiString.contentEquals(AsciiString.trim(charSequence.subSequence(i11, iIndexOf2)), charSequence2)) {
                    i11 = iIndexOf2 + 1;
                    iIndexOf2 = AsciiString.indexOf(charSequence, ',', i11);
                    if (iIndexOf2 == -1) {
                        if (i11 < charSequence.length() && AsciiString.contentEquals(AsciiString.trim(charSequence.subSequence(i11, charSequence.length())), charSequence2)) {
                            return true;
                        }
                    }
                }
                return true;
            }
            if (AsciiString.contentEquals(AsciiString.trim(charSequence), charSequence2)) {
                return true;
            }
        }
        return false;
    }

    public HttpHeaders add(CharSequence charSequence, Object obj) {
        return add(charSequence.toString(), obj);
    }

    public abstract HttpHeaders add(String str, Object obj);

    public abstract HttpHeaders clear();

    public boolean contains(CharSequence charSequence) {
        return contains(charSequence.toString());
    }

    public abstract boolean contains(String str);

    public String get(CharSequence charSequence) {
        return get(charSequence.toString());
    }

    public abstract String get(String str);

    public List<String> getAll(CharSequence charSequence) {
        return getAll(charSequence.toString());
    }

    public abstract List<String> getAll(String str);

    public abstract boolean isEmpty();

    @Override // java.lang.Iterable
    @Deprecated
    public abstract Iterator<Map.Entry<String, String>> iterator();

    public abstract Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence();

    public HttpHeaders remove(CharSequence charSequence) {
        return remove(charSequence.toString());
    }

    public abstract HttpHeaders remove(String str);

    public HttpHeaders set(CharSequence charSequence, Object obj) {
        return set(charSequence.toString(), obj);
    }

    public abstract HttpHeaders set(String str, Iterable<?> iterable);

    public abstract HttpHeaders set(String str, Object obj);

    public abstract HttpHeaders setInt(CharSequence charSequence, int i10);

    public abstract int size();

    public boolean contains(String str, String str2, boolean z10) {
        Iterator<String> itValueStringIterator = valueStringIterator(str);
        if (z10) {
            while (itValueStringIterator.hasNext()) {
                if (itValueStringIterator.next().equalsIgnoreCase(str2)) {
                    return true;
                }
            }
            return false;
        }
        while (itValueStringIterator.hasNext()) {
            if (itValueStringIterator.next().equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public HttpHeaders set(CharSequence charSequence, Iterable<?> iterable) {
        return set(charSequence.toString(), iterable);
    }

    protected HttpHeaders() {
    }

    public boolean containsValue(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        Iterator<? extends CharSequence> itValueCharSequenceIterator = valueCharSequenceIterator(charSequence);
        while (itValueCharSequenceIterator.hasNext()) {
            if (containsCommaSeparatedTrimmed(itValueCharSequenceIterator.next(), charSequence2, z10)) {
                return true;
            }
        }
        return false;
    }

    public HttpHeaders set(HttpHeaders httpHeaders) {
        ObjectUtil.checkNotNull(httpHeaders, "headers");
        clear();
        if (!httpHeaders.isEmpty()) {
            for (Map.Entry<String, String> entry : httpHeaders) {
                add(entry.getKey(), (Object) entry.getValue());
            }
        }
        return this;
    }

    public String toString() {
        return HeadersUtils.toString(getClass(), iteratorCharSequence(), size());
    }

    public Iterator<? extends CharSequence> valueCharSequenceIterator(CharSequence charSequence) {
        return valueStringIterator(charSequence);
    }

    public Iterator<String> valueStringIterator(CharSequence charSequence) {
        return getAll(charSequence).iterator();
    }

    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        return contains(charSequence.toString(), charSequence2.toString(), z10);
    }
}
