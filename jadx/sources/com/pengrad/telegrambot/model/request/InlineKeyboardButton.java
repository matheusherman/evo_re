package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.WebAppInfo;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\"J\u0092\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010<J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0013\u0010=\u001a\u00020\u000f2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\u0006\u0010A\u001a\u00020\u000fJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0000J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0015\"\u0004\b&\u0010\u0017R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010'\"\u0004\b(\u0010)R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00038\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0015\"\u0004\b*\u0010\u0017R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0015\"\u0004\b+\u0010\u0017R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0015\"\u0004\b,\u0010\u0017R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010-\"\u0004\b.\u0010/¨\u0006C"}, d2 = {"Lcom/pengrad/telegrambot/model/request/InlineKeyboardButton;", "", "text", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "loginUrl", "Lcom/pengrad/telegrambot/model/request/LoginUrl;", "callbackData", "switchInlineQuery", "switchInlineQueryCurrentChat", "switchInlineQueryChosenChat", "Lcom/pengrad/telegrambot/model/request/SwitchInlineQueryChosenChat;", "callbackGame", "Lcom/pengrad/telegrambot/model/request/CallbackGame;", "pay", "", "webApp", "Lcom/pengrad/telegrambot/model/WebAppInfo;", "copyText", "Lcom/pengrad/telegrambot/model/request/CopyTextButton;", "(Ljava/lang/String;Ljava/lang/String;Lcom/pengrad/telegrambot/model/request/LoginUrl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/pengrad/telegrambot/model/request/SwitchInlineQueryChosenChat;Lcom/pengrad/telegrambot/model/request/CallbackGame;Ljava/lang/Boolean;Lcom/pengrad/telegrambot/model/WebAppInfo;Lcom/pengrad/telegrambot/model/request/CopyTextButton;)V", "()Ljava/lang/String;", "setCallbackData", "(Ljava/lang/String;)V", "()Lcom/pengrad/telegrambot/model/request/CallbackGame;", "setCallbackGame", "(Lcom/pengrad/telegrambot/model/request/CallbackGame;)V", "()Lcom/pengrad/telegrambot/model/request/CopyTextButton;", "setCopyText", "(Lcom/pengrad/telegrambot/model/request/CopyTextButton;)V", "()Lcom/pengrad/telegrambot/model/request/LoginUrl;", "setLoginUrl", "(Lcom/pengrad/telegrambot/model/request/LoginUrl;)V", "getPay", "()Ljava/lang/Boolean;", "setPay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setSwitchInlineQuery", "()Lcom/pengrad/telegrambot/model/request/SwitchInlineQueryChosenChat;", "setSwitchInlineQueryChosenChat", "(Lcom/pengrad/telegrambot/model/request/SwitchInlineQueryChosenChat;)V", "setSwitchInlineQueryCurrentChat", "setText", "setUrl", "()Lcom/pengrad/telegrambot/model/WebAppInfo;", "setWebApp", "(Lcom/pengrad/telegrambot/model/WebAppInfo;)V", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/pengrad/telegrambot/model/request/LoginUrl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/pengrad/telegrambot/model/request/SwitchInlineQueryChosenChat;Lcom/pengrad/telegrambot/model/request/CallbackGame;Ljava/lang/Boolean;Lcom/pengrad/telegrambot/model/WebAppInfo;Lcom/pengrad/telegrambot/model/request/CopyTextButton;)Lcom/pengrad/telegrambot/model/request/InlineKeyboardButton;", "equals", TransactionPartnerType.OTHER, "hashCode", "", "isPay", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class InlineKeyboardButton {
    private String callbackData;
    private CallbackGame callbackGame;
    private CopyTextButton copyText;
    private LoginUrl loginUrl;
    private Boolean pay;
    private String switchInlineQuery;
    private SwitchInlineQueryChosenChat switchInlineQueryChosenChat;
    private String switchInlineQueryCurrentChat;
    private String text;
    private String url;
    private WebAppInfo webApp;

    public InlineKeyboardButton() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX INFO: renamed from: callbackData, reason: from getter */
    public final String getCallbackData() {
        return this.callbackData;
    }

    /* JADX INFO: renamed from: callbackGame, reason: from getter */
    public final CallbackGame getCallbackGame() {
        return this.callbackGame;
    }

    public final CopyTextButton copyText() {
        return this.copyText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InlineKeyboardButton)) {
            return false;
        }
        InlineKeyboardButton inlineKeyboardButton = (InlineKeyboardButton) other;
        return m.a(this.text, inlineKeyboardButton.text) && m.a(this.url, inlineKeyboardButton.url) && m.a(this.loginUrl, inlineKeyboardButton.loginUrl) && m.a(this.callbackData, inlineKeyboardButton.callbackData) && m.a(this.switchInlineQuery, inlineKeyboardButton.switchInlineQuery) && m.a(this.switchInlineQueryCurrentChat, inlineKeyboardButton.switchInlineQueryCurrentChat) && m.a(this.switchInlineQueryChosenChat, inlineKeyboardButton.switchInlineQueryChosenChat) && m.a(this.callbackGame, inlineKeyboardButton.callbackGame) && m.a(this.pay, inlineKeyboardButton.pay) && m.a(this.webApp, inlineKeyboardButton.webApp) && m.a(this.copyText, inlineKeyboardButton.copyText);
    }

    public final LoginUrl loginUrl() {
        return this.loginUrl;
    }

    public final String switchInlineQuery() {
        return this.switchInlineQuery;
    }

    public final SwitchInlineQueryChosenChat switchInlineQueryChosenChat() {
        return this.switchInlineQueryChosenChat;
    }

    public final String switchInlineQueryCurrentChat() {
        return this.switchInlineQueryCurrentChat;
    }

    public final String url() {
        return this.url;
    }

    public final WebAppInfo webApp() {
        return this.webApp;
    }

    public InlineKeyboardButton(String str) {
        this(str, null, null, null, null, null, null, null, null, null, null, 2046, null);
    }

    public static /* synthetic */ InlineKeyboardButton copy$default(InlineKeyboardButton inlineKeyboardButton, String str, String str2, LoginUrl loginUrl, String str3, String str4, String str5, SwitchInlineQueryChosenChat switchInlineQueryChosenChat, CallbackGame callbackGame, Boolean bool, WebAppInfo webAppInfo, CopyTextButton copyTextButton, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = inlineKeyboardButton.text;
        }
        if ((i10 & 2) != 0) {
            str2 = inlineKeyboardButton.url;
        }
        if ((i10 & 4) != 0) {
            loginUrl = inlineKeyboardButton.loginUrl;
        }
        if ((i10 & 8) != 0) {
            str3 = inlineKeyboardButton.callbackData;
        }
        if ((i10 & 16) != 0) {
            str4 = inlineKeyboardButton.switchInlineQuery;
        }
        if ((i10 & 32) != 0) {
            str5 = inlineKeyboardButton.switchInlineQueryCurrentChat;
        }
        if ((i10 & 64) != 0) {
            switchInlineQueryChosenChat = inlineKeyboardButton.switchInlineQueryChosenChat;
        }
        if ((i10 & 128) != 0) {
            callbackGame = inlineKeyboardButton.callbackGame;
        }
        if ((i10 & 256) != 0) {
            bool = inlineKeyboardButton.pay;
        }
        if ((i10 & 512) != 0) {
            webAppInfo = inlineKeyboardButton.webApp;
        }
        if ((i10 & 1024) != 0) {
            copyTextButton = inlineKeyboardButton.copyText;
        }
        WebAppInfo webAppInfo2 = webAppInfo;
        CopyTextButton copyTextButton2 = copyTextButton;
        CallbackGame callbackGame2 = callbackGame;
        Boolean bool2 = bool;
        String str6 = str5;
        SwitchInlineQueryChosenChat switchInlineQueryChosenChat2 = switchInlineQueryChosenChat;
        String str7 = str4;
        LoginUrl loginUrl2 = loginUrl;
        return inlineKeyboardButton.copy(str, str2, loginUrl2, str3, str7, str6, switchInlineQueryChosenChat2, callbackGame2, bool2, webAppInfo2, copyTextButton2);
    }

    public final InlineKeyboardButton callbackData(String callbackData) {
        m.f(callbackData, "callbackData");
        this.callbackData = callbackData;
        return this;
    }

    public final InlineKeyboardButton callbackGame(String callbackGame) {
        m.f(callbackGame, "callbackGame");
        this.callbackGame = CallbackGame.INSTANCE;
        return this;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final WebAppInfo getWebApp() {
        return this.webApp;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final CopyTextButton getCopyText() {
        return this.copyText;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final LoginUrl getLoginUrl() {
        return this.loginUrl;
    }

    public final String component4() {
        return this.callbackData;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSwitchInlineQuery() {
        return this.switchInlineQuery;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSwitchInlineQueryCurrentChat() {
        return this.switchInlineQueryCurrentChat;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final SwitchInlineQueryChosenChat getSwitchInlineQueryChosenChat() {
        return this.switchInlineQueryChosenChat;
    }

    public final CallbackGame component8() {
        return this.callbackGame;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getPay() {
        return this.pay;
    }

    public final InlineKeyboardButton copy(String text, String url, LoginUrl loginUrl, String callbackData, String switchInlineQuery, String switchInlineQueryCurrentChat, SwitchInlineQueryChosenChat switchInlineQueryChosenChat, CallbackGame callbackGame, Boolean pay, WebAppInfo webApp, CopyTextButton copyText) {
        return new InlineKeyboardButton(text, url, loginUrl, callbackData, switchInlineQuery, switchInlineQueryCurrentChat, switchInlineQueryChosenChat, callbackGame, pay, webApp, copyText);
    }

    public final InlineKeyboardButton copyText(String text) {
        m.f(text, "text");
        return copyText(new CopyTextButton(text));
    }

    public final Boolean getPay() {
        return this.pay;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        LoginUrl loginUrl = this.loginUrl;
        int iHashCode3 = (iHashCode2 + (loginUrl == null ? 0 : loginUrl.hashCode())) * 31;
        String str3 = this.callbackData;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.switchInlineQuery;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.switchInlineQueryCurrentChat;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        SwitchInlineQueryChosenChat switchInlineQueryChosenChat = this.switchInlineQueryChosenChat;
        int iHashCode7 = (iHashCode6 + (switchInlineQueryChosenChat == null ? 0 : switchInlineQueryChosenChat.hashCode())) * 31;
        CallbackGame callbackGame = this.callbackGame;
        int iHashCode8 = (iHashCode7 + (callbackGame == null ? 0 : callbackGame.hashCode())) * 31;
        Boolean bool = this.pay;
        int iHashCode9 = (iHashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        WebAppInfo webAppInfo = this.webApp;
        int iHashCode10 = (iHashCode9 + (webAppInfo == null ? 0 : webAppInfo.hashCode())) * 31;
        CopyTextButton copyTextButton = this.copyText;
        return iHashCode10 + (copyTextButton != null ? copyTextButton.hashCode() : 0);
    }

    public final boolean isPay() {
        Boolean bool = this.pay;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final InlineKeyboardButton loginUrl(LoginUrl loginUrl) {
        m.f(loginUrl, "loginUrl");
        this.loginUrl = loginUrl;
        return this;
    }

    public final InlineKeyboardButton pay() {
        this.pay = Boolean.TRUE;
        return this;
    }

    public final void setCallbackData(String str) {
        this.callbackData = str;
    }

    public final void setCallbackGame(CallbackGame callbackGame) {
        this.callbackGame = callbackGame;
    }

    public final void setCopyText(CopyTextButton copyTextButton) {
        this.copyText = copyTextButton;
    }

    public final void setLoginUrl(LoginUrl loginUrl) {
        this.loginUrl = loginUrl;
    }

    public final void setPay(Boolean bool) {
        this.pay = bool;
    }

    public final void setSwitchInlineQuery(String str) {
        this.switchInlineQuery = str;
    }

    public final void setSwitchInlineQueryChosenChat(SwitchInlineQueryChosenChat switchInlineQueryChosenChat) {
        this.switchInlineQueryChosenChat = switchInlineQueryChosenChat;
    }

    public final void setSwitchInlineQueryCurrentChat(String str) {
        this.switchInlineQueryCurrentChat = str;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setWebApp(WebAppInfo webAppInfo) {
        this.webApp = webAppInfo;
    }

    public final InlineKeyboardButton switchInlineQuery(String switchInlineQuery) {
        m.f(switchInlineQuery, "switchInlineQuery");
        this.switchInlineQuery = switchInlineQuery;
        return this;
    }

    public final InlineKeyboardButton switchInlineQueryChosenChat(SwitchInlineQueryChosenChat switchInlineQueryChosenChat) {
        m.f(switchInlineQueryChosenChat, "switchInlineQueryChosenChat");
        this.switchInlineQueryChosenChat = switchInlineQueryChosenChat;
        return this;
    }

    public final InlineKeyboardButton switchInlineQueryCurrentChat(String switchInlineQueryCurrentChat) {
        m.f(switchInlineQueryCurrentChat, "switchInlineQueryCurrentChat");
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
        return this;
    }

    public final String text() {
        return this.text;
    }

    public String toString() {
        return "InlineKeyboardButton(text=" + this.text + ", url=" + this.url + ", loginUrl=" + this.loginUrl + ", callbackData=" + this.callbackData + ", switchInlineQuery=" + this.switchInlineQuery + ", switchInlineQueryCurrentChat=" + this.switchInlineQueryCurrentChat + ", switchInlineQueryChosenChat=" + this.switchInlineQueryChosenChat + ", callbackGame=" + this.callbackGame + ", pay=" + this.pay + ", webApp=" + this.webApp + ", copyText=" + this.copyText + ')';
    }

    public final InlineKeyboardButton url(String url) {
        m.f(url, "url");
        this.url = url;
        return this;
    }

    public final InlineKeyboardButton webApp(WebAppInfo webApp) {
        m.f(webApp, "webApp");
        this.webApp = webApp;
        return this;
    }

    public InlineKeyboardButton(String str, String str2) {
        this(str, str2, null, null, null, null, null, null, null, null, null, 2044, null);
    }

    public final InlineKeyboardButton copyText(CopyTextButton copyText) {
        m.f(copyText, "copyText");
        this.copyText = copyText;
        return this;
    }

    public InlineKeyboardButton(String str, String str2, LoginUrl loginUrl) {
        this(str, str2, loginUrl, null, null, null, null, null, null, null, null, 2040, null);
    }

    public InlineKeyboardButton(String str, String str2, LoginUrl loginUrl, String str3) {
        this(str, str2, loginUrl, str3, null, null, null, null, null, null, null, 2032, null);
    }

    public InlineKeyboardButton(String str, String str2, LoginUrl loginUrl, String str3, String str4) {
        this(str, str2, loginUrl, str3, str4, null, null, null, null, null, null, 2016, null);
    }

    public InlineKeyboardButton(String str, String str2, LoginUrl loginUrl, String str3, String str4, String str5) {
        this(str, str2, loginUrl, str3, str4, str5, null, null, null, null, null, 1984, null);
    }

    public InlineKeyboardButton(String str, String str2, LoginUrl loginUrl, String str3, String str4, String str5, SwitchInlineQueryChosenChat switchInlineQueryChosenChat) {
        this(str, str2, loginUrl, str3, str4, str5, switchInlineQueryChosenChat, null, null, null, null, 1920, null);
    }

    public InlineKeyboardButton(String str, String str2, LoginUrl loginUrl, String str3, String str4, String str5, SwitchInlineQueryChosenChat switchInlineQueryChosenChat, CallbackGame callbackGame) {
        this(str, str2, loginUrl, str3, str4, str5, switchInlineQueryChosenChat, callbackGame, null, null, null, 1792, null);
    }

    public InlineKeyboardButton(String str, String str2, LoginUrl loginUrl, String str3, String str4, String str5, SwitchInlineQueryChosenChat switchInlineQueryChosenChat, CallbackGame callbackGame, Boolean bool) {
        this(str, str2, loginUrl, str3, str4, str5, switchInlineQueryChosenChat, callbackGame, bool, null, null, 1536, null);
    }

    public InlineKeyboardButton(String str, String str2, LoginUrl loginUrl, String str3, String str4, String str5, SwitchInlineQueryChosenChat switchInlineQueryChosenChat, CallbackGame callbackGame, Boolean bool, WebAppInfo webAppInfo) {
        this(str, str2, loginUrl, str3, str4, str5, switchInlineQueryChosenChat, callbackGame, bool, webAppInfo, null, 1024, null);
    }

    public InlineKeyboardButton(String str, String str2, LoginUrl loginUrl, String str3, String str4, String str5, SwitchInlineQueryChosenChat switchInlineQueryChosenChat, CallbackGame callbackGame, Boolean bool, WebAppInfo webAppInfo, CopyTextButton copyTextButton) {
        this.text = str;
        this.url = str2;
        this.loginUrl = loginUrl;
        this.callbackData = str3;
        this.switchInlineQuery = str4;
        this.switchInlineQueryCurrentChat = str5;
        this.switchInlineQueryChosenChat = switchInlineQueryChosenChat;
        this.callbackGame = callbackGame;
        this.pay = bool;
        this.webApp = webAppInfo;
        this.copyText = copyTextButton;
    }

    public /* synthetic */ InlineKeyboardButton(String str, String str2, LoginUrl loginUrl, String str3, String str4, String str5, SwitchInlineQueryChosenChat switchInlineQueryChosenChat, CallbackGame callbackGame, Boolean bool, WebAppInfo webAppInfo, CopyTextButton copyTextButton, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : loginUrl, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : switchInlineQueryChosenChat, (i10 & 128) != 0 ? null : callbackGame, (i10 & 256) != 0 ? null : bool, (i10 & 512) != 0 ? null : webAppInfo, (i10 & 1024) != 0 ? null : copyTextButton);
    }
}
