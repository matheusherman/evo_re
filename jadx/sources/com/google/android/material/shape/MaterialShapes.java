package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.graphics.shapes.CornerRounding;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.RoundedPolygonKt;
import androidx.graphics.shapes.ShapesKt;
import androidx.graphics.shapes.Shapes_androidKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialShapes {
    private static final CornerRounding CORNER_ROUND_15 = new CornerRounding(0.15f, 0.0f);
    private static final CornerRounding CORNER_ROUND_20 = new CornerRounding(0.2f, 0.0f);
    private static final CornerRounding CORNER_ROUND_30 = new CornerRounding(0.3f, 0.0f);
    private static final CornerRounding CORNER_ROUND_50 = new CornerRounding(0.5f, 0.0f);
    private static final CornerRounding CORNER_ROUND_100 = new CornerRounding(1.0f, 0.0f);
    public static final RoundedPolygon CIRCLE = normalize(getCircle(), true);
    public static final RoundedPolygon SQUARE = normalize(getSquare(), true);
    public static final RoundedPolygon SLANTED_SQUARE = normalize(getSlantedSquare(), true);
    public static final RoundedPolygon ARCH = normalize(getArch(), true);
    public static final RoundedPolygon FAN = normalize(getFan(), true);
    public static final RoundedPolygon ARROW = normalize(getArrow(), true);
    public static final RoundedPolygon SEMI_CIRCLE = normalize(getSemiCircle(), true);
    public static final RoundedPolygon OVAL = normalize(getOval(-45.0f), true);
    public static final RoundedPolygon PILL = normalize(getPill(), true);
    public static final RoundedPolygon TRIANGLE = normalize(getTriangle(-90.0f), true);
    public static final RoundedPolygon DIAMOND = normalize(getDiamond(), true);
    public static final RoundedPolygon CLAM_SHELL = normalize(getClamShell(), true);
    public static final RoundedPolygon PENTAGON = normalize(getPentagon(), true);
    public static final RoundedPolygon GEM = normalize(getGem(-90.0f), true);
    public static final RoundedPolygon SUNNY = normalize(getSunny(), true);
    public static final RoundedPolygon VERY_SUNNY = normalize(getVerySunny(), true);
    public static final RoundedPolygon COOKIE_4 = normalize(getCookie4(), true);
    public static final RoundedPolygon COOKIE_6 = normalize(getCookie6(), true);
    public static final RoundedPolygon COOKIE_7 = normalize(getCookie7(), true);
    public static final RoundedPolygon COOKIE_9 = normalize(getCookie9(), true);
    public static final RoundedPolygon COOKIE_12 = normalize(getCookie12(), true);
    public static final RoundedPolygon GHOSTISH = normalize(getGhostish(), true);
    public static final RoundedPolygon CLOVER_4 = normalize(getClover4(), true);
    public static final RoundedPolygon CLOVER_8 = normalize(getClover8(), true);
    public static final RoundedPolygon BURST = normalize(getBurst(), true);
    public static final RoundedPolygon SOFT_BURST = normalize(getSoftBurst(), true);
    public static final RoundedPolygon BOOM = normalize(getBoom(), true);
    public static final RoundedPolygon SOFT_BOOM = normalize(getSoftBoom(), true);
    public static final RoundedPolygon FLOWER = normalize(getFlower(), true);
    public static final RoundedPolygon PUFFY = normalize(getPuffy(), true);
    public static final RoundedPolygon PUFFY_DIAMOND = normalize(getPuffyDiamond(), true);
    public static final RoundedPolygon PIXEL_CIRCLE = normalize(getPixelCircle(), true);
    public static final RoundedPolygon PIXEL_TRIANGLE = normalize(getPixelTriangle(), true);
    public static final RoundedPolygon BUN = normalize(getBun(), true);
    public static final RoundedPolygon HEART = normalize(getHeart(), true);

    /* JADX INFO: renamed from: com.google.android.material.shape.MaterialShapes$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class VertexAndRounding {
        private CornerRounding rounding;
        private PointF vertex;

        /* synthetic */ VertexAndRounding(PointF pointF, CornerRounding cornerRounding, AnonymousClass1 anonymousClass1) {
            this(pointF, cornerRounding);
        }

        /* synthetic */ VertexAndRounding(PointF pointF, AnonymousClass1 anonymousClass1) {
            this(pointF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void toCartesian(float f10, float f11) {
            PointF pointF = this.vertex;
            float fCos = (float) ((((double) pointF.y) * Math.cos(pointF.x)) + ((double) f10));
            PointF pointF2 = this.vertex;
            float fSin = (float) ((((double) pointF2.y) * Math.sin(pointF2.x)) + ((double) f11));
            PointF pointF3 = this.vertex;
            pointF3.x = fCos;
            pointF3.y = fSin;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void toRadial(float f10, float f11) {
            this.vertex.offset(-f10, -f11);
            PointF pointF = this.vertex;
            float fAtan2 = (float) Math.atan2(pointF.y, pointF.x);
            PointF pointF2 = this.vertex;
            float fHypot = (float) Math.hypot(pointF2.x, pointF2.y);
            PointF pointF3 = this.vertex;
            pointF3.x = fAtan2;
            pointF3.y = fHypot;
        }

        private VertexAndRounding(@NonNull PointF pointF) {
            this(pointF, CornerRounding.Unrounded);
        }

        private VertexAndRounding(@NonNull PointF pointF, @NonNull CornerRounding cornerRounding) {
            this.vertex = pointF;
            this.rounding = cornerRounding;
        }
    }

    @NonNull
    private static RoundedPolygon getGem() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.499f, 1.023f), new CornerRounding(0.241f, 0.778f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(-0.005f, 0.792f), new CornerRounding(0.208f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.073f, 0.258f), new CornerRounding(0.228f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.433f, -0.0f), new CornerRounding(0.491f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, true);
    }

    @NonNull
    private static RoundedPolygon getOval() {
        return Shapes_androidKt.transformed(ShapesKt.circle(RoundedPolygon.INSTANCE), createScaleMatrix(1.0f, 0.64f));
    }

    @NonNull
    private static RoundedPolygon getTriangle() {
        return RoundedPolygonKt.RoundedPolygon(3, 1.0f, 0.0f, 0.0f, CORNER_ROUND_20);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static RoundedPolygon normalize(@NonNull RoundedPolygon roundedPolygon, boolean z10, @NonNull RectF rectF) {
        float[] fArr = new float[4];
        if (z10) {
            roundedPolygon.calculateMaxBounds(fArr);
        } else {
            roundedPolygon.calculateBounds(fArr);
        }
        RectF rectF2 = new RectF(fArr[0], fArr[1], fArr[2], fArr[3]);
        float fMin = Math.min(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
        Matrix matrixCreateScaleMatrix = createScaleMatrix(fMin, fMin);
        matrixCreateScaleMatrix.preTranslate(-rectF2.centerX(), -rectF2.centerY());
        matrixCreateScaleMatrix.postTranslate(rectF.centerX(), rectF.centerY());
        return Shapes_androidKt.transformed(roundedPolygon, matrixCreateScaleMatrix);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static Matrix createRotationMatrix(float f10) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f10);
        return matrix;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static Matrix createScaleMatrix(float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f11);
        return matrix;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static ShapeDrawable createShapeDrawable(@NonNull RoundedPolygon roundedPolygon) {
        return new ShapeDrawable(new PathShape(Shapes_androidKt.toPath(roundedPolygon), 1.0f, 1.0f));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static Matrix createSkewMatrix(float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.setSkew(f10, f11);
        return matrix;
    }

    @NonNull
    private static RoundedPolygon customPolygon(@NonNull List<VertexAndRounding> list, int i10, float f10, float f11, boolean z10) {
        ArrayList arrayList = new ArrayList();
        repeatAroundCenter(list, arrayList, i10, f10, f11, z10);
        return RoundedPolygonKt.RoundedPolygon(toVerticesXyArray(arrayList), CornerRounding.Unrounded, toRoundingsList(arrayList), f10, f11);
    }

    @NonNull
    private static RoundedPolygon getArch() {
        CornerRounding cornerRounding = CornerRounding.Unrounded;
        CornerRounding cornerRounding2 = CORNER_ROUND_100;
        CornerRounding cornerRounding3 = CORNER_ROUND_20;
        return Shapes_androidKt.transformed(RoundedPolygonKt.RoundedPolygon(4, 1.0f, 0.0f, 0.0f, cornerRounding, Arrays.asList(cornerRounding2, cornerRounding2, cornerRounding3, cornerRounding3)), createRotationMatrix(-135.0f));
    }

    @NonNull
    private static RoundedPolygon getArrow() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.892f), new CornerRounding(0.313f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(-0.216f, 1.05f), new CornerRounding(0.207f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.499f, -0.16f), new CornerRounding(0.215f, 1.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(1.225f, 1.06f), new CornerRounding(0.211f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getBoom() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.457f, 0.296f), new CornerRounding(0.007f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.5f, -0.051f), new CornerRounding(0.007f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 15, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getBun() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.796f, 0.5f), anonymousClass1));
        PointF pointF = new PointF(0.853f, 0.518f);
        CornerRounding cornerRounding = CORNER_ROUND_100;
        arrayList.add(new VertexAndRounding(pointF, cornerRounding, anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.992f, 0.631f), cornerRounding, anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.968f, 1.0f), cornerRounding, anonymousClass1));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, true);
    }

    @NonNull
    private static RoundedPolygon getBurst() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.5f, -0.006f), new CornerRounding(0.006f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.592f, 0.158f), new CornerRounding(0.006f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 12, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getCircle() {
        return ShapesKt.circle(RoundedPolygon.INSTANCE, 10);
    }

    @NonNull
    private static RoundedPolygon getClamShell() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.171f, 0.841f), new CornerRounding(0.159f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(-0.02f, 0.5f), new CornerRounding(0.14f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.17f, 0.159f), new CornerRounding(0.159f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getClover4() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.074f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.725f, -0.099f), new CornerRounding(0.476f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 4, 0.5f, 0.5f, true);
    }

    @NonNull
    private static RoundedPolygon getClover8() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.036f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.758f, -0.101f), new CornerRounding(0.209f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 8, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getCookie12() {
        return Shapes_androidKt.transformed(ShapesKt.star(RoundedPolygon.INSTANCE, 12, 1.0f, 0.8f, CORNER_ROUND_50), createRotationMatrix(-90.0f));
    }

    @NonNull
    private static RoundedPolygon getCookie4() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(1.237f, 1.236f), new CornerRounding(0.258f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.918f), new CornerRounding(0.233f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 4, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getCookie6() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.723f, 0.884f), new CornerRounding(0.394f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 1.099f), new CornerRounding(0.398f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 6, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getCookie7() {
        return Shapes_androidKt.transformed(ShapesKt.star(RoundedPolygon.INSTANCE, 7, 1.0f, 0.75f, CORNER_ROUND_50), createRotationMatrix(-90.0f));
    }

    @NonNull
    private static RoundedPolygon getCookie9() {
        return Shapes_androidKt.transformed(ShapesKt.star(RoundedPolygon.INSTANCE, 9, 1.0f, 0.8f, CORNER_ROUND_50), createRotationMatrix(-90.0f));
    }

    @NonNull
    private static RoundedPolygon getDiamond() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 1.096f), new CornerRounding(0.151f, 0.524f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.04f, 0.5f), new CornerRounding(0.159f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getFan() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 1.0f), new CornerRounding(0.148f, 0.417f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.0f, 1.0f), new CornerRounding(0.151f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.0f, 0.0f), new CornerRounding(0.148f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.978f, 0.02f), new CornerRounding(0.803f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getFlower() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.37f, 0.187f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.416f, 0.049f), new CornerRounding(0.381f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.479f, 0.0f), new CornerRounding(0.095f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 8, 0.5f, 0.5f, true);
    }

    @NonNull
    private static RoundedPolygon getGhostish() {
        ArrayList arrayList = new ArrayList();
        PointF pointF = new PointF(0.5f, 0.0f);
        CornerRounding cornerRounding = CORNER_ROUND_100;
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(pointF, cornerRounding, anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 0.0f), cornerRounding, anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 1.14f), new CornerRounding(0.254f, 0.106f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.575f, 0.906f), new CornerRounding(0.253f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, true);
    }

    @NonNull
    private static RoundedPolygon getHeart() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.268f), new CornerRounding(0.016f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.792f, -0.066f), new CornerRounding(0.958f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(1.064f, 0.276f), CORNER_ROUND_100, anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.501f, 0.946f), new CornerRounding(0.129f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, true);
    }

    @NonNull
    private static RoundedPolygon getPentagon() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VertexAndRounding(new PointF(0.5f, -0.009f), new CornerRounding(0.172f, 0.0f), null));
        return customPolygon(arrayList, 5, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getPill() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.961f, 0.039f), new CornerRounding(0.426f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(1.001f, 0.428f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 0.609f), CORNER_ROUND_100, anonymousClass1));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, true);
    }

    @NonNull
    private static RoundedPolygon getPixelCircle() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.704f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.704f, 0.065f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.843f, 0.065f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.843f, 0.148f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.926f, 0.148f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.926f, 0.296f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 0.296f), anonymousClass1));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, true);
    }

    @NonNull
    private static RoundedPolygon getPixelTriangle() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.11f, 0.5f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.113f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.287f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.287f, 0.087f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.421f, 0.087f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.421f, 0.17f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.56f, 0.17f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.56f, 0.265f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.674f, 0.265f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.675f, 0.344f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.789f, 0.344f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.789f, 0.439f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.888f, 0.439f), anonymousClass1));
        return customPolygon(arrayList, 1, 0.5f, 0.5f, true);
    }

    @NonNull
    private static RoundedPolygon getPuffy() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 0.053f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.545f, -0.04f), new CornerRounding(0.405f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.67f, -0.035f), new CornerRounding(0.426f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.717f, 0.066f), new CornerRounding(0.574f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.722f, 0.128f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.777f, 0.002f), new CornerRounding(0.36f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.914f, 0.149f), new CornerRounding(0.66f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.926f, 0.289f), new CornerRounding(0.66f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.881f, 0.346f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.94f, 0.344f), new CornerRounding(0.126f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(1.003f, 0.437f), new CornerRounding(0.255f, 0.0f), anonymousClass1));
        return Shapes_androidKt.transformed(customPolygon(arrayList, 2, 0.5f, 0.5f, true), createScaleMatrix(1.0f, 0.742f));
    }

    @NonNull
    private static RoundedPolygon getPuffyDiamond() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.87f, 0.13f), new CornerRounding(0.146f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.818f, 0.357f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(1.0f, 0.332f), new CornerRounding(0.853f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 4, 0.5f, 0.5f, true);
    }

    @NonNull
    private static RoundedPolygon getSemiCircle() {
        RoundedPolygon.Companion companion = RoundedPolygon.INSTANCE;
        CornerRounding cornerRounding = CornerRounding.Unrounded;
        CornerRounding cornerRounding2 = CORNER_ROUND_20;
        CornerRounding cornerRounding3 = CORNER_ROUND_100;
        return ShapesKt.rectangle(companion, 1.6f, 1.0f, cornerRounding, Arrays.asList(cornerRounding2, cornerRounding2, cornerRounding3, cornerRounding3), 0.0f, 0.0f);
    }

    @NonNull
    private static RoundedPolygon getSlantedSquare() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.926f, 0.97f), new CornerRounding(0.189f, 0.811f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(-0.021f, 0.967f), new CornerRounding(0.187f, 0.057f), anonymousClass1));
        return customPolygon(arrayList, 2, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getSoftBoom() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.733f, 0.454f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.839f, 0.437f), new CornerRounding(0.532f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.949f, 0.449f), new CornerRounding(0.439f, 1.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.998f, 0.478f), new CornerRounding(0.174f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 16, 0.5f, 0.5f, true);
    }

    @NonNull
    private static RoundedPolygon getSoftBurst() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.193f, 0.277f), new CornerRounding(0.053f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.176f, 0.055f), new CornerRounding(0.053f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 10, 0.5f, 0.5f, false);
    }

    @NonNull
    private static RoundedPolygon getSquare() {
        return ShapesKt.rectangle(RoundedPolygon.INSTANCE, 1.0f, 1.0f, CORNER_ROUND_30, null, 0.0f, 0.0f);
    }

    @NonNull
    private static RoundedPolygon getSunny() {
        return ShapesKt.star(RoundedPolygon.INSTANCE, 8, 1.0f, 0.8f, CORNER_ROUND_15);
    }

    @NonNull
    private static RoundedPolygon getTriangle(float f10) {
        return Shapes_androidKt.transformed(getTriangle(), createRotationMatrix(f10));
    }

    @NonNull
    private static RoundedPolygon getVerySunny() {
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        arrayList.add(new VertexAndRounding(new PointF(0.5f, 1.08f), new CornerRounding(0.085f, 0.0f), anonymousClass1));
        arrayList.add(new VertexAndRounding(new PointF(0.358f, 0.843f), new CornerRounding(0.085f, 0.0f), anonymousClass1));
        return customPolygon(arrayList, 8, 0.5f, 0.5f, false);
    }

    @NonNull
    private static List<CornerRounding> toRoundingsList(@NonNull List<VertexAndRounding> list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            arrayList.add(list.get(i10).rounding);
        }
        return arrayList;
    }

    private MaterialShapes() {
    }

    private static void repeatAroundCenter(@NonNull List<VertexAndRounding> list, @NonNull List<VertexAndRounding> list2, int i10, float f10, float f11, boolean z10) {
        boolean z11;
        int size;
        float f12;
        list2.clear();
        toRadial(list, f10, f11);
        float f13 = (float) (6.283185307179586d / ((double) i10));
        AnonymousClass1 anonymousClass1 = null;
        if (z10) {
            int i11 = i10 * 2;
            float f14 = f13 / 2.0f;
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < list.size(); i13++) {
                    if (i12 % 2 != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        size = (list.size() - 1) - i13;
                    } else {
                        size = i13;
                    }
                    VertexAndRounding vertexAndRounding = list.get(size);
                    if (size > 0 || !z11) {
                        float f15 = i12 * f14;
                        if (z11) {
                            f12 = (f14 - vertexAndRounding.vertex.x) + (list.get(0).vertex.x * 2.0f);
                        } else {
                            f12 = vertexAndRounding.vertex.x;
                        }
                        list2.add(new VertexAndRounding(new PointF(f15 + f12, vertexAndRounding.vertex.y), vertexAndRounding.rounding, anonymousClass1));
                    }
                }
            }
        } else {
            for (int i14 = 0; i14 < i10; i14++) {
                for (VertexAndRounding vertexAndRounding2 : list) {
                    list2.add(new VertexAndRounding(new PointF((i14 * f13) + vertexAndRounding2.vertex.x, vertexAndRounding2.vertex.y), vertexAndRounding2.rounding, anonymousClass1));
                }
            }
        }
        toCartesian(list2, f10, f11);
    }

    private static void toCartesian(@NonNull List<VertexAndRounding> list, float f10, float f11) {
        Iterator<VertexAndRounding> it = list.iterator();
        while (it.hasNext()) {
            it.next().toCartesian(f10, f11);
        }
    }

    private static void toRadial(@NonNull List<VertexAndRounding> list, float f10, float f11) {
        Iterator<VertexAndRounding> it = list.iterator();
        while (it.hasNext()) {
            it.next().toRadial(f10, f11);
        }
    }

    @NonNull
    private static float[] toVerticesXyArray(@NonNull List<VertexAndRounding> list) {
        float[] fArr = new float[list.size() * 2];
        for (int i10 = 0; i10 < list.size(); i10++) {
            int i11 = i10 * 2;
            fArr[i11] = list.get(i10).vertex.x;
            fArr[i11 + 1] = list.get(i10).vertex.y;
        }
        return fArr;
    }

    @NonNull
    private static RoundedPolygon getOval(float f10) {
        return Shapes_androidKt.transformed(getOval(), createRotationMatrix(f10));
    }

    @NonNull
    private static RoundedPolygon getGem(float f10) {
        return Shapes_androidKt.transformed(getGem(), createRotationMatrix(f10));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static RoundedPolygon normalize(@NonNull RoundedPolygon roundedPolygon, boolean z10) {
        return normalize(roundedPolygon, z10, new RectF(0.0f, 0.0f, 1.0f, 1.0f));
    }
}
