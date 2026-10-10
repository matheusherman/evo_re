package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class StickerSet implements Serializable {
    private static final long serialVersionUID = 0;
    private String name;
    private Sticker.Type sticker_type;
    private Sticker[] stickers;
    private PhotoSize thumbnail;
    private String title;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            StickerSet stickerSet = (StickerSet) obj;
            if (Objects.equals(this.name, stickerSet.name) && Objects.equals(this.title, stickerSet.title) && this.sticker_type == stickerSet.sticker_type && Arrays.equals(this.stickers, stickerSet.stickers) && Objects.equals(this.thumbnail, stickerSet.thumbnail)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Objects.hash(this.name, this.title, this.sticker_type, this.thumbnail) * 31) + Arrays.hashCode(this.stickers);
    }

    public String name() {
        return this.name;
    }

    public Sticker.Type stickerType() {
        return this.sticker_type;
    }

    public Sticker[] stickers() {
        return this.stickers;
    }

    public PhotoSize thumbnail() {
        return this.thumbnail;
    }

    public String title() {
        return this.title;
    }

    public String toString() {
        return "StickerSet{name='" + this.name + "', title='" + this.title + "', sticker_type=" + this.sticker_type + ", stickers=" + Arrays.toString(this.stickers) + ", thumbnail=" + this.thumbnail + '}';
    }
}
