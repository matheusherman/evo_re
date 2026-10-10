package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class ChainRun extends WidgetRun {
    private int mChainStyle;
    ArrayList<WidgetRun> mWidgets;

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i10 = 0; i10 < this.mWidgets.size(); i10++) {
            WidgetRun widgetRun = this.mWidgets.get(i10);
            if (widgetRun.mWidget.getVisibility() != 8) {
                return widgetRun.mWidget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i10 = 0; i10 < this.mWidgets.size(); i10++) {
            this.mWidgets.get(i10).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.mRunGroup = null;
        Iterator<WidgetRun> it = this.mWidgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.mWidget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.mWidget = constraintWidget;
        this.mWidgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.mWidgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        for (WidgetRun widgetRun : this.mWidgets) {
            int i10 = this.orientation;
            if (i10 == 0) {
                widgetRun.mWidget.horizontalChainRun = this;
            } else if (i10 == 1) {
                widgetRun.mWidget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.mWidget.getParent()).isRtl() && this.mWidgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.mWidgets;
            this.mWidget = arrayList.get(arrayList.size() - 1).mWidget;
        }
        this.mChainStyle = this.orientation == 0 ? this.mWidget.getHorizontalChainStyle() : this.mWidget.getVerticalChainStyle();
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.mWidgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.mWidgets.get(size);
            if (widgetRun.mWidget.getVisibility() != 8) {
                return widgetRun.mWidget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Iterator<WidgetRun> it = this.mWidgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.mWidgets.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.mWidgets.get(0).mWidget;
        ConstraintWidget constraintWidget2 = this.mWidgets.get(size - 1).mWidget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.mWidgets.size();
        long wrapDimension = 0;
        for (int i10 = 0; i10 < size; i10++) {
            WidgetRun widgetRun = this.mWidgets.get(i10);
            wrapDimension = wrapDimension + ((long) widgetRun.start.mMargin) + widgetRun.getWrapDimension() + ((long) widgetRun.end.mMargin);
        }
        return wrapDimension;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        int size = this.mWidgets.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.mWidgets.get(i10).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        for (WidgetRun widgetRun : this.mWidgets) {
            sb2.append("<");
            sb2.append(widgetRun);
            sb2.append("> ");
        }
        return sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:90:0x0160  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int i10;
        int i11;
        boolean z10;
        float f10;
        int i12;
        int i13;
        int i14;
        float f11;
        int i15;
        int i16;
        int i17;
        float f12;
        int i18;
        int i19;
        boolean z11;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.mWidget.getParent();
            boolean zIsRtl = parent instanceof ConstraintWidgetContainer ? ((ConstraintWidgetContainer) parent).isRtl() : false;
            int i20 = this.end.value - this.start.value;
            int size = this.mWidgets.size();
            int i21 = 0;
            while (true) {
                i10 = -1;
                i11 = 8;
                if (i21 >= size) {
                    i21 = -1;
                    break;
                } else if (this.mWidgets.get(i21).mWidget.getVisibility() != 8) {
                    break;
                } else {
                    i21++;
                }
            }
            int i22 = size - 1;
            for (int i23 = i22; i23 >= 0; i23--) {
                if (this.mWidgets.get(i23).mWidget.getVisibility() != 8) {
                    i10 = i23;
                    break;
                }
            }
            int i24 = 0;
            while (true) {
                if (i24 >= 2) {
                    z10 = zIsRtl;
                    f10 = 0.0f;
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    f11 = 0.0f;
                    break;
                }
                int i25 = 0;
                i13 = 0;
                i14 = 0;
                int i26 = 0;
                f11 = 0.0f;
                while (i25 < size) {
                    WidgetRun widgetRun = this.mWidgets.get(i25);
                    if (widgetRun.mWidget.getVisibility() == i11) {
                        z11 = zIsRtl;
                    } else {
                        i26++;
                        if (i25 > 0 && i25 >= i21) {
                            i13 += widgetRun.start.mMargin;
                        }
                        DimensionDependency dimensionDependency = widgetRun.mDimension;
                        int i27 = dimensionDependency.value;
                        boolean z12 = widgetRun.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z12) {
                            int i28 = this.orientation;
                            if (i28 == 0 && !widgetRun.mWidget.mHorizontalRun.mDimension.resolved) {
                                return;
                            }
                            if (i28 == 1 && !widgetRun.mWidget.mVerticalRun.mDimension.resolved) {
                                return;
                            } else {
                                z11 = zIsRtl;
                            }
                        } else {
                            z11 = zIsRtl;
                            if (widgetRun.matchConstraintsType == 1 && i24 == 0) {
                                i27 = dimensionDependency.wrapValue;
                                i14++;
                            } else if (dimensionDependency.resolved) {
                            }
                            z12 = true;
                        }
                        if (z12) {
                            i13 += i27;
                        } else {
                            i14++;
                            float f13 = widgetRun.mWidget.mWeight[this.orientation];
                            if (f13 >= 0.0f) {
                                f11 += f13;
                            }
                        }
                        if (i25 < i22 && i25 < i10) {
                            i13 += -widgetRun.end.mMargin;
                        }
                    }
                    i25++;
                    zIsRtl = z11;
                    i11 = 8;
                }
                z10 = zIsRtl;
                f10 = 0.0f;
                if (i13 < i20 || i14 == 0) {
                    i12 = i26;
                    break;
                } else {
                    i24++;
                    zIsRtl = z10;
                    i11 = 8;
                }
            }
            int i29 = this.start.value;
            if (z10) {
                i29 = this.end.value;
            }
            if (i13 > i20) {
                i29 = z10 ? i29 + ((int) (((i13 - i20) / 2.0f) + 0.5f)) : i29 - ((int) (((i13 - i20) / 2.0f) + 0.5f));
            }
            if (i14 > 0) {
                float f14 = i20 - i13;
                int i30 = (int) ((f14 / i14) + 0.5f);
                int i31 = 0;
                int i32 = 0;
                while (i31 < size) {
                    WidgetRun widgetRun2 = this.mWidgets.get(i31);
                    int i33 = i29;
                    if (widgetRun2.mWidget.getVisibility() != 8 && widgetRun2.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        DimensionDependency dimensionDependency2 = widgetRun2.mDimension;
                        if (dimensionDependency2.resolved) {
                            i30 = i30;
                            i32 = i32;
                        } else {
                            int i34 = f11 > f10 ? (int) (((widgetRun2.mWidget.mWeight[this.orientation] * f14) / f11) + 0.5f) : i30;
                            if (this.orientation == 0) {
                                ConstraintWidget constraintWidget = widgetRun2.mWidget;
                                i18 = constraintWidget.mMatchConstraintMaxWidth;
                                i19 = constraintWidget.mMatchConstraintMinWidth;
                            } else {
                                ConstraintWidget constraintWidget2 = widgetRun2.mWidget;
                                i18 = constraintWidget2.mMatchConstraintMaxHeight;
                                i19 = constraintWidget2.mMatchConstraintMinHeight;
                            }
                            int i35 = i32;
                            int iMax = Math.max(i19, widgetRun2.matchConstraintsType == 1 ? Math.min(i34, dimensionDependency2.wrapValue) : i34);
                            if (i18 > 0) {
                                iMax = Math.min(i18, iMax);
                            }
                            if (iMax != i34) {
                                i32 = i35 + 1;
                                i34 = iMax;
                            } else {
                                i32 = i35;
                            }
                            widgetRun2.mDimension.resolve(i34);
                        }
                    } else {
                        i30 = i30;
                        i32 = i32;
                    }
                    i31++;
                    i29 = i33;
                    f14 = f14;
                    i30 = i30;
                }
                i15 = i29;
                int i36 = i32;
                f12 = 0.5f;
                if (i36 > 0) {
                    i14 -= i36;
                    i13 = 0;
                    for (int i37 = 0; i37 < size; i37++) {
                        WidgetRun widgetRun3 = this.mWidgets.get(i37);
                        if (widgetRun3.mWidget.getVisibility() != 8) {
                            if (i37 > 0 && i37 >= i21) {
                                i13 += widgetRun3.start.mMargin;
                            }
                            i13 += widgetRun3.mDimension.value;
                            if (i37 < i22 && i37 < i10) {
                                i13 += -widgetRun3.end.mMargin;
                            }
                        }
                    }
                }
                i17 = 2;
                if (this.mChainStyle == 2 && i36 == 0) {
                    i16 = 0;
                    this.mChainStyle = 0;
                } else {
                    i16 = 0;
                }
            } else {
                i15 = i29;
                i16 = 0;
                i17 = 2;
                f12 = 0.5f;
            }
            if (i13 > i20) {
                this.mChainStyle = i17;
            }
            if (i12 > 0 && i14 == 0 && i21 == i10) {
                this.mChainStyle = i17;
            }
            int i38 = this.mChainStyle;
            if (i38 == 1) {
                int i39 = i12 > 1 ? (i20 - i13) / (i12 - 1) : i12 == 1 ? (i20 - i13) / 2 : 0;
                if (i14 > 0) {
                    i39 = 0;
                }
                int i40 = i15;
                while (i16 < size) {
                    WidgetRun widgetRun4 = this.mWidgets.get(z10 ? size - (i16 + 1) : i16);
                    if (widgetRun4.mWidget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i40);
                        widgetRun4.end.resolve(i40);
                    } else {
                        if (i16 > 0) {
                            i40 = z10 ? i40 - i39 : i40 + i39;
                        }
                        if (i16 > 0 && i16 >= i21) {
                            i40 = z10 ? i40 - widgetRun4.start.mMargin : i40 + widgetRun4.start.mMargin;
                        }
                        if (z10) {
                            widgetRun4.end.resolve(i40);
                        } else {
                            widgetRun4.start.resolve(i40);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun4.mDimension;
                        int i41 = dimensionDependency3.value;
                        if (widgetRun4.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i41 = dimensionDependency3.wrapValue;
                        }
                        i40 = z10 ? i40 - i41 : i40 + i41;
                        if (z10) {
                            widgetRun4.start.resolve(i40);
                        } else {
                            widgetRun4.end.resolve(i40);
                        }
                        widgetRun4.mResolved = true;
                        if (i16 < i22 && i16 < i10) {
                            i40 = z10 ? i40 - (-widgetRun4.end.mMargin) : i40 + (-widgetRun4.end.mMargin);
                        }
                    }
                    i16++;
                }
                return;
            }
            if (i38 == 0) {
                int i42 = (i20 - i13) / (i12 + 1);
                if (i14 > 0) {
                    i42 = 0;
                }
                int i43 = i15;
                while (i16 < size) {
                    WidgetRun widgetRun5 = this.mWidgets.get(z10 ? size - (i16 + 1) : i16);
                    if (widgetRun5.mWidget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i43);
                        widgetRun5.end.resolve(i43);
                    } else {
                        int i44 = z10 ? i43 - i42 : i43 + i42;
                        if (i16 > 0 && i16 >= i21) {
                            i44 = z10 ? i44 - widgetRun5.start.mMargin : i44 + widgetRun5.start.mMargin;
                        }
                        if (z10) {
                            widgetRun5.end.resolve(i44);
                        } else {
                            widgetRun5.start.resolve(i44);
                        }
                        DimensionDependency dimensionDependency4 = widgetRun5.mDimension;
                        int iMin = dimensionDependency4.value;
                        if (widgetRun5.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            iMin = Math.min(iMin, dimensionDependency4.wrapValue);
                        }
                        i43 = z10 ? i44 - iMin : i44 + iMin;
                        if (z10) {
                            widgetRun5.start.resolve(i43);
                        } else {
                            widgetRun5.end.resolve(i43);
                        }
                        if (i16 < i22 && i16 < i10) {
                            i43 = z10 ? i43 - (-widgetRun5.end.mMargin) : i43 + (-widgetRun5.end.mMargin);
                        }
                    }
                    i16++;
                }
                return;
            }
            if (i38 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.mWidget.getHorizontalBiasPercent() : this.mWidget.getVerticalBiasPercent();
                if (z10) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i45 = (int) (((i20 - i13) * horizontalBiasPercent) + f12);
                if (i45 < 0 || i14 > 0) {
                    i45 = 0;
                }
                int i46 = z10 ? i15 - i45 : i15 + i45;
                while (i16 < size) {
                    WidgetRun widgetRun6 = this.mWidgets.get(z10 ? size - (i16 + 1) : i16);
                    if (widgetRun6.mWidget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i46);
                        widgetRun6.end.resolve(i46);
                    } else {
                        if (i16 > 0 && i16 >= i21) {
                            i46 = z10 ? i46 - widgetRun6.start.mMargin : i46 + widgetRun6.start.mMargin;
                        }
                        if (z10) {
                            widgetRun6.end.resolve(i46);
                        } else {
                            widgetRun6.start.resolve(i46);
                        }
                        DimensionDependency dimensionDependency5 = widgetRun6.mDimension;
                        int i47 = dimensionDependency5.value;
                        if (widgetRun6.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i47 = dimensionDependency5.wrapValue;
                        }
                        i46 = z10 ? i46 - i47 : i46 + i47;
                        if (z10) {
                            widgetRun6.start.resolve(i46);
                        } else {
                            widgetRun6.end.resolve(i46);
                        }
                        if (i16 < i22 && i16 < i10) {
                            i46 = z10 ? i46 - (-widgetRun6.end.mMargin) : i46 + (-widgetRun6.end.mMargin);
                        }
                    }
                    i16++;
                }
            }
        }
    }

    public ChainRun(ConstraintWidget constraintWidget, int i10) {
        super(constraintWidget);
        this.mWidgets = new ArrayList<>();
        this.orientation = i10;
        build();
    }
}
