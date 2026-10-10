package f1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float[] f9954h = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float[] f9955i = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float[] f9956j = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float[] f9957k = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f9958l = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d1.c.C0168c f9960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9965g;

    public void b() {
        d1.c.C0168c c0168c = new d1.c.C0168c("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
        this.f9960b = c0168c;
        this.f9961c = c0168c.c("uMvpMatrix");
        this.f9962d = this.f9960b.c("uTexMatrix");
        this.f9963e = this.f9960b.a("aPosition");
        this.f9964f = this.f9960b.a("aTexCoords");
        this.f9965g = this.f9960b.c("uTexture");
    }

    e() {
    }

    public static boolean c(d dVar) {
        dVar.getClass();
        throw null;
    }

    public void d(d dVar) {
        if (!c(dVar)) {
            return;
        }
        this.f9959a = dVar.f9953a;
        throw null;
    }

    public void a(int i10, float[] fArr, boolean z10) {
    }
}
