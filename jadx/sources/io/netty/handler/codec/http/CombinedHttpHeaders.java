package io.netty.handler.codec.http;

import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.StringUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CombinedHttpHeaders extends DefaultHttpHeaders {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class CombinedHttpHeadersImpl extends DefaultHeaders<CharSequence, CharSequence, CombinedHttpHeadersImpl> {
        private CsvValueEscaper<CharSequence> charSequenceEscaper;
        private CsvValueEscaper<Object> objectEscaper;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        private interface CsvValueEscaper<T> {
            CharSequence escape(CharSequence charSequence, T t10);
        }

        private static <T> CharSequence commaSeparate(CharSequence charSequence, CsvValueEscaper<T> csvValueEscaper, T... tArr) {
            StringBuilder sb2 = new StringBuilder(tArr.length * 10);
            if (tArr.length > 0) {
                int length = tArr.length - 1;
                for (int i10 = 0; i10 < length; i10++) {
                    sb2.append(csvValueEscaper.escape(charSequence, tArr[i10]));
                    sb2.append(',');
                }
                sb2.append(csvValueEscaper.escape(charSequence, tArr[length]));
            }
            return sb2;
        }

        @Override // io.netty.handler.codec.DefaultHeaders
        public /* bridge */ /* synthetic */ Headers setObject(CharSequence charSequence, Iterable iterable) {
            return setObject2(charSequence, (Iterable<?>) iterable);
        }

        private static boolean cannotBeCombined(CharSequence charSequence) {
            return HttpHeaderNames.SET_COOKIE.contentEqualsIgnoreCase(charSequence);
        }

        private CsvValueEscaper<CharSequence> charSequenceEscaper() {
            if (this.charSequenceEscaper == null) {
                this.charSequenceEscaper = new CsvValueEscaper<CharSequence>() { // from class: io.netty.handler.codec.http.CombinedHttpHeaders.CombinedHttpHeadersImpl.2
                    @Override // io.netty.handler.codec.http.CombinedHttpHeaders.CombinedHttpHeadersImpl.CsvValueEscaper
                    public CharSequence escape(CharSequence charSequence, CharSequence charSequence2) {
                        return StringUtil.escapeCsv(charSequence2, true);
                    }
                };
            }
            return this.charSequenceEscaper;
        }

        private static CharSequence commaSeparateEscapedValues(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb2 = new StringBuilder(charSequence.length() + 1 + charSequence2.length());
            sb2.append(charSequence);
            sb2.append(',');
            sb2.append(charSequence2);
            return sb2;
        }

        private CsvValueEscaper<Object> objectEscaper() {
            if (this.objectEscaper == null) {
                this.objectEscaper = new CsvValueEscaper<Object>() { // from class: io.netty.handler.codec.http.CombinedHttpHeaders.CombinedHttpHeadersImpl.1
                    @Override // io.netty.handler.codec.http.CombinedHttpHeaders.CombinedHttpHeadersImpl.CsvValueEscaper
                    public CharSequence escape(CharSequence charSequence, Object obj) {
                        try {
                            return StringUtil.escapeCsv((CharSequence) CombinedHttpHeadersImpl.this.valueConverter().convertObject(obj), true);
                        } catch (IllegalArgumentException e10) {
                            throw new IllegalArgumentException("Failed to convert object value for header '" + ((Object) charSequence) + '\'', e10);
                        }
                    }
                };
            }
            return this.objectEscaper;
        }

        public CombinedHttpHeadersImpl add(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
            if (headers == this) {
                throw new IllegalArgumentException("can't add to itself.");
            }
            if (!(headers instanceof CombinedHttpHeadersImpl)) {
                for (Map.Entry<? extends CharSequence, ? extends CharSequence> entry : headers) {
                    add(entry.getKey(), entry.getValue());
                }
            } else {
                if (isEmpty()) {
                    addImpl(headers);
                    return this;
                }
                for (Map.Entry<? extends CharSequence, ? extends CharSequence> entry2 : headers) {
                    addEscapedValue(entry2.getKey(), entry2.getValue());
                }
            }
            return this;
        }

        @Override // io.netty.handler.codec.DefaultHeaders
        public CombinedHttpHeadersImpl addObject(CharSequence charSequence, Object obj) {
            return addEscapedValue(charSequence, commaSeparate(charSequence, objectEscaper(), obj));
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public List<CharSequence> getAll(CharSequence charSequence) {
            List<CharSequence> all = super.getAll(charSequence);
            if (all.isEmpty() || cannotBeCombined(charSequence)) {
                return all;
            }
            if (all.size() == 1) {
                return StringUtil.unescapeCsvFields(all.get(0));
            }
            throw new IllegalStateException("CombinedHttpHeaders should only have one value");
        }

        @Override // io.netty.handler.codec.DefaultHeaders
        public CombinedHttpHeadersImpl set(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
            if (headers == this) {
                return this;
            }
            clear();
            return add(headers);
        }

        @Override // io.netty.handler.codec.DefaultHeaders
        public Iterator<CharSequence> valueIterator(CharSequence charSequence) {
            Iterator<CharSequence> itValueIterator = super.valueIterator(charSequence);
            if (!itValueIterator.hasNext() || cannotBeCombined(charSequence)) {
                return itValueIterator;
            }
            Iterator<CharSequence> it = StringUtil.unescapeCsvFields(itValueIterator.next()).iterator();
            if (itValueIterator.hasNext()) {
                throw new IllegalStateException("CombinedHttpHeaders should only have one value");
            }
            return it;
        }

        CombinedHttpHeadersImpl(HashingStrategy<CharSequence> hashingStrategy, ValueConverter<CharSequence> valueConverter, DefaultHeaders.NameValidator<CharSequence> nameValidator) {
            super(hashingStrategy, valueConverter, nameValidator);
        }

        private CombinedHttpHeadersImpl addEscapedValue(CharSequence charSequence, CharSequence charSequence2) {
            CharSequence charSequence3 = get(charSequence);
            if (charSequence3 != null && !cannotBeCombined(charSequence)) {
                set(charSequence, commaSeparateEscapedValues(charSequence3, charSequence2));
                return this;
            }
            super.add(charSequence, charSequence2);
            return this;
        }

        @Override // io.netty.handler.codec.DefaultHeaders
        public CombinedHttpHeadersImpl setObject(CharSequence charSequence, Object obj) {
            set(charSequence, commaSeparate(charSequence, objectEscaper(), obj));
            return this;
        }

        /* JADX INFO: renamed from: setObject, reason: avoid collision after fix types in other method */
        public CombinedHttpHeadersImpl setObject2(CharSequence charSequence, Iterable<?> iterable) {
            set(charSequence, commaSeparate(charSequence, objectEscaper(), iterable));
            return this;
        }

        private static <T> CharSequence commaSeparate(CharSequence charSequence, CsvValueEscaper<T> csvValueEscaper, Iterable<? extends T> iterable) {
            StringBuilder sb2 = iterable instanceof Collection ? new StringBuilder(((Collection) iterable).size() * 10) : new StringBuilder();
            Iterator<? extends T> it = iterable.iterator();
            if (it.hasNext()) {
                T next = it.next();
                while (it.hasNext()) {
                    sb2.append(csvValueEscaper.escape(charSequence, next));
                    sb2.append(',');
                    next = it.next();
                }
                sb2.append(csvValueEscaper.escape(charSequence, next));
            }
            return sb2;
        }

        @Override // io.netty.handler.codec.DefaultHeaders
        public CombinedHttpHeadersImpl add(CharSequence charSequence, CharSequence charSequence2) {
            return addEscapedValue(charSequence, charSequenceEscaper().escape(charSequence, charSequence2));
        }
    }

    public CombinedHttpHeaders(boolean z10) {
        super(new CombinedHttpHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, DefaultHttpHeaders.valueConverter(z10), DefaultHttpHeaders.nameValidator(z10)));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean containsValue(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        return super.containsValue(charSequence, StringUtil.trimOws(charSequence2), z10);
    }
}
