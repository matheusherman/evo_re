package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() { // from class: androidx.transition.MatrixUtils.1
        @Override // android.graphics.Matrix
        public boolean postRotate(float f10, float f11, float f12) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f10, float f11, float f12, float f13) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f10, float f11, float f12, float f13) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f10, float f11, float f12) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f10, float f11, float f12, float f13) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f10, float f11, float f12, float f13) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f10, float f11, float f12) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f10, float f11, float f12, float f13) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f10, float f11, float f12, float f13) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f10, float f11, float f12, float f13) {
            oops();
        }

        void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f10) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f10, float f11) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f10, float f11) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f10, float f11) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i10, float[] fArr2, int i11, int i12) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f10, float f11) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }
    };

    private MatrixUtils() {
    }
}
