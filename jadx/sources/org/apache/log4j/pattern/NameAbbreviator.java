package org.apache.log4j.pattern;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class NameAbbreviator {
    private static final NameAbbreviator DEFAULT = new NOPAbbreviator();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class DropElementAbbreviator extends NameAbbreviator {
        private final int count;

        @Override // org.apache.log4j.pattern.NameAbbreviator
        public void abbreviate(int i10, StringBuffer stringBuffer) {
            int i11 = this.count;
            int iIndexOf = stringBuffer.indexOf(".", i10);
            while (iIndexOf != -1) {
                i11--;
                if (i11 == 0) {
                    stringBuffer.delete(i10, iIndexOf + 1);
                    return;
                }
                iIndexOf = stringBuffer.indexOf(".", iIndexOf + 1);
            }
        }

        public DropElementAbbreviator(int i10) {
            this.count = i10;
        }
    }

    public abstract void abbreviate(int i10, StringBuffer stringBuffer);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class MaxElementAbbreviator extends NameAbbreviator {
        private final int count;

        public MaxElementAbbreviator(int i10) {
            this.count = i10;
        }

        @Override // org.apache.log4j.pattern.NameAbbreviator
        public void abbreviate(int i10, StringBuffer stringBuffer) {
            int length = stringBuffer.length() - 1;
            String string = stringBuffer.toString();
            for (int i11 = this.count; i11 > 0; i11--) {
                length = string.lastIndexOf(".", length - 1);
                if (length == -1 || length < i10) {
                    return;
                }
            }
            stringBuffer.delete(i10, length + 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class PatternAbbreviator extends NameAbbreviator {
        private final PatternAbbreviatorFragment[] fragments;

        @Override // org.apache.log4j.pattern.NameAbbreviator
        public void abbreviate(int i10, StringBuffer stringBuffer) {
            for (int i11 = 0; i11 < this.fragments.length - 1 && i10 < stringBuffer.length(); i11++) {
                i10 = this.fragments[i11].abbreviate(stringBuffer, i10);
            }
            PatternAbbreviatorFragment[] patternAbbreviatorFragmentArr = this.fragments;
            PatternAbbreviatorFragment patternAbbreviatorFragment = patternAbbreviatorFragmentArr[patternAbbreviatorFragmentArr.length - 1];
            while (i10 < stringBuffer.length() && i10 >= 0) {
                i10 = patternAbbreviatorFragment.abbreviate(stringBuffer, i10);
            }
        }

        public PatternAbbreviator(List list) {
            if (list.size() != 0) {
                PatternAbbreviatorFragment[] patternAbbreviatorFragmentArr = new PatternAbbreviatorFragment[list.size()];
                this.fragments = patternAbbreviatorFragmentArr;
                list.toArray(patternAbbreviatorFragmentArr);
                return;
            }
            throw new IllegalArgumentException("fragments must have at least one element");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class PatternAbbreviatorFragment {
        private final int charCount;
        private final char ellipsis;

        public PatternAbbreviatorFragment(int i10, char c10) {
            this.charCount = i10;
            this.ellipsis = c10;
        }

        public int abbreviate(StringBuffer stringBuffer, int i10) {
            int iIndexOf = stringBuffer.toString().indexOf(".", i10);
            if (iIndexOf != -1) {
                int i11 = iIndexOf - i10;
                int i12 = this.charCount;
                if (i11 > i12) {
                    stringBuffer.delete(i12 + i10, iIndexOf);
                    iIndexOf = this.charCount + i10;
                    char c10 = this.ellipsis;
                    if (c10 != 0) {
                        stringBuffer.insert(iIndexOf, c10);
                        iIndexOf++;
                    }
                }
                return iIndexOf + 1;
            }
            return iIndexOf;
        }
    }

    public static NameAbbreviator getDefaultAbbreviator() {
        return DEFAULT;
    }

    public static NameAbbreviator getAbbreviator(String str) {
        int i10;
        int i11;
        int iCharAt;
        char cCharAt;
        if (str.length() > 0) {
            String strTrim = str.trim();
            if (strTrim.length() == 0) {
                return DEFAULT;
            }
            if (strTrim.length() > 0) {
                if (strTrim.charAt(0) == '-') {
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                while (i10 < strTrim.length() && strTrim.charAt(i10) >= '0' && strTrim.charAt(i10) <= '9') {
                    i10++;
                }
            } else {
                i10 = 0;
            }
            if (i10 == strTrim.length()) {
                int i12 = Integer.parseInt(strTrim);
                if (i12 >= 0) {
                    return new MaxElementAbbreviator(i12);
                }
                return new DropElementAbbreviator(-i12);
            }
            ArrayList arrayList = new ArrayList(5);
            int i13 = 0;
            while (i13 < strTrim.length() && i13 >= 0) {
                if (strTrim.charAt(i13) == '*') {
                    i11 = i13 + 1;
                    iCharAt = Integer.MAX_VALUE;
                } else if (strTrim.charAt(i13) >= '0' && strTrim.charAt(i13) <= '9') {
                    iCharAt = strTrim.charAt(i13) - '0';
                    i11 = i13 + 1;
                } else {
                    i11 = i13;
                    iCharAt = 0;
                }
                if (i11 >= strTrim.length() || (cCharAt = strTrim.charAt(i11)) == '.') {
                    cCharAt = 0;
                }
                arrayList.add(new PatternAbbreviatorFragment(iCharAt, cCharAt));
                int iIndexOf = strTrim.indexOf(".", i13);
                if (iIndexOf == -1) {
                    break;
                }
                i13 = iIndexOf + 1;
            }
            return new PatternAbbreviator(arrayList);
        }
        return DEFAULT;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class NOPAbbreviator extends NameAbbreviator {
        @Override // org.apache.log4j.pattern.NameAbbreviator
        public void abbreviate(int i10, StringBuffer stringBuffer) {
        }
    }
}
