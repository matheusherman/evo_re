package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class LinkPreviewOptions implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean is_disabled;
    private Boolean prefer_large_media;
    private Boolean prefer_small_media;
    private Boolean show_above_text;
    private String url;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            LinkPreviewOptions linkPreviewOptions = (LinkPreviewOptions) obj;
            if (Objects.equals(this.is_disabled, linkPreviewOptions.is_disabled) && Objects.equals(this.url, linkPreviewOptions.url) && Objects.equals(this.prefer_small_media, linkPreviewOptions.prefer_small_media) && Objects.equals(this.prefer_large_media, linkPreviewOptions.prefer_large_media) && Objects.equals(this.show_above_text, linkPreviewOptions.show_above_text)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isDisabled() {
        return this.is_disabled;
    }

    public Boolean preferLargeMedia() {
        return this.prefer_large_media;
    }

    public Boolean preferSmallMedia() {
        return this.prefer_small_media;
    }

    public Boolean showAboveText() {
        return this.show_above_text;
    }

    public String url() {
        return this.url;
    }

    public int hashCode() {
        return Objects.hash(this.is_disabled, this.url, this.prefer_small_media, this.prefer_large_media, this.show_above_text);
    }

    public LinkPreviewOptions isDisabled(boolean z10) {
        this.is_disabled = Boolean.valueOf(z10);
        return this;
    }

    public LinkPreviewOptions preferLargeMedia(Boolean bool) {
        this.prefer_large_media = bool;
        return this;
    }

    public LinkPreviewOptions preferSmallMedia(Boolean bool) {
        this.prefer_small_media = bool;
        return this;
    }

    public LinkPreviewOptions showAboveText(Boolean bool) {
        this.show_above_text = bool;
        return this;
    }

    public String toString() {
        return "LinkPreviewOptions{is_disabled='" + this.is_disabled + "',url='" + this.url + "',prefer_small_media='" + this.prefer_small_media + "',prefer_large_media='" + this.prefer_large_media + "',show_above_text='" + this.show_above_text + "'}";
    }

    public LinkPreviewOptions url(String str) {
        this.url = str;
        return this;
    }
}
