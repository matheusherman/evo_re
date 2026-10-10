package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final /* synthetic */ class j5 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f4424a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f4424a.highestSurface((DynamicScheme) obj);
    }

    public /* synthetic */ j5(MaterialDynamicColors materialDynamicColors) {
        this.f4424a = materialDynamicColors;
    }
}
