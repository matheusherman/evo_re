package com.google.gson.internal;

import b3.o;
import com.google.gson.s;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class m {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f4912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f4913b = new a();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        private static class a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private char[] f4914a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f4915b;

            private a() {
            }

            void a(char[] cArr) {
                this.f4914a = cArr;
                this.f4915b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i10) {
                return this.f4914a[i10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f4914a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f4914a, i10, i11 - i10);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f4915b == null) {
                    this.f4915b = new String(this.f4914a);
                }
                return this.f4915b;
            }
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) throws IOException {
            this.f4913b.a(cArr);
            this.f4912a.append(this.f4913b, i10, i11 + i10);
        }

        b(Appendable appendable) {
            this.f4912a = appendable;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f4912a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i10) throws IOException {
            this.f4912a.append((char) i10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i10, int i11) throws IOException {
            this.f4912a.append(charSequence, i10, i11);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i10, int i11) throws IOException {
            Objects.requireNonNull(str);
            this.f4912a.append(str, i10, i11 + i10);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }

    public static void b(com.google.gson.k kVar, g3.c cVar) {
        o.V.d(cVar, kVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }

    public static com.google.gson.k a(g3.a aVar) {
        boolean z10;
        try {
            try {
                aVar.B();
                z10 = false;
                try {
                    return o.V.b(aVar);
                } catch (EOFException e10) {
                    e = e10;
                    if (z10) {
                        return com.google.gson.m.f4922a;
                    }
                    throw new s(e);
                }
            } catch (EOFException e11) {
                e = e11;
                z10 = true;
            }
        } catch (g3.d e12) {
            throw new s(e12);
        } catch (IOException e13) {
            throw new com.google.gson.l(e13);
        } catch (NumberFormatException e14) {
            throw new s(e14);
        }
    }
}
