package x1.f1.lb.util;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlinx.coroutines.g2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lx1/f1/lb/util/t0;", "", "<init>", "()V", "", "str", "", "width", "height", "Landroid/graphics/Bitmap;", "c", "(Ljava/lang/String;II)Landroid/graphics/Bitmap;", "text", "sizeInPx", "Landroid/widget/ImageView;", "imgView", "logTag", "Lr8/z;", "d", "(Ljava/lang/String;ILandroid/widget/ImageView;Ljava/lang/String;)V", "Lq6/b;", "b", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f21446a = new t0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.QrCodeUtils$setQrCode$1", f = "QrCodeUtils.kt", l = {35}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ ImageView $imgView;
        final /* synthetic */ String $logTag;
        final /* synthetic */ int $sizeInPx;
        final /* synthetic */ String $text;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.util.t0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.QrCodeUtils$setQrCode$1$1", f = "QrCodeUtils.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0467a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ Bitmap $bitmap;
            final /* synthetic */ ImageView $imgView;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0467a(ImageView imageView, Bitmap bitmap, v8.f<? super C0467a> fVar) {
                super(2, fVar);
                this.$imgView = imageView;
                this.$bitmap = bitmap;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new C0467a(this.$imgView, this.$bitmap, fVar);
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((C0467a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    this.$imgView.setImageBitmap(this.$bitmap);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, int i10, String str2, ImageView imageView, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$text = str;
            this.$sizeInPx = i10;
            this.$logTag = str2;
            this.$imgView = imageView;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$text, this.$sizeInPx, this.$logTag, this.$imgView, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            String str;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    t0 t0Var = t0.f21446a;
                    String str2 = this.$text;
                    int i11 = this.$sizeInPx;
                    Bitmap bitmapC = t0Var.c(str2, i11, i11);
                    g2 g2VarC = kotlinx.coroutines.a1.c();
                    C0467a c0467a = new C0467a(this.$imgView, bitmapC, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(g2VarC, c0467a, this) == objC) {
                        return objC;
                    }
                }
            } catch (Throwable th) {
                q6.b bVar = t0.logger;
                String str3 = this.$logTag;
                if (str3 == null) {
                    str = "";
                } else {
                    str = ": " + str3;
                }
                bVar.error("generate qrcode failure" + str, th);
            }
            return r8.z.f17874a;
        }
    }

    static {
        q6.b bVarD = q6.c.d(t0.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        logger = bVarD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap c(String str, int width, int height) {
        y5.a aVar = new y5.a();
        HashMap map = new HashMap();
        map.put(v5.b.CHARACTER_SET, "utf-8");
        map.put(v5.b.MARGIN, 1);
        w5.b bVarA = aVar.a(str, v5.a.QR_CODE, width, height, map);
        int i10 = width * height;
        Integer[] numArr = new Integer[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            numArr[i11] = 0;
        }
        for (int i12 = 0; i12 < height; i12++) {
            for (int i13 = 0; i13 < width; i13++) {
                if (bVarA.c(i13, i12)) {
                    numArr[(i12 * width) + i13] = 0;
                } else {
                    numArr[(i12 * width) + i13] = -1;
                }
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(kotlin.collections.j.x0(numArr), 0, width, width, height, Bitmap.Config.RGB_565);
        kotlin.jvm.internal.m.e(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    public final void d(String text, int sizeInPx, ImageView imgView, String logTag) {
        kotlin.jvm.internal.m.f(text, "text");
        kotlin.jvm.internal.m.f(imgView, "imgView");
        if (sizeInPx != 0) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new a(text, sizeInPx, logTag, imgView, null), 3, null);
        } else {
            logger.warn("0 size to generate qrcode", new Object[0]);
            imgView.setVisibility(8);
        }
    }

    private t0() {
    }
}
