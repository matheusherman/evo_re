package com.google.common.base;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class c implements n<Character> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static abstract class a extends c {
        @Override // com.google.common.base.n
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.b(ch);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f4559a;

        @Override // com.google.common.base.c
        public boolean e(char c10) {
            return c10 == this.f4559a;
        }

        public String toString() {
            return "CharMatcher.is('" + c.f(this.f4559a) + "')";
        }

        b(char c10) {
            this.f4559a = c10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(char c10) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            cArr[5 - i10] = "0123456789ABCDEF".charAt(c10 & 15);
            c10 = (char) (c10 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public int c(CharSequence charSequence) {
        int i10 = 0;
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            if (e(charSequence.charAt(i11))) {
                i10++;
            }
        }
        return i10;
    }

    public abstract boolean e(char c10);

    public static c d(char c10) {
        return new b(c10);
    }

    protected c() {
    }

    @Deprecated
    public boolean b(Character ch) {
        return e(ch.charValue());
    }
}
