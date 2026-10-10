package io.netty.util;

import io.netty.util.internal.MathUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class AsciiString implements CharSequence, Comparable<CharSequence> {
    private int hash;
    private final int length;
    private final int offset;
    private String string;
    private final byte[] value;
    public static final AsciiString EMPTY_STRING = cached("");
    public static final HashingStrategy<CharSequence> CASE_INSENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.1
        @Override // io.netty.util.HashingStrategy
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEqualsIgnoreCase(charSequence, charSequence2);
        }

        @Override // io.netty.util.HashingStrategy
        public int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }
    };
    public static final HashingStrategy<CharSequence> CASE_SENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.2
        @Override // io.netty.util.HashingStrategy
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEquals(charSequence, charSequence2);
        }

        @Override // io.netty.util.HashingStrategy
        public int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }
    };

    public AsciiString(byte[] bArr, int i10, int i11, boolean z10) {
        if (z10) {
            this.value = Arrays.copyOfRange(bArr, i10, i10 + i11);
            this.offset = 0;
        } else {
            if (MathUtil.isOutOfBounds(i10, i11, bArr.length)) {
                throw new IndexOutOfBoundsException("expected: 0 <= start(" + i10 + ") <= start + length(" + i11 + ") <= value.length(" + bArr.length + ')');
            }
            this.value = bArr;
            this.offset = i10;
        }
        this.length = i11;
    }

    private static byte c2b0(char c10) {
        return (byte) c10;
    }

    private static boolean equalsIgnoreCase(byte b10, byte b11) {
        return b10 == b11 || toLowerCase(b10) == toLowerCase(b11);
    }

    public static boolean isUpperCase(byte b10) {
        return b10 >= 65 && b10 <= 90;
    }

    private static byte toLowerCase(byte b10) {
        return isUpperCase(b10) ? (byte) (b10 + 32) : b10;
    }

    public static CharSequence trim(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).trim();
        }
        if (charSequence instanceof String) {
            return ((String) charSequence).trim();
        }
        int length = charSequence.length() - 1;
        int i10 = 0;
        while (i10 <= length && charSequence.charAt(i10) <= ' ') {
            i10++;
        }
        int i11 = length;
        while (i11 >= i10 && charSequence.charAt(i11) <= ' ') {
            i11--;
        }
        return (i10 == 0 && i11 == length) ? charSequence : charSequence.subSequence(i10, i11);
    }

    public boolean contentEquals(CharSequence charSequence) {
        if (this == charSequence) {
            return true;
        }
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (charSequence instanceof AsciiString) {
            return equals(charSequence);
        }
        int iArrayOffset = arrayOffset();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (b2c(this.value[iArrayOffset]) != charSequence.charAt(i10)) {
                return false;
            }
            iArrayOffset++;
        }
        return true;
    }

    public boolean contentEqualsIgnoreCase(CharSequence charSequence) {
        if (this == charSequence) {
            return true;
        }
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (!(charSequence instanceof AsciiString)) {
            int iArrayOffset = arrayOffset();
            int length = length();
            for (int i10 = 0; i10 < length; i10++) {
                if (!equalsIgnoreCase(b2c(this.value[iArrayOffset]), charSequence.charAt(i10))) {
                    return false;
                }
                iArrayOffset++;
            }
            return true;
        }
        AsciiString asciiString = (AsciiString) charSequence;
        int iArrayOffset2 = arrayOffset();
        int iArrayOffset3 = asciiString.arrayOffset();
        int length2 = length() + iArrayOffset2;
        while (iArrayOffset2 < length2) {
            if (!equalsIgnoreCase(this.value[iArrayOffset2], asciiString.value[iArrayOffset3])) {
                return false;
            }
            iArrayOffset2++;
            iArrayOffset3++;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == AsciiString.class) {
            if (this == obj) {
                return true;
            }
            AsciiString asciiString = (AsciiString) obj;
            if (length() == asciiString.length() && hashCode() == asciiString.hashCode() && PlatformDependent.equals(array(), arrayOffset(), asciiString.array(), asciiString.arrayOffset(), length())) {
                return true;
            }
        }
        return false;
    }

    public int forEachByte(ByteProcessor byteProcessor) {
        return forEachByte0(0, length(), byteProcessor);
    }

    public int hashCode() {
        int i10 = this.hash;
        if (i10 != 0) {
            return i10;
        }
        int iHashCodeAscii = PlatformDependent.hashCodeAscii(this.value, this.offset, this.length);
        this.hash = iHashCodeAscii;
        return iHashCodeAscii;
    }

    public int indexOf(char c10, int i10) {
        if (c10 > 255) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        byte bC2b0 = c2b0(c10);
        int i11 = this.offset;
        int i12 = this.length + i11;
        for (int i13 = i10 + i11; i13 < i12; i13++) {
            if (this.value[i13] == bC2b0) {
                return i13 - this.offset;
            }
        }
        return -1;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        String str = this.string;
        if (str != null) {
            return str;
        }
        String string = toString(0);
        this.string = string;
        return string;
    }

    public static char b2c(byte b10) {
        return (char) (b10 & 255);
    }

    public static byte c2b(char c10) {
        if (c10 > 255) {
            c10 = '?';
        }
        return (byte) c10;
    }

    public static AsciiString cached(String str) {
        AsciiString asciiString = new AsciiString(str);
        asciiString.string = str;
        return asciiString;
    }

    private static boolean equalsIgnoreCase(char c10, char c11) {
        return c10 == c11 || toLowerCase(c10) == toLowerCase(c11);
    }

    private int forEachByte0(int i10, int i11, ByteProcessor byteProcessor) {
        int i12 = this.offset;
        int i13 = i12 + i10 + i11;
        for (int i14 = i12 + i10; i14 < i13; i14++) {
            if (!byteProcessor.process(this.value[i14])) {
                return i14 - this.offset;
            }
        }
        return -1;
    }

    public static boolean isUpperCase(char c10) {
        return c10 >= 'A' && c10 <= 'Z';
    }

    public static AsciiString of(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? (AsciiString) charSequence : new AsciiString(charSequence);
    }

    public static char toLowerCase(char c10) {
        return isUpperCase(c10) ? (char) (c10 + ' ') : c10;
    }

    public byte[] array() {
        return this.value;
    }

    public int arrayOffset() {
        return this.offset;
    }

    public byte byteAt(int i10) {
        if (i10 >= 0 && i10 < this.length) {
            return PlatformDependent.hasUnsafe() ? PlatformDependent.getByte(this.value, i10 + this.offset) : this.value[i10 + this.offset];
        }
        throw new IndexOutOfBoundsException("index: " + i10 + " must be in the range [0," + this.length + ")");
    }

    @Override // java.lang.Comparable
    public int compareTo(CharSequence charSequence) {
        int i10 = 0;
        if (this == charSequence) {
            return 0;
        }
        int length = length();
        int length2 = charSequence.length();
        int iMin = Math.min(length, length2);
        int iArrayOffset = arrayOffset();
        while (i10 < iMin) {
            int iB2c = b2c(this.value[iArrayOffset]) - charSequence.charAt(i10);
            if (iB2c != 0) {
                return iB2c;
            }
            i10++;
            iArrayOffset++;
        }
        return length - length2;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public AsciiString subSequence(int i10, int i11) {
        return subSequence(i10, i11, true);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return b2c(byteAt(i10));
    }

    public AsciiString subSequence(int i10, int i11, boolean z10) {
        int i12 = i11 - i10;
        if (!MathUtil.isOutOfBounds(i10, i12, length())) {
            if (i10 == 0 && i11 == length()) {
                return this;
            }
            if (i11 == i10) {
                return EMPTY_STRING;
            }
            return new AsciiString(this.value, i10 + this.offset, i12, z10);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i10 + ") <= end (" + i11 + ") <= length(" + length() + ')');
    }

    public static int hashCode(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        if (charSequence instanceof AsciiString) {
            return charSequence.hashCode();
        }
        return PlatformDependent.hashCodeAscii(charSequence);
    }

    public String toString(int i10) {
        return toString(i10, length());
    }

    public static int indexOf(CharSequence charSequence, char c10, int i10) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(c10, i10);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).indexOf(c10, i10);
        }
        if (charSequence == null) {
            return -1;
        }
        int length = charSequence.length();
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < length) {
            if (charSequence.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public String toString(int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 == 0) {
            return "";
        }
        if (!MathUtil.isOutOfBounds(i10, i12, length())) {
            return new String(this.value, 0, i10 + this.offset, i12);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i10 + ") <= srcIdx + length(" + i12 + ") <= srcLen(" + length() + ')');
    }

    public static boolean contentEquals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).contentEquals(charSequence2);
        }
        if (charSequence2 instanceof AsciiString) {
            return ((AsciiString) charSequence2).contentEquals(charSequence);
        }
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (charSequence.charAt(i10) != charSequence2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public static boolean contentEqualsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).contentEqualsIgnoreCase(charSequence2);
        }
        if (charSequence2 instanceof AsciiString) {
            return ((AsciiString) charSequence2).contentEqualsIgnoreCase(charSequence);
        }
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!equalsIgnoreCase(charSequence.charAt(i10), charSequence2.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public AsciiString(CharSequence charSequence) {
        this(charSequence, 0, charSequence.length());
    }

    public AsciiString trim() {
        int iArrayOffset = arrayOffset();
        int iArrayOffset2 = (arrayOffset() + length()) - 1;
        while (iArrayOffset <= iArrayOffset2 && this.value[iArrayOffset] <= 32) {
            iArrayOffset++;
        }
        int i10 = iArrayOffset2;
        while (i10 >= iArrayOffset && this.value[i10] <= 32) {
            i10--;
        }
        return (iArrayOffset == 0 && i10 == iArrayOffset2) ? this : new AsciiString(this.value, iArrayOffset, (i10 - iArrayOffset) + 1, false);
    }

    public AsciiString(CharSequence charSequence, int i10, int i11) {
        if (!MathUtil.isOutOfBounds(i10, i11, charSequence.length())) {
            this.value = PlatformDependent.allocateUninitializedArray(i11);
            int i12 = 0;
            while (i12 < i11) {
                this.value[i12] = c2b(charSequence.charAt(i10));
                i12++;
                i10++;
            }
            this.offset = 0;
            this.length = i11;
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i10 + ") <= start + length(" + i11 + ") <= value.length(" + charSequence.length() + ')');
    }
}
