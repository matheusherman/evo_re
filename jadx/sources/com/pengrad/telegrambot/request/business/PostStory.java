package com.pengrad.telegrambot.request.business;

import c9.l;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.story.StoryArea;
import com.pengrad.telegrambot.model.story.inputstory.InputStoryContent;
import com.pengrad.telegrambot.request.KBaseRequest;
import com.pengrad.telegrambot.response.PostStoryResponse;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBg\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0014J\u0019\u0010\u000f\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0002\u00109J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u0019\u0010\f\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010:J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R;\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 R/\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0018\u001a\u0004\b\"\u0010 \"\u0004\b#\u0010$R;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0018\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0018\u001a\u0004\b+\u0010,R/\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0018\u001a\u0004\b.\u0010 \"\u0004\b/\u0010$R/\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0018\u001a\u0004\b1\u00102\"\u0004\b3\u00104R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u0018\u001a\u0004\b6\u00102\"\u0004\b7\u00104¨\u0006;"}, d2 = {"Lcom/pengrad/telegrambot/request/business/PostStory;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", "Lcom/pengrad/telegrambot/response/PostStoryResponse;", "businessConnectionId", "", "content", "Lcom/pengrad/telegrambot/model/story/inputstory/InputStoryContent;", "activePeriod", "", "(Ljava/lang/String;Lcom/pengrad/telegrambot/model/story/inputstory/InputStoryContent;I)V", "caption", "parseMode", "captionEntities", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "areas", "Lcom/pengrad/telegrambot/model/story/StoryArea;", "postToChatPage", "", "protectContent", "(Ljava/lang/String;Lcom/pengrad/telegrambot/model/story/inputstory/InputStoryContent;ILjava/lang/String;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/MessageEntity;[Lcom/pengrad/telegrambot/model/story/StoryArea;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getActivePeriod", "()I", "activePeriod$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "<set-?>", "getAreas", "()[Lcom/pengrad/telegrambot/model/story/StoryArea;", "setAreas", "([Lcom/pengrad/telegrambot/model/story/StoryArea;)V", "areas$delegate", "getBusinessConnectionId", "()Ljava/lang/String;", "businessConnectionId$delegate", "getCaption", "setCaption", "(Ljava/lang/String;)V", "caption$delegate", "getCaptionEntities", "()[Lcom/pengrad/telegrambot/model/MessageEntity;", "setCaptionEntities", "([Lcom/pengrad/telegrambot/model/MessageEntity;)V", "captionEntities$delegate", "getContent", "()Lcom/pengrad/telegrambot/model/story/inputstory/InputStoryContent;", "content$delegate", "getParseMode", "setParseMode", "parseMode$delegate", "getPostToChatPage", "()Ljava/lang/Boolean;", "setPostToChatPage", "(Ljava/lang/Boolean;)V", "postToChatPage$delegate", "getProtectContent", "setProtectContent", "protectContent$delegate", "([Lcom/pengrad/telegrambot/model/story/StoryArea;)Lcom/pengrad/telegrambot/request/business/PostStory;", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/request/business/PostStory;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PostStory extends KBaseRequest<PostStory, PostStoryResponse> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(PostStory.class, "businessConnectionId", "getBusinessConnectionId()Ljava/lang/String;", 0)), c0.g(new w(PostStory.class, "content", "getContent()Lcom/pengrad/telegrambot/model/story/inputstory/InputStoryContent;", 0)), c0.g(new w(PostStory.class, "activePeriod", "getActivePeriod()I", 0)), c0.e(new q(PostStory.class, "caption", "getCaption()Ljava/lang/String;", 0)), c0.e(new q(PostStory.class, "parseMode", "getParseMode()Ljava/lang/String;", 0)), c0.e(new q(PostStory.class, "captionEntities", "getCaptionEntities()[Lcom/pengrad/telegrambot/model/MessageEntity;", 0)), c0.e(new q(PostStory.class, "areas", "getAreas()[Lcom/pengrad/telegrambot/model/story/StoryArea;", 0)), c0.e(new q(PostStory.class, "postToChatPage", "getPostToChatPage()Ljava/lang/Boolean;", 0)), c0.e(new q(PostStory.class, "protectContent", "getProtectContent()Ljava/lang/Boolean;", 0))};

    /* JADX INFO: renamed from: activePeriod$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate activePeriod;

    /* JADX INFO: renamed from: areas$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate areas;

    /* JADX INFO: renamed from: businessConnectionId$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate businessConnectionId;

    /* JADX INFO: renamed from: caption$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate caption;

    /* JADX INFO: renamed from: captionEntities$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate captionEntities;

    /* JADX INFO: renamed from: content$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate content;

    /* JADX INFO: renamed from: parseMode$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate parseMode;

    /* JADX INFO: renamed from: postToChatPage$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate postToChatPage;

    /* JADX INFO: renamed from: protectContent$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate protectContent;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.PostStory$areas$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/PostStory;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/PostStory;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<PostStory, z> {
        final /* synthetic */ StoryArea[] $areas;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(PostStory postStory) {
            invoke2(postStory);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(StoryArea[] storyAreaArr) {
            super(1);
            this.$areas = storyAreaArr;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PostStory applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setAreas(this.$areas);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.PostStory$caption$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/PostStory;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/PostStory;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06755 extends o implements l<PostStory, z> {
        final /* synthetic */ String $caption;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(PostStory postStory) {
            invoke2(postStory);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06755(String str) {
            super(1);
            this.$caption = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PostStory applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaption(this.$caption);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.PostStory$captionEntities$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/PostStory;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/PostStory;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06765 extends o implements l<PostStory, z> {
        final /* synthetic */ MessageEntity[] $captionEntities;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(PostStory postStory) {
            invoke2(postStory);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06765(MessageEntity[] messageEntityArr) {
            super(1);
            this.$captionEntities = messageEntityArr;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PostStory applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaptionEntities(this.$captionEntities);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.PostStory$parseMode$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/PostStory;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/PostStory;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06775 extends o implements l<PostStory, z> {
        final /* synthetic */ String $parseMode;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(PostStory postStory) {
            invoke2(postStory);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06775(String str) {
            super(1);
            this.$parseMode = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PostStory applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setParseMode(this.$parseMode);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.PostStory$postToChatPage$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/PostStory;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/PostStory;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06785 extends o implements l<PostStory, z> {
        final /* synthetic */ boolean $postToChatPage;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(PostStory postStory) {
            invoke2(postStory);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06785(boolean z10) {
            super(1);
            this.$postToChatPage = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PostStory applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setPostToChatPage(Boolean.valueOf(this.$postToChatPage));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.business.PostStory$protectContent$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/business/PostStory;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/business/PostStory;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06795 extends o implements l<PostStory, z> {
        final /* synthetic */ boolean $protectContent;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(PostStory postStory) {
            invoke2(postStory);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06795(boolean z10) {
            super(1);
            this.$protectContent = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PostStory applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setProtectContent(Boolean.valueOf(this.$protectContent));
        }
    }

    private PostStory(String str, InputStoryContent inputStoryContent, int i10, String str2, String str3, MessageEntity[] messageEntityArr, StoryArea[] storyAreaArr, Boolean bool, Boolean bool2) {
        super(c0.b(PostStoryResponse.class));
        RequestParameterDelegate requestParameterDelegateRequestParameter = RequestParameterDelegateKt.requestParameter(str, "business_connection_id");
        k<?>[] kVarArr = $$delegatedProperties;
        this.businessConnectionId = requestParameterDelegateRequestParameter.provideDelegate(this, kVarArr[0]);
        this.content = RequestParameterDelegateKt.requestParameter(inputStoryContent, "content").provideDelegate(this, kVarArr[1]);
        this.activePeriod = RequestParameterDelegateKt.requestParameter(Integer.valueOf(i10), "active_period").provideDelegate(this, kVarArr[2]);
        this.caption = RequestParameterDelegateKt.optionalRequestParameter$default(str2, "caption", null, 4, null).provideDelegate(this, kVarArr[3]);
        this.parseMode = RequestParameterDelegateKt.optionalRequestParameter$default(str3, "parse_mode", null, 4, null).provideDelegate(this, kVarArr[4]);
        this.captionEntities = RequestParameterDelegateKt.optionalRequestParameter$default(messageEntityArr, "caption_entities", null, 4, null).provideDelegate(this, kVarArr[5]);
        this.areas = RequestParameterDelegateKt.optionalRequestParameter$default(storyAreaArr, "areas", null, 4, null).provideDelegate(this, kVarArr[6]);
        this.postToChatPage = RequestParameterDelegateKt.optionalRequestParameter$default(bool, "post_to_chat_page", null, 4, null).provideDelegate(this, kVarArr[7]);
        this.protectContent = RequestParameterDelegateKt.optionalRequestParameter$default(bool2, "protect_content", null, 4, null).provideDelegate(this, kVarArr[8]);
    }

    public final PostStory areas(StoryArea[] areas) {
        m.f(areas, "areas");
        return applySelf(new AnonymousClass5(areas));
    }

    public final PostStory caption(String caption) {
        m.f(caption, "caption");
        return applySelf(new C06755(caption));
    }

    public final PostStory captionEntities(MessageEntity[] captionEntities) {
        m.f(captionEntities, "captionEntities");
        return applySelf(new C06765(captionEntities));
    }

    public final int getActivePeriod() {
        return ((Number) this.activePeriod.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final StoryArea[] getAreas() {
        return (StoryArea[]) this.areas.getValue(this, $$delegatedProperties[6]);
    }

    public final String getBusinessConnectionId() {
        return (String) this.businessConnectionId.getValue(this, $$delegatedProperties[0]);
    }

    public final String getCaption() {
        return (String) this.caption.getValue(this, $$delegatedProperties[3]);
    }

    public final MessageEntity[] getCaptionEntities() {
        return (MessageEntity[]) this.captionEntities.getValue(this, $$delegatedProperties[5]);
    }

    public final InputStoryContent getContent() {
        return (InputStoryContent) this.content.getValue(this, $$delegatedProperties[1]);
    }

    public final String getParseMode() {
        return (String) this.parseMode.getValue(this, $$delegatedProperties[4]);
    }

    public final Boolean getPostToChatPage() {
        return (Boolean) this.postToChatPage.getValue(this, $$delegatedProperties[7]);
    }

    public final Boolean getProtectContent() {
        return (Boolean) this.protectContent.getValue(this, $$delegatedProperties[8]);
    }

    public final PostStory parseMode(String parseMode) {
        m.f(parseMode, "parseMode");
        return applySelf(new C06775(parseMode));
    }

    public final PostStory postToChatPage(boolean postToChatPage) {
        return applySelf(new C06785(postToChatPage));
    }

    public final PostStory protectContent(boolean protectContent) {
        return applySelf(new C06795(protectContent));
    }

    public final void setAreas(StoryArea[] storyAreaArr) {
        this.areas.setValue(this, $$delegatedProperties[6], storyAreaArr);
    }

    public final void setCaption(String str) {
        this.caption.setValue(this, $$delegatedProperties[3], str);
    }

    public final void setCaptionEntities(MessageEntity[] messageEntityArr) {
        this.captionEntities.setValue(this, $$delegatedProperties[5], messageEntityArr);
    }

    public final void setParseMode(String str) {
        this.parseMode.setValue(this, $$delegatedProperties[4], str);
    }

    public final void setPostToChatPage(Boolean bool) {
        this.postToChatPage.setValue(this, $$delegatedProperties[7], bool);
    }

    public final void setProtectContent(Boolean bool) {
        this.protectContent.setValue(this, $$delegatedProperties[8], bool);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostStory(String businessConnectionId, InputStoryContent content, int i10) {
        this(businessConnectionId, content, i10, null, null, null, null, null, null);
        m.f(businessConnectionId, "businessConnectionId");
        m.f(content, "content");
    }
}
