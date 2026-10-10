package com.pengrad.telegrambot.request;

import androidx.exifinterface.media.ExifInterface;
import c9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/pengrad/telegrambot/request/BaseRequest;", "R", "Lcom/pengrad/telegrambot/response/BaseResponse;", "invoke", "()Lcom/pengrad/telegrambot/request/BaseRequest;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class KBaseRequest$self$2<T> extends o implements a<T> {
    final /* synthetic */ KBaseRequest<T, R> this$0;

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // c9.a
    public final BaseRequest invoke() {
        BaseRequest baseRequest = this.this$0;
        m.d(baseRequest, "null cannot be cast to non-null type T of com.pengrad.telegrambot.request.KBaseRequest");
        return baseRequest;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KBaseRequest$self$2(KBaseRequest<T, R> kBaseRequest) {
        super(0);
        this.this$0 = kBaseRequest;
    }
}
