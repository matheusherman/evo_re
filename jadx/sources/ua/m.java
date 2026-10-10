package ua;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a%\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000f\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ljava/util/regex/Matcher;", "", TypedValues.TransitionType.S_FROM, "", "input", "Lua/i;", "e", "(Ljava/util/regex/Matcher;ILjava/lang/CharSequence;)Lua/i;", "f", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)Lua/i;", "Ljava/util/regex/MatchResult;", "Lh9/e;", "g", "(Ljava/util/regex/MatchResult;)Lh9/e;", "groupIndex", "h", "(Ljava/util/regex/MatchResult;I)Lh9/e;", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class m {
    /* JADX INFO: Access modifiers changed from: private */
    public static final i e(Matcher matcher, int i10, CharSequence charSequence) {
        if (!matcher.find(i10)) {
            return null;
        }
        return new j(matcher, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i f(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new j(matcher, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h9.e g(MatchResult matchResult) {
        return h9.f.m(matchResult.start(), matchResult.end());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h9.e h(MatchResult matchResult, int i10) {
        return h9.f.m(matchResult.start(i10), matchResult.end(i10));
    }
}
