package ua;

import com.pengrad.telegrambot.model.chatbackground.BackgroundTypePattern;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u0000 \u00192\u00060\u0001j\u0002`\u0002:\u0002.\u0019B\u0011\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0012H\u0086\u0004¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000e\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000e\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\"\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00122\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00120 ¢\u0006\u0004\b\"\u0010#J%\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070%2\u0006\u0010\u000e\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010*R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lua/l;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/regex/Pattern;", "nativePattern", "<init>", "(Ljava/util/regex/Pattern;)V", "", BackgroundTypePattern.TYPE, "(Ljava/lang/String;)V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "input", "Lr8/z;", "readObject", "(Ljava/io/ObjectInputStream;)V", "", "", "d", "(Ljava/lang/CharSequence;)Z", "", "startIndex", "Lua/i;", "a", "(Ljava/lang/CharSequence;I)Lua/i;", "c", "(Ljava/lang/CharSequence;)Lua/i;", "replacement", "f", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/Function1;", "transform", "e", "(Ljava/lang/CharSequence;Lc9/l;)Ljava/lang/String;", "limit", "", "g", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "toString", "()Ljava/lang/String;", "Ljava/util/regex/Pattern;", "", "_options", "Ljava/util/Set;", "b", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class l implements Serializable {
    private Set<Object> _options;
    private final Pattern nativePattern;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\b\u0002\u0018\u0000 \u00122\u00060\u0001j\u0002`\u0002:\u0001\u0012B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lua/l$b;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", BackgroundTypePattern.TYPE, "", "flags", "<init>", "(Ljava/lang/String;I)V", "", "readResolve", "()Ljava/lang/Object;", "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "I", "getFlags", "()I", "a", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class b implements Serializable {
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public b(String pattern, int i10) {
            kotlin.jvm.internal.m.f(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i10;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            kotlin.jvm.internal.m.e(patternCompile, "compile(...)");
            return new l(patternCompile);
        }
    }

    public l(Pattern nativePattern) {
        kotlin.jvm.internal.m.f(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ i b(l lVar, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return lVar.a(charSequence, i10);
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        kotlin.jvm.internal.m.e(strPattern, "pattern(...)");
        return new b(strPattern, this.nativePattern.flags());
    }

    public final i a(CharSequence input, int startIndex) {
        kotlin.jvm.internal.m.f(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.m.e(matcher, "matcher(...)");
        return m.e(matcher, startIndex, input);
    }

    public final i c(CharSequence input) {
        kotlin.jvm.internal.m.f(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.m.e(matcher, "matcher(...)");
        return m.f(matcher, input);
    }

    public final boolean d(CharSequence input) {
        kotlin.jvm.internal.m.f(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final String e(CharSequence input, c9.l<? super i, ? extends CharSequence> transform) {
        kotlin.jvm.internal.m.f(input, "input");
        kotlin.jvm.internal.m.f(transform, "transform");
        int iIntValue = 0;
        i iVarB = b(this, input, 0, 2, null);
        if (iVarB == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb2 = new StringBuilder(length);
        do {
            sb2.append(input, iIntValue, iVarB.c().getStart().intValue());
            sb2.append(transform.invoke(iVarB));
            iIntValue = iVarB.c().getEndInclusive().intValue() + 1;
            iVarB = iVarB.next();
            if (iIntValue >= length) {
                break;
            }
        } while (iVarB != null);
        if (iIntValue < length) {
            sb2.append(input, iIntValue, length);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "toString(...)");
        return string;
    }

    public final String f(CharSequence input, String replacement) {
        kotlin.jvm.internal.m.f(input, "input");
        kotlin.jvm.internal.m.f(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.m.e(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final List<String> g(CharSequence input, int limit) {
        kotlin.jvm.internal.m.f(input, "input");
        b0.u0(limit);
        Matcher matcher = this.nativePattern.matcher(input);
        if (limit == 1 || !matcher.find()) {
            return kotlin.collections.r.e(input.toString());
        }
        ArrayList arrayList = new ArrayList(limit > 0 ? h9.f.e(limit, 10) : 10);
        int i10 = limit - 1;
        int iEnd = 0;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i10 >= 0 && arrayList.size() == i10) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        kotlin.jvm.internal.m.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public l(String pattern) {
        kotlin.jvm.internal.m.f(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        kotlin.jvm.internal.m.e(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
