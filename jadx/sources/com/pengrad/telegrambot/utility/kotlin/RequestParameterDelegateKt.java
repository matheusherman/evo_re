package com.pengrad.telegrambot.utility.kotlin;

import androidx.exifinterface.media.ExifInterface;
import c9.l;
import com.pengrad.telegrambot.request.KBaseRequest;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import ua.i;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001aI\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t\u001a}\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0007\"\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000\"\u0004\b\u0001\u0010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u000520\b\u0002\u0010\f\u001a*\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011*.\u0010\u0014\u001a\u0004\b\u0000\u0010\u0012\u001a\u0004\b\u0001\u0010\u0013\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¨\u0006\u0015"}, d2 = {"Lcom/pengrad/telegrambot/request/KBaseRequest;", ExifInterface.GPS_DIRECTION_TRUE, "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "initialValue", "", "customParameterName", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "requestParameter", "(Ljava/lang/Object;Ljava/lang/String;)Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterValueMapper;", "valueMapper", "optionalRequestParameter", "(Ljava/lang/Object;Ljava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "input", "convertToSnakeCase", "(Ljava/lang/String;)Ljava/lang/String;", "I", "O", "RequestParameterValueMapper", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RequestParameterDelegateKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt$convertToSnakeCase$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lua/i;", "it", "", "invoke", "(Lua/i;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass1 extends o implements l<i, CharSequence> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // c9.l
        public final CharSequence invoke(i it) {
            m.f(it, "it");
            return it.b().get(1) + '_' + it.b().get(2);
        }
    }

    public static final String convertToSnakeCase(String input) {
        m.f(input, "input");
        String lowerCase = new ua.l("([a-z])([A-Z])").e(input, AnonymousClass1.INSTANCE).toLowerCase(Locale.ROOT);
        m.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final <T extends KBaseRequest<?, ?>, V> RequestParameterDelegate<T, V> optionalRequestParameter(V v10, String str, l<? super V, ? extends Object> lVar) {
        return new RequestParameterDelegate<>(v10, str, lVar);
    }

    public static /* synthetic */ RequestParameterDelegate optionalRequestParameter$default(Object obj, String str, l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = null;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        return optionalRequestParameter(obj, str, lVar);
    }

    public static final <T extends KBaseRequest<?, ?>, V> RequestParameterDelegate<T, V> requestParameter(V initialValue, String str) {
        m.f(initialValue, "initialValue");
        return new RequestParameterDelegate<>(initialValue, str, null, 4, null);
    }

    public static /* synthetic */ RequestParameterDelegate requestParameter$default(Object obj, String str, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        return requestParameter(obj, str);
    }
}
