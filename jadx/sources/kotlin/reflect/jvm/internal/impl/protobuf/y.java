package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class y {
    public static boolean e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    private static int a(int i10) {
        if (i10 > -12) {
            return -1;
        }
        return i10;
    }

    private static int b(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }

    private static int c(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }

    private static int d(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 == 0) {
            return a(b10);
        }
        if (i12 == 1) {
            return b(b10, bArr[i10]);
        }
        if (i12 == 2) {
            return c(b10, bArr[i10], bArr[i10 + 1]);
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r7[r8] > (-65)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
    
        if (r7[r8] > (-65)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
    
        if (r7[r6] > (-65)) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(int i10, byte[] bArr, int i11, int i12) {
        byte b10;
        int i13;
        int i14;
        if (i10 != 0) {
            if (i11 >= i12) {
                return i10;
            }
            byte b11 = (byte) i10;
            if (b11 < -32) {
                if (b11 >= -62) {
                    i14 = i11 + 1;
                }
                return -1;
            }
            if (b11 < -16) {
                byte b12 = (byte) (~(i10 >> 8));
                if (b12 == 0) {
                    int i15 = i11 + 1;
                    byte b13 = bArr[i11];
                    if (i15 >= i12) {
                        return b(b11, b13);
                    }
                    i11 = i15;
                    b12 = b13;
                }
                if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                    i14 = i11 + 1;
                }
                return -1;
            }
            byte b14 = (byte) (~(i10 >> 8));
            if (b14 == 0) {
                i13 = i11 + 1;
                b14 = bArr[i11];
                if (i13 >= i12) {
                    return b(b11, b14);
                }
                b10 = 0;
            } else {
                b10 = (byte) (i10 >> 16);
                i13 = i11;
            }
            if (b10 == 0) {
                int i16 = i13 + 1;
                byte b15 = bArr[i13];
                if (i16 >= i12) {
                    return c(b11, b14, b15);
                }
                b10 = b15;
                i13 = i16;
            }
            if (b14 <= -65 && (((b11 << 28) + (b14 + 112)) >> 30) == 0 && b10 <= -65) {
                i11 = i13 + 1;
            }
            return -1;
            i11 = i14;
        }
        return h(bArr, i11, i12);
    }

    public static int h(byte[] bArr, int i10, int i11) {
        while (i10 < i11 && bArr[i10] >= 0) {
            i10++;
        }
        if (i10 >= i11) {
            return 0;
        }
        return i(bArr, i10, i11);
    }

    private static int i(byte[] bArr, int i10, int i11) {
        while (i10 < i11) {
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            if (b10 < 0) {
                if (b10 < -32) {
                    if (i12 >= i11) {
                        return b10;
                    }
                    if (b10 >= -62) {
                        i10 += 2;
                        if (bArr[i12] > -65) {
                        }
                    }
                    return -1;
                }
                if (b10 >= -16) {
                    if (i12 >= i11 - 2) {
                        return d(bArr, i12, i11);
                    }
                    int i13 = i10 + 2;
                    byte b11 = bArr[i12];
                    if (b11 <= -65 && (((b10 << 28) + (b11 + 112)) >> 30) == 0) {
                        int i14 = i10 + 3;
                        if (bArr[i13] <= -65) {
                            i10 += 4;
                            if (bArr[i14] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i12 >= i11 - 1) {
                    return d(bArr, i12, i11);
                }
                int i15 = i10 + 2;
                byte b12 = bArr[i12];
                if (b12 <= -65 && ((b10 != -32 || b12 >= -96) && (b10 != -19 || b12 < -96))) {
                    i10 += 3;
                    if (bArr[i15] > -65) {
                    }
                }
                return -1;
            }
            i10 = i12;
        }
        return 0;
    }

    public static boolean f(byte[] bArr, int i10, int i11) {
        if (h(bArr, i10, i11) == 0) {
            return true;
        }
        return false;
    }
}
