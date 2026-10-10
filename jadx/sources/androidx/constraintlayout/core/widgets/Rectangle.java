package androidx.constraintlayout.core.widgets;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f324x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f325y;

    public boolean contains(int i10, int i11) {
        int i12;
        int i13 = this.f324x;
        return i10 >= i13 && i10 < i13 + this.width && i11 >= (i12 = this.f325y) && i11 < i12 + this.height;
    }

    public int getCenterX() {
        return (this.f324x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f325y + this.height) / 2;
    }

    void grow(int i10, int i11) {
        this.f324x -= i10;
        this.f325y -= i11;
        this.width += i10 * 2;
        this.height += i11 * 2;
    }

    boolean intersects(Rectangle rectangle) {
        int i10;
        int i11;
        int i12 = this.f324x;
        int i13 = rectangle.f324x;
        return i12 >= i13 && i12 < i13 + rectangle.width && (i10 = this.f325y) >= (i11 = rectangle.f325y) && i10 < i11 + rectangle.height;
    }

    public void setBounds(int i10, int i11, int i12, int i13) {
        this.f324x = i10;
        this.f325y = i11;
        this.width = i12;
        this.height = i13;
    }
}
