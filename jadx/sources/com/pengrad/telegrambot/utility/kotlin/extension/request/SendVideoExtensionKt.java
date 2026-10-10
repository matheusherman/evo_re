package com.pengrad.telegrambot.utility.kotlin.extension.request;

import c9.l;
import com.pengrad.telegrambot.TelegramAware;
import com.pengrad.telegrambot.request.SendVideo;
import com.pengrad.telegrambot.response.SendResponse;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u001a=\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a=\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\r\u001a=\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0010\u001a=\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0011\u001a=\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00122\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0014\u001a=\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "chatId", "", "videoUrl", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "modifier", "Lcom/pengrad/telegrambot/response/SendResponse;", "sendVideo", "(Lcom/pengrad/telegrambot/TelegramAware;JLjava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "channelUsername", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Ljava/lang/String;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "Ljava/io/File;", "videoFile", "(Lcom/pengrad/telegrambot/TelegramAware;JLjava/io/File;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;Ljava/io/File;Lc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "", "videoBytes", "(Lcom/pengrad/telegrambot/TelegramAware;J[BLc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "(Lcom/pengrad/telegrambot/TelegramAware;Ljava/lang/String;[BLc9/l;)Lcom/pengrad/telegrambot/response/SendResponse;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SendVideoExtensionKt {

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendVideoExtensionKt$sendVideo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends o implements l<SendVideo, z> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo sendVideo) {
            m.f(sendVideo, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendVideoExtensionKt$sendVideo$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass2 extends o implements l<SendVideo, z> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo sendVideo) {
            m.f(sendVideo, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendVideoExtensionKt$sendVideo$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass3 extends o implements l<SendVideo, z> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo sendVideo) {
            m.f(sendVideo, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendVideoExtensionKt$sendVideo$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass4 extends o implements l<SendVideo, z> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo sendVideo) {
            m.f(sendVideo, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendVideoExtensionKt$sendVideo$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass5 extends o implements l<SendVideo, z> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo sendVideo) {
            m.f(sendVideo, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.utility.kotlin.extension.request.SendVideoExtensionKt$sendVideo$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class AnonymousClass6 extends o implements l<SendVideo, z> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo sendVideo) {
            m.f(sendVideo, "$this$null");
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }
    }

    public static final SendResponse sendVideo(TelegramAware telegramAware, long j10, String videoUrl, l<? super SendVideo, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(videoUrl, "videoUrl");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(j10, videoUrl);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }

    public static /* synthetic */ SendResponse sendVideo$default(TelegramAware telegramAware, long j10, String videoUrl, l modifier, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            modifier = AnonymousClass1.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(videoUrl, "videoUrl");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(j10, videoUrl);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }

    public static final SendResponse sendVideo(TelegramAware telegramAware, String channelUsername, String videoUrl, l<? super SendVideo, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(videoUrl, "videoUrl");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(channelUsername, videoUrl);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }

    public static final SendResponse sendVideo(TelegramAware telegramAware, long j10, File videoFile, l<? super SendVideo, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(videoFile, "videoFile");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(j10, videoFile);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }

    public static /* synthetic */ SendResponse sendVideo$default(TelegramAware telegramAware, String channelUsername, String videoUrl, l modifier, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            modifier = AnonymousClass2.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(videoUrl, "videoUrl");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(channelUsername, videoUrl);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }

    public static final SendResponse sendVideo(TelegramAware telegramAware, String channelUsername, File videoFile, l<? super SendVideo, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(videoFile, "videoFile");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(channelUsername, videoFile);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }

    public static final SendResponse sendVideo(TelegramAware telegramAware, long j10, byte[] videoBytes, l<? super SendVideo, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(videoBytes, "videoBytes");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(j10, videoBytes);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }

    public static /* synthetic */ SendResponse sendVideo$default(TelegramAware telegramAware, long j10, File videoFile, l modifier, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            modifier = AnonymousClass3.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(videoFile, "videoFile");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(j10, videoFile);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }

    public static final SendResponse sendVideo(TelegramAware telegramAware, String channelUsername, byte[] videoBytes, l<? super SendVideo, z> modifier) {
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(videoBytes, "videoBytes");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(channelUsername, videoBytes);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }

    public static /* synthetic */ SendResponse sendVideo$default(TelegramAware telegramAware, String channelUsername, File videoFile, l modifier, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            modifier = AnonymousClass4.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(videoFile, "videoFile");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(channelUsername, videoFile);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }

    public static /* synthetic */ SendResponse sendVideo$default(TelegramAware telegramAware, long j10, byte[] videoBytes, l modifier, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            modifier = AnonymousClass5.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(videoBytes, "videoBytes");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(j10, videoBytes);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }

    public static /* synthetic */ SendResponse sendVideo$default(TelegramAware telegramAware, String channelUsername, byte[] videoBytes, l modifier, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            modifier = AnonymousClass6.INSTANCE;
        }
        m.f(telegramAware, "<this>");
        m.f(channelUsername, "channelUsername");
        m.f(videoBytes, "videoBytes");
        m.f(modifier, "modifier");
        SendVideo sendVideo = new SendVideo(channelUsername, videoBytes);
        modifier.invoke(sendVideo);
        return (SendResponse) telegramAware.execute(sendVideo);
    }
}
