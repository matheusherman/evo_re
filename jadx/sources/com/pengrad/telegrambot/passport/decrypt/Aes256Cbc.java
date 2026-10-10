package com.pengrad.telegrambot.passport.decrypt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class Aes256Cbc {
    private final ByteArrayOutputStream baos;
    private final Cbc cbc;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class Aes256 {
        private static final int BLOCK_SIZE = 16;
        private static final int EXPANDED_KEY_SIZE = 240;
        private static final int KEY_SIZE = 32;
        private static final int ROUNDS = 14;
        private static final int WORD_SIZE = 4;
        private final byte[] _expandedKey;
        private final byte[] _tmp;
        private final byte[] _sBox = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, -128, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, 127, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, -68, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};
        private final byte[] _invSBox = {82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, -68, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, 16, 89, 39, -128, -20, 95, 96, 81, 127, -87, 25, -75, 74, 13, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, 12, 125};

        private void addRoundKey(int i10) {
            for (int i11 = 0; i11 < 16; i11++) {
                byte[] bArr = this._tmp;
                bArr[i11] = (byte) (bArr[i11] ^ this._expandedKey[i10 + i11]);
            }
        }

        private void invMixColumns() {
            invMixColumn(0);
            invMixColumn(4);
            invMixColumn(8);
            invMixColumn(12);
        }

        private void invSubstituteState() {
            for (int i10 = 0; i10 < 16; i10++) {
                byte[] bArr = this._tmp;
                bArr[i10] = this._invSBox[bArr[i10] & 255];
            }
        }

        private byte[] rotate(byte[] bArr) {
            byte b10 = bArr[0];
            for (int i10 = 1; i10 < 4; i10++) {
                bArr[i10 - 1] = bArr[i10];
            }
            bArr[3] = b10;
            return bArr;
        }

        private byte[] substituteWord(byte[] bArr) {
            for (int i10 = 0; i10 < 4; i10++) {
                bArr[i10] = this._sBox[bArr[i10] & 255];
            }
            return bArr;
        }

        private void invMixColumn(int i10) {
            int i11 = i10 + 1;
            int i12 = i10 + 2;
            int i13 = i10 + 3;
            int iMul = ((mul(14, this._tmp[i10]) ^ mul(11, this._tmp[i11])) ^ mul(13, this._tmp[i12])) ^ mul(9, this._tmp[i13]);
            int iMul2 = ((mul(9, this._tmp[i10]) ^ mul(14, this._tmp[i11])) ^ mul(11, this._tmp[i12])) ^ mul(13, this._tmp[i13]);
            int iMul3 = ((mul(13, this._tmp[i10]) ^ mul(9, this._tmp[i11])) ^ mul(14, this._tmp[i12])) ^ mul(11, this._tmp[i13]);
            int iMul4 = mul(14, this._tmp[i13]) ^ ((mul(11, this._tmp[i10]) ^ mul(13, this._tmp[i11])) ^ mul(9, this._tmp[i12]));
            byte[] bArr = this._tmp;
            bArr[i10] = (byte) (iMul & 255);
            bArr[i11] = (byte) (iMul2 & 255);
            bArr[i12] = (byte) (iMul3 & 255);
            bArr[i13] = (byte) (iMul4 & 255);
        }

        private void invShiftRows() {
            byte[] bArr = this._tmp;
            byte b10 = bArr[13];
            bArr[13] = bArr[9];
            bArr[9] = bArr[5];
            bArr[5] = bArr[1];
            bArr[1] = b10;
            byte b11 = bArr[2];
            bArr[2] = bArr[10];
            bArr[10] = b11;
            byte b12 = bArr[6];
            bArr[6] = bArr[14];
            bArr[14] = b12;
            byte b13 = bArr[3];
            bArr[3] = bArr[7];
            bArr[7] = bArr[11];
            bArr[11] = bArr[15];
            bArr[15] = b13;
        }

        private byte mul(int i10, byte b10) {
            int iTimes2 = b10 & 255;
            int i11 = 0;
            while (i10 != 0) {
                if ((i10 & 1) != 0) {
                    i11 ^= iTimes2;
                }
                i10 >>= 1;
                iTimes2 = times2(iTimes2);
            }
            return (byte) (i11 & 255);
        }

        private int times2(int i10) {
            int i11 = i10 << 1;
            if ((i10 & 128) != 0) {
                i11 ^= 27;
            }
            return i11 & 255;
        }

        public void decrypt(byte[] bArr, int i10, byte[] bArr2, int i11) {
            System.arraycopy(bArr, i10, this._tmp, 0, 16);
            addRoundKey(224);
            for (int i12 = 13; i12 > 0; i12--) {
                invShiftRows();
                invSubstituteState();
                addRoundKey(i12 * 16);
                invMixColumns();
            }
            invShiftRows();
            invSubstituteState();
            addRoundKey(0);
            System.arraycopy(this._tmp, 0, bArr2, i11, 16);
        }

        public Aes256(byte[] bArr) {
            byte[] bArr2 = new byte[EXPANDED_KEY_SIZE];
            this._expandedKey = bArr2;
            this._tmp = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 0, 32);
            for (int i10 = 32; i10 < EXPANDED_KEY_SIZE; i10 += 4) {
                System.arraycopy(this._expandedKey, i10 - 4, this._tmp, 0, 4);
                int i11 = i10 % 32;
                if (i11 == 0) {
                    substituteWord(rotate(this._tmp));
                    byte[] bArr3 = this._tmp;
                    bArr3[0] = (byte) (bArr3[0] ^ (1 << ((i10 / 32) - 1)));
                } else if (i11 == 16) {
                    substituteWord(this._tmp);
                }
                for (int i12 = 0; i12 < 4; i12++) {
                    byte[] bArr4 = this._expandedKey;
                    bArr4[i10 + i12] = (byte) (bArr4[(i10 - 32) + i12] ^ this._tmp[i12]);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class Cbc {
        private static final int BLOCK_SIZE = 16;
        private byte[] _buffer;
        private final Aes256 _cipher;
        private final byte[] _current;
        private byte[] _outBuffer;
        private boolean _outBufferUsed;
        private final OutputStream _output;
        private final byte[] _overflow;
        private int _overflowUsed;
        private final byte[] _tmp;

        public void decrypt(byte[] bArr) throws IOException {
            if (bArr != null) {
                decrypt(bArr, bArr.length);
            }
        }

        private void decryptBlock(byte[] bArr) {
            System.arraycopy(bArr, 0, this._buffer, 0, 16);
            this._cipher.decrypt(this._buffer, 0, this._tmp, 0);
            for (int i10 = 0; i10 < 16; i10++) {
                byte[] bArr2 = this._tmp;
                byte b10 = bArr2[i10];
                byte[] bArr3 = this._current;
                bArr2[i10] = (byte) (b10 ^ bArr3[i10]);
                bArr3[i10] = this._buffer[i10];
                this._outBuffer[i10] = bArr2[i10];
            }
        }

        public void decrypt(byte[] bArr, int i10) throws IOException {
            if (bArr == null || i10 <= 0) {
                return;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                byte[] bArr2 = this._overflow;
                int i12 = this._overflowUsed;
                int i13 = i12 + 1;
                this._overflowUsed = i13;
                bArr2[i12] = bArr[i11];
                if (i13 == 16) {
                    if (this._outBufferUsed) {
                        this._output.write(this._outBuffer);
                    }
                    decryptBlock(this._overflow);
                    this._outBufferUsed = true;
                    this._overflowUsed = 0;
                }
            }
        }

        public void finishDecryption() throws IOException {
            if (this._outBufferUsed) {
                byte[] bArr = this._outBuffer;
                byte b10 = bArr[15];
                this._output.write(bArr, 0, 16);
                this._output.close();
            }
        }

        public Cbc(byte[] bArr, byte[] bArr2, OutputStream outputStream) {
            this._buffer = null;
            this._outBuffer = null;
            this._outBufferUsed = false;
            this._cipher = new Aes256(bArr2);
            byte[] bArr3 = new byte[16];
            this._current = bArr3;
            System.arraycopy(bArr, 0, bArr3, 0, 16);
            this._tmp = new byte[16];
            this._buffer = new byte[16];
            this._outBuffer = new byte[16];
            this._outBufferUsed = false;
            this._overflow = new byte[16];
            this._overflowUsed = 0;
            this._output = outputStream;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class DecryptException extends Exception {
        private static final long serialVersionUID = -935882404526228391L;

        private DecryptException() {
        }
    }

    public byte[] decrypt(byte[] bArr) throws IOException {
        this.cbc.decrypt(bArr);
        this.cbc.finishDecryption();
        return this.baos.toByteArray();
    }

    public Aes256Cbc(byte[] bArr, byte[] bArr2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.baos = byteArrayOutputStream;
        this.cbc = new Cbc(bArr2, bArr, byteArrayOutputStream);
    }
}
