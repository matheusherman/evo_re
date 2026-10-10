package com.pengrad.telegrambot.passport.decrypt;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Base64 {
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        @Override // com.pengrad.telegrambot.passport.decrypt.Base64.Coder
        public int maxOutputSize(int i10) {
            return ((i10 * 3) / 4) + 10;
        }

        /* JADX WARN: Code duplicated, block: B:42:0x00c0  */
        @Override // com.pengrad.telegrambot.passport.decrypt.Base64.Coder
        public boolean process(byte[] bArr, int i10, int i11, boolean z10) {
            int i12 = this.state;
            if (i12 == 6) {
                return false;
            }
            int i13 = i11 + i10;
            int i14 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
            int i15 = i14;
            int i16 = 0;
            int i17 = i12;
            int i18 = i10;
            while (i18 < i13) {
                if (i17 == 0) {
                    while (true) {
                        int i19 = i18 + 4;
                        if (i19 > i13 || (i15 = (iArr[bArr[i18] & 255] << 18) | (iArr[bArr[i18 + 1] & 255] << 12) | (iArr[bArr[i18 + 2] & 255] << 6) | iArr[bArr[i18 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i16 + 2] = (byte) i15;
                        bArr2[i16 + 1] = (byte) (i15 >> 8);
                        bArr2[i16] = (byte) (i15 >> 16);
                        i16 += 3;
                        i18 = i19;
                    }
                    if (i18 >= i13) {
                        break;
                    }
                }
                int i20 = i18 + 1;
                int i21 = iArr[bArr[i18] & 255];
                if (i17 != 0) {
                    if (i17 != 1) {
                        if (i17 != 2) {
                            if (i17 != 3) {
                                if (i17 != 4) {
                                    if (i17 == 5 && i21 != -1) {
                                        this.state = 6;
                                        return false;
                                    }
                                } else if (i21 == -2) {
                                    i17++;
                                } else if (i21 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            } else if (i21 >= 0) {
                                int i22 = i21 | (i15 << 6);
                                bArr2[i16 + 2] = (byte) i22;
                                bArr2[i16 + 1] = (byte) (i22 >> 8);
                                bArr2[i16] = (byte) (i22 >> 16);
                                i16 += 3;
                                i15 = i22;
                                i17 = 0;
                            } else if (i21 == -2) {
                                bArr2[i16 + 1] = (byte) (i15 >> 2);
                                bArr2[i16] = (byte) (i15 >> 10);
                                i16 += 2;
                                i17 = 5;
                            } else if (i21 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i21 >= 0) {
                            i21 |= i15 << 6;
                            i17++;
                            i15 = i21;
                        } else if (i21 == -2) {
                            bArr2[i16] = (byte) (i15 >> 4);
                            i16++;
                            i17 = 4;
                        } else if (i21 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i21 >= 0) {
                        i21 |= i15 << 6;
                        i17++;
                        i15 = i21;
                    } else if (i21 != -1) {
                        this.state = 6;
                        return false;
                    }
                } else if (i21 >= 0) {
                    i17++;
                    i15 = i21;
                } else if (i21 != -1) {
                    this.state = 6;
                    return false;
                }
                i18 = i20;
            }
            if (!z10) {
                this.state = i17;
                this.value = i15;
                this.op = i16;
                return true;
            }
            if (i17 == 1) {
                this.state = 6;
                return false;
            }
            if (i17 == 2) {
                bArr2[i16] = (byte) (i15 >> 4);
                i16++;
            } else if (i17 == 3) {
                int i23 = i16 + 1;
                bArr2[i16] = (byte) (i15 >> 10);
                i16 += 2;
                bArr2[i23] = (byte) (i15 >> 2);
            } else if (i17 == 4) {
                this.state = 6;
                return false;
            }
            this.state = i17;
            this.op = i16;
            return true;
        }

        public Decoder(int i10, byte[] bArr) {
            int[] iArr;
            this.output = bArr;
            if ((i10 & 8) == 0) {
                iArr = DECODE;
            } else {
                iArr = DECODE_WEBSAFE;
            }
            this.alphabet = iArr;
            this.state = 0;
            this.value = 0;
        }
    }

    public static byte[] decode(String str, int i10) {
        return decode(str.getBytes(), i10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int i10);

        public abstract boolean process(byte[] bArr, int i10, int i11, boolean z10);

        Coder() {
        }
    }

    public static byte[] decode(byte[] bArr, int i10) {
        return decode(bArr, 0, bArr.length, i10);
    }

    private Base64() {
    }

    public static byte[] decode(byte[] bArr, int i10, int i11, int i12) {
        Decoder decoder = new Decoder(i12, new byte[(i11 * 3) / 4]);
        if (decoder.process(bArr, i10, i11, true)) {
            int i13 = decoder.op;
            byte[] bArr2 = decoder.output;
            if (i13 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i13];
            System.arraycopy(bArr2, 0, bArr3, 0, i13);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
