package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Animation implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer duration;
    private String file_id;
    private String file_name;
    private Long file_size;
    private String file_unique_id;
    private Integer height;
    private String mime_type;
    private PhotoSize thumbnail;
    private Integer width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Animation animation = (Animation) obj;
            if (Objects.equals(this.file_id, animation.file_id) && Objects.equals(this.file_unique_id, animation.file_unique_id) && Objects.equals(this.width, animation.width) && Objects.equals(this.height, animation.height) && Objects.equals(this.duration, animation.duration) && Objects.equals(this.thumbnail, animation.thumbnail) && Objects.equals(this.file_name, animation.file_name) && Objects.equals(this.mime_type, animation.mime_type) && Objects.equals(this.file_size, animation.file_size)) {
                return true;
            }
        }
        return false;
    }

    public Integer duration() {
        return this.duration;
    }

    public String fileId() {
        return this.file_id;
    }

    public String fileName() {
        return this.file_name;
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

    public String mimeType() {
        return this.mime_type;
    }

    public PhotoSize thumbnail() {
        return this.thumbnail;
    }

    public String toString() {
        return "Animation{file_id='" + this.file_id + "', file_unique_id='" + this.file_unique_id + "', width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", thumbnail=" + this.thumbnail + ", file_name='" + this.file_name + "', mime_type='" + this.mime_type + "', file_size=" + this.file_size + '}';
    }

    public Integer width() {
        return this.width;
    }
}
