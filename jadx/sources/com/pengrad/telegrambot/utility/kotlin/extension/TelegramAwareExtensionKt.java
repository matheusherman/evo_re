package com.pengrad.telegrambot.utility.kotlin.extension;

import androidx.exifinterface.media.ExifInterface;
import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aU\u0010\t\u001a\u00028\u0001\"\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"Lcom/pengrad/telegrambot/request/BaseRequest;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/pengrad/telegrambot/response/BaseResponse;", "R", "Lcom/pengrad/telegrambot/TelegramAware;", "request", "Lkotlin/Function1;", "Lr8/z;", "modifier", "execute", "(Lcom/pengrad/telegrambot/TelegramAware;Lcom/pengrad/telegrambot/request/BaseRequest;Lc9/l;)Lcom/pengrad/telegrambot/response/BaseResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TelegramAwareExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.TelegramAwareExtensionKt$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/pengrad/telegrambot/request/BaseRequest;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/pengrad/telegrambot/response/BaseResponse;", "R", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/BaseRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(BaseRequest baseRequest) {
            m.f(baseRequest, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BaseRequest) obj);
            return z.f17874a;
        }
    }

    public static final <T extends BaseRequest<T, R>, R extends BaseResponse> R execute(TelegramAware telegramAware, T request, l<? super T, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(request, "request");
        m.f(modifier, "modifier");
        modifier.invoke(request);
        return (R) telegramAware.execute(request);
    }

    public static /* synthetic */ BaseResponse execute$default(TelegramAware telegramAware, BaseRequest request, l modifier, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(request, "request");
        m.f(modifier, "modifier");
        modifier.invoke(request);
        return telegramAware.execute(request);
    }
}
