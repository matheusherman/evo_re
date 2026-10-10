package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i10) {
        int i11;
        ChainHead[] chainHeadArr;
        int i12;
        if (i10 == 0) {
            i11 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i12 = 0;
        } else {
            i11 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i12 = 2;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            ChainHead chainHead = chainHeadArr[i13];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i10, i12, chainHead);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x016d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0173  */
    /* JADX WARN: Code duplicated, block: B:104:0x0194  */
    /* JADX WARN: Code duplicated, block: B:16:0x0033 A[PHI: r15 r16
      0x0033: PHI (r15v26 boolean) = (r15v1 boolean), (r15v28 boolean) binds: [B:26:0x0047, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0033: PHI (r16v5 boolean) = (r16v1 boolean), (r16v7 boolean) binds: [B:26:0x0047, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:177:0x02de  */
    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[PHI: r15 r16
      0x0035: PHI (r15v3 boolean) = (r15v1 boolean), (r15v28 boolean) binds: [B:26:0x0047, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r16v3 boolean) = (r16v1 boolean), (r16v7 boolean) binds: [B:26:0x0047, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:286:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:289:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:290:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:293:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:294:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:296:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:298:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:301:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:98:0x016a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [androidx.constraintlayout.core.LinearSystem] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.constraintlayout.core.LinearSystem] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r5v17, types: [androidx.constraintlayout.core.SolverVariable] */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i10, int i11, ChainHead chainHead) {
        boolean z10;
        boolean z11;
        boolean z12;
        float f10;
        ?? r10;
        LinearSystem linearSystem2;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        int i12;
        ConstraintAnchor[] constraintAnchorArr;
        int i13;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable4;
        ConstraintAnchor constraintAnchor5;
        Object obj;
        float f11;
        int size;
        float f12;
        float f13;
        ConstraintAnchor constraintAnchor6;
        int i14;
        int i15 = i10;
        ConstraintWidget constraintWidget = chainHead.mFirst;
        ConstraintWidget constraintWidget2 = chainHead.mLast;
        ConstraintWidget constraintWidget3 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget4 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget5 = chainHead.mHead;
        float f14 = chainHead.mTotalWeight;
        boolean z13 = constraintWidgetContainer.mListDimensionBehaviors[i15] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i15 == 0) {
            int i16 = constraintWidget5.mHorizontalChainStyle;
            z10 = i16 == 0;
            z11 = i16 == 1;
            if (i16 == 2) {
                z12 = true;
            } else {
                z12 = false;
            }
        } else {
            int i17 = constraintWidget5.mVerticalChainStyle;
            z10 = i17 == 0;
            z11 = i17 == 1;
            if (i17 == 2) {
                z12 = true;
            } else {
                z12 = false;
            }
        }
        ?? r14 = constraintWidget;
        boolean z14 = false;
        while (true) {
            f10 = f14;
            Object obj2 = null;
            if (z14) {
                break;
            }
            ConstraintAnchor constraintAnchor7 = r14.mListAnchors[i11];
            int i18 = z12 ? 1 : 4;
            int margin = constraintAnchor7.getMargin();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = r14.mListDimensionBehaviors[i15];
            boolean z15 = z13;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z16 = dimensionBehaviour == dimensionBehaviour2 && r14.mResolvedMatchConstraintDefault[i15] == 0;
            boolean z17 = z12;
            ConstraintAnchor constraintAnchor8 = constraintAnchor7.mTarget;
            if (constraintAnchor8 != null && r14 != constraintWidget) {
                margin += constraintAnchor8.getMargin();
            }
            int i19 = margin;
            if (z17 && r14 != constraintWidget && r14 != constraintWidget3) {
                i18 = 8;
            }
            boolean z18 = z16;
            ConstraintAnchor constraintAnchor9 = constraintAnchor7.mTarget;
            if (constraintAnchor9 != null) {
                if (r14 == constraintWidget3) {
                    linearSystem.addGreaterThan(constraintAnchor7.mSolverVariable, constraintAnchor9.mSolverVariable, i19, 6);
                } else {
                    linearSystem.addGreaterThan(constraintAnchor7.mSolverVariable, constraintAnchor9.mSolverVariable, i19, 8);
                }
                if (z18 && !z17) {
                    i18 = 5;
                }
                linearSystem.addEquality(constraintAnchor7.mSolverVariable, constraintAnchor7.mTarget.mSolverVariable, i19, (r14 == constraintWidget3 && z17 && r14.isInBarrier(i15)) ? 5 : i18);
            } else {
                z14 = z14;
                z10 = z10;
            }
            if (z15) {
                if (r14.getVisibility() == 8 || r14.mListDimensionBehaviors[i15] != dimensionBehaviour2) {
                    i14 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr2 = r14.mListAnchors;
                    i14 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr2[i11 + 1].mSolverVariable, constraintAnchorArr2[i11].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r14.mListAnchors[i11].mSolverVariable, constraintWidgetContainer.mListAnchors[i11].mSolverVariable, i14, 8);
            }
            ConstraintAnchor constraintAnchor10 = r14.mListAnchors[i11 + 1].mTarget;
            if (constraintAnchor10 != null) {
                ConstraintWidget constraintWidget6 = constraintAnchor10.mOwner;
                ConstraintAnchor constraintAnchor11 = constraintWidget6.mListAnchors[i11].mTarget;
                if (constraintAnchor11 != null && constraintAnchor11.mOwner == r14) {
                    obj2 = constraintWidget6;
                }
            }
            if (obj2 != null) {
                r14 = obj2;
                z14 = z14;
            } else {
                z14 = true;
            }
            f14 = f10;
            z13 = z15;
            z12 = z17;
            z10 = z10;
            r14 = r14;
        }
        boolean z19 = z13;
        boolean z20 = z12;
        boolean z21 = z10;
        if (constraintWidget4 != null) {
            int i20 = i11 + 1;
            if (constraintWidget2.mListAnchors[i20].mTarget != null) {
                ConstraintAnchor constraintAnchor12 = constraintWidget4.mListAnchors[i20];
                if (constraintWidget4.mListDimensionBehaviors[i15] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget4.mResolvedMatchConstraintDefault[i15] == 0 && !z20) {
                    ConstraintAnchor constraintAnchor13 = constraintAnchor12.mTarget;
                    if (constraintAnchor13.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, -constraintAnchor12.getMargin(), 5);
                    } else if (z20) {
                        constraintAnchor6 = constraintAnchor12.mTarget;
                        if (constraintAnchor6.mOwner == constraintWidgetContainer) {
                            linearSystem.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor6.mSolverVariable, -constraintAnchor12.getMargin(), 4);
                        }
                    }
                } else if (z20) {
                    constraintAnchor6 = constraintAnchor12.mTarget;
                    if (constraintAnchor6.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor6.mSolverVariable, -constraintAnchor12.getMargin(), 4);
                    }
                }
                linearSystem.addLowerThan(constraintAnchor12.mSolverVariable, constraintWidget2.mListAnchors[i20].mTarget.mSolverVariable, -constraintAnchor12.getMargin(), 6);
            }
        }
        if (z19) {
            int i21 = i11 + 1;
            SolverVariable solverVariable5 = constraintWidgetContainer.mListAnchors[i21].mSolverVariable;
            ConstraintAnchor constraintAnchor14 = constraintWidget2.mListAnchors[i21];
            linearSystem.addGreaterThan(solverVariable5, constraintAnchor14.mSolverVariable, constraintAnchor14.getMargin(), 8);
        }
        ArrayList<ConstraintWidget> arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f15 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f10 : chainHead.mWidgetsMatchCount;
            float f16 = 0.0f;
            ConstraintWidget constraintWidget7 = null;
            int i22 = 0;
            float f17 = 0.0f;
            while (i22 < size) {
                ConstraintWidget constraintWidget8 = arrayList.get(i22);
                float f18 = constraintWidget8.mWeight[i15];
                if (f18 < f16) {
                    if (chainHead.mHasComplexMatchWeights) {
                        ConstraintAnchor[] constraintAnchorArr3 = constraintWidget8.mListAnchors;
                        linearSystem.addEquality(constraintAnchorArr3[i11 + 1].mSolverVariable, constraintAnchorArr3[i11].mSolverVariable, 0, 4);
                    } else {
                        f12 = 0.0f;
                        f13 = 1.0f;
                    }
                    arrayList = arrayList;
                    i22++;
                    arrayList = arrayList;
                    f16 = 0.0f;
                } else {
                    f12 = 0.0f;
                    f13 = f18;
                }
                if (f13 == f12) {
                    ConstraintAnchor[] constraintAnchorArr4 = constraintWidget8.mListAnchors;
                    linearSystem.addEquality(constraintAnchorArr4[i11 + 1].mSolverVariable, constraintAnchorArr4[i11].mSolverVariable, 0, 8);
                    arrayList = arrayList;
                } else {
                    if (constraintWidget7 != null) {
                        ConstraintAnchor[] constraintAnchorArr5 = constraintWidget7.mListAnchors;
                        SolverVariable solverVariable6 = constraintAnchorArr5[i11].mSolverVariable;
                        int i23 = i11 + 1;
                        SolverVariable solverVariable7 = constraintAnchorArr5[i23].mSolverVariable;
                        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget8.mListAnchors;
                        SolverVariable solverVariable8 = constraintAnchorArr6[i11].mSolverVariable;
                        SolverVariable solverVariable9 = constraintAnchorArr6[i23].mSolverVariable;
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f17, f15, f13, solverVariable6, solverVariable7, solverVariable8, solverVariable9);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    }
                    constraintWidget7 = constraintWidget8;
                    f17 = f13;
                }
                i22++;
                arrayList = arrayList;
                f16 = 0.0f;
            }
        }
        if (constraintWidget3 != null && (constraintWidget3 == constraintWidget4 || z20)) {
            ConstraintAnchor constraintAnchor15 = constraintWidget.mListAnchors[i11];
            int i24 = i11 + 1;
            ConstraintAnchor constraintAnchor16 = constraintWidget2.mListAnchors[i24];
            ConstraintAnchor constraintAnchor17 = constraintAnchor15.mTarget;
            SolverVariable solverVariable10 = constraintAnchor17 != null ? constraintAnchor17.mSolverVariable : null;
            ConstraintAnchor constraintAnchor18 = constraintAnchor16.mTarget;
            SolverVariable solverVariable11 = constraintAnchor18 != null ? constraintAnchor18.mSolverVariable : null;
            ConstraintAnchor constraintAnchor19 = constraintWidget3.mListAnchors[i11];
            if (constraintWidget4 != null) {
                constraintAnchor16 = constraintWidget4.mListAnchors[i24];
            }
            if (solverVariable10 != null && solverVariable11 != null) {
                if (i15 == 0) {
                    f11 = constraintWidget5.mHorizontalBiasPercent;
                } else {
                    f11 = constraintWidget5.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor19.mSolverVariable, solverVariable10, constraintAnchor19.getMargin(), f11, solverVariable11, constraintAnchor16.mSolverVariable, constraintAnchor16.getMargin(), 7);
            }
        } else {
            if (!z21 || constraintWidget3 == null) {
                if (z11 && constraintWidget3 != null) {
                    int i25 = chainHead.mWidgetsMatchCount;
                    boolean z22 = i25 > 0 && chainHead.mWidgetsCount == i25;
                    ConstraintWidget constraintWidget9 = constraintWidget3;
                    ConstraintWidget constraintWidget10 = constraintWidget9;
                    while (constraintWidget9 != null) {
                        ConstraintWidget constraintWidget11 = constraintWidget9.mNextChainWidget[i10];
                        while (constraintWidget11 != null && constraintWidget11.getVisibility() == 8) {
                            constraintWidget11 = constraintWidget11.mNextChainWidget[i10];
                        }
                        if (constraintWidget9 != constraintWidget3 && constraintWidget9 != constraintWidget4 && constraintWidget11 != null) {
                            if (constraintWidget11 == constraintWidget4) {
                                constraintWidget11 = null;
                            }
                            ConstraintAnchor constraintAnchor20 = constraintWidget9.mListAnchors[i11];
                            SolverVariable solverVariable12 = constraintAnchor20.mSolverVariable;
                            ConstraintAnchor constraintAnchor21 = constraintAnchor20.mTarget;
                            if (constraintAnchor21 != null) {
                                SolverVariable solverVariable13 = constraintAnchor21.mSolverVariable;
                            }
                            int i26 = i11 + 1;
                            SolverVariable solverVariable14 = constraintWidget10.mListAnchors[i26].mSolverVariable;
                            int margin2 = constraintAnchor20.getMargin();
                            int margin3 = constraintWidget9.mListAnchors[i26].getMargin();
                            if (constraintWidget11 != null) {
                                constraintAnchor = constraintWidget11.mListAnchors[i11];
                                solverVariable = constraintAnchor.mSolverVariable;
                                ConstraintAnchor constraintAnchor22 = constraintAnchor.mTarget;
                                solverVariable2 = constraintAnchor22 != null ? constraintAnchor22.mSolverVariable : null;
                            } else {
                                constraintAnchor = constraintWidget4.mListAnchors[i11];
                                solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                                solverVariable2 = constraintWidget9.mListAnchors[i26].mSolverVariable;
                            }
                            if (constraintAnchor != null) {
                                margin3 += constraintAnchor.getMargin();
                            }
                            int margin4 = margin2 + constraintWidget10.mListAnchors[i26].getMargin();
                            int i27 = z22 ? 8 : 4;
                            if (solverVariable12 != null && solverVariable14 != null && solverVariable != null && solverVariable2 != null) {
                                linearSystem.addCentering(solverVariable12, solverVariable14, margin4, 0.5f, solverVariable, solverVariable2, margin3, i27);
                            }
                            constraintWidget11 = constraintWidget11;
                        }
                        if (constraintWidget9.getVisibility() != 8) {
                            constraintWidget10 = constraintWidget9;
                        }
                        constraintWidget9 = constraintWidget11;
                    }
                    ConstraintAnchor constraintAnchor23 = constraintWidget3.mListAnchors[i11];
                    ConstraintAnchor constraintAnchor24 = constraintWidget.mListAnchors[i11].mTarget;
                    int i28 = i11 + 1;
                    ConstraintAnchor constraintAnchor25 = constraintWidget4.mListAnchors[i28];
                    ConstraintAnchor constraintAnchor26 = constraintWidget2.mListAnchors[i28].mTarget;
                    if (constraintAnchor24 == null) {
                        r10 = linearSystem;
                    } else {
                        if (constraintWidget3 != constraintWidget4) {
                            linearSystem.addEquality(constraintAnchor23.mSolverVariable, constraintAnchor24.mSolverVariable, constraintAnchor23.getMargin(), 5);
                        } else if (constraintAnchor26 != null) {
                            linearSystem2 = linearSystem;
                            linearSystem2.addCentering(constraintAnchor23.mSolverVariable, constraintAnchor24.mSolverVariable, constraintAnchor23.getMargin(), 0.5f, constraintAnchor25.mSolverVariable, constraintAnchor26.mSolverVariable, constraintAnchor25.getMargin(), 5);
                        }
                        r10 = linearSystem;
                    }
                    if (constraintAnchor26 != null && constraintWidget3 != constraintWidget4) {
                        r10.addEquality(constraintAnchor25.mSolverVariable, constraintAnchor26.mSolverVariable, -constraintAnchor25.getMargin(), 5);
                    }
                }
                if ((z21 && !z11) || constraintWidget3 == null || constraintWidget3 == constraintWidget4) {
                    return;
                }
                constraintAnchorArr = constraintWidget3.mListAnchors;
                ConstraintAnchor constraintAnchor27 = constraintAnchorArr[i11];
                if (constraintWidget4 == null) {
                    constraintWidget4 = constraintWidget3;
                }
                i13 = i11 + 1;
                constraintAnchor3 = constraintWidget4.mListAnchors[i13];
                constraintAnchor4 = constraintAnchor27.mTarget;
                if (constraintAnchor4 != null) {
                    solverVariable4 = constraintAnchor4.mSolverVariable;
                } else {
                    solverVariable4 = null;
                }
                constraintAnchor5 = constraintAnchor3.mTarget;
                if (constraintAnchor5 != null) {
                    obj = constraintAnchor5.mSolverVariable;
                } else {
                    obj = null;
                }
                if (constraintWidget2 != constraintWidget4) {
                    ConstraintAnchor constraintAnchor28 = constraintWidget2.mListAnchors[i13].mTarget;
                    obj = constraintAnchor28 != null ? constraintAnchor28.mSolverVariable : null;
                }
                if (constraintWidget3 == constraintWidget4) {
                    constraintAnchor3 = constraintAnchorArr[i13];
                }
                if (solverVariable4 != null || obj == null) {
                }
                r10.addCentering(constraintAnchor27.mSolverVariable, solverVariable4, constraintAnchor27.getMargin(), 0.5f, obj, constraintAnchor3.mSolverVariable, constraintWidget4.mListAnchors[i13].getMargin(), 5);
                return;
            }
            int i29 = chainHead.mWidgetsMatchCount;
            boolean z23 = i29 > 0 && chainHead.mWidgetsCount == i29;
            ConstraintWidget constraintWidget12 = constraintWidget3;
            ConstraintWidget constraintWidget13 = constraintWidget12;
            while (constraintWidget12 != null) {
                ConstraintWidget constraintWidget14 = constraintWidget12.mNextChainWidget[i15];
                while (constraintWidget14 != null && constraintWidget14.getVisibility() == 8) {
                    constraintWidget14 = constraintWidget14.mNextChainWidget[i15];
                }
                if (constraintWidget14 != null || constraintWidget12 == constraintWidget4) {
                    ConstraintAnchor constraintAnchor29 = constraintWidget12.mListAnchors[i11];
                    SolverVariable solverVariable15 = constraintAnchor29.mSolverVariable;
                    ConstraintAnchor constraintAnchor30 = constraintAnchor29.mTarget;
                    SolverVariable solverVariable16 = constraintAnchor30 != null ? constraintAnchor30.mSolverVariable : null;
                    if (constraintWidget13 != constraintWidget12) {
                        solverVariable16 = constraintWidget13.mListAnchors[i11 + 1].mSolverVariable;
                    } else if (constraintWidget12 == constraintWidget3) {
                        ConstraintAnchor constraintAnchor31 = constraintWidget.mListAnchors[i11].mTarget;
                        solverVariable16 = constraintAnchor31 != null ? constraintAnchor31.mSolverVariable : null;
                    }
                    int margin5 = constraintAnchor29.getMargin();
                    int i30 = i11 + 1;
                    int margin6 = constraintWidget12.mListAnchors[i30].getMargin();
                    if (constraintWidget14 != null) {
                        constraintAnchor2 = constraintWidget14.mListAnchors[i11];
                        solverVariable3 = constraintAnchor2.mSolverVariable;
                    } else {
                        constraintAnchor2 = constraintWidget2.mListAnchors[i30].mTarget;
                        solverVariable3 = constraintAnchor2 != null ? constraintAnchor2.mSolverVariable : null;
                    }
                    SolverVariable solverVariable17 = constraintWidget12.mListAnchors[i30].mSolverVariable;
                    if (constraintAnchor2 != null) {
                        margin6 += constraintAnchor2.getMargin();
                    }
                    int margin7 = margin5 + constraintWidget13.mListAnchors[i30].getMargin();
                    if (solverVariable15 == null || solverVariable16 == null || solverVariable3 == null || solverVariable17 == null) {
                        i12 = 8;
                    } else {
                        if (constraintWidget12 == constraintWidget3) {
                            margin7 = constraintWidget3.mListAnchors[i11].getMargin();
                        }
                        if (constraintWidget12 == constraintWidget4) {
                            margin6 = constraintWidget4.mListAnchors[i30].getMargin();
                        }
                        i12 = 8;
                        linearSystem.addCentering(solverVariable15, solverVariable16, margin7, 0.5f, solverVariable3, solverVariable17, margin6, z23 ? 8 : 5);
                    }
                } else {
                    i12 = 8;
                }
                if (constraintWidget12.getVisibility() != i12) {
                    constraintWidget13 = constraintWidget12;
                }
                i15 = i10;
                constraintWidget12 = constraintWidget14;
            }
        }
        r10 = linearSystem;
        if (z21) {
        }
        constraintAnchorArr = constraintWidget3.mListAnchors;
        ConstraintAnchor constraintAnchor210 = constraintAnchorArr[i11];
        if (constraintWidget4 == null) {
            constraintWidget4 = constraintWidget3;
        }
        i13 = i11 + 1;
        constraintAnchor3 = constraintWidget4.mListAnchors[i13];
        constraintAnchor4 = constraintAnchor210.mTarget;
        if (constraintAnchor4 != null) {
            solverVariable4 = constraintAnchor4.mSolverVariable;
        } else {
            solverVariable4 = null;
        }
        constraintAnchor5 = constraintAnchor3.mTarget;
        if (constraintAnchor5 != null) {
            obj = constraintAnchor5.mSolverVariable;
        } else {
            obj = null;
        }
        if (constraintWidget2 != constraintWidget4) {
            ConstraintAnchor constraintAnchor211 = constraintWidget2.mListAnchors[i13].mTarget;
            obj = constraintAnchor211 != null ? constraintAnchor211.mSolverVariable : null;
        }
        if (constraintWidget3 == constraintWidget4) {
            constraintAnchor3 = constraintAnchorArr[i13];
        }
        if (solverVariable4 != null) {
        }
    }
}
