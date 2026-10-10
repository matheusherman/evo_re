package y3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d extends s {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum b {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[][] f22338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b[][] f22339b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        private enum a {
            A,
            B,
            C,
            NONE
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        private enum b {
            A,
            B,
            C,
            SHIFT,
            NONE
        }

        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        private static void b(Collection<int[]> collection, int i10, int[] iArr, int[] iArr2, int i11) {
            collection.add(y3.c.f22332a[i10]);
            if (i11 != 0) {
                iArr2[0] = iArr2[0] + 1;
            }
            iArr[0] = iArr[0] + (i10 * iArr2[0]);
        }

        private int d(CharSequence charSequence, a aVar, int i10) {
            int iD;
            int iD2;
            int i11 = this.f22338a[aVar.ordinal()][i10];
            if (i11 > 0) {
                return i11;
            }
            b bVar = b.NONE;
            int i12 = i10 + 1;
            boolean z10 = i12 >= charSequence.length();
            a[] aVarArr = {a.A, a.B};
            int i13 = Integer.MAX_VALUE;
            for (int i14 = 0; i14 <= 1; i14++) {
                if (c(charSequence, aVarArr[i14], i10)) {
                    b bVarValueOf = b.NONE;
                    a aVar2 = aVarArr[i14];
                    if (aVar != aVar2) {
                        bVarValueOf = b.valueOf(aVar2.toString());
                        iD2 = 2;
                    } else {
                        iD2 = 1;
                    }
                    if (!z10) {
                        iD2 += d(charSequence, aVarArr[i14], i12);
                    }
                    if (iD2 < i13) {
                        bVar = bVarValueOf;
                        i13 = iD2;
                    }
                    if (aVar == aVarArr[(i14 + 1) % 2]) {
                        b bVar2 = b.SHIFT;
                        int iD3 = !z10 ? d(charSequence, aVar, i12) + 2 : 2;
                        if (iD3 < i13) {
                            bVar = bVar2;
                            i13 = iD3;
                        }
                    }
                }
            }
            a aVar3 = a.C;
            if (c(charSequence, aVar3, i10)) {
                b bVar3 = b.NONE;
                if (aVar != aVar3) {
                    bVar3 = b.C;
                    iD = 2;
                } else {
                    iD = 1;
                }
                int i15 = (charSequence.charAt(i10) != 241 ? 2 : 1) + i10;
                if (i15 < charSequence.length()) {
                    iD += d(charSequence, aVar3, i15);
                }
                if (iD < i13) {
                    bVar = bVar3;
                    i13 = iD;
                }
            }
            if (i13 != Integer.MAX_VALUE) {
                this.f22338a[aVar.ordinal()][i10] = i13;
                this.f22339b[aVar.ordinal()][i10] = bVar;
                return i13;
            }
            throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) charSequence.charAt(i10)));
        }

        private static boolean f(char c10) {
            return c10 >= '0' && c10 <= '9';
        }

        private boolean c(CharSequence charSequence, a aVar, int i10) {
            int i11;
            char cCharAt = charSequence.charAt(i10);
            int iOrdinal = aVar.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        return false;
                    }
                    if (cCharAt != 241 && ((i11 = i10 + 1) >= charSequence.length() || !f(cCharAt) || !f(charSequence.charAt(i11)))) {
                        return false;
                    }
                    return true;
                }
                if (cCharAt != 241 && cCharAt != 242 && cCharAt != 243 && cCharAt != 244 && " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007fÿ".indexOf(cCharAt) < 0) {
                    return false;
                }
                return true;
            }
            if (cCharAt != 241 && cCharAt != 242 && cCharAt != 243 && cCharAt != 244 && " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fÿ".indexOf(cCharAt) < 0) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean[] e(String str) {
            int i10;
            int i11;
            int i12;
            this.f22338a = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, str.length());
            this.f22339b = (b[][]) Array.newInstance((Class<?>) b.class, 4, str.length());
            a aVar = a.NONE;
            d(str, aVar, 0);
            ArrayList arrayList = new ArrayList();
            int[] iArr = {0};
            int[] iArr2 = {1};
            int length = str.length();
            int i13 = 0;
            while (i13 < length) {
                b bVar = this.f22339b[aVar.ordinal()][i13];
                int iOrdinal = bVar.ordinal();
                int iCharAt = 101;
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            if (iOrdinal == 3) {
                                b(arrayList, 98, iArr, iArr2, i13);
                            }
                        } else {
                            aVar = a.C;
                            if (i13 == 0) {
                                i12 = 105;
                            } else {
                                i12 = 99;
                            }
                            b(arrayList, i12, iArr, iArr2, i13);
                        }
                    } else {
                        aVar = a.B;
                        if (i13 == 0) {
                            i11 = 104;
                        } else {
                            i11 = 100;
                        }
                        b(arrayList, i11, iArr, iArr2, i13);
                    }
                } else {
                    aVar = a.A;
                    if (i13 == 0) {
                        i10 = 103;
                    } else {
                        i10 = 101;
                    }
                    b(arrayList, i10, iArr, iArr2, i13);
                }
                if (aVar == a.C) {
                    if (str.charAt(i13) == 241) {
                        b(arrayList, 102, iArr, iArr2, i13);
                    } else {
                        b(arrayList, Integer.parseInt(str.substring(i13, i13 + 2)), iArr, iArr2, i13);
                        int i14 = i13 + 1;
                        if (i14 < length) {
                            i13 = i14;
                        }
                    }
                } else {
                    switch (str.charAt(i13)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
                            if ((aVar != a.A || bVar == b.SHIFT) && (aVar != a.B || bVar != b.SHIFT)) {
                                iCharAt = 100;
                            }
                            break;
                        default:
                            iCharAt = str.charAt(i13) - ' ';
                            break;
                    }
                    if (((aVar == a.A && bVar != b.SHIFT) || (aVar == a.B && bVar == b.SHIFT)) && iCharAt < 0) {
                        iCharAt += 96;
                    }
                    b(arrayList, iCharAt, iArr, iArr2, i13);
                }
                i13++;
            }
            this.f22338a = null;
            this.f22339b = null;
            return d.m(arrayList, iArr[0]);
        }
    }

    private static int i(String str, Map<h3.g, ?> map) {
        if (map != null) {
            h3.g gVar = h3.g.FORCE_CODE_SET;
            if (map.containsKey(gVar)) {
                String string = map.get(gVar).toString();
                string.getClass();
                switch (string) {
                    case "A":
                        break;
                    case "B":
                        break;
                    case "C":
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported code set hint: " + string);
                }
            }
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            switch (cCharAt) {
                case 241:
                case 242:
                case 243:
                case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
                    break;
                default:
                    if (cCharAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) cCharAt));
                    }
                    break;
            }
            /*  JADX ERROR: Method code generation error
                java.lang.NullPointerException: Switch insn not found in header
                	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:195)
                	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                Method dump skipped, instruction units count: 292
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: y3.d.i(java.lang.String, java.util.Map):int");
        }

        @Override // y3.s
        public boolean[] d(String str) {
            return e(str, null);
        }

        static boolean[] m(Collection<int[]> collection, int i10) {
            int i11 = i10 % 103;
            if (i11 < 0) {
                throw new IllegalArgumentException("Unable to compute a valid input checksum");
            }
            int[][] iArr = y3.c.f22332a;
            collection.add(iArr[i11]);
            collection.add(iArr[106]);
            int iB = 0;
            int i12 = 0;
            for (int[] iArr2 : collection) {
                for (int i13 : iArr2) {
                    i12 += i13;
                }
            }
            boolean[] zArr = new boolean[i12];
            Iterator<int[]> it = collection.iterator();
            while (it.hasNext()) {
                iB += s.b(zArr, iB, it.next(), true);
            }
            return zArr;
        }

        @Override // y3.s
        protected Collection<h3.a> g() {
            return Collections.singleton(h3.a.CODE_128);
        }

        private static int j(CharSequence charSequence, int i10, int i11) {
            b bVarL;
            b bVarL2;
            char cCharAt;
            b bVarL3 = l(charSequence, i10);
            b bVar = b.ONE_DIGIT;
            if (bVarL3 == bVar) {
                if (i11 == 101) {
                    return 101;
                }
                return 100;
            }
            b bVar2 = b.UNCODABLE;
            if (bVarL3 == bVar2) {
                if (i10 < charSequence.length() && ((cCharAt = charSequence.charAt(i10)) < ' ' || (i11 == 101 && (cCharAt < '`' || (cCharAt >= 241 && cCharAt <= 244))))) {
                    return 101;
                }
                return 100;
            }
            if (i11 == 101 && bVarL3 == b.FNC_1) {
                return 101;
            }
            if (i11 == 99) {
                return 99;
            }
            if (i11 == 100) {
                b bVar3 = b.FNC_1;
                if (bVarL3 == bVar3 || (bVarL = l(charSequence, i10 + 2)) == bVar2 || bVarL == bVar) {
                    return 100;
                }
                if (bVarL == bVar3) {
                    if (l(charSequence, i10 + 3) != b.TWO_DIGITS) {
                        return 100;
                    }
                    return 99;
                }
                int i12 = i10 + 4;
                while (true) {
                    bVarL2 = l(charSequence, i12);
                    if (bVarL2 != b.TWO_DIGITS) {
                        break;
                    }
                    i12 += 2;
                }
                if (bVarL2 == b.ONE_DIGIT) {
                    return 100;
                }
                return 99;
            }
            if (bVarL3 == b.FNC_1) {
                bVarL3 = l(charSequence, i10 + 1);
            }
            if (bVarL3 != b.TWO_DIGITS) {
                return 100;
            }
            return 99;
        }

        private static boolean[] k(String str, int i10) {
            int iJ;
            int length = str.length();
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 1;
            while (i11 < length) {
                if (i10 == -1) {
                    iJ = j(str, i11, i13);
                } else {
                    iJ = i10;
                }
                int iCharAt = 100;
                if (iJ == i13) {
                    switch (str.charAt(i11)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
                            if (i13 == 101) {
                                iCharAt = 101;
                            }
                            break;
                        default:
                            if (i13 != 100) {
                                if (i13 != 101) {
                                    int i15 = i11 + 1;
                                    if (i15 != length) {
                                        iCharAt = Integer.parseInt(str.substring(i11, i11 + 2));
                                        i11 = i15;
                                    } else {
                                        throw new IllegalArgumentException("Bad number of characters for digit only encoding.");
                                    }
                                } else {
                                    char cCharAt = str.charAt(i11);
                                    iCharAt = cCharAt - ' ';
                                    if (iCharAt < 0) {
                                        iCharAt = cCharAt + '@';
                                    }
                                }
                            } else {
                                iCharAt = str.charAt(i11) - ' ';
                            }
                            break;
                    }
                    i11++;
                } else {
                    if (i13 == 0) {
                        if (iJ != 100) {
                            if (iJ != 101) {
                                iCharAt = 105;
                            } else {
                                iCharAt = 103;
                            }
                        } else {
                            iCharAt = 104;
                        }
                    } else {
                        iCharAt = iJ;
                    }
                    i13 = iJ;
                }
                arrayList.add(y3.c.f22332a[iCharAt]);
                i12 += iCharAt * i14;
                if (i11 != 0) {
                    i14++;
                }
            }
            return m(arrayList, i12);
        }

        private static b l(CharSequence charSequence, int i10) {
            int length = charSequence.length();
            if (i10 >= length) {
                return b.UNCODABLE;
            }
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt == 241) {
                return b.FNC_1;
            }
            if (cCharAt >= '0' && cCharAt <= '9') {
                int i11 = i10 + 1;
                if (i11 >= length) {
                    return b.ONE_DIGIT;
                }
                char cCharAt2 = charSequence.charAt(i11);
                if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                    return b.TWO_DIGITS;
                }
                return b.ONE_DIGIT;
            }
            return b.UNCODABLE;
        }

        @Override // y3.s
        public boolean[] e(String str, Map<h3.g, ?> map) {
            int i10 = i(str, map);
            if (map != null) {
                h3.g gVar = h3.g.CODE128_COMPACT;
                if (map.containsKey(gVar) && Boolean.parseBoolean(map.get(gVar).toString())) {
                    return new c(null).e(str);
                }
            }
            return k(str, i10);
        }
    }
