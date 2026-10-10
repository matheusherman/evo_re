package com.live.evo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.manager.r;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e extends com.bumptech.glide.l {
    @Override // com.bumptech.glide.l
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public <ResourceType> d<ResourceType> c(@NonNull Class<ResourceType> cls) {
        return new d<>(this.f1347a, this, cls, this.f1348b);
    }

    @Override // com.bumptech.glide.l
    protected void z(@NonNull a0.i iVar) {
        if (iVar instanceof c) {
            super.z(iVar);
        } else {
            super.z(new c().a(iVar));
        }
    }

    public e(@NonNull com.bumptech.glide.c cVar, @NonNull com.bumptech.glide.manager.l lVar, @NonNull r rVar, @NonNull Context context) {
        super(cVar, lVar, rVar, context);
    }

    @Override // com.bumptech.glide.l
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public d<Bitmap> e() {
        return (d) super.e();
    }

    @Override // com.bumptech.glide.l
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public d<Drawable> f() {
        return (d) super.f();
    }

    @Override // com.bumptech.glide.l
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public d<File> m() {
        return (d) super.m();
    }

    @Override // com.bumptech.glide.l
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public d<Drawable> s(@Nullable Bitmap bitmap) {
        return (d) super.s(bitmap);
    }

    @Override // com.bumptech.glide.l
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public d<Drawable> t(@Nullable @DrawableRes @RawRes Integer num) {
        return (d) super.t(num);
    }

    @Override // com.bumptech.glide.l
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public d<Drawable> u(@Nullable String str) {
        return (d) super.u(str);
    }
}
