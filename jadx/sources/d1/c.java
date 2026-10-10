package d1;

import android.opengl.GLES20;
import android.opengl.GLU;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f9555b = {12344};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f9556c = {12445, 13120, 12344};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f9557d = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f9558e = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* JADX INFO: renamed from: d1.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0168c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a[] f9563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d[] f9564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<String, a> f9565d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Map<String, d> f9566e;

        private int b(String str) {
            return c.k(this.f9562a, str);
        }

        public int c(String str) {
            return c.l(this.f9562a, str);
        }

        public C0168c(String str, String str2) {
            String str3;
            int iGlCreateProgram = GLES20.glCreateProgram();
            this.f9562a = iGlCreateProgram;
            c.g();
            c.f(iGlCreateProgram, 35633, str);
            c.f(iGlCreateProgram, 35632, str2);
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = {0};
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String strValueOf = String.valueOf(GLES20.glGetProgramInfoLog(iGlCreateProgram));
                if (strValueOf.length() != 0) {
                    str3 = "Unable to link shader program: \n".concat(strValueOf);
                } else {
                    str3 = new String("Unable to link shader program: \n");
                }
                c.n(str3);
            }
            GLES20.glUseProgram(iGlCreateProgram);
            this.f9565d = new HashMap();
            int[] iArr2 = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35721, iArr2, 0);
            this.f9563b = new a[iArr2[0]];
            for (int i10 = 0; i10 < iArr2[0]; i10++) {
                a aVarA = a.a(this.f9562a, i10);
                this.f9563b[i10] = aVarA;
                this.f9565d.put(aVarA.f9559a, aVarA);
            }
            this.f9566e = new HashMap();
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(this.f9562a, 35718, iArr3, 0);
            this.f9564c = new d[iArr3[0]];
            for (int i11 = 0; i11 < iArr3[0]; i11++) {
                d dVarA = d.a(this.f9562a, i11);
                this.f9564c[i11] = dVarA;
                this.f9566e.put(dVarA.f9567a, dVarA);
            }
            c.g();
        }

        public int a(String str) {
            int iB = b(str);
            GLES20.glEnableVertexAttribArray(iB);
            c.g();
            return iB;
        }
    }

    public static void g() {
        int i10 = 0;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            String strValueOf = String.valueOf(GLU.gluErrorString(iGlGetError));
            d1.d.b("GlUtil", strValueOf.length() != 0 ? "glError: ".concat(strValueOf) : new String("glError: "));
            i10 = iGlGetError;
        }
        if (i10 != 0) {
            String strValueOf2 = String.valueOf(GLU.gluErrorString(i10));
            n(strValueOf2.length() != 0 ? "glError: ".concat(strValueOf2) : new String("glError: "));
        }
    }

    public static FloatBuffer i(float[] fArr) {
        return (FloatBuffer) h(fArr.length).put(fArr).flip();
    }

    public static int j() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr));
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        g();
        return iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (bArr[i10] == 0) {
                return i10;
            }
        }
        return bArr.length;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9561c;

        public static a a(int i10, int i11) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i10, 35722, iArr, 0);
            int i12 = iArr[0];
            byte[] bArr = new byte[i12];
            GLES20.glGetActiveAttrib(i10, i11, i12, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, c.m(bArr));
            return new a(str, i11, c.k(i10, str));
        }

        private a(String str, int i10, int i11) {
            this.f9559a = str;
            this.f9560b = i10;
            this.f9561c = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends RuntimeException {
        public b(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float[] f9570d = new float[16];

        public static d a(int i10, int i11) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i10, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i12 = iArr[0];
            byte[] bArr = new byte[i12];
            GLES20.glGetActiveUniform(i10, i11, i12, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, c.m(bArr));
            return new d(str, c.l(i10, str), iArr2[0]);
        }

        private d(String str, int i10, int i11) {
            this.f9567a = str;
            this.f9568b = i10;
            this.f9569c = i11;
        }
    }

    public static FloatBuffer h(int i10) {
        return ByteBuffer.allocateDirect(i10 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(String str) {
        d1.d.b("GlUtil", str);
        if (f9554a) {
            throw new b(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(int i10, int i11, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i11);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(iGlCreateShader);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strGlGetShaderInfoLog).length() + 10 + String.valueOf(str).length());
            sb2.append(strGlGetShaderInfoLog);
            sb2.append(", source: ");
            sb2.append(str);
            n(sb2.toString());
        }
        GLES20.glAttachShader(i10, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i10, String str) {
        return GLES20.glGetAttribLocation(i10, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(int i10, String str) {
        return GLES20.glGetUniformLocation(i10, str);
    }
}
