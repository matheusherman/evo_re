package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.response.GetFileResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "fileId", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/GetFile;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/GetFileResponse;", "kotlin.jvm.PlatformType", "getFile", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/GetFileResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class GetFileExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.GetFileExtensionKt$getFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/GetFile;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/GetFile;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass1 extends o implements l<GetFile, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetFile getFile) {
            m.f(getFile, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(GetFile getFile) {
            invoke2(getFile);
            return z.f17874a;
        }
    }

    public static final GetFileResponse getFile(TelegramAware telegramAware, String fileId, l<? super GetFile, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(fileId, "fileId");
        m.f(modifier, "modifier");
        GetFile getFile = new GetFile(fileId);
        modifier.invoke(getFile);
        return (GetFileResponse) telegramAware.execute(getFile);
    }

    public static /* synthetic */ GetFileResponse getFile$default(TelegramAware telegramAware, String str, l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        return getFile(telegramAware, str, lVar);
    }
}
