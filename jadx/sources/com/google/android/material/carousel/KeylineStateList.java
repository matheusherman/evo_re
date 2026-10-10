package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i10 = 0; i10 < keylineState.getKeylines().size(); i10++) {
            if (!keylineState.getKeylines().get(i10).isAnchor) {
                return i10;
            }
        }
        return -1;
    }

    @NonNull
    public KeylineState getShiftedState(float f10, float f11, float f12) {
        return getShiftedState(f10, f11, f12, false);
    }

    /* JADX INFO: renamed from: com.google.android.material.carousel.KeylineStateList$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType;

        static {
            int[] iArr = new int[CarouselStrategy.StrategyType.values().length];
            $SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType = iArr;
            try {
                iArr[CarouselStrategy.StrategyType.CONTAINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static KeylineStateList from(Carousel carousel, KeylineState keylineState, float f10, float f11, float f12, CarouselStrategy.StrategyType strategyType) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState, f10, f11, strategyType), getStateStepsEnd(carousel, keylineState, f10, f12, strategyType));
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState, float f10, float f11, CarouselStrategy.StrategyType strategyType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState);
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState) && iFindLastNonAnchorKeylineIndex != -1) {
            int lastFocalKeylineIndex = iFindLastNonAnchorKeylineIndex - keylineState.getLastFocalKeylineIndex();
            float f12 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (lastFocalKeylineIndex <= 0 && keylineState.getLastFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, (f12 - keylineState.getLastFocalKeyline().cutoff) - f11, containerWidth));
                return arrayList;
            }
            int i10 = 0;
            float f13 = 0.0f;
            while (i10 < lastFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i11 = iFindLastNonAnchorKeylineIndex - i10;
                float f14 = f13 + keylineState.getKeylines().get(i11).cutoff;
                int i12 = i11 + 1;
                int i13 = containerWidth;
                KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindLastNonAnchorKeylineIndex, i12 < keylineState.getKeylines().size() ? findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i12).mask) + 1 : 0, f12 - f14, keylineState.getFirstFocalKeylineIndex() + i10 + 1, keylineState.getLastFocalKeylineIndex() + i10 + 1, i13);
                if (i10 == lastFocalKeylineIndex - 1 && f11 > 0.0f) {
                    keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f11, i13, false, f10, strategyType);
                    i13 = i13;
                }
                arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
                i10++;
                containerWidth = i13;
                f13 = f14;
            }
        } else if (f11 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f11, containerWidth, false, f10, strategyType));
        }
        return arrayList;
    }

    private static List<KeylineState> getStateStepsStart(Carousel carousel, KeylineState keylineState, float f10, float f11, CarouselStrategy.StrategyType strategyType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState);
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isFirstFocalItemAtLeftOfContainer(keylineState) && iFindFirstNonAnchorKeylineIndex != -1) {
            int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - iFindFirstNonAnchorKeylineIndex;
            float f12 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (firstFocalKeylineIndex <= 0 && keylineState.getFirstFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f12 + keylineState.getFirstFocalKeyline().cutoff + f11, containerWidth));
                return arrayList;
            }
            float f13 = 0.0f;
            for (int i10 = 0; i10 < firstFocalKeylineIndex; i10++) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i11 = iFindFirstNonAnchorKeylineIndex + i10;
                int size = keylineState.getKeylines().size() - 1;
                f13 += keylineState.getKeylines().get(i11).cutoff;
                int i12 = i11 - 1;
                if (i12 >= 0) {
                    size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i12).mask) - 1;
                }
                int i13 = containerWidth;
                KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindFirstNonAnchorKeylineIndex, size, f12 + f13, (keylineState.getFirstFocalKeylineIndex() - i10) - 1, (keylineState.getLastFocalKeylineIndex() - i10) - 1, i13);
                containerWidth = i13;
                if (i10 == firstFocalKeylineIndex - 1 && f11 > 0.0f) {
                    keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f11, containerWidth, true, f10, strategyType);
                }
                arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
            }
        } else if (f11 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f11, containerWidth, true, f10, strategyType));
        }
        return arrayList;
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i10, int i11, float f10, int i12, int i13, int i14) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i11, (KeylineState.Keyline) arrayList.remove(i10));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i14);
        int i15 = 0;
        while (i15 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i15);
            float f11 = keyline.maskedItemSize;
            builder.addKeyline(f10 + (f11 / 2.0f), keyline.mask, f11, i15 >= i12 && i15 <= i13, keyline.isAnchor, keyline.cutoff);
            f10 += keyline.maskedItemSize;
            i15++;
        }
        return builder.build();
    }

    @NonNull
    private static KeylineState shiftKeylineStateForPadding(@NonNull KeylineState keylineState, float f10, int i10, boolean z10, float f11, CarouselStrategy.StrategyType strategyType) {
        return AnonymousClass1.$SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType[strategyType.ordinal()] != 1 ? shiftKeylineStateForPaddingUncontained(keylineState, f10, i10, z10) : shiftKeylineStateForPaddingContained(keylineState, f10, i10, z10, f11);
    }

    private static KeylineState shiftKeylineStateForPaddingContained(KeylineState keylineState, float f10, int i10, boolean z10, float f11) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i10);
        float numberOfNonAnchorKeylines = f10 / keylineState.getNumberOfNonAnchorKeylines();
        float f12 = z10 ? f10 : 0.0f;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i11);
            if (keyline.isAnchor) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                boolean z11 = i11 >= keylineState.getFirstFocalKeylineIndex() && i11 <= keylineState.getLastFocalKeylineIndex();
                float f13 = keyline.maskedItemSize - numberOfNonAnchorKeylines;
                float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(f13, keylineState.getItemSize(), f11);
                float f14 = (f13 / 2.0f) + f12;
                float fAbs = Math.abs(f14 - keyline.locOffset);
                builder.addKeyline(f14, childMaskPercentage, f13, z11, false, keyline.cutoff, z10 ? fAbs : 0.0f, z10 ? 0.0f : fAbs);
                f12 += f13;
            }
            i11++;
        }
        return builder.build();
    }

    @NonNull
    private static KeylineState shiftKeylineStateForPaddingUncontained(@NonNull KeylineState keylineState, float f10, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i10);
        int size = z10 ? 0 : arrayList.size() - 1;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i11);
            if (keyline.isAnchor && i11 == size) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                float f11 = keyline.locOffset;
                float f12 = z10 ? f11 + f10 : f11 - f10;
                float f13 = z10 ? f10 : 0.0f;
                float f14 = z10 ? 0.0f : f10;
                boolean z11 = i11 >= keylineState.getFirstFocalKeylineIndex() && i11 <= keylineState.getLastFocalKeylineIndex();
                float f15 = f12;
                float f16 = keyline.mask;
                float f17 = keyline.maskedItemSize;
                builder.addKeyline(f15, f16, f17, z11, keyline.isAnchor, Math.abs(z10 ? Math.max(0.0f, ((f17 / 2.0f) + f15) - i10) : Math.min(0.0f, f15 - (f17 / 2.0f))), f13, f14);
            }
            i11++;
        }
        return builder.build();
    }

    KeylineState getDefaultState() {
        return this.defaultState;
    }

    KeylineState getEndState() {
        List<KeylineState> list = this.endStateSteps;
        return list.get(list.size() - 1);
    }

    Map<Integer, KeylineState> getKeylineStateForPositionMap(int i10, int i11, int i12, boolean z10) {
        float itemSize = this.defaultState.getItemSize();
        HashMap map = new HashMap();
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i13 >= i10) {
                break;
            }
            int i15 = z10 ? (i10 - i13) - 1 : i13;
            if (i15 * itemSize * (z10 ? -1 : 1) > i12 - this.endShiftRange || i13 >= i10 - this.endStateSteps.size()) {
                Integer numValueOf = Integer.valueOf(i15);
                List<KeylineState> list = this.endStateSteps;
                map.put(numValueOf, list.get(MathUtils.clamp(i14, 0, list.size() - 1)));
                i14++;
            }
            i13++;
        }
        int i16 = 0;
        for (int i17 = i10 - 1; i17 >= 0; i17--) {
            int i18 = z10 ? (i10 - i17) - 1 : i17;
            if (i18 * itemSize * (z10 ? -1 : 1) < i11 + this.startShiftRange || i17 < this.startStateSteps.size()) {
                Integer numValueOf2 = Integer.valueOf(i18);
                List<KeylineState> list2 = this.startStateSteps;
                map.put(numValueOf2, list2.get(MathUtils.clamp(i16, 0, list2.size() - 1)));
                i16++;
            }
        }
        return map;
    }

    KeylineState getShiftedState(float f10, float f11, float f12, boolean z10) {
        float fLerp;
        List<KeylineState> list;
        float[] fArr;
        float f13 = this.startShiftRange + f11;
        float f14 = f12 - this.endShiftRange;
        float f15 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float f16 = getEndState().getFirstFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange == f15) {
            f13 += f15;
        }
        if (this.endShiftRange == f16) {
            f14 -= f16;
        }
        if (f10 < f13) {
            fLerp = AnimationUtils.lerp(1.0f, 0.0f, f11, f13, f10);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else {
            if (f10 <= f14) {
                return this.defaultState;
            }
            fLerp = AnimationUtils.lerp(0.0f, 1.0f, f14, f12, f10);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        return z10 ? closestStateStepFromInterpolation(list, fLerp, fArr) : lerp(list, fLerp, fArr);
    }

    KeylineState getStartState() {
        List<KeylineState> list = this.startStateSteps;
        return list.get(list.size() - 1);
    }

    private KeylineStateList(@NonNull KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = Collections.unmodifiableList(list);
        this.endStateSteps = Collections.unmodifiableList(list2);
        float f10 = list.get(list.size() - 1).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f10;
        float f11 = keylineState.getLastKeyline().loc - list2.get(list2.size() - 1).getLastKeyline().loc;
        this.endShiftRange = f11;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f10, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f11, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f10, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f10, fArr);
        if (stateStepsRange[0] >= 0.5f) {
            return list.get((int) stateStepsRange[2]);
        }
        return list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f10) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f10 == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f10) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f10 == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!keylineState.getKeylines().get(size).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    private static float[] getStateStepInterpolationPoints(float f10, List<KeylineState> list, boolean z10) {
        float f11;
        float f12;
        int size = list.size();
        float[] fArr = new float[size];
        for (int i10 = 1; i10 < size; i10++) {
            int i11 = i10 - 1;
            KeylineState keylineState = list.get(i11);
            KeylineState keylineState2 = list.get(i10);
            if (z10) {
                f11 = keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
            } else {
                f11 = keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc;
            }
            float f13 = f11 / f10;
            if (i10 == size - 1) {
                f12 = 1.0f;
            } else {
                f12 = fArr[i11] + f13;
            }
            fArr[i10] = f12;
        }
        return fArr;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f10, float[] fArr) {
        int size = list.size();
        float f11 = fArr[0];
        int i10 = 1;
        while (i10 < size) {
            float f12 = fArr[i10];
            if (f10 <= f12) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f11, f12, f10), i10 - 1, i10};
            }
            i10++;
            f11 = f12;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        if (keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) >= 0.0f && keylineState.getFirstFocalKeyline() == keylineState.getFirstNonAnchorKeyline()) {
            return true;
        }
        return false;
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        if (keylineState.getLastFocalKeyline().locOffset + (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) <= containerHeight && keylineState.getLastFocalKeyline() == keylineState.getLastNonAnchorKeyline()) {
            return true;
        }
        return false;
    }

    private static KeylineState lerp(List<KeylineState> list, float f10, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f10, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f10, int i10) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f10, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), i10);
    }
}
