package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQueryResultVideo extends InlineQueryResult<InlineQueryResultVideo> implements Serializable {
    public static final String MIME_TEXT_HTML = "text/html";
    public static final String MIME_VIDEO_MP4 = "video/mp4";
    private static final long serialVersionUID = 0;
    private String caption;
    private String description;
    private String mime_type;
    private String parse_mode;
    private String thumbnail_url;
    private String title;
    private Integer video_duration;
    private Integer video_height;
    private String video_url;
    private Integer video_width;

    @Deprecated
    public InlineQueryResultVideo(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, str2, str3, new InputTextMessageContent(str4), str5, str6);
    }

    @Deprecated
    public InlineQueryResultVideo(String str, String str2, String str3, InputMessageContent inputMessageContent, String str4, String str5) {
        this(str, str2, str3, str4, str5);
        inputMessageContent(inputMessageContent);
    }

    public InlineQueryResultVideo caption(String str) {
        this.caption = str;
        return this;
    }

    public InlineQueryResultVideo description(String str) {
        this.description = str;
        return this;
    }

    public InlineQueryResultVideo videoDuration(Integer num) {
        this.video_duration = num;
        return this;
    }

    public InlineQueryResultVideo videoHeight(Integer num) {
        this.video_height = num;
        return this;
    }

    public InlineQueryResultVideo videoWidth(Integer num) {
        this.video_width = num;
        return this;
    }

    public InlineQueryResultVideo parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }

    public InlineQueryResultVideo(String str, String str2, String str3, String str4, String str5) {
        super("video", str);
        this.video_url = str2;
        this.mime_type = str3;
        this.thumbnail_url = str4;
        this.title = str5;
    }
}
