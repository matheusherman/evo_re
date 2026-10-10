package com.live.evo.util;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f7373a = a("(?:[" + Pattern.quote(".[]()") + "]|$|^)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f7374b = a("(?:[" + Pattern.quote(" _-,") + "])");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f7375c = a("(?:[" + Pattern.quote(" _-,.[]()") + "]|$|^)");

    public static Pattern a(String str) {
        return Pattern.compile(str);
    }
}
