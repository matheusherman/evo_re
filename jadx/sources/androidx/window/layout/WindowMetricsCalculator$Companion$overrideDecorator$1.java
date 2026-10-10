package androidx.window.layout;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class WindowMetricsCalculator$Companion$overrideDecorator$1 extends kotlin.jvm.internal.k implements c9.l<WindowMetricsCalculator, WindowMetricsCalculator> {
    @Override // c9.l
    public final WindowMetricsCalculator invoke(WindowMetricsCalculator p10) {
        kotlin.jvm.internal.m.f(p10, "p0");
        return ((WindowMetricsCalculatorDecorator) this.receiver).decorate(p10);
    }

    WindowMetricsCalculator$Companion$overrideDecorator$1(Object obj) {
        super(1, obj, WindowMetricsCalculatorDecorator.class, "decorate", "decorate(Landroidx/window/layout/WindowMetricsCalculator;)Landroidx/window/layout/WindowMetricsCalculator;", 0);
    }
}
