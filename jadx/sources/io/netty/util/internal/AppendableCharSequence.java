package io.netty.util.internal;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class AppendableCharSequence implements CharSequence, Appendable {
    private char[] chars;
    private int pos;

    public AppendableCharSequence(int i10) {
        this.chars = new char[ObjectUtil.checkPositive(i10, "length")];
    }

    private static char[] expand(char[] cArr, int i10, int i11) {
        int length = cArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i10 > length);
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, 0, cArr2, 0, i11);
        return cArr2;
    }

    public void reset() {
        this.pos = 0;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        if (i10 <= this.pos) {
            return this.chars[i10];
        }
        throw new IndexOutOfBoundsException();
    }

    public char charAtUnsafe(int i10) {
        return this.chars[i10];
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.pos;
    }

    public void setLength(int i10) {
        if (i10 >= 0 && i10 <= this.pos) {
            this.pos = i10;
            return;
        }
        throw new IllegalArgumentException("length: " + i10 + " (length: >= 0, <= " + this.pos + ')');
    }

    @Override // java.lang.CharSequence
    public AppendableCharSequence subSequence(int i10, int i11) {
        return i10 == i11 ? new AppendableCharSequence(Math.min(16, this.chars.length)) : new AppendableCharSequence(Arrays.copyOfRange(this.chars, i10, i11));
    }

    public String subStringUnsafe(int i10, int i11) {
        return new String(this.chars, i10, i11 - i10);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.chars, 0, this.pos);
    }

    private AppendableCharSequence(char[] cArr) {
        this.chars = ObjectUtil.checkNonEmpty(cArr, "chars");
        this.pos = cArr.length;
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(char c10) {
        int i10 = this.pos;
        char[] cArr = this.chars;
        if (i10 == cArr.length) {
            char[] cArr2 = new char[cArr.length << 1];
            this.chars = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        }
        char[] cArr3 = this.chars;
        int i11 = this.pos;
        this.pos = i11 + 1;
        cArr3[i11] = c10;
        return this;
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence) {
        return append(charSequence, 0, charSequence.length());
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence, int i10, int i11) {
        if (charSequence.length() >= i11) {
            int i12 = i11 - i10;
            char[] cArr = this.chars;
            int length = cArr.length;
            int i13 = this.pos;
            if (i12 > length - i13) {
                this.chars = expand(cArr, i13 + i12, i13);
            }
            if (charSequence instanceof AppendableCharSequence) {
                System.arraycopy(((AppendableCharSequence) charSequence).chars, i10, this.chars, this.pos, i12);
                this.pos += i12;
                return this;
            }
            while (i10 < i11) {
                char[] cArr2 = this.chars;
                int i14 = this.pos;
                this.pos = i14 + 1;
                cArr2[i14] = charSequence.charAt(i10);
                i10++;
            }
            return this;
        }
        throw new IndexOutOfBoundsException("expected: csq.length() >= (" + i11 + "),but actual is (" + charSequence.length() + ")");
    }
}
