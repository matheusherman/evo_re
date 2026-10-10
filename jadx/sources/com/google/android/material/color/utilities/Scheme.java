package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Deprecated
public class Scheme {
    private int background;
    private int error;
    private int errorContainer;
    private int inverseOnSurface;
    private int inversePrimary;
    private int inverseSurface;
    private int onBackground;
    private int onError;
    private int onErrorContainer;
    private int onPrimary;
    private int onPrimaryContainer;
    private int onSecondary;
    private int onSecondaryContainer;
    private int onSurface;
    private int onSurfaceVariant;
    private int onTertiary;
    private int onTertiaryContainer;
    private int outline;
    private int outlineVariant;
    private int primary;
    private int primaryContainer;
    private int scrim;
    private int secondary;
    private int secondaryContainer;
    private int shadow;
    private int surface;
    private int surfaceVariant;
    private int tertiary;
    private int tertiaryContainer;

    public Scheme() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scheme)) {
            return false;
        }
        Scheme scheme = (Scheme) obj;
        return this.primary == scheme.primary && this.onPrimary == scheme.onPrimary && this.primaryContainer == scheme.primaryContainer && this.onPrimaryContainer == scheme.onPrimaryContainer && this.secondary == scheme.secondary && this.onSecondary == scheme.onSecondary && this.secondaryContainer == scheme.secondaryContainer && this.onSecondaryContainer == scheme.onSecondaryContainer && this.tertiary == scheme.tertiary && this.onTertiary == scheme.onTertiary && this.tertiaryContainer == scheme.tertiaryContainer && this.onTertiaryContainer == scheme.onTertiaryContainer && this.error == scheme.error && this.onError == scheme.onError && this.errorContainer == scheme.errorContainer && this.onErrorContainer == scheme.onErrorContainer && this.background == scheme.background && this.onBackground == scheme.onBackground && this.surface == scheme.surface && this.onSurface == scheme.onSurface && this.surfaceVariant == scheme.surfaceVariant && this.onSurfaceVariant == scheme.onSurfaceVariant && this.outline == scheme.outline && this.outlineVariant == scheme.outlineVariant && this.shadow == scheme.shadow && this.scrim == scheme.scrim && this.inverseSurface == scheme.inverseSurface && this.inverseOnSurface == scheme.inverseOnSurface && this.inversePrimary == scheme.inversePrimary;
    }

    public Scheme(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38) {
        this.primary = i10;
        this.onPrimary = i11;
        this.primaryContainer = i12;
        this.onPrimaryContainer = i13;
        this.secondary = i14;
        this.onSecondary = i15;
        this.secondaryContainer = i16;
        this.onSecondaryContainer = i17;
        this.tertiary = i18;
        this.onTertiary = i19;
        this.tertiaryContainer = i20;
        this.onTertiaryContainer = i21;
        this.error = i22;
        this.onError = i23;
        this.errorContainer = i24;
        this.onErrorContainer = i25;
        this.background = i26;
        this.onBackground = i27;
        this.surface = i28;
        this.onSurface = i29;
        this.surfaceVariant = i30;
        this.onSurfaceVariant = i31;
        this.outline = i32;
        this.outlineVariant = i33;
        this.shadow = i34;
        this.scrim = i35;
        this.inverseSurface = i36;
        this.inverseOnSurface = i37;
        this.inversePrimary = i38;
    }

    private static Scheme darkFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.f4385a1.tone(80)).withOnPrimary(corePalette.f4385a1.tone(20)).withPrimaryContainer(corePalette.f4385a1.tone(30)).withOnPrimaryContainer(corePalette.f4385a1.tone(90)).withSecondary(corePalette.f4386a2.tone(80)).withOnSecondary(corePalette.f4386a2.tone(20)).withSecondaryContainer(corePalette.f4386a2.tone(30)).withOnSecondaryContainer(corePalette.f4386a2.tone(90)).withTertiary(corePalette.f4387a3.tone(80)).withOnTertiary(corePalette.f4387a3.tone(20)).withTertiaryContainer(corePalette.f4387a3.tone(30)).withOnTertiaryContainer(corePalette.f4387a3.tone(90)).withError(corePalette.error.tone(80)).withOnError(corePalette.error.tone(20)).withErrorContainer(corePalette.error.tone(30)).withOnErrorContainer(corePalette.error.tone(80)).withBackground(corePalette.f4388n1.tone(10)).withOnBackground(corePalette.f4388n1.tone(90)).withSurface(corePalette.f4388n1.tone(10)).withOnSurface(corePalette.f4388n1.tone(90)).withSurfaceVariant(corePalette.f4389n2.tone(30)).withOnSurfaceVariant(corePalette.f4389n2.tone(80)).withOutline(corePalette.f4389n2.tone(60)).withOutlineVariant(corePalette.f4389n2.tone(30)).withShadow(corePalette.f4388n1.tone(0)).withScrim(corePalette.f4388n1.tone(0)).withInverseSurface(corePalette.f4388n1.tone(90)).withInverseOnSurface(corePalette.f4388n1.tone(20)).withInversePrimary(corePalette.f4385a1.tone(40));
    }

    private static Scheme lightFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.f4385a1.tone(40)).withOnPrimary(corePalette.f4385a1.tone(100)).withPrimaryContainer(corePalette.f4385a1.tone(90)).withOnPrimaryContainer(corePalette.f4385a1.tone(10)).withSecondary(corePalette.f4386a2.tone(40)).withOnSecondary(corePalette.f4386a2.tone(100)).withSecondaryContainer(corePalette.f4386a2.tone(90)).withOnSecondaryContainer(corePalette.f4386a2.tone(10)).withTertiary(corePalette.f4387a3.tone(40)).withOnTertiary(corePalette.f4387a3.tone(100)).withTertiaryContainer(corePalette.f4387a3.tone(90)).withOnTertiaryContainer(corePalette.f4387a3.tone(10)).withError(corePalette.error.tone(40)).withOnError(corePalette.error.tone(100)).withErrorContainer(corePalette.error.tone(90)).withOnErrorContainer(corePalette.error.tone(10)).withBackground(corePalette.f4388n1.tone(99)).withOnBackground(corePalette.f4388n1.tone(10)).withSurface(corePalette.f4388n1.tone(99)).withOnSurface(corePalette.f4388n1.tone(10)).withSurfaceVariant(corePalette.f4389n2.tone(90)).withOnSurfaceVariant(corePalette.f4389n2.tone(30)).withOutline(corePalette.f4389n2.tone(50)).withOutlineVariant(corePalette.f4389n2.tone(80)).withShadow(corePalette.f4388n1.tone(0)).withScrim(corePalette.f4388n1.tone(0)).withInverseSurface(corePalette.f4388n1.tone(20)).withInverseOnSurface(corePalette.f4388n1.tone(95)).withInversePrimary(corePalette.f4385a1.tone(80));
    }

    public int getBackground() {
        return this.background;
    }

    public int getError() {
        return this.error;
    }

    public int getErrorContainer() {
        return this.errorContainer;
    }

    public int getInverseOnSurface() {
        return this.inverseOnSurface;
    }

    public int getInversePrimary() {
        return this.inversePrimary;
    }

    public int getInverseSurface() {
        return this.inverseSurface;
    }

    public int getOnBackground() {
        return this.onBackground;
    }

    public int getOnError() {
        return this.onError;
    }

    public int getOnErrorContainer() {
        return this.onErrorContainer;
    }

    public int getOnPrimary() {
        return this.onPrimary;
    }

    public int getOnPrimaryContainer() {
        return this.onPrimaryContainer;
    }

    public int getOnSecondary() {
        return this.onSecondary;
    }

    public int getOnSecondaryContainer() {
        return this.onSecondaryContainer;
    }

    public int getOnSurface() {
        return this.onSurface;
    }

    public int getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    public int getOnTertiary() {
        return this.onTertiary;
    }

    public int getOnTertiaryContainer() {
        return this.onTertiaryContainer;
    }

    public int getOutline() {
        return this.outline;
    }

    public int getOutlineVariant() {
        return this.outlineVariant;
    }

    public int getPrimary() {
        return this.primary;
    }

    public int getPrimaryContainer() {
        return this.primaryContainer;
    }

    public int getScrim() {
        return this.scrim;
    }

    public int getSecondary() {
        return this.secondary;
    }

    public int getSecondaryContainer() {
        return this.secondaryContainer;
    }

    public int getShadow() {
        return this.shadow;
    }

    public int getSurface() {
        return this.surface;
    }

    public int getSurfaceVariant() {
        return this.surfaceVariant;
    }

    public int getTertiary() {
        return this.tertiary;
    }

    public int getTertiaryContainer() {
        return this.tertiaryContainer;
    }

    public void setBackground(int i10) {
        this.background = i10;
    }

    public void setError(int i10) {
        this.error = i10;
    }

    public void setErrorContainer(int i10) {
        this.errorContainer = i10;
    }

    public void setInverseOnSurface(int i10) {
        this.inverseOnSurface = i10;
    }

    public void setInversePrimary(int i10) {
        this.inversePrimary = i10;
    }

    public void setInverseSurface(int i10) {
        this.inverseSurface = i10;
    }

    public void setOnBackground(int i10) {
        this.onBackground = i10;
    }

    public void setOnError(int i10) {
        this.onError = i10;
    }

    public void setOnErrorContainer(int i10) {
        this.onErrorContainer = i10;
    }

    public void setOnPrimary(int i10) {
        this.onPrimary = i10;
    }

    public void setOnPrimaryContainer(int i10) {
        this.onPrimaryContainer = i10;
    }

    public void setOnSecondary(int i10) {
        this.onSecondary = i10;
    }

    public void setOnSecondaryContainer(int i10) {
        this.onSecondaryContainer = i10;
    }

    public void setOnSurface(int i10) {
        this.onSurface = i10;
    }

    public void setOnSurfaceVariant(int i10) {
        this.onSurfaceVariant = i10;
    }

    public void setOnTertiary(int i10) {
        this.onTertiary = i10;
    }

    public void setOnTertiaryContainer(int i10) {
        this.onTertiaryContainer = i10;
    }

    public void setOutline(int i10) {
        this.outline = i10;
    }

    public void setOutlineVariant(int i10) {
        this.outlineVariant = i10;
    }

    public void setPrimary(int i10) {
        this.primary = i10;
    }

    public void setPrimaryContainer(int i10) {
        this.primaryContainer = i10;
    }

    public void setScrim(int i10) {
        this.scrim = i10;
    }

    public void setSecondary(int i10) {
        this.secondary = i10;
    }

    public void setSecondaryContainer(int i10) {
        this.secondaryContainer = i10;
    }

    public void setShadow(int i10) {
        this.shadow = i10;
    }

    public void setSurface(int i10) {
        this.surface = i10;
    }

    public void setSurfaceVariant(int i10) {
        this.surfaceVariant = i10;
    }

    public void setTertiary(int i10) {
        this.tertiary = i10;
    }

    public void setTertiaryContainer(int i10) {
        this.tertiaryContainer = i10;
    }

    public String toString() {
        return "Scheme{primary=" + this.primary + ", onPrimary=" + this.onPrimary + ", primaryContainer=" + this.primaryContainer + ", onPrimaryContainer=" + this.onPrimaryContainer + ", secondary=" + this.secondary + ", onSecondary=" + this.onSecondary + ", secondaryContainer=" + this.secondaryContainer + ", onSecondaryContainer=" + this.onSecondaryContainer + ", tertiary=" + this.tertiary + ", onTertiary=" + this.onTertiary + ", tertiaryContainer=" + this.tertiaryContainer + ", onTertiaryContainer=" + this.onTertiaryContainer + ", error=" + this.error + ", onError=" + this.onError + ", errorContainer=" + this.errorContainer + ", onErrorContainer=" + this.onErrorContainer + ", background=" + this.background + ", onBackground=" + this.onBackground + ", surface=" + this.surface + ", onSurface=" + this.onSurface + ", surfaceVariant=" + this.surfaceVariant + ", onSurfaceVariant=" + this.onSurfaceVariant + ", outline=" + this.outline + ", outlineVariant=" + this.outlineVariant + ", shadow=" + this.shadow + ", scrim=" + this.scrim + ", inverseSurface=" + this.inverseSurface + ", inverseOnSurface=" + this.inverseOnSurface + ", inversePrimary=" + this.inversePrimary + '}';
    }

    public Scheme withBackground(int i10) {
        this.background = i10;
        return this;
    }

    public Scheme withError(int i10) {
        this.error = i10;
        return this;
    }

    public Scheme withErrorContainer(int i10) {
        this.errorContainer = i10;
        return this;
    }

    public Scheme withInverseOnSurface(int i10) {
        this.inverseOnSurface = i10;
        return this;
    }

    public Scheme withInversePrimary(int i10) {
        this.inversePrimary = i10;
        return this;
    }

    public Scheme withInverseSurface(int i10) {
        this.inverseSurface = i10;
        return this;
    }

    public Scheme withOnBackground(int i10) {
        this.onBackground = i10;
        return this;
    }

    public Scheme withOnError(int i10) {
        this.onError = i10;
        return this;
    }

    public Scheme withOnErrorContainer(int i10) {
        this.onErrorContainer = i10;
        return this;
    }

    public Scheme withOnPrimary(int i10) {
        this.onPrimary = i10;
        return this;
    }

    public Scheme withOnPrimaryContainer(int i10) {
        this.onPrimaryContainer = i10;
        return this;
    }

    public Scheme withOnSecondary(int i10) {
        this.onSecondary = i10;
        return this;
    }

    public Scheme withOnSecondaryContainer(int i10) {
        this.onSecondaryContainer = i10;
        return this;
    }

    public Scheme withOnSurface(int i10) {
        this.onSurface = i10;
        return this;
    }

    public Scheme withOnSurfaceVariant(int i10) {
        this.onSurfaceVariant = i10;
        return this;
    }

    public Scheme withOnTertiary(int i10) {
        this.onTertiary = i10;
        return this;
    }

    public Scheme withOnTertiaryContainer(int i10) {
        this.onTertiaryContainer = i10;
        return this;
    }

    public Scheme withOutline(int i10) {
        this.outline = i10;
        return this;
    }

    public Scheme withOutlineVariant(int i10) {
        this.outlineVariant = i10;
        return this;
    }

    public Scheme withPrimary(int i10) {
        this.primary = i10;
        return this;
    }

    public Scheme withPrimaryContainer(int i10) {
        this.primaryContainer = i10;
        return this;
    }

    public Scheme withScrim(int i10) {
        this.scrim = i10;
        return this;
    }

    public Scheme withSecondary(int i10) {
        this.secondary = i10;
        return this;
    }

    public Scheme withSecondaryContainer(int i10) {
        this.secondaryContainer = i10;
        return this;
    }

    public Scheme withShadow(int i10) {
        this.shadow = i10;
        return this;
    }

    public Scheme withSurface(int i10) {
        this.surface = i10;
        return this;
    }

    public Scheme withSurfaceVariant(int i10) {
        this.surfaceVariant = i10;
        return this;
    }

    public Scheme withTertiary(int i10) {
        this.tertiary = i10;
        return this;
    }

    public Scheme withTertiaryContainer(int i10) {
        this.tertiaryContainer = i10;
        return this;
    }

    public static Scheme dark(int i10) {
        return darkFromCorePalette(CorePalette.of(i10));
    }

    public static Scheme darkContent(int i10) {
        return darkFromCorePalette(CorePalette.contentOf(i10));
    }

    public static Scheme light(int i10) {
        return lightFromCorePalette(CorePalette.of(i10));
    }

    public static Scheme lightContent(int i10) {
        return lightFromCorePalette(CorePalette.contentOf(i10));
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((System.identityHashCode(this) * 31) + this.primary) * 31) + this.onPrimary) * 31) + this.primaryContainer) * 31) + this.onPrimaryContainer) * 31) + this.secondary) * 31) + this.onSecondary) * 31) + this.secondaryContainer) * 31) + this.onSecondaryContainer) * 31) + this.tertiary) * 31) + this.onTertiary) * 31) + this.tertiaryContainer) * 31) + this.onTertiaryContainer) * 31) + this.error) * 31) + this.onError) * 31) + this.errorContainer) * 31) + this.onErrorContainer) * 31) + this.background) * 31) + this.onBackground) * 31) + this.surface) * 31) + this.onSurface) * 31) + this.surfaceVariant) * 31) + this.onSurfaceVariant) * 31) + this.outline) * 31) + this.outlineVariant) * 31) + this.shadow) * 31) + this.scrim) * 31) + this.inverseSurface) * 31) + this.inverseOnSurface) * 31) + this.inversePrimary;
    }
}
