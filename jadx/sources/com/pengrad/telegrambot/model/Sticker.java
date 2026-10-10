package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Sticker implements Serializable {
    private static final long serialVersionUID = 0;
    private String custom_emoji_id;
    private String emoji;
    private String file_id;
    private Long file_size;
    private String file_unique_id;
    private Integer height;
    private Boolean is_animated;
    private Boolean is_video;
    private MaskPosition mask_position;
    private Boolean needs_repainting;
    private File premium_animation;
    private String set_name;
    private PhotoSize thumbnail;
    private Type type;
    private Integer width;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Format {
        Static,
        animated,
        video
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Type {
        regular,
        mask,
        custom_emoji
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Sticker sticker = (Sticker) obj;
            if (Objects.equals(this.file_id, sticker.file_id) && Objects.equals(this.file_unique_id, sticker.file_unique_id) && Objects.equals(this.type, sticker.type) && Objects.equals(this.width, sticker.width) && Objects.equals(this.height, sticker.height) && Objects.equals(this.is_animated, sticker.is_animated) && Objects.equals(this.is_video, sticker.is_video) && Objects.equals(this.thumbnail, sticker.thumbnail) && Objects.equals(this.emoji, sticker.emoji) && Objects.equals(this.set_name, sticker.set_name) && Objects.equals(this.premium_animation, sticker.premium_animation) && Objects.equals(this.mask_position, sticker.mask_position) && Objects.equals(this.custom_emoji_id, sticker.custom_emoji_id) && Objects.equals(this.needs_repainting, sticker.needs_repainting) && Objects.equals(this.file_size, sticker.file_size)) {
                return true;
            }
        }
        return false;
    }

    public String customEmojiId() {
        return this.custom_emoji_id;
    }

    public String emoji() {
        return this.emoji;
    }

    public String fileId() {
        return this.file_id;
    }

    public Long fileSize() {
        return this.file_size;
    }

    public String fileUniqueId() {
        return this.file_unique_id;
    }

    public int hashCode() {
        String str = this.file_id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public Integer height() {
        return this.height;
    }

    public Boolean isAnimated() {
        return this.is_animated;
    }

    public Boolean isVideo() {
        return this.is_video;
    }

    public MaskPosition maskPosition() {
        return this.mask_position;
    }

    public Boolean needsRepainting() {
        return this.needs_repainting;
    }

    public File premiumAnimation() {
        return this.premium_animation;
    }

    public String setName() {
        return this.set_name;
    }

    public PhotoSize thumbnail() {
        return this.thumbnail;
    }

    public String toString() {
        return "Sticker{file_id='" + this.file_id + "', file_unique_id='" + this.file_unique_id + "', type=" + this.type + ", width=" + this.width + ", height=" + this.height + ", is_animated=" + this.is_animated + ", is_video=" + this.is_video + ", thumbnail=" + this.thumbnail + ", emoji='" + this.emoji + "', set_name='" + this.set_name + "', premium_animation=" + this.premium_animation + ", mask_position=" + this.mask_position + ", custom_emoji_id=" + this.custom_emoji_id + ", needs_repainting=" + this.needs_repainting + ", file_size=" + this.file_size + '}';
    }

    public Type type() {
        return this.type;
    }

    public Integer width() {
        return this.width;
    }
}
