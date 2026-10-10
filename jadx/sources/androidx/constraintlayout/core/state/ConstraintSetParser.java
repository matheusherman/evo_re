package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.ChainReference;
import androidx.constraintlayout.core.state.helpers.FlowReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class ConstraintSetParser {
    private static final boolean PARSER_DEBUG = false;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class DesignElement {
        String mId;
        HashMap<String, String> mParams;
        String mType;

        public String getId() {
            return this.mId;
        }

        public HashMap<String, String> getParams() {
            return this.mParams;
        }

        public String getType() {
            return this.mType;
        }

        DesignElement(String str, String str2, HashMap<String, String> map) {
            this.mId = str;
            this.mType = str2;
            this.mParams = map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class FiniteGenerator implements GeneratedValue {
        float mFrom;
        float mInitial;
        float mMax;
        String mPostfix;
        String mPrefix;
        float mStep;
        float mTo;
        boolean mStop = false;
        float mCurrent = 0.0f;

        public ArrayList<String> array() {
            ArrayList<String> arrayList = new ArrayList<>();
            int i10 = (int) this.mInitial;
            int i11 = (int) this.mMax;
            int i12 = i10;
            while (i10 <= i11) {
                arrayList.add(this.mPrefix + i12 + this.mPostfix);
                i12 += (int) this.mStep;
                i10++;
            }
            return arrayList;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            float f10 = this.mCurrent;
            if (f10 >= this.mMax) {
                this.mStop = true;
            }
            if (!this.mStop) {
                this.mCurrent = f10 + this.mStep;
            }
            return this.mCurrent;
        }

        FiniteGenerator(float f10, float f11, float f12, String str, String str2) {
            this.mFrom = f10;
            this.mTo = f11;
            this.mStep = f12;
            this.mPrefix = str == null ? "" : str;
            this.mPostfix = str2 == null ? "" : str2;
            this.mMax = f11;
            this.mInitial = f10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface GeneratedValue {
        float value();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class Generator implements GeneratedValue {
        float mCurrent;
        float mIncrementBy;
        float mStart;
        boolean mStop = false;

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            if (!this.mStop) {
                this.mCurrent += this.mIncrementBy;
            }
            return this.mCurrent;
        }

        Generator(float f10, float f11) {
            this.mStart = f10;
            this.mIncrementBy = f11;
            this.mCurrent = f10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class LayoutVariables {
        HashMap<String, Integer> mMargins = new HashMap<>();
        HashMap<String, GeneratedValue> mGenerators = new HashMap<>();
        HashMap<String, ArrayList<String>> mArrayIds = new HashMap<>();

        void put(String str, int i10) {
            this.mMargins.put(str, Integer.valueOf(i10));
        }

        float get(Object obj) {
            if (!(obj instanceof CLString)) {
                if (obj instanceof CLNumber) {
                    return ((CLNumber) obj).getFloat();
                }
                return 0.0f;
            }
            String strContent = ((CLString) obj).content();
            if (this.mGenerators.containsKey(strContent)) {
                return this.mGenerators.get(strContent).value();
            }
            if (this.mMargins.containsKey(strContent)) {
                return this.mMargins.get(strContent).floatValue();
            }
            return 0.0f;
        }

        ArrayList<String> getList(String str) {
            if (this.mArrayIds.containsKey(str)) {
                return this.mArrayIds.get(str);
            }
            return null;
        }

        void put(String str, float f10, float f11) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            this.mGenerators.put(str, new Generator(f10, f11));
        }

        public void putOverride(String str, float f10) {
            this.mGenerators.put(str, new OverrideValue(f10));
        }

        void put(String str, float f10, float f11, float f12, String str2, String str3) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            FiniteGenerator finiteGenerator = new FiniteGenerator(f10, f11, f12, str2, str3);
            this.mGenerators.put(str, finiteGenerator);
            this.mArrayIds.put(str, finiteGenerator.array());
        }

        void put(String str, ArrayList<String> arrayList) {
            this.mArrayIds.put(str, arrayList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum MotionLayoutDebugFlags {
        NONE,
        SHOW_ALL,
        UNKNOWN
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class OverrideValue implements GeneratedValue {
        float mValue;

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            return this.mValue;
        }

        OverrideValue(float f10) {
            this.mValue = f10;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:107:0x0161  */
    /* JADX WARN: Code duplicated, block: B:4:0x0011  */
    static void applyAttribute(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject, String str) throws CLParsingException {
        str.getClass();
        switch (str) {
            case "centerVertically":
                String string = cLObject.getString(str);
                boolean zEquals = string.equals("parent");
                Object obj = string;
                if (zEquals) {
                    obj = State.PARENT;
                }
                ConstraintReference constraintReferenceConstraints = state.constraints(obj);
                constraintReference.topToTop(constraintReferenceConstraints);
                constraintReference.bottomToBottom(constraintReferenceConstraints);
                break;
            case "center":
                String string2 = cLObject.getString(str);
                ConstraintReference constraintReferenceConstraints2 = string2.equals("parent") ? state.constraints(State.PARENT) : state.constraints(string2);
                constraintReference.startToStart(constraintReferenceConstraints2);
                constraintReference.endToEnd(constraintReferenceConstraints2);
                constraintReference.topToTop(constraintReferenceConstraints2);
                constraintReference.bottomToBottom(constraintReferenceConstraints2);
                break;
            case "custom":
                parseCustomProperties(cLObject, constraintReference, str);
                break;
            case "rotationX":
                constraintReference.rotationX(layoutVariables.get(cLObject.get(str)));
                break;
            case "rotationY":
                constraintReference.rotationY(layoutVariables.get(cLObject.get(str)));
                break;
            case "rotationZ":
                constraintReference.rotationZ(layoutVariables.get(cLObject.get(str)));
                break;
            case "translationX":
                constraintReference.translationX(toPix(state, layoutVariables.get(cLObject.get(str))));
                break;
            case "translationY":
                constraintReference.translationY(toPix(state, layoutVariables.get(cLObject.get(str))));
                break;
            case "translationZ":
                constraintReference.translationZ(toPix(state, layoutVariables.get(cLObject.get(str))));
                break;
            case "height":
                constraintReference.setHeight(parseDimension(cLObject, str, state, state.getDpToPixel()));
                break;
            case "motion":
                parseMotionProperties(cLObject.get(str), constraintReference);
                break;
            case "pivotX":
                constraintReference.pivotX(layoutVariables.get(cLObject.get(str)));
                break;
            case "pivotY":
                constraintReference.pivotY(layoutVariables.get(cLObject.get(str)));
                break;
            case "scaleX":
                constraintReference.scaleX(layoutVariables.get(cLObject.get(str)));
                break;
            case "scaleY":
                constraintReference.scaleY(layoutVariables.get(cLObject.get(str)));
                break;
            case "hRtlBias":
                float f10 = layoutVariables.get(cLObject.get(str));
                if (state.isRtl()) {
                    f10 = 1.0f - f10;
                }
                constraintReference.horizontalBias(f10);
                break;
            case "vWeight":
                constraintReference.setVerticalChainWeight(layoutVariables.get(cLObject.get(str)));
                break;
            case "alpha":
                constraintReference.alpha(layoutVariables.get(cLObject.get(str)));
                break;
            case "hBias":
                constraintReference.horizontalBias(layoutVariables.get(cLObject.get(str)));
                break;
            case "vBias":
                constraintReference.verticalBias(layoutVariables.get(cLObject.get(str)));
                break;
            case "width":
                constraintReference.setWidth(parseDimension(cLObject, str, state, state.getDpToPixel()));
                break;
            case "hWeight":
                constraintReference.setHorizontalChainWeight(layoutVariables.get(cLObject.get(str)));
                break;
            case "centerHorizontally":
                String string3 = cLObject.getString(str);
                boolean zEquals2 = string3.equals("parent");
                Object obj2 = string3;
                if (zEquals2) {
                    obj2 = State.PARENT;
                }
                ConstraintReference constraintReferenceConstraints3 = state.constraints(obj2);
                constraintReference.startToStart(constraintReferenceConstraints3);
                constraintReference.endToEnd(constraintReferenceConstraints3);
                break;
            case "visibility":
                String string4 = cLObject.getString(str);
                string4.getClass();
                switch (string4) {
                    case "invisible":
                        constraintReference.visibility(4);
                        constraintReference.alpha(0.0f);
                        break;
                    case "gone":
                        constraintReference.visibility(8);
                        break;
                    case "visible":
                        constraintReference.visibility(0);
                        break;
                }
                break;
            default:
                parseConstraint(state, layoutVariables, cLObject, constraintReference, str);
                break;
        }
    }

    private static int indexOf(String str, String... strArr) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (strArr[i10].equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:47:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00da  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:68:0x0106  */
    /* JADX WARN: Code duplicated, block: B:70:0x010e  */
    /* JADX WARN: Code duplicated, block: B:72:0x0116  */
    /* JADX WARN: Code duplicated, block: B:74:0x0128 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x012a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x012c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x012e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0140  */
    /* JADX WARN: Code duplicated, block: B:81:0x0172  */
    /* JADX WARN: Code duplicated, block: B:82:0x0196  */
    /* JADX WARN: Code duplicated, block: B:83:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:86:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:91:0x0205  */
    /* JADX WARN: Code duplicated, block: B:95:0x01e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x01e2 A[SYNTHETIC] */
    private static void parseChainType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        CLArray cLArray;
        float f10;
        float pix;
        float f11;
        float pix2;
        float f12;
        String strContent;
        int i10 = 0;
        ChainReference chainReferenceHorizontalChain = str.charAt(0) == 'h' ? state.horizontalChain() : state.verticalChain();
        chainReferenceHorizontalChain.setKey(str2);
        for (String str3 : cLObject.names()) {
            str3.getClass();
            int i11 = 6;
            int i12 = 5;
            int i13 = 3;
            int i14 = 2;
            int i15 = 1;
            byte b10 = -1;
            switch (str3) {
                case "bottom":
                    b10 = 0;
                case "contains":
                    b10 = 1;
                case "end":
                    b10 = 2;
                case "top":
                    b10 = 3;
                case "left":
                    b10 = 4;
                case "right":
                    b10 = 5;
                case "start":
                    b10 = 6;
                case "style":
                    b10 = 7;
                default:
                    switch (b10) {
                        case 0:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            parseConstraint(state, layoutVariables, cLObject, chainReferenceHorizontalChain, str3);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            i10 = 0;
                            break;
                        case 1:
                            CLElement cLElement = cLObject.get(str3);
                            if (cLElement instanceof CLArray) {
                                CLArray cLArray2 = (CLArray) cLElement;
                                if (cLArray2.size() >= 1) {
                                    int i16 = 0;
                                    while (i16 < cLArray2.size()) {
                                        CLElement cLElement2 = cLArray2.get(i16);
                                        if (cLElement2 instanceof CLArray) {
                                            CLArray cLArray3 = (CLArray) cLElement2;
                                            if (cLArray3.size() > 0) {
                                                String strContent2 = cLArray3.get(i10).content();
                                                int size = cLArray3.size();
                                                if (size != i14) {
                                                    if (size == i13) {
                                                        float f13 = cLArray3.getFloat(i15);
                                                        float pix3 = toPix(state, cLArray3.getFloat(i14));
                                                        CLArray cLArray4 = cLArray2;
                                                        f10 = f13;
                                                        cLArray = cLArray4;
                                                        i16 = i16;
                                                        f12 = pix3;
                                                        pix2 = f12;
                                                        strContent2 = strContent2;
                                                        f11 = Float.NaN;
                                                        pix = Float.NaN;
                                                    } else if (size == 4) {
                                                        float f14 = cLArray3.getFloat(i15);
                                                        float pix4 = toPix(state, cLArray3.getFloat(i14));
                                                        i13 = 3;
                                                        CLArray cLArray5 = cLArray2;
                                                        f10 = f14;
                                                        cLArray = cLArray5;
                                                        pix2 = toPix(state, cLArray3.getFloat(3));
                                                        f12 = pix4;
                                                        f11 = Float.NaN;
                                                        i16 = i16;
                                                        strContent2 = strContent2;
                                                        pix = Float.NaN;
                                                    } else if (size != i11) {
                                                        cLArray = cLArray2;
                                                        f10 = Float.NaN;
                                                    } else {
                                                        float f15 = cLArray3.getFloat(i15);
                                                        float pix5 = toPix(state, cLArray3.getFloat(i14));
                                                        float pix6 = toPix(state, cLArray3.getFloat(i13));
                                                        float pix7 = toPix(state, cLArray3.getFloat(4));
                                                        f12 = pix5;
                                                        cLArray = cLArray2;
                                                        pix2 = pix6;
                                                        f10 = f15;
                                                        i16 = i16;
                                                        strContent2 = strContent2;
                                                        pix = toPix(state, cLArray3.getFloat(i12));
                                                        f11 = pix7;
                                                        i13 = 3;
                                                    }
                                                    chainReferenceHorizontalChain.addChainElement(strContent2, f10, f12, pix2, f11, pix);
                                                } else {
                                                    CLArray cLArray6 = cLArray2;
                                                    f10 = cLArray3.getFloat(i15);
                                                    cLArray = cLArray6;
                                                }
                                                f12 = Float.NaN;
                                                pix2 = Float.NaN;
                                                f11 = Float.NaN;
                                                pix = Float.NaN;
                                                chainReferenceHorizontalChain.addChainElement(strContent2, f10, f12, pix2, f11, pix);
                                            } else {
                                                i16 = i16;
                                                cLArray = cLArray2;
                                            }
                                        } else {
                                            i16 = i16;
                                            cLArray = cLArray2;
                                            chainReferenceHorizontalChain.add(cLElement2.content());
                                        }
                                        i16++;
                                        cLArray2 = cLArray;
                                        i10 = 0;
                                        i14 = 2;
                                        i15 = 1;
                                        i11 = 6;
                                        i12 = 5;
                                    }
                                    continue;
                                    continue;
                                    continue;
                                    continue;
                                    continue;
                                    continue;
                                    continue;
                                    continue;
                                    continue;
                                    i10 = 0;
                                    break;
                                }
                            }
                            System.err.println(str2 + " contains should be an array \"" + cLElement.content() + "\"");
                            return;
                        case 7:
                            CLElement cLElement3 = cLObject.get(str3);
                            if (cLElement3 instanceof CLArray) {
                                CLArray cLArray7 = (CLArray) cLElement3;
                                if (cLArray7.size() > 1) {
                                    strContent = cLArray7.getString(i10);
                                    chainReferenceHorizontalChain.bias(cLArray7.getFloat(1));
                                } else {
                                    strContent = cLElement3.content();
                                }
                            } else {
                                strContent = cLElement3.content();
                            }
                            strContent.getClass();
                            if (strContent.equals("packed")) {
                                chainReferenceHorizontalChain.style(State.Chain.PACKED);
                            } else if (strContent.equals("spread_inside")) {
                                chainReferenceHorizontalChain.style(State.Chain.SPREAD_INSIDE);
                            } else {
                                chainReferenceHorizontalChain.style(State.Chain.SPREAD);
                            }
                            break;
                    }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:107:0x0190  */
    /* JADX WARN: Code duplicated, block: B:129:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:168:0x0266  */
    /* JADX WARN: Code duplicated, block: B:20:0x0083  */
    /* JADX WARN: Code duplicated, block: B:61:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:82:0x012b  */
    /* JADX WARN: Failed to find 'out' block for switch in B:53:0x00ce. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static void parseConstraint(State state, LayoutVariables layoutVariables, CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        boolean z10;
        boolean z11;
        byte b10;
        boolean z12;
        boolean zIsRtl = state.isRtl();
        boolean z13 = !zIsRtl;
        CLArray arrayOrNull = cLObject.getArrayOrNull(str);
        if (arrayOrNull == null || arrayOrNull.size() <= 1) {
            String stringOrNull = cLObject.getStringOrNull(str);
            if (stringOrNull != null) {
                ConstraintReference constraintReferenceConstraints = stringOrNull.equals("parent") ? state.constraints(State.PARENT) : state.constraints(stringOrNull);
                str.getClass();
                switch (str) {
                    case "baseline":
                        state.baselineNeededFor(constraintReference.getKey());
                        state.baselineNeededFor(constraintReferenceConstraints.getKey());
                        constraintReference.baselineToBaseline(constraintReferenceConstraints);
                        break;
                    case "bottom":
                        constraintReference.bottomToBottom(constraintReferenceConstraints);
                        break;
                    case "end":
                        if (zIsRtl) {
                            constraintReference.leftToLeft(constraintReferenceConstraints);
                            break;
                        } else {
                            constraintReference.rightToRight(constraintReferenceConstraints);
                            break;
                        }
                        break;
                    case "top":
                        constraintReference.topToTop(constraintReferenceConstraints);
                        break;
                    case "start":
                        if (zIsRtl) {
                            constraintReference.rightToRight(constraintReferenceConstraints);
                            break;
                        } else {
                            constraintReference.leftToLeft(constraintReferenceConstraints);
                            break;
                        }
                        break;
                }
            }
            return;
        }
        String string = arrayOrNull.getString(0);
        String stringOrNull2 = arrayOrNull.getStringOrNull(1);
        float pix = arrayOrNull.size() > 2 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(2))) : 0.0f;
        float pix2 = arrayOrNull.size() > 3 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(3))) : 0.0f;
        ConstraintReference constraintReferenceConstraints2 = string.equals("parent") ? state.constraints(State.PARENT) : state.constraints(string);
        str.getClass();
        float f10 = pix;
        switch (str) {
            case "baseline":
                stringOrNull2.getClass();
                switch (stringOrNull2) {
                    case "baseline":
                        state.baselineNeededFor(constraintReference.getKey());
                        state.baselineNeededFor(constraintReferenceConstraints2.getKey());
                        constraintReference.baselineToBaseline(constraintReferenceConstraints2);
                        break;
                    case "bottom":
                        state.baselineNeededFor(constraintReference.getKey());
                        constraintReference.baselineToBottom(constraintReferenceConstraints2);
                        break;
                    case "top":
                        state.baselineNeededFor(constraintReference.getKey());
                        constraintReference.baselineToTop(constraintReferenceConstraints2);
                        break;
                }
                z10 = true;
                z11 = false;
                break;
            case "circular":
                constraintReference.circularConstraint(constraintReferenceConstraints2, layoutVariables.get(arrayOrNull.get(1)), arrayOrNull.size() > 2 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(2))) : 0.0f);
                z10 = true;
                z11 = false;
                break;
            case "bottom":
                stringOrNull2.getClass();
                switch (stringOrNull2) {
                    case "baseline":
                        state.baselineNeededFor(constraintReferenceConstraints2.getKey());
                        constraintReference.bottomToBaseline(constraintReferenceConstraints2);
                        break;
                    case "bottom":
                        constraintReference.bottomToBottom(constraintReferenceConstraints2);
                        break;
                    case "top":
                        constraintReference.bottomToTop(constraintReferenceConstraints2);
                        break;
                }
                z10 = true;
                z11 = false;
                break;
            case "end":
                z10 = zIsRtl;
                z11 = true;
                break;
            case "top":
                stringOrNull2.getClass();
                switch (stringOrNull2) {
                    case "baseline":
                        state.baselineNeededFor(constraintReferenceConstraints2.getKey());
                        constraintReference.topToBaseline(constraintReferenceConstraints2);
                        break;
                    case "bottom":
                        constraintReference.topToBottom(constraintReferenceConstraints2);
                        break;
                    case "top":
                        constraintReference.topToTop(constraintReferenceConstraints2);
                        break;
                }
                z10 = true;
                z11 = false;
                break;
            case "left":
                z10 = true;
                z11 = true;
                break;
            case "right":
                z10 = false;
                z11 = true;
                break;
            case "start":
                z10 = z13;
                z11 = true;
                break;
            default:
                z10 = true;
                z11 = false;
                break;
        }
        if (z11) {
            stringOrNull2.getClass();
            switch (stringOrNull2.hashCode()) {
                case 100571:
                    if (!stringOrNull2.equals("end")) {
                        b10 = -1;
                    } else {
                        b10 = 0;
                    }
                    break;
                case 3317767:
                    if (!stringOrNull2.equals("left")) {
                        b10 = -1;
                    } else {
                        b10 = 1;
                    }
                    break;
                case 108511772:
                    if (!stringOrNull2.equals("right")) {
                        b10 = -1;
                    } else {
                        b10 = 2;
                    }
                    break;
                case 109757538:
                    if (!stringOrNull2.equals("start")) {
                        b10 = -1;
                    } else {
                        b10 = 3;
                    }
                    break;
                default:
                    b10 = -1;
                    break;
            }
            switch (b10) {
                case 0:
                    z12 = zIsRtl;
                    break;
                case 1:
                default:
                    z12 = true;
                    break;
                case 2:
                    z12 = false;
                    break;
                case 3:
                    z12 = z13;
                    break;
            }
            if (z10) {
                if (z12) {
                    constraintReference.leftToLeft(constraintReferenceConstraints2);
                } else {
                    constraintReference.leftToRight(constraintReferenceConstraints2);
                }
            } else if (z12) {
                constraintReference.rightToLeft(constraintReferenceConstraints2);
            } else {
                constraintReference.rightToRight(constraintReferenceConstraints2);
            }
        }
        constraintReference.margin(Float.valueOf(f10)).marginGone(Float.valueOf(pix2));
    }

    static Dimension parseDimensionMode(String str) {
        Dimension dimensionCreateFixed = Dimension.createFixed(0);
        str.getClass();
        switch (str) {
            case "preferWrap":
                return Dimension.createSuggested(Dimension.WRAP_DIMENSION);
            case "parent":
                return Dimension.createParent();
            case "spread":
                return Dimension.createSuggested(Dimension.SPREAD_DIMENSION);
            case "wrap":
                return Dimension.createWrap();
            default:
                if (str.endsWith("%")) {
                    return Dimension.createPercent(0, Float.parseFloat(str.substring(0, str.indexOf(37))) / 100.0f).suggested(0);
                }
                return str.contains(":") ? Dimension.createRatio(str).suggested(Dimension.SPREAD_DIMENSION) : dimensionCreateFixed;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:114:0x023c  */
    /* JADX WARN: Code duplicated, block: B:11:0x0041  */
    /* JADX WARN: Code duplicated, block: B:134:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:144:0x030a  */
    /* JADX WARN: Code duplicated, block: B:182:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:198:0x0415  */
    private static void parseFlowType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        String strContent;
        String string;
        String string2;
        Float fValueOf;
        Float fValueOf2;
        Float fValueOf3;
        String strContent2;
        String string3;
        String string4;
        float f10;
        float f11;
        float f12;
        float f13;
        Float fValueOf4;
        Float fValueOf5;
        Float fValueOf6;
        float f14;
        float f15;
        float pix;
        float f16;
        Float fValueOf7 = Float.valueOf(0.5f);
        int i10 = 0;
        FlowReference flow = state.getFlow(str2, str.charAt(0) == 'v');
        for (String str3 : cLObject.names()) {
            str3.getClass();
            int i11 = 4;
            switch (str3) {
                case "hAlign":
                    String strContent3 = cLObject.get(str3).content();
                    strContent3.getClass();
                    if (strContent3.equals("end")) {
                        flow.setHorizontalAlign(1);
                    } else if (strContent3.equals("start")) {
                        flow.setHorizontalAlign(0);
                    } else {
                        flow.setHorizontalAlign(2);
                    }
                    i10 = 0;
                    break;
                case "hStyle":
                    CLElement cLElement = cLObject.get(str3);
                    if (cLElement instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLElement;
                        if (cLArray.size() > 1) {
                            string = cLArray.getString(0);
                            strContent = cLArray.getString(1);
                            string2 = cLArray.size() > 2 ? cLArray.getString(2) : "";
                        } else {
                            strContent = cLElement.content();
                            string = "";
                            string2 = string;
                        }
                    } else {
                        strContent = cLElement.content();
                        string = "";
                        string2 = string;
                    }
                    if (!strContent.equals("")) {
                        flow.setHorizontalStyle(State.Chain.getValueByString(strContent));
                    }
                    if (!string.equals("")) {
                        flow.setFirstHorizontalStyle(State.Chain.getValueByString(string));
                    }
                    if (!string2.equals("")) {
                        flow.setLastHorizontalStyle(State.Chain.getValueByString(string2));
                    }
                    i10 = 0;
                    break;
                case "hFlowBias":
                    CLElement cLElement2 = cLObject.get(str3);
                    if (cLElement2 instanceof CLArray) {
                        CLArray cLArray2 = (CLArray) cLElement2;
                        if (cLArray2.size() > 1) {
                            fValueOf2 = Float.valueOf(cLArray2.getFloat(0));
                            fValueOf = Float.valueOf(cLArray2.getFloat(1));
                            fValueOf3 = cLArray2.size() > 2 ? Float.valueOf(cLArray2.getFloat(2)) : fValueOf7;
                        } else {
                            fValueOf = Float.valueOf(cLElement2.getFloat());
                            fValueOf2 = fValueOf7;
                            fValueOf3 = fValueOf2;
                        }
                    } else {
                        fValueOf = Float.valueOf(cLElement2.getFloat());
                        fValueOf2 = fValueOf7;
                        fValueOf3 = fValueOf2;
                    }
                    flow.horizontalBias(fValueOf.floatValue());
                    if (fValueOf2.floatValue() != 0.5f) {
                        flow.setFirstHorizontalBias(fValueOf2.floatValue());
                    }
                    if (fValueOf3.floatValue() != 0.5f) {
                        flow.setLastHorizontalBias(fValueOf3.floatValue());
                    }
                    i10 = 0;
                    break;
                case "vAlign":
                    String strContent4 = cLObject.get(str3).content();
                    strContent4.getClass();
                    switch (strContent4) {
                        case "baseline":
                            flow.setVerticalAlign(3);
                            break;
                        case "bottom":
                            flow.setVerticalAlign(1);
                            break;
                        case "top":
                            flow.setVerticalAlign(0);
                            break;
                        default:
                            flow.setVerticalAlign(2);
                            break;
                    }
                    i10 = 0;
                    break;
                case "vStyle":
                    CLElement cLElement3 = cLObject.get(str3);
                    if (cLElement3 instanceof CLArray) {
                        CLArray cLArray3 = (CLArray) cLElement3;
                        if (cLArray3.size() > 1) {
                            string3 = cLArray3.getString(0);
                            strContent2 = cLArray3.getString(1);
                            string4 = cLArray3.size() > 2 ? cLArray3.getString(2) : "";
                        } else {
                            strContent2 = cLElement3.content();
                            string3 = "";
                            string4 = string3;
                        }
                    } else {
                        strContent2 = cLElement3.content();
                        string3 = "";
                        string4 = string3;
                    }
                    if (!strContent2.equals("")) {
                        flow.setVerticalStyle(State.Chain.getValueByString(strContent2));
                    }
                    if (!string3.equals("")) {
                        flow.setFirstVerticalStyle(State.Chain.getValueByString(string3));
                    }
                    if (!string4.equals("")) {
                        flow.setLastVerticalStyle(State.Chain.getValueByString(string4));
                    }
                    i10 = 0;
                    break;
                case "padding":
                    CLElement cLElement4 = cLObject.get(str3);
                    if (cLElement4 instanceof CLArray) {
                        CLArray cLArray4 = (CLArray) cLElement4;
                        if (cLArray4.size() > 1) {
                            f10 = cLArray4.getInt(0);
                            f13 = cLArray4.getInt(1);
                            if (cLArray4.size() > 2) {
                                f12 = cLArray4.getInt(2);
                                try {
                                    f11 = ((CLArray) cLElement4).getInt(3);
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    f11 = 0.0f;
                                }
                            } else {
                                f12 = f10;
                                f11 = f13;
                            }
                        } else {
                            f10 = cLElement4.getInt();
                            f11 = f10;
                            f12 = f11;
                            f13 = f12;
                        }
                    } else {
                        f10 = cLElement4.getInt();
                        f11 = f10;
                        f12 = f11;
                        f13 = f12;
                    }
                    flow.setPaddingLeft(Math.round(toPix(state, f10)));
                    flow.setPaddingTop(Math.round(toPix(state, f13)));
                    flow.setPaddingRight(Math.round(toPix(state, f12)));
                    flow.setPaddingBottom(Math.round(toPix(state, f11)));
                    i10 = 0;
                    break;
                case "vFlowBias":
                    CLElement cLElement5 = cLObject.get(str3);
                    if (cLElement5 instanceof CLArray) {
                        CLArray cLArray5 = (CLArray) cLElement5;
                        if (cLArray5.size() > 1) {
                            fValueOf5 = Float.valueOf(cLArray5.getFloat(0));
                            fValueOf4 = Float.valueOf(cLArray5.getFloat(1));
                            fValueOf6 = cLArray5.size() > 2 ? Float.valueOf(cLArray5.getFloat(2)) : fValueOf7;
                        } else {
                            fValueOf4 = Float.valueOf(cLElement5.getFloat());
                            fValueOf5 = fValueOf7;
                            fValueOf6 = fValueOf5;
                        }
                    } else {
                        fValueOf4 = Float.valueOf(cLElement5.getFloat());
                        fValueOf5 = fValueOf7;
                        fValueOf6 = fValueOf5;
                    }
                    try {
                        flow.verticalBias(fValueOf4.floatValue());
                        if (fValueOf5.floatValue() != 0.5f) {
                            flow.setFirstVerticalBias(fValueOf5.floatValue());
                        }
                        if (fValueOf6.floatValue() != 0.5f) {
                            flow.setLastVerticalBias(fValueOf6.floatValue());
                        }
                    } catch (NumberFormatException unused2) {
                    }
                    i10 = 0;
                    break;
                case "contains":
                    CLElement cLElement6 = cLObject.get(str3);
                    if (cLElement6 instanceof CLArray) {
                        CLArray cLArray6 = (CLArray) cLElement6;
                        if (cLArray6.size() >= 1) {
                            int i12 = 0;
                            while (i12 < cLArray6.size()) {
                                CLElement cLElement7 = cLArray6.get(i12);
                                if (cLElement7 instanceof CLArray) {
                                    CLArray cLArray7 = (CLArray) cLElement7;
                                    if (cLArray7.size() > 0) {
                                        String strContent5 = cLArray7.get(i10).content();
                                        int size = cLArray7.size();
                                        if (size != 2) {
                                            if (size == 3) {
                                                f16 = cLArray7.getFloat(1);
                                                pix = toPix(state, cLArray7.getFloat(2));
                                                f15 = pix;
                                            } else if (size != i11) {
                                                f14 = Float.NaN;
                                            } else {
                                                f16 = cLArray7.getFloat(1);
                                                float pix2 = toPix(state, cLArray7.getFloat(2));
                                                pix = toPix(state, cLArray7.getFloat(3));
                                                f15 = pix2;
                                            }
                                            f14 = f16;
                                            flow.addFlowElement(strContent5, f14, f15, pix);
                                        } else {
                                            f14 = cLArray7.getFloat(1);
                                        }
                                        pix = Float.NaN;
                                        f15 = Float.NaN;
                                        flow.addFlowElement(strContent5, f14, f15, pix);
                                    }
                                } else {
                                    flow.add(cLElement7.content());
                                }
                                i12++;
                                i10 = 0;
                                i11 = 4;
                            }
                            i10 = 0;
                            break;
                        }
                    }
                    System.err.println(str2 + " contains should be an array \"" + cLElement6.content() + "\"");
                    break;
                case "maxElement":
                    flow.setMaxElementsWrap(cLObject.get(str3).getInt());
                    i10 = 0;
                    break;
                case "hGap":
                    flow.setHorizontalGap(cLObject.get(str3).getInt());
                    i10 = 0;
                    break;
                case "type":
                    if (cLObject.get(str3).content().equals("hFlow")) {
                        flow.setOrientation(i10);
                    } else {
                        flow.setOrientation(1);
                    }
                    i10 = 0;
                    break;
                case "vGap":
                    flow.setVerticalGap(cLObject.get(str3).getInt());
                    i10 = 0;
                    break;
                case "wrap":
                    flow.setWrapMode(State.Wrap.getValueByString(cLObject.get(str3).content()));
                    i10 = 0;
                    break;
                default:
                    applyAttribute(state, layoutVariables, state.constraints(str2), cLObject, str3);
                    i10 = 0;
                    break;
            }
            return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:118:0x01f0  */
    private static void parseGridType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        float f10;
        float f11;
        float f12;
        float f13;
        GridReference grid = state.getGrid(str2, str);
        for (String str3 : cLObject.names()) {
            str3.getClass();
            int i10 = 0;
            switch (str3) {
                case "orientation":
                    grid.setOrientation(cLObject.get(str3).getInt());
                    break;
                case "padding":
                    CLElement cLElement = cLObject.get(str3);
                    if (cLElement instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLElement;
                        if (cLArray.size() > 1) {
                            f10 = cLArray.getInt(0);
                            f13 = cLArray.getInt(1);
                            if (cLArray.size() > 2) {
                                f12 = cLArray.getInt(2);
                                try {
                                    f11 = ((CLArray) cLElement).getInt(3);
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    f11 = 0.0f;
                                }
                            } else {
                                f11 = f13;
                                f12 = f10;
                            }
                        } else {
                            f10 = cLElement.getInt();
                            f11 = f10;
                            f12 = f11;
                            f13 = f12;
                        }
                    } else {
                        f10 = cLElement.getInt();
                        f11 = f10;
                        f12 = f11;
                        f13 = f12;
                    }
                    grid.setPaddingStart(Math.round(toPix(state, f10)));
                    grid.setPaddingTop(Math.round(toPix(state, f13)));
                    grid.setPaddingEnd(Math.round(toPix(state, f12)));
                    grid.setPaddingBottom(Math.round(toPix(state, f11)));
                    break;
                case "contains":
                    CLArray arrayOrNull = cLObject.getArrayOrNull(str3);
                    if (arrayOrNull != null) {
                        for (int i11 = 0; i11 < arrayOrNull.size(); i11++) {
                            grid.add(state.constraints(arrayOrNull.get(i11).content()));
                        }
                        break;
                    } else {
                        break;
                    }
                    break;
                case "hGap":
                    grid.setHorizontalGaps(toPix(state, cLObject.get(str3).getFloat()));
                    break;
                case "rows":
                    int i12 = cLObject.get(str3).getInt();
                    if (i12 > 0) {
                        grid.setRowsSet(i12);
                        break;
                    } else {
                        break;
                    }
                    break;
                case "vGap":
                    grid.setVerticalGaps(toPix(state, cLObject.get(str3).getFloat()));
                    break;
                case "flags":
                    String strContent = "";
                    try {
                        CLElement cLElement2 = cLObject.get(str3);
                        if (cLElement2 instanceof CLNumber) {
                            i10 = cLElement2.getInt();
                        } else {
                            strContent = cLElement2.content();
                        }
                    } catch (Exception e10) {
                        System.err.println("Error parsing grid flags " + e10);
                    }
                    if (strContent != null && !strContent.isEmpty()) {
                        grid.setFlags(strContent);
                        break;
                    } else {
                        grid.setFlags(i10);
                        break;
                    }
                    break;
                case "skips":
                    String strContent2 = cLObject.get(str3).content();
                    if (strContent2 == null || !strContent2.contains(":")) {
                        break;
                    } else {
                        grid.setSkips(strContent2);
                        break;
                    }
                    break;
                case "spans":
                    String strContent3 = cLObject.get(str3).content();
                    if (strContent3 == null || !strContent3.contains(":")) {
                        break;
                    } else {
                        grid.setSpans(strContent3);
                        break;
                    }
                    break;
                case "rowWeights":
                    String strContent4 = cLObject.get(str3).content();
                    if (strContent4 == null || !strContent4.contains(",")) {
                        break;
                    } else {
                        grid.setRowWeights(strContent4);
                        break;
                    }
                    break;
                case "columns":
                    int i13 = cLObject.get(str3).getInt();
                    if (i13 > 0) {
                        grid.setColumnsSet(i13);
                        break;
                    } else {
                        break;
                    }
                    break;
                case "columnWeights":
                    String strContent5 = cLObject.get(str3).content();
                    if (strContent5 == null || !strContent5.contains(",")) {
                        break;
                    } else {
                        grid.setColumnWeights(strContent5);
                        break;
                    }
                    break;
                default:
                    applyAttribute(state, layoutVariables, state.constraints(str2), cLObject, str3);
                    break;
            }
        }
    }

    static void parseGuideline(int i10, State state, CLArray cLArray) throws CLParsingException {
        CLObject cLObject;
        String stringOrNull;
        CLElement cLElement = cLArray.get(1);
        if ((cLElement instanceof CLObject) && (stringOrNull = (cLObject = (CLObject) cLElement).getStringOrNull(IjkMediaMeta.IJKM_KEY_TRACK_ID)) != null) {
            parseGuidelineParams(i10, state, stringOrNull, cLObject);
        }
    }

    static void parseHelpers(State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        for (int i10 = 0; i10 < cLArray.size(); i10++) {
            CLElement cLElement = cLArray.get(i10);
            if (cLElement instanceof CLArray) {
                CLArray cLArray2 = (CLArray) cLElement;
                if (cLArray2.size() > 1) {
                    String string = cLArray2.getString(0);
                    string.getClass();
                    switch (string) {
                        case "vGuideline":
                            parseGuideline(1, state, cLArray2);
                            break;
                        case "hChain":
                            parseChain(0, state, layoutVariables, cLArray2);
                            break;
                        case "vChain":
                            parseChain(1, state, layoutVariables, cLArray2);
                            break;
                        case "hGuideline":
                            parseGuideline(0, state, cLArray2);
                            break;
                    }
                }
            }
        }
    }

    public static void parseJSON(String str, Transition transition, int i10) {
        CLObject objectOrNull;
        try {
            CLObject cLObject = CLParser.parse(str);
            ArrayList<String> arrayListNames = cLObject.names();
            if (arrayListNames == null) {
                return;
            }
            for (String str2 : arrayListNames) {
                CLElement cLElement = cLObject.get(str2);
                if ((cLElement instanceof CLObject) && (objectOrNull = ((CLObject) cLElement).getObjectOrNull("custom")) != null) {
                    for (String str3 : objectOrNull.names()) {
                        CLElement cLElement2 = objectOrNull.get(str3);
                        if (cLElement2 instanceof CLNumber) {
                            transition.addCustomFloat(i10, str2, str3, cLElement2.getFloat());
                        } else if (cLElement2 instanceof CLString) {
                            long colorString = parseColorString(cLElement2.content());
                            if (colorString != -1) {
                                transition.addCustomColor(i10, str2, str3, (int) colorString);
                            }
                        }
                    }
                }
            }
        } catch (CLParsingException e10) {
            System.err.println("Error parsing JSON " + e10);
        }
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) throws CLParsingException {
        parseWidget(state, layoutVariables, state.constraints(str), cLObject);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0086  */
    static void parseChain(int i10, State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        String strContent;
        ChainReference chainReferenceHorizontalChain = i10 == 0 ? state.horizontalChain() : state.verticalChain();
        CLElement cLElement = cLArray.get(1);
        if (cLElement instanceof CLArray) {
            CLArray cLArray2 = (CLArray) cLElement;
            if (cLArray2.size() < 1) {
                return;
            }
            for (int i11 = 0; i11 < cLArray2.size(); i11++) {
                chainReferenceHorizontalChain.add(cLArray2.getString(i11));
            }
            if (cLArray.size() > 2) {
                CLElement cLElement2 = cLArray.get(2);
                if (cLElement2 instanceof CLObject) {
                    CLObject cLObject = (CLObject) cLElement2;
                    for (String str : cLObject.names()) {
                        str.getClass();
                        if (str.equals("style")) {
                            CLElement cLElement3 = cLObject.get(str);
                            if (cLElement3 instanceof CLArray) {
                                CLArray cLArray3 = (CLArray) cLElement3;
                                if (cLArray3.size() > 1) {
                                    strContent = cLArray3.getString(0);
                                    chainReferenceHorizontalChain.bias(cLArray3.getFloat(1));
                                } else {
                                    strContent = cLElement3.content();
                                }
                            } else {
                                strContent = cLElement3.content();
                            }
                            strContent.getClass();
                            if (strContent.equals("packed")) {
                                chainReferenceHorizontalChain.style(State.Chain.PACKED);
                            } else if (strContent.equals("spread_inside")) {
                                chainReferenceHorizontalChain.style(State.Chain.SPREAD_INSIDE);
                            } else {
                                chainReferenceHorizontalChain.style(State.Chain.SPREAD);
                            }
                        } else {
                            parseConstraint(state, layoutVariables, cLObject, chainReferenceHorizontalChain, str);
                        }
                    }
                }
            }
        }
    }

    static long parseColorString(String str) {
        if (!str.startsWith("#")) {
            return -1L;
        }
        String strSubstring = str.substring(1);
        if (strSubstring.length() == 6) {
            strSubstring = "FF" + strSubstring;
        }
        return Long.parseLong(strSubstring, 16);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x00af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:0x00fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0033 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x0039  */
    /* JADX WARN: Code duplicated, block: B:21:0x0053  */
    /* JADX WARN: Code duplicated, block: B:22:0x0055  */
    /* JADX WARN: Code duplicated, block: B:25:0x005c  */
    /* JADX WARN: Code duplicated, block: B:26:0x005e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:30:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070  */
    /* JADX WARN: Code duplicated, block: B:37:0x0077  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:62:0x00df  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:93:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:42:0x0083. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:74:0x00f9. Please report as an issue. */
    /* JADX WARN: Switch 'out' block B:17:0x0033 for B:42:0x0083 already processed. Defaulting to fallback option. */
    /* JADX WARN: Switch 'out' block B:17:0x0033 for B:74:0x00f9 already processed. Defaulting to fallback option. */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:107:0x0102
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    static void parseGuidelineParams(int r17, androidx.constraintlayout.core.state.State r18, java.lang.String r19, androidx.constraintlayout.core.parser.CLObject r20) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseGuidelineParams(int, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static void parseHeader(CoreMotionScene coreMotionScene, CLObject cLObject) {
        String stringOrNull = cLObject.getStringOrNull("export");
        if (stringOrNull != null) {
            coreMotionScene.setDebugName(stringOrNull);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    private static void parseMotionProperties(CLElement cLElement, ConstraintReference constraintReference) throws CLParsingException {
        if (cLElement instanceof CLObject) {
            CLObject cLObject = (CLObject) cLElement;
            TypedBundle typedBundle = new TypedBundle();
            ArrayList<String> arrayListNames = cLObject.names();
            if (arrayListNames == null) {
                return;
            }
            for (String str : arrayListNames) {
                str.getClass();
                switch (str) {
                    case "stagger":
                        typedBundle.add(600, cLObject.getFloat(str));
                        break;
                    case "easing":
                        typedBundle.add(TypedValues.MotionType.TYPE_EASING, cLObject.getString(str));
                        break;
                    case "quantize":
                        CLElement cLElement2 = cLObject.get(str);
                        if (!(cLElement2 instanceof CLArray)) {
                            typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLObject.getInt(str));
                            break;
                        } else {
                            CLArray cLArray = (CLArray) cLElement2;
                            int size = cLArray.size();
                            if (size > 0) {
                                typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLArray.getInt(0));
                                if (size > 1) {
                                    typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE, cLArray.getString(1));
                                    if (size > 2) {
                                        typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, cLArray.getFloat(2));
                                    }
                                }
                            }
                            break;
                        }
                        break;
                    case "pathArc":
                        String string = cLObject.getString(str);
                        int iIndexOf = indexOf(string, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                        if (iIndexOf != -1) {
                            typedBundle.add(TypedValues.MotionType.TYPE_PATHMOTION_ARC, iIndexOf);
                            break;
                        } else {
                            System.err.println(cLObject.getLine() + " pathArc = '" + string + "'");
                            break;
                        }
                        break;
                    case "relativeTo":
                        typedBundle.add(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, cLObject.getString(str));
                        break;
                }
            }
            constraintReference.mMotionProperties = typedBundle;
        }
    }

    static String lookForType(CLObject cLObject) {
        Iterator<String> it = cLObject.names().iterator();
        while (it.hasNext()) {
            if (it.next().equals(IjkMediaMeta.IJKM_KEY_TYPE)) {
                return cLObject.getString(IjkMediaMeta.IJKM_KEY_TYPE);
            }
        }
        return null;
    }

    static void override(CLObject cLObject, String str, CLObject cLObject2) throws CLParsingException {
        if (!cLObject.has(str)) {
            cLObject.put(str, cLObject2);
            return;
        }
        CLObject object = cLObject.getObject(str);
        for (String str2 : cLObject2.names()) {
            if (!str2.equals("clear")) {
                object.put(str2, cLObject2.get(str2));
            } else {
                CLArray array = cLObject2.getArray("clear");
                for (int i10 = 0; i10 < array.size(); i10++) {
                    String stringOrNull = array.getStringOrNull(i10);
                    if (stringOrNull != null) {
                        switch (stringOrNull) {
                            case "transforms":
                                object.remove("visibility");
                                object.remove("alpha");
                                object.remove("pivotX");
                                object.remove("pivotY");
                                object.remove("rotationX");
                                object.remove("rotationY");
                                object.remove("rotationZ");
                                object.remove("scaleX");
                                object.remove("scaleY");
                                object.remove("translationX");
                                object.remove("translationY");
                                break;
                            case "constraints":
                                object.remove("start");
                                object.remove("end");
                                object.remove("top");
                                object.remove("bottom");
                                object.remove("baseline");
                                object.remove("center");
                                object.remove("centerHorizontally");
                                object.remove("centerVertically");
                                break;
                            case "dimensions":
                                object.remove("width");
                                object.remove("height");
                                break;
                            default:
                                object.remove(stringOrNull);
                                break;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:10:0x0030  */
    /* JADX WARN: Code duplicated, block: B:33:0x0087  */
    static void parseBarrier(State state, String str, CLObject cLObject) throws CLParsingException {
        boolean zIsRtl = state.isRtl();
        BarrierReference barrierReferenceBarrier = state.barrier(str, State.Direction.END);
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames != null) {
            for (String str2 : arrayListNames) {
                str2.getClass();
                switch (str2) {
                    case "margin":
                        float floatOrNaN = cLObject.getFloatOrNaN(str2);
                        if (Float.isNaN(floatOrNaN)) {
                            break;
                        } else {
                            barrierReferenceBarrier.margin(Float.valueOf(toPix(state, floatOrNaN)));
                            break;
                        }
                        break;
                    case "direction":
                        String string = cLObject.getString(str2);
                        string.getClass();
                        switch (string) {
                            case "bottom":
                                barrierReferenceBarrier.setBarrierDirection(State.Direction.BOTTOM);
                                break;
                            case "end":
                                if (!zIsRtl) {
                                    barrierReferenceBarrier.setBarrierDirection(State.Direction.RIGHT);
                                    break;
                                } else {
                                    barrierReferenceBarrier.setBarrierDirection(State.Direction.LEFT);
                                    break;
                                }
                                break;
                            case "top":
                                barrierReferenceBarrier.setBarrierDirection(State.Direction.TOP);
                                break;
                            case "left":
                                barrierReferenceBarrier.setBarrierDirection(State.Direction.LEFT);
                                break;
                            case "right":
                                barrierReferenceBarrier.setBarrierDirection(State.Direction.RIGHT);
                                break;
                            case "start":
                                if (!zIsRtl) {
                                    barrierReferenceBarrier.setBarrierDirection(State.Direction.LEFT);
                                    break;
                                } else {
                                    barrierReferenceBarrier.setBarrierDirection(State.Direction.RIGHT);
                                    break;
                                }
                                break;
                        }
                        break;
                    case "contains":
                        CLArray arrayOrNull = cLObject.getArrayOrNull(str2);
                        if (arrayOrNull != null) {
                            for (int i10 = 0; i10 < arrayOrNull.size(); i10++) {
                                barrierReferenceBarrier.add(state.constraints(arrayOrNull.get(i10).content()));
                            }
                            break;
                        } else {
                            break;
                        }
                        break;
                }
            }
        }
    }

    static void parseConstraintSets(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames != null) {
            for (String str : arrayListNames) {
                CLObject object = cLObject.getObject(str);
                String stringOrNull = object.getStringOrNull("Extends");
                if (stringOrNull != null && !stringOrNull.isEmpty()) {
                    String constraintSet = coreMotionScene.getConstraintSet(stringOrNull);
                    if (constraintSet != null) {
                        CLObject cLObject2 = CLParser.parse(constraintSet);
                        ArrayList<String> arrayListNames2 = object.names();
                        if (arrayListNames2 != null) {
                            for (String str2 : arrayListNames2) {
                                CLElement cLElement = object.get(str2);
                                if (cLElement instanceof CLObject) {
                                    override(cLObject2, str2, (CLObject) cLElement);
                                }
                            }
                            coreMotionScene.setConstraintSetContent(str, cLObject2.toJSON());
                        }
                    }
                } else {
                    coreMotionScene.setConstraintSetContent(str, object.toJSON());
                }
            }
        }
    }

    static void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ArrayList<String> arrayListNames;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull != null && (arrayListNames = objectOrNull.names()) != null) {
            for (String str2 : arrayListNames) {
                CLElement cLElement = objectOrNull.get(str2);
                if (cLElement instanceof CLNumber) {
                    constraintReference.addCustomFloat(str2, cLElement.getFloat());
                } else if (cLElement instanceof CLString) {
                    long colorString = parseColorString(cLElement.content());
                    if (colorString != -1) {
                        constraintReference.addCustomColor(str2, (int) colorString);
                    }
                }
            }
        }
    }

    public static void parseDesignElementsJSON(String str, ArrayList<DesignElement> arrayList) throws CLParsingException {
        CLObject cLObject = CLParser.parse(str);
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames != null && arrayListNames.size() > 0) {
            String str2 = arrayListNames.get(0);
            CLElement cLElement = cLObject.get(str2);
            str2.getClass();
            if (str2.equals("Design") && (cLElement instanceof CLObject)) {
                CLObject cLObject2 = (CLObject) cLElement;
                ArrayList<String> arrayListNames2 = cLObject2.names();
                for (int i10 = 0; i10 < arrayListNames2.size(); i10++) {
                    String str3 = arrayListNames2.get(i10);
                    CLObject cLObject3 = (CLObject) cLObject2.get(str3);
                    System.out.printf("element found " + str3 + "", new Object[0]);
                    String stringOrNull = cLObject3.getStringOrNull(IjkMediaMeta.IJKM_KEY_TYPE);
                    if (stringOrNull != null) {
                        HashMap map = new HashMap();
                        int size = cLObject3.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            CLKey cLKey = (CLKey) cLObject3.get(i10);
                            String strContent = cLKey.content();
                            String strContent2 = cLKey.getValue().content();
                            if (strContent2 != null) {
                                map.put(strContent, strContent2);
                            }
                        }
                        arrayList.add(new DesignElement(str2, stringOrNull, map));
                    }
                }
            }
        }
    }

    static Dimension parseDimension(CLObject cLObject, String str, State state, CorePixelDp corePixelDp) throws CLParsingException {
        CLElement cLElement = cLObject.get(str);
        Dimension dimensionCreateFixed = Dimension.createFixed(0);
        if (cLElement instanceof CLString) {
            return parseDimensionMode(cLElement.content());
        }
        if (cLElement instanceof CLNumber) {
            return Dimension.createFixed(state.convertDimension(Float.valueOf(corePixelDp.toPixels(cLObject.getFloat(str)))));
        }
        if (cLElement instanceof CLObject) {
            CLObject cLObject2 = (CLObject) cLElement;
            String stringOrNull = cLObject2.getStringOrNull("value");
            if (stringOrNull != null) {
                dimensionCreateFixed = parseDimensionMode(stringOrNull);
            }
            CLElement orNull = cLObject2.getOrNull("min");
            if (orNull != null) {
                if (orNull instanceof CLNumber) {
                    dimensionCreateFixed.min(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull).getFloat()))));
                } else if (orNull instanceof CLString) {
                    dimensionCreateFixed.min(Dimension.WRAP_DIMENSION);
                }
            }
            CLElement orNull2 = cLObject2.getOrNull("max");
            if (orNull2 != null) {
                if (orNull2 instanceof CLNumber) {
                    dimensionCreateFixed.max(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull2).getFloat()))));
                    return dimensionCreateFixed;
                }
                if (orNull2 instanceof CLString) {
                    dimensionCreateFixed.max(Dimension.WRAP_DIMENSION);
                }
            }
        }
        return dimensionCreateFixed;
    }

    static void parseGenerate(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames != null) {
            for (String str : arrayListNames) {
                CLElement cLElement = cLObject.get(str);
                ArrayList<String> list = layoutVariables.getList(str);
                if (list != null && (cLElement instanceof CLObject)) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        parseWidget(state, layoutVariables, it.next(), (CLObject) cLElement);
                    }
                }
            }
        }
    }

    public static void parseMotionSceneJSON(CoreMotionScene coreMotionScene, String str) {
        try {
            CLObject cLObject = CLParser.parse(str);
            ArrayList<String> arrayListNames = cLObject.names();
            if (arrayListNames != null) {
                for (String str2 : arrayListNames) {
                    CLElement cLElement = cLObject.get(str2);
                    if (cLElement instanceof CLObject) {
                        CLObject cLObject2 = (CLObject) cLElement;
                        int iHashCode = str2.hashCode();
                        if (iHashCode != -2137403731) {
                            if (iHashCode != -241441378) {
                                if (iHashCode == 1101852654 && str2.equals("ConstraintSets")) {
                                    parseConstraintSets(coreMotionScene, cLObject2);
                                }
                            } else if (str2.equals("Transitions")) {
                                parseTransitions(coreMotionScene, cLObject2);
                            }
                        } else if (str2.equals("Header")) {
                            parseHeader(coreMotionScene, cLObject2);
                        }
                    }
                }
            }
        } catch (CLParsingException e10) {
            System.err.println("Error parsing JSON " + e10);
        }
    }

    static void parseTransitions(CoreMotionScene coreMotionScene, CLObject cLObject) {
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames != null) {
            for (String str : arrayListNames) {
                coreMotionScene.setTransitionContent(str, cLObject.getObject(str).toJSON());
            }
        }
    }

    private static void parseVariables(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames != null) {
            for (String str : arrayListNames) {
                CLElement cLElement = cLObject.get(str);
                if (cLElement instanceof CLNumber) {
                    layoutVariables.put(str, cLElement.getInt());
                } else if (cLElement instanceof CLObject) {
                    CLObject cLObject2 = (CLObject) cLElement;
                    if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has(TypedValues.TransitionType.S_TO)) {
                        layoutVariables.put(str, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_TO)), 1.0f, cLObject2.getStringOrNull("prefix"), cLObject2.getStringOrNull("postfix"));
                    } else if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("step")) {
                        layoutVariables.put(str, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get("step")));
                    } else if (cLObject2.has("ids")) {
                        CLArray array = cLObject2.getArray("ids");
                        ArrayList<String> arrayList = new ArrayList<>();
                        for (int i10 = 0; i10 < array.size(); i10++) {
                            arrayList.add(array.getString(i10));
                        }
                        layoutVariables.put(str, arrayList);
                    } else if (cLObject2.has("tag")) {
                        layoutVariables.put(str, state.getIdsForTag(cLObject2.getString("tag")));
                    }
                }
            }
        }
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject) throws CLParsingException {
        if (constraintReference.getWidth() == null) {
            constraintReference.setWidth(Dimension.createWrap());
        }
        if (constraintReference.getHeight() == null) {
            constraintReference.setHeight(Dimension.createWrap());
        }
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames == null) {
            return;
        }
        Iterator<String> it = arrayListNames.iterator();
        while (it.hasNext()) {
            applyAttribute(state, layoutVariables, constraintReference, cLObject, it.next());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void populateState(@NonNull CLObject cLObject, @NonNull State state, @NonNull LayoutVariables layoutVariables) throws CLParsingException {
        ArrayList<String> arrayListNames = cLObject.names();
        if (arrayListNames != null) {
            for (String str : arrayListNames) {
                CLElement cLElement = cLObject.get(str);
                str.getClass();
                switch (str) {
                    case "Helpers":
                        if (!(cLElement instanceof CLArray)) {
                            break;
                        } else {
                            parseHelpers(state, layoutVariables, (CLArray) cLElement);
                            break;
                        }
                        break;
                    case "Generate":
                        if (!(cLElement instanceof CLObject)) {
                            break;
                        } else {
                            parseGenerate(state, layoutVariables, (CLObject) cLElement);
                            break;
                        }
                        break;
                    case "Variables":
                        if (!(cLElement instanceof CLObject)) {
                            break;
                        } else {
                            parseVariables(state, layoutVariables, (CLObject) cLElement);
                            break;
                        }
                        break;
                    default:
                        if (cLElement instanceof CLObject) {
                            CLObject cLObject2 = (CLObject) cLElement;
                            String strLookForType = lookForType(cLObject2);
                            if (strLookForType != null) {
                                switch (strLookForType) {
                                    case "vGuideline":
                                        parseGuidelineParams(1, state, str, cLObject2);
                                        break;
                                    case "column":
                                    case "row":
                                    case "grid":
                                        parseGridType(strLookForType, state, str, layoutVariables, cLObject2);
                                        break;
                                    case "hChain":
                                    case "vChain":
                                        parseChainType(strLookForType, state, str, layoutVariables, cLObject2);
                                        break;
                                    case "barrier":
                                        parseBarrier(state, str, cLObject2);
                                        break;
                                    case "hFlow":
                                    case "vFlow":
                                        parseFlowType(strLookForType, state, str, layoutVariables, cLObject2);
                                        break;
                                    case "hGuideline":
                                        parseGuidelineParams(0, state, str, cLObject2);
                                        break;
                                }
                            } else {
                                parseWidget(state, layoutVariables, str, cLObject2);
                                break;
                            }
                        } else {
                            if (cLElement instanceof CLNumber) {
                                layoutVariables.put(str, cLElement.getInt());
                            }
                            break;
                        }
                        break;
                }
            }
        }
    }

    private static float toPix(State state, float f10) {
        return state.getDpToPixel().toPixels(f10);
    }

    public static void parseJSON(String str, State state, LayoutVariables layoutVariables) {
        try {
            populateState(CLParser.parse(str), state, layoutVariables);
        } catch (CLParsingException e10) {
            System.err.println("Error parsing JSON " + e10);
        }
    }
}
