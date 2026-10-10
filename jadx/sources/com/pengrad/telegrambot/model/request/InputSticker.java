package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.AttachName;
import com.pengrad.telegrambot.model.MaskPosition;
import com.pengrad.telegrambot.model.Sticker;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputSticker implements Serializable {
    private static final long serialVersionUID = 0;
    private transient Object attach;
    private transient String attachName;
    private String[] emoji_list;
    private Sticker.Format format;
    private String[] keywords;
    private MaskPosition mask_position;
    private String sticker;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputSticker)) {
            return false;
        }
        InputSticker inputSticker = (InputSticker) obj;
        return Objects.equals(this.sticker, inputSticker.sticker) && Arrays.equals(this.emoji_list, inputSticker.emoji_list) && Objects.equals(this.mask_position, inputSticker.mask_position) && Arrays.equals(this.keywords, inputSticker.keywords) && Objects.equals(this.format, inputSticker.format) && Objects.equals(this.attachName, inputSticker.attachName) && Objects.equals(this.attach, inputSticker.attach);
    }

    public InputSticker format(Sticker.Format format) {
        this.format = format;
        return this;
    }

    public String getAttachName() {
        return this.attachName;
    }

    public Object getAttachment() {
        return this.attach;
    }

    public int hashCode() {
        return (((Objects.hash(this.sticker, this.mask_position, this.format, this.attachName, this.attach) * 31) + Arrays.hashCode(this.emoji_list)) * 31) + Arrays.hashCode(this.keywords);
    }

    public InputSticker keywords(String[] strArr) {
        this.keywords = strArr;
        return this;
    }

    public InputSticker maskPosition(MaskPosition maskPosition) {
        this.mask_position = maskPosition;
        return this;
    }

    public String toString() {
        return "InputSticker{sticker='" + this.sticker + "', emoji_list=" + Arrays.toString(this.emoji_list) + ", mask_position=" + this.mask_position + ", keywords=" + Arrays.toString(this.keywords) + ", format=" + this.format + ", attachName='" + this.attachName + "', attach=" + this.attach + '}';
    }

    public InputSticker(Object obj, Sticker.Format format, String[] strArr) {
        this.format = format;
        this.emoji_list = strArr;
        if (obj instanceof String) {
            this.sticker = (String) obj;
            return;
        }
        this.attach = obj;
        this.attachName = AttachName.next();
        this.sticker = "attach://" + this.attachName;
    }
}
