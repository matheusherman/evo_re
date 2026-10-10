package com.pengrad.telegrambot.passport.decrypt;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class RsaOaep {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class Asn1Object {
        protected final int length;
        protected final int tag;
        protected final int type;
        protected final byte[] value;

        public BigInteger getInteger() throws IOException {
            if (this.type == 2) {
                return new BigInteger(this.value);
            }
            throw new IOException("Invalid DER: object is not integer");
        }

        public int getLength() {
            return this.length;
        }

        public int getType() {
            return this.type;
        }

        public byte[] getValue() {
            return this.value;
        }

        public boolean isConstructed() {
            return (this.tag & 32) == 32;
        }

        public Asn1Object(int i10, int i11, byte[] bArr) {
            this.tag = i10;
            this.type = i10 & 31;
            this.length = i11;
            this.value = bArr;
        }

        public DerParser getParser() throws IOException {
            if (isConstructed()) {
                return new DerParser(this.value);
            }
            throw new IOException("Invalid DER: can't parse primitive entity");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class DerParser {
        public static final int ANY = 0;
        public static final int APPLICATION = 64;
        public static final int BIT_STRING = 3;
        public static final int BMP_STRING = 30;
        public static final int BOOLEAN = 1;
        public static final int CONSTRUCTED = 32;
        public static final int CONTEXT = 128;
        public static final int ENUMERATED = 10;
        public static final int GENERALIZED_TIME = 24;
        public static final int GENERAL_STRING = 27;
        public static final int GRAPHIC_STRING = 25;
        public static final int IA5_STRING = 22;
        public static final int INTEGER = 2;
        public static final int ISO646_STRING = 26;
        public static final int NULL = 5;
        public static final int NUMERIC_STRING = 18;
        public static final int OBJECT_IDENTIFIER = 6;
        public static final int OCTET_STRING = 4;
        public static final int PRINTABLE_STRING = 19;
        public static final int PRIVATE = 192;
        public static final int REAL = 9;
        public static final int RELATIVE_OID = 13;
        public static final int SEQUENCE = 16;
        public static final int SET = 17;
        public static final int T61_STRING = 20;
        public static final int UNIVERSAL = 0;
        public static final int UNIVERSAL_STRING = 28;
        public static final int UTC_TIME = 23;
        public static final int UTF8_STRING = 12;
        public static final int VIDEOTEX_STRING = 21;
        protected InputStream in;

        public DerParser(InputStream inputStream) {
            this.in = inputStream;
        }

        private int getLength() throws IOException {
            int i10 = this.in.read();
            if (i10 == -1) {
                throw new IOException("Invalid DER: length missing");
            }
            if ((i10 & (-128)) == 0) {
                return i10;
            }
            int i11 = i10 & 127;
            if (i10 < 255 && i11 <= 4) {
                byte[] bArr = new byte[i11];
                if (this.in.read(bArr) >= i11) {
                    return new BigInteger(1, bArr).intValue();
                }
                throw new IOException("Invalid DER: length too short");
            }
            throw new IOException("Invalid DER: length field too big (" + i10 + ")");
        }

        public Asn1Object read() throws IOException {
            int i10 = this.in.read();
            if (i10 == -1) {
                throw new IOException("Invalid DER: stream too short, missing tag");
            }
            int length = getLength();
            byte[] bArr = new byte[length];
            if (this.in.read(bArr) >= length) {
                return new Asn1Object(i10, length, bArr);
            }
            throw new IOException("Invalid DER: stream too short, missing value");
        }

        public DerParser(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }
    }

    static byte[] decrypt(String str, byte[] bArr) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("RSA").generatePrivate(getRSAKeySpec(Base64.decode(str.replace("-----BEGIN RSA PRIVATE KEY-----", "").replace("-----END RSA PRIVATE KEY-----", "").replaceAll("\\s+", ""), 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        cipher.init(2, privateKeyGeneratePrivate);
        return cipher.doFinal(bArr);
    }

    private static RSAPrivateCrtKeySpec getRSAKeySpec(byte[] bArr) throws IOException {
        Asn1Object asn1Object = new DerParser(bArr).read();
        if (asn1Object.getType() != 16) {
            throw new IOException("Invalid DER: not a sequence");
        }
        DerParser parser = asn1Object.getParser();
        parser.read();
        return new RSAPrivateCrtKeySpec(parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger(), parser.read().getInteger());
    }

    RsaOaep() {
    }
}
