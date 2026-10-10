package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MaskPosition implements Serializable {
    private static final long serialVersionUID = 0;
    private String point;
    private Float scale;
    private Float x_shift;
    private Float y_shift;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Point {
        forehead,
        eyes,
        mouth,
        chin
    }

    MaskPosition() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MaskPosition maskPosition = (MaskPosition) obj;
            String str = this.point;
            if (str == null ? maskPosition.point != null : !str.equals(maskPosition.point)) {
                return false;
            }
            Float f10 = this.x_shift;
            if (f10 == null ? maskPosition.x_shift != null : !f10.equals(maskPosition.x_shift)) {
                return false;
            }
            Float f11 = this.y_shift;
            if (f11 == null ? maskPosition.y_shift != null : !f11.equals(maskPosition.y_shift)) {
                return false;
            }
            Float f12 = this.scale;
            Float f13 = maskPosition.scale;
            if (f12 != null) {
                return f12.equals(f13);
            }
            if (f13 == null) {
                return true;
            }
        }
        return false;
    }

    public MaskPosition(Point point, Float f10, Float f11, Float f12) {
        this(point.name(), f10, f11, f12);
    }

    public int hashCode() {
        String str = this.point;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Float f10 = this.x_shift;
        int iHashCode2 = (iHashCode + (f10 != null ? f10.hashCode() : 0)) * 31;
        Float f11 = this.y_shift;
        int iHashCode3 = (iHashCode2 + (f11 != null ? f11.hashCode() : 0)) * 31;
        Float f12 = this.scale;
        return iHashCode3 + (f12 != null ? f12.hashCode() : 0);
    }

    public String point() {
        return this.point;
    }

    public Float scale() {
        return this.scale;
    }

    public String toString() {
        return "MaskPosition{point='" + this.point + "', x_shift=" + this.x_shift + ", y_shift=" + this.y_shift + ", scale=" + this.scale + '}';
    }

    public Float xShift() {
        return this.x_shift;
    }

    public Float yShift() {
        return this.y_shift;
    }

    public MaskPosition(String str, Float f10, Float f11, Float f12) {
        this.point = str;
        this.x_shift = f10;
        this.y_shift = f11;
        this.scale = f12;
    }
}
