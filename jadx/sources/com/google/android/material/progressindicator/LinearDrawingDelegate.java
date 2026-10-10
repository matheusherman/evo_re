package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float adjustedWavelength;
    private int cachedWavelength;
    private float displayedAmplitude;
    private float displayedCornerRadius;
    private float displayedInnerCornerRadius;
    private float displayedTrackThickness;
    private boolean drawingDeterminateIndicator;
    Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> endPoints;

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    private float totalTrackLengthFraction;
    private float trackLength;

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint, float f10, float f11, float f12) {
        drawRoundedBlock(canvas, paint, pathPoint, f10, f11, f12, null, 0.0f, 0.0f, 0.0f, false);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    int getPreferredWidth() {
        return -1;
    }

    private void calculateDisplayedPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, @NonNull Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair, float f10, float f11, float f12, float f13) {
        int i10 = this.drawingDeterminateIndicator ? ((LinearProgressIndicatorSpec) this.spec).wavelengthDeterminate : ((LinearProgressIndicatorSpec) this.spec).wavelengthIndeterminate;
        if (pathMeasure == this.activePathMeasure && i10 != this.cachedWavelength) {
            this.cachedWavelength = i10;
            invalidateCachedPaths();
        }
        path.rewind();
        float f14 = (-this.trackLength) / 2.0f;
        boolean zHasWavyEffect = ((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator);
        if (zHasWavyEffect) {
            float f15 = this.trackLength;
            float f16 = this.adjustedWavelength;
            float f17 = f15 / f16;
            float f18 = f13 / f17;
            float f19 = f17 / (f17 + 1.0f);
            f10 = (f10 + f18) * f19;
            f11 = (f11 + f18) * f19;
            f14 -= f13 * f16;
        }
        float length = f10 * pathMeasure.getLength();
        float length2 = f11 * pathMeasure.getLength();
        pathMeasure.getSegment(length, length2, path, true);
        DrawingDelegate.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
        pathPoint.reset();
        pathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
        DrawingDelegate.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair.second;
        pathPoint2.reset();
        pathMeasure.getPosTan(length2, pathPoint2.posVec, pathPoint2.tanVec);
        this.transform.reset();
        this.transform.setTranslate(f14, 0.0f);
        pathPoint.translate(f14, 0.0f);
        pathPoint2.translate(f14, 0.0f);
        if (zHasWavyEffect) {
            float f20 = this.displayedAmplitude * f12;
            this.transform.postScale(1.0f, f20);
            pathPoint.scale(1.0f, f20);
            pathPoint2.scale(1.0f, f20);
        }
        path.transform(this.transform);
    }

    private void drawLine(@NonNull Canvas canvas, @NonNull Paint paint, float f10, float f11, @ColorInt int i10, @Px int i11, @Px int i12, float f12, float f13, boolean z10) {
        float f14;
        float fLerp;
        Paint paint2;
        Canvas canvas2;
        float fClamp = MathUtils.clamp(f10, 0.0f, 1.0f);
        float fClamp2 = MathUtils.clamp(f11, 0.0f, 1.0f);
        float fLerp2 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, fClamp);
        float fLerp3 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, fClamp2);
        int iClamp = (int) ((i11 * MathUtils.clamp(fLerp2, 0.0f, 0.01f)) / 0.01f);
        int iClamp2 = (int) ((i12 * (1.0f - MathUtils.clamp(fLerp3, 0.99f, 1.0f))) / 0.01f);
        float f15 = this.trackLength;
        int i13 = (int) ((fLerp2 * f15) + iClamp);
        int i14 = (int) ((fLerp3 * f15) - iClamp2);
        float f16 = this.displayedCornerRadius;
        float f17 = this.displayedInnerCornerRadius;
        if (f16 != f17) {
            float fMax = Math.max(f16, f17);
            float f18 = this.trackLength;
            float f19 = fMax / f18;
            float fLerp4 = com.google.android.material.math.MathUtils.lerp(this.displayedCornerRadius, this.displayedInnerCornerRadius, MathUtils.clamp(i13 / f18, 0.0f, f19) / f19);
            float f20 = this.displayedCornerRadius;
            float f21 = this.displayedInnerCornerRadius;
            float f22 = this.trackLength;
            fLerp = com.google.android.material.math.MathUtils.lerp(f20, f21, MathUtils.clamp((f22 - i14) / f22, 0.0f, f19) / f19);
            f14 = fLerp4;
        } else {
            f14 = f16;
            fLerp = f14;
        }
        float f23 = (-this.trackLength) / 2.0f;
        boolean z11 = ((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator) && z10 && f12 > 0.0f;
        if (i13 <= i14) {
            float f24 = i13 + f14;
            float f25 = i14 - fLerp;
            float f26 = f14 * 2.0f;
            float f27 = 2.0f * fLerp;
            paint.setColor(i10);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.displayedTrackThickness);
            ((DrawingDelegate.PathPoint) this.endPoints.first).reset();
            ((DrawingDelegate.PathPoint) this.endPoints.second).reset();
            ((DrawingDelegate.PathPoint) this.endPoints.first).translate(f24 + f23, 0.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.second).translate(f23 + f25, 0.0f);
            if (i13 == 0 && f25 + fLerp < f24 + f14) {
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair = this.endPoints;
                DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
                float f28 = this.displayedTrackThickness;
                drawRoundedBlock(canvas, paint, pathPoint, f26, f28, f14, (DrawingDelegate.PathPoint) pair.second, f27, f28, fLerp, true);
                return;
            }
            if (f24 - f14 > f25 - fLerp) {
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair2 = this.endPoints;
                DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair2.second;
                float f29 = this.displayedTrackThickness;
                drawRoundedBlock(canvas, paint, pathPoint2, f27, f29, fLerp, (DrawingDelegate.PathPoint) pair2.first, f26, f29, f14, false);
                return;
            }
            float f30 = fLerp;
            float f31 = f14;
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(((LinearProgressIndicatorSpec) this.spec).useStrokeCap() ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            if (z11) {
                paint2 = paint;
                PathMeasure pathMeasure = this.activePathMeasure;
                Path path = this.displayedActivePath;
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair3 = this.endPoints;
                float f32 = this.trackLength;
                calculateDisplayedPath(pathMeasure, path, pair3, f24 / f32, f25 / f32, f12, f13);
                canvas2 = canvas;
                canvas2.drawPath(this.displayedActivePath, paint2);
            } else {
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair4 = this.endPoints;
                Object obj = pair4.first;
                float f33 = ((DrawingDelegate.PathPoint) obj).posVec[0];
                float f34 = ((DrawingDelegate.PathPoint) obj).posVec[1];
                Object obj2 = pair4.second;
                canvas.drawLine(f33, f34, ((DrawingDelegate.PathPoint) obj2).posVec[0], ((DrawingDelegate.PathPoint) obj2).posVec[1], paint);
                paint2 = paint;
                canvas2 = canvas;
            }
            if (((LinearProgressIndicatorSpec) this.spec).useStrokeCap()) {
                return;
            }
            if (f24 > 0.0f && f31 > 0.0f) {
                drawRoundedBlock(canvas2, paint2, (DrawingDelegate.PathPoint) this.endPoints.first, f26, this.displayedTrackThickness, f31);
            }
            if (f25 >= this.trackLength || f30 <= 0.0f) {
                return;
            }
            drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.second, f27, this.displayedTrackThickness, f30);
        }
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint, float f10, float f11, float f12, @Nullable DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint2, float f13, float f14, float f15, boolean z10) {
        char c10;
        float f16;
        float f17;
        float fMin = Math.min(f11, this.displayedTrackThickness);
        float f18 = (-f10) / 2.0f;
        float f19 = (-fMin) / 2.0f;
        float f20 = f10 / 2.0f;
        float f21 = fMin / 2.0f;
        RectF rectF = new RectF(f18, f19, f20, f21);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pathPoint2 != null) {
            float fMin2 = Math.min(f14, this.displayedTrackThickness);
            float fMin3 = Math.min(f13 / 2.0f, (f15 * fMin2) / this.displayedTrackThickness);
            RectF rectF2 = new RectF();
            if (z10) {
                c10 = 0;
                float f22 = (pathPoint2.posVec[0] - fMin3) - (pathPoint.posVec[0] - f12);
                if (f22 > 0.0f) {
                    pathPoint2.translate((-f22) / 2.0f, 0.0f);
                    f17 = f13 + f22;
                } else {
                    f17 = f13;
                }
                rectF2.set(0.0f, f19, f20, f21);
            } else {
                c10 = 0;
                float f23 = (pathPoint2.posVec[0] + fMin3) - (pathPoint.posVec[0] + f12);
                if (f23 < 0.0f) {
                    pathPoint2.translate((-f23) / 2.0f, 0.0f);
                    f16 = f13 - f23;
                } else {
                    f16 = f13;
                }
                rectF2.set(f18, f19, 0.0f, f21);
                f17 = f16;
            }
            RectF rectF3 = new RectF((-f17) / 2.0f, (-fMin2) / 2.0f, f17 / 2.0f, fMin2 / 2.0f);
            float[] fArr = pathPoint2.posVec;
            canvas.translate(fArr[c10], fArr[1]);
            canvas.rotate(vectorToCanvasRotation(pathPoint2.tanVec));
            Path path = new Path();
            path.addRoundRect(rectF3, fMin3, fMin3, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.rotate(-vectorToCanvasRotation(pathPoint2.tanVec));
            float[] fArr2 = pathPoint2.posVec;
            canvas.translate(-fArr2[c10], -fArr2[1]);
            float[] fArr3 = pathPoint.posVec;
            canvas.translate(fArr3[c10], fArr3[1]);
            canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
            canvas.drawRect(rectF2, paint);
            canvas.drawRoundRect(rectF, f12, f12, paint);
        } else {
            float[] fArr4 = pathPoint.posVec;
            canvas.translate(fArr4[0], fArr4[1]);
            canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
            canvas.drawRoundRect(rectF, f12, f12, paint);
        }
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10, boolean z10, boolean z11) {
        if (this.trackLength != rect.width()) {
            this.trackLength = rect.width();
            invalidateCachedPaths();
        }
        float preferredHeight = getPreferredHeight();
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(0.0f, (rect.height() - preferredHeight) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f11 = this.trackLength / 2.0f;
        float f12 = preferredHeight / 2.0f;
        canvas.clipRect(-f11, -f12, f11, f12);
        S s10 = this.spec;
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) s10).trackThickness * f10;
        this.displayedCornerRadius = Math.min(((LinearProgressIndicatorSpec) s10).trackThickness / 2, ((LinearProgressIndicatorSpec) s10).getTrackCornerRadiusInPx()) * f10;
        S s11 = this.spec;
        this.displayedAmplitude = ((LinearProgressIndicatorSpec) s11).waveAmplitude * f10;
        this.displayedInnerCornerRadius = Math.min(((LinearProgressIndicatorSpec) s11).trackThickness / 2.0f, ((LinearProgressIndicatorSpec) s11).getTrackInnerCornerRadiusInPx()) * f10;
        if (z10 || z11) {
            if ((z10 && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (z11 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z10 || (z11 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3)) {
                canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.spec).trackThickness * (1.0f - f10)) / 2.0f);
            }
        }
        if (z11 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f10;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, int i10) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i10);
        this.drawingDeterminateIndicator = activeIndicator.isDeterminate;
        float f10 = activeIndicator.startFraction;
        float f11 = activeIndicator.endFraction;
        int i11 = activeIndicator.gapSize;
        drawLine(canvas, paint, f10, f11, iCompositeARGBWithAlpha, i11, i11, activeIndicator.amplitudeFraction, activeIndicator.phaseFraction, true);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    int getPreferredHeight() {
        S s10 = this.spec;
        return ((LinearProgressIndicatorSpec) s10).trackThickness + (((LinearProgressIndicatorSpec) s10).waveAmplitude * 2);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void invalidateCachedPaths() {
        this.cachedActivePath.rewind();
        if (((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            int i10 = this.drawingDeterminateIndicator ? ((LinearProgressIndicatorSpec) this.spec).wavelengthDeterminate : ((LinearProgressIndicatorSpec) this.spec).wavelengthIndeterminate;
            float f10 = this.trackLength;
            int i11 = (int) (f10 / i10);
            this.adjustedWavelength = f10 / i11;
            for (int i12 = 0; i12 <= i11; i12++) {
                int i13 = i12 * 2;
                float f11 = i13 + 1;
                this.cachedActivePath.cubicTo(i13 + 0.48f, 0.0f, f11 - 0.48f, 1.0f, f11, 1.0f);
                float f12 = i13 + 2;
                this.cachedActivePath.cubicTo(f11 + 0.48f, 1.0f, f12 - 0.48f, 0.0f, f12, 0.0f);
            }
            this.transform.reset();
            this.transform.setScale(this.adjustedWavelength / 2.0f, -2.0f);
            this.transform.postTranslate(0.0f, 1.0f);
            this.cachedActivePath.transform(this.transform);
        } else {
            this.cachedActivePath.lineTo(this.trackLength, 0.0f);
        }
        this.activePathMeasure.setPath(this.cachedActivePath, false);
    }

    LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.trackLength = 300.0f;
        this.endPoints = new Pair<>(new DrawingDelegate.PathPoint(), new DrawingDelegate.PathPoint());
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i10, @IntRange(from = 0, to = 255) int i11) {
        float fFloatValue;
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i10, i11);
        this.drawingDeterminateIndicator = false;
        if (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize > 0 && iCompositeARGBWithAlpha != 0) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(iCompositeARGBWithAlpha);
            S s10 = this.spec;
            if (((LinearProgressIndicatorSpec) s10).trackStopIndicatorPadding != null) {
                fFloatValue = ((LinearProgressIndicatorSpec) s10).trackStopIndicatorPadding.floatValue() + (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize / 2.0f);
            } else {
                fFloatValue = this.displayedTrackThickness / 2.0f;
            }
            DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint = new DrawingDelegate.PathPoint(new float[]{(this.trackLength / 2.0f) - fFloatValue, 0.0f}, new float[]{1.0f, 0.0f});
            S s11 = this.spec;
            drawRoundedBlock(canvas, paint, pathPoint, ((LinearProgressIndicatorSpec) s11).trackStopIndicatorSize, ((LinearProgressIndicatorSpec) s11).trackStopIndicatorSize, (this.displayedCornerRadius * ((LinearProgressIndicatorSpec) s11).trackStopIndicatorSize) / this.displayedTrackThickness);
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f10, float f11, int i10, int i11, @Px int i12) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i10, i11);
        this.drawingDeterminateIndicator = false;
        drawLine(canvas, paint, f10, f11, iCompositeARGBWithAlpha, i12, i12, 0.0f, 0.0f, false);
    }
}
