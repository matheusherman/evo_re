package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
class ItemAlignmentFacetHelper {
    private static final Rect sRect = new Rect();

    private ItemAlignmentFacetHelper() {
    }

    static int getAlignmentPosition(View view, ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef, int i10) {
        View viewFindViewById;
        int height;
        int width;
        int width2;
        int width3;
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        int i11 = itemAlignmentDef.mViewId;
        if (i11 == 0 || (viewFindViewById = view.findViewById(i11)) == null) {
            viewFindViewById = view;
        }
        int opticalTopInset = itemAlignmentDef.mOffset;
        if (i10 == 0) {
            if (view.getLayoutDirection() == 1) {
                if (viewFindViewById == view) {
                    width2 = layoutParams.getOpticalWidth(viewFindViewById);
                } else {
                    width2 = viewFindViewById.getWidth();
                }
                int paddingLeft = width2 - opticalTopInset;
                if (itemAlignmentDef.mOffsetWithPadding) {
                    float f10 = itemAlignmentDef.mOffsetPercent;
                    if (f10 == 0.0f) {
                        paddingLeft -= viewFindViewById.getPaddingRight();
                    } else if (f10 == 100.0f) {
                        paddingLeft += viewFindViewById.getPaddingLeft();
                    }
                }
                if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                    if (viewFindViewById == view) {
                        width3 = layoutParams.getOpticalWidth(viewFindViewById);
                    } else {
                        width3 = viewFindViewById.getWidth();
                    }
                    paddingLeft -= (int) ((width3 * itemAlignmentDef.mOffsetPercent) / 100.0f);
                }
                if (view != viewFindViewById) {
                    Rect rect = sRect;
                    rect.right = paddingLeft;
                    ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect);
                    return rect.right + layoutParams.getOpticalRightInset();
                }
                return paddingLeft;
            }
            if (itemAlignmentDef.mOffsetWithPadding) {
                float f11 = itemAlignmentDef.mOffsetPercent;
                if (f11 == 0.0f) {
                    opticalTopInset += viewFindViewById.getPaddingLeft();
                } else if (f11 == 100.0f) {
                    opticalTopInset -= viewFindViewById.getPaddingRight();
                }
            }
            if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                if (viewFindViewById == view) {
                    width = layoutParams.getOpticalWidth(viewFindViewById);
                } else {
                    width = viewFindViewById.getWidth();
                }
                opticalTopInset += (int) ((width * itemAlignmentDef.mOffsetPercent) / 100.0f);
            }
            if (view != viewFindViewById) {
                Rect rect2 = sRect;
                rect2.left = opticalTopInset;
                ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect2);
                return rect2.left - layoutParams.getOpticalLeftInset();
            }
            return opticalTopInset;
        }
        if (itemAlignmentDef.mOffsetWithPadding) {
            float f12 = itemAlignmentDef.mOffsetPercent;
            if (f12 == 0.0f) {
                opticalTopInset += viewFindViewById.getPaddingTop();
            } else if (f12 == 100.0f) {
                opticalTopInset -= viewFindViewById.getPaddingBottom();
            }
        }
        if (itemAlignmentDef.mOffsetPercent != -1.0f) {
            if (viewFindViewById == view) {
                height = layoutParams.getOpticalHeight(viewFindViewById);
            } else {
                height = viewFindViewById.getHeight();
            }
            opticalTopInset += (int) ((height * itemAlignmentDef.mOffsetPercent) / 100.0f);
        }
        if (view != viewFindViewById) {
            Rect rect3 = sRect;
            rect3.top = opticalTopInset;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect3);
            opticalTopInset = rect3.top - layoutParams.getOpticalTopInset();
        }
        if (itemAlignmentDef.isAlignedToTextViewBaseLine()) {
            return opticalTopInset + viewFindViewById.getBaseline();
        }
        return opticalTopInset;
    }
}
