package e1;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b extends GLSurfaceView implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f9808b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9809a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final float[] f9810k = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final float[] f9811l = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final float[] f9812m = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final String[] f9813n = {"y_tex", "u_tex", "v_tex"};

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final FloatBuffer f9814o = d1.c.i(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GLSurfaceView f9815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f9816b = new int[3];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f9817c = new int[3];

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f9818d = new int[3];

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f9819e = new int[3];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicReference<l0.c> f9820f = new AtomicReference<>();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final FloatBuffer[] f9821g = new FloatBuffer[3];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private d1.c.C0168c f9822h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f9823i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private l0.c f9824j;

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
            GLES20.glViewport(0, 0, i10, i11);
        }

        private void b() {
            GLES20.glGenTextures(3, this.f9816b, 0);
            for (int i10 = 0; i10 < 3; i10++) {
                GLES20.glUniform1i(this.f9822h.c(f9813n[i10]), i10);
                GLES20.glActiveTexture(33984 + i10);
                GLES20.glBindTexture(3553, this.f9816b[i10]);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            d1.c.g();
        }

        public void a(l0.c cVar) {
            l0.c andSet = this.f9820f.getAndSet(cVar);
            if (andSet != null) {
                andSet.a();
            }
            this.f9815a.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            l0.c andSet = this.f9820f.getAndSet(null);
            if (andSet == null && this.f9824j == null) {
                return;
            }
            if (andSet != null) {
                l0.c cVar = this.f9824j;
                if (cVar != null) {
                    cVar.a();
                }
                this.f9824j = andSet;
            }
            l0.c cVar2 = (l0.c) d1.a.b(this.f9824j);
            float[] fArr = f9811l;
            int i10 = cVar2.f15176e;
            if (i10 == 1) {
                fArr = f9810k;
            } else if (i10 == 3) {
                fArr = f9812m;
            }
            GLES20.glUniformMatrix3fv(this.f9823i, 1, false, fArr, 0);
            int[] iArr = (int[]) d1.a.b(cVar2.f15175d);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) d1.a.b(cVar2.f15174c);
            int i11 = 0;
            while (i11 < 3) {
                int i12 = i11 == 0 ? cVar2.f15173b : (cVar2.f15173b + 1) / 2;
                GLES20.glActiveTexture(33984 + i11);
                GLES20.glBindTexture(3553, this.f9816b[i11]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i11], i12, 0, 6409, 5121, byteBufferArr[i11]);
                i11++;
            }
            int i13 = cVar2.f15172a;
            int i14 = (i13 + 1) / 2;
            int[] iArr2 = {i13, i14, i14};
            for (int i15 = 0; i15 < 3; i15++) {
                if (this.f9818d[i15] != iArr2[i15] || this.f9819e[i15] != iArr[i15]) {
                    d1.a.c(iArr[i15] != 0);
                    float f10 = iArr2[i15] / iArr[i15];
                    this.f9821g[i15] = d1.c.i(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f10, 0.0f, f10, 1.0f});
                    GLES20.glVertexAttribPointer(this.f9817c[i15], 2, 5126, false, 0, (Buffer) this.f9821g[i15]);
                    this.f9818d[i15] = iArr2[i15];
                    this.f9819e[i15] = iArr[i15];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            d1.c.g();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            d1.c.C0168c c0168c = new d1.c.C0168c("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.f9822h = c0168c;
            GLES20.glVertexAttribPointer(c0168c.a("in_pos"), 2, 5126, false, 0, (Buffer) f9814o);
            this.f9817c[0] = this.f9822h.a("in_tc_y");
            this.f9817c[1] = this.f9822h.a("in_tc_u");
            this.f9817c[2] = this.f9822h.a("in_tc_v");
            this.f9823i = this.f9822h.c("mColorConversion");
            d1.c.g();
            b();
            d1.c.g();
        }

        public a(GLSurfaceView gLSurfaceView) {
            this.f9815a = gLSurfaceView;
            for (int i10 = 0; i10 < 3; i10++) {
                int[] iArr = this.f9818d;
                this.f9819e[i10] = -1;
                iArr[i10] = -1;
            }
        }
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f9809a = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    public void setOutputBuffer(l0.c cVar) {
        this.f9809a.a(cVar);
    }

    @Deprecated
    public c getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
