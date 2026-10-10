package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;

    @Deprecated
    public float currentShadowAngle;

    @Deprecated
    public float endShadowAngle;

    @Deprecated
    public float endX;

    @Deprecated
    public float endY;
    private final List<PathOperation> operations = new ArrayList();
    private final List<ShadowCompatOperation> shadowCompatOperations = new ArrayList();

    @Deprecated
    public float startX;

    @Deprecated
    public float startY;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i10, @NonNull Canvas canvas) {
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), i10, this.operation.getStartAngle(), this.operation.getSweepAngle());
        }

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class InnerCornerShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation1;
        private final PathLineOperation operation2;
        private final float startX;
        private final float startY;

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
            int i11;
            float sweepAngle = getSweepAngle();
            if (sweepAngle > 0.0f) {
                return;
            }
            double dHypot = Math.hypot(this.operation1.f4517x - this.startX, this.operation1.f4518y - this.startY);
            double dHypot2 = Math.hypot(this.operation2.f4517x - this.operation1.f4517x, this.operation2.f4518y - this.operation1.f4518y);
            float fMin = (float) Math.min(i10, Math.min(dHypot, dHypot2));
            double d10 = fMin;
            double dTan = Math.tan(Math.toRadians((-sweepAngle) / 2.0f)) * d10;
            if (dHypot > dTan) {
                RectF rectF = new RectF(0.0f, 0.0f, (float) (dHypot - dTan), 0.0f);
                this.renderMatrix.set(matrix);
                this.renderMatrix.preTranslate(this.startX, this.startY);
                this.renderMatrix.preRotate(getStartAngle());
                i11 = i10;
                shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF, i11);
            } else {
                i11 = i10;
            }
            float f10 = fMin * 2.0f;
            RectF rectF2 = new RectF(0.0f, 0.0f, f10, f10);
            this.renderMatrix.set(matrix);
            this.renderMatrix.preTranslate(this.operation1.f4517x, this.operation1.f4518y);
            this.renderMatrix.preRotate(getStartAngle());
            this.renderMatrix.preTranslate((float) ((-dTan) - d10), (-2.0f) * fMin);
            shadowRenderer.drawInnerCornerShadow(canvas, this.renderMatrix, rectF2, (int) fMin, 450.0f, sweepAngle, new float[]{(float) (d10 + dTan), f10});
            if (dHypot2 > dTan) {
                RectF rectF3 = new RectF(0.0f, 0.0f, (float) (dHypot2 - dTan), 0.0f);
                this.renderMatrix.set(matrix);
                this.renderMatrix.preTranslate(this.operation1.f4517x, this.operation1.f4518y);
                this.renderMatrix.preRotate(getEndAngle());
                this.renderMatrix.preTranslate((float) dTan, 0.0f);
                shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF3, i11);
            }
        }

        float getEndAngle() {
            return (float) Math.toDegrees(Math.atan((this.operation2.f4518y - this.operation1.f4518y) / (this.operation2.f4517x - this.operation1.f4517x)));
        }

        float getStartAngle() {
            return (float) Math.toDegrees(Math.atan((this.operation1.f4518y - this.startY) / (this.operation1.f4517x - this.startX)));
        }

        public InnerCornerShadowOperation(PathLineOperation pathLineOperation, PathLineOperation pathLineOperation2, float f10, float f11) {
            this.operation1 = pathLineOperation;
            this.operation2 = pathLineOperation2;
            this.startX = f10;
            this.startY = f11;
        }

        float getSweepAngle() {
            float endAngle = ((getEndAngle() - getStartAngle()) + 360.0f) % 360.0f;
            if (endAngle <= ShapePath.ANGLE_LEFT) {
                return endAngle;
            }
            return endAngle - 360.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i10, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.operation.f4518y - this.startY, this.operation.f4517x - this.startX), 0.0f);
            this.renderMatrix.set(matrix);
            this.renderMatrix.preTranslate(this.startX, this.startY);
            this.renderMatrix.preRotate(getAngle());
            shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF, i10);
        }

        float getAngle() {
            return (float) Math.toDegrees(Math.atan((this.operation.f4518y - this.startY) / (this.operation.f4517x - this.startX)));
        }

        public LineShadowOperation(PathLineOperation pathLineOperation, float f10, float f11) {
            this.operation = pathLineOperation;
            this.startX = f10;
            this.startY = f11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = new RectF();

        @Deprecated
        public float bottom;

        @Deprecated
        public float left;

        @Deprecated
        public float right;

        @Deprecated
        public float startAngle;

        @Deprecated
        public float sweepAngle;

        @Deprecated
        public float top;

        /* JADX INFO: Access modifiers changed from: private */
        public float getBottom() {
            return this.bottom;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getLeft() {
            return this.left;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getRight() {
            return this.right;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getStartAngle() {
            return this.startAngle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getSweepAngle() {
            return this.sweepAngle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getTop() {
            return this.top;
        }

        private void setBottom(float f10) {
            this.bottom = f10;
        }

        private void setLeft(float f10) {
            this.left = f10;
        }

        private void setRight(float f10) {
            this.right = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartAngle(float f10) {
            this.startAngle = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSweepAngle(float f10) {
            this.sweepAngle = f10;
        }

        private void setTop(float f10) {
            this.top = f10;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF2 = rectF;
            rectF2.set(getLeft(), getTop(), getRight(), getBottom());
            path.arcTo(rectF2, getStartAngle(), getSweepAngle(), false);
            path.transform(matrix);
        }

        public PathArcOperation(float f10, float f11, float f12, float f13) {
            setLeft(f10);
            setTop(f11);
            setRight(f12);
            setBottom(f13);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        private float getControlX1() {
            return this.controlX1;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX1(float f10) {
            this.controlX1 = f10;
        }

        private void setControlX2(float f10) {
            this.controlX2 = f10;
        }

        private void setControlY1(float f10) {
            this.controlY1 = f10;
        }

        private void setControlY2(float f10) {
            this.controlY2 = f10;
        }

        private void setEndX(float f10) {
            this.endX = f10;
        }

        private void setEndY(float f10) {
            this.endY = f10;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path.transform(matrix);
        }

        public PathCubicOperation(float f10, float f11, float f12, float f13, float f14, float f15) {
            setControlX1(f10);
            setControlY1(f11);
            setControlX2(f12);
            setControlY2(f13);
            setEndX(f14);
            setEndY(f15);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class PathLineOperation extends PathOperation {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private float f4517x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private float f4518y;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f4517x, this.f4518y);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class PathOperation {
        protected final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class PathQuadOperation extends PathOperation {

        @Deprecated
        public float controlX;

        @Deprecated
        public float controlY;

        @Deprecated
        public float endX;

        @Deprecated
        public float endY;

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlX(float f10) {
            this.controlX = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlY(float f10) {
            this.controlY = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndX(float f10) {
            this.endX = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndY(float f10) {
            this.endY = f10;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    public void lineTo(float f10, float f11) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f4517x = f10;
        pathLineOperation.f4518y = f11;
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + ANGLE_UP, lineShadowOperation.getAngle() + ANGLE_UP);
        setEndX(f10);
        setEndY(f11);
    }

    public void reset(float f10, float f11) {
        reset(f10, f11, ANGLE_UP, 0.0f);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = new Matrix();
        final Matrix renderMatrix = new Matrix();

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas);

        public final void draw(ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
            draw(IDENTITY_MATRIX, shadowRenderer, i10, canvas);
        }

        ShadowCompatOperation() {
        }
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float f10) {
        this.currentShadowAngle = f10;
    }

    private void setEndShadowAngle(float f10) {
        this.endShadowAngle = f10;
    }

    private void setEndX(float f10) {
        this.endX = f10;
    }

    private void setEndY(float f10) {
        this.endY = f10;
    }

    private void setStartX(float f10) {
        this.startX = f10;
    }

    private void setStartY(float f10) {
        this.startY = f10;
    }

    public void addArc(float f10, float f11, float f12, float f13, float f14, float f15) {
        PathArcOperation pathArcOperation = new PathArcOperation(f10, f11, f12, f13);
        pathArcOperation.setStartAngle(f14);
        pathArcOperation.setSweepAngle(f15);
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f16 = f14 + f15;
        boolean z10 = f15 < 0.0f;
        if (z10) {
            f14 = (f14 + ANGLE_LEFT) % 360.0f;
        }
        addShadowCompatOperation(arcShadowOperation, f14, z10 ? (ANGLE_LEFT + f16) % 360.0f : f16);
        double d10 = f16;
        setEndX(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        setEndY(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.operations.get(i10).applyToPath(matrix, path);
        }
    }

    boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    public void cubicToPoint(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.operations.add(new PathCubicOperation(f10, f11, f12, f13, f14, f15));
        this.containsIncompatibleShadowOp = true;
        setEndX(f14);
        setEndY(f15);
    }

    float getEndX() {
        return this.endX;
    }

    float getEndY() {
        return this.endY;
    }

    float getStartX() {
        return this.startX;
    }

    float getStartY() {
        return this.startY;
    }

    public void quadToPoint(float f10, float f11, float f12, float f13) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.setControlX(f10);
        pathQuadOperation.setControlY(f11);
        pathQuadOperation.setEndX(f12);
        pathQuadOperation.setEndY(f13);
        this.operations.add(pathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f12);
        setEndY(f13);
    }

    public void reset(float f10, float f11, float f12, float f13) {
        setStartX(f10);
        setStartY(f11);
        setEndX(f10);
        setEndY(f11);
        setCurrentShadowAngle(f12);
        setEndShadowAngle((f12 + f13) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    private void addConnectingShadowIfNecessary(float f10) {
        if (getCurrentShadowAngle() != f10) {
            float currentShadowAngle = ((f10 - getCurrentShadowAngle()) + 360.0f) % 360.0f;
            if (currentShadowAngle > ANGLE_LEFT) {
                return;
            }
            PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
            pathArcOperation.setStartAngle(getCurrentShadowAngle());
            pathArcOperation.setSweepAngle(currentShadowAngle);
            this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
            setCurrentShadowAngle(f10);
        }
    }

    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float f10, float f11) {
        addConnectingShadowIfNecessary(f10);
        this.shadowCompatOperations.add(shadowCompatOperation);
        setCurrentShadowAngle(f11);
    }

    @NonNull
    ShadowCompatOperation createShadowCompatOperation(Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.shadowCompatOperations);
        return new ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
            @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
            public void draw(Matrix matrix3, ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ShadowCompatOperation) it.next()).draw(matrix2, shadowRenderer, i10, canvas);
                }
            }
        };
    }

    public ShapePath(float f10, float f11) {
        reset(f10, f11);
    }

    public void lineTo(float f10, float f11, float f12, float f13) {
        if ((Math.abs(f10 - getEndX()) < 0.001f && Math.abs(f11 - getEndY()) < 0.001f) || (Math.abs(f10 - f12) < 0.001f && Math.abs(f11 - f13) < 0.001f)) {
            lineTo(f12, f13);
            return;
        }
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f4517x = f10;
        pathLineOperation.f4518y = f11;
        this.operations.add(pathLineOperation);
        PathLineOperation pathLineOperation2 = new PathLineOperation();
        pathLineOperation2.f4517x = f12;
        pathLineOperation2.f4518y = f13;
        this.operations.add(pathLineOperation2);
        InnerCornerShadowOperation innerCornerShadowOperation = new InnerCornerShadowOperation(pathLineOperation, pathLineOperation2, getEndX(), getEndY());
        if (innerCornerShadowOperation.getSweepAngle() > 0.0f) {
            lineTo(f10, f11);
            lineTo(f12, f13);
        } else {
            addShadowCompatOperation(innerCornerShadowOperation, innerCornerShadowOperation.getStartAngle() + ANGLE_UP, innerCornerShadowOperation.getEndAngle() + ANGLE_UP);
            setEndX(f12);
            setEndY(f13);
        }
    }
}
