package com.pengrad.telegrambot.utility.kotlin;

import androidx.exifinterface.media.ExifInterface;
import c9.l;
import com.pengrad.telegrambot.request.KBaseRequest;
import e9.d;
import i9.k;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0010\b\u0000\u0010\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0005BI\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012,\b\u0002\u0010\u000b\u001a&\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tj\u0012\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\n¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u00002\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0006\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J0\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000e\u001a\u00028\u00002\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0016\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u00002\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J,\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u00002\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0006\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0013R\u0016\u0010\u0006\u001a\u00028\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001aR8\u0010\u000b\u001a&\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tj\u0012\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "Lcom/pengrad/telegrambot/request/KBaseRequest;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Le9/d;", "", "value", "", "customParameterName", "Lkotlin/Function1;", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterValueMapper;", "valueMapper", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lc9/l;)V", "thisRef", "Li9/k;", "property", "Lr8/z;", "updateRequestValue", "(Lcom/pengrad/telegrambot/request/KBaseRequest;Li9/k;Ljava/lang/Object;)V", "provideDelegate", "(Lcom/pengrad/telegrambot/request/KBaseRequest;Li9/k;)Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getValue", "(Lcom/pengrad/telegrambot/request/KBaseRequest;Li9/k;)Ljava/lang/Object;", "setValue", "Ljava/lang/Object;", "Ljava/lang/String;", "Lc9/l;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RequestParameterDelegate<T extends KBaseRequest<?, ?>, V> implements d<T, V> {
    private final String customParameterName;
    private V value;
    private final l<V, Object> valueMapper;

    /* JADX WARN: Multi-variable type inference failed */
    public RequestParameterDelegate(V v10, String str, l<? super V, ? extends Object> lVar) {
        this.value = v10;
        this.customParameterName = str;
        this.valueMapper = lVar;
    }

    @Override // e9.d, e9.c
    public /* bridge */ /* synthetic */ Object getValue(Object obj, k kVar) {
        return getValue((KBaseRequest) obj, (k<?>) kVar);
    }

    public /* bridge */ /* synthetic */ Object provideDelegate(Object obj, k kVar) {
        return provideDelegate((KBaseRequest) obj, (k<?>) kVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e9.d
    public /* bridge */ /* synthetic */ void setValue(Object obj, k kVar, Object obj2) {
        setValue((KBaseRequest) obj, (k<?>) kVar, obj2);
    }

    private final void updateRequestValue(T thisRef, k<?> property, V value) {
        Object objInvoke;
        String strConvertToSnakeCase = this.customParameterName;
        if (strConvertToSnakeCase == null) {
            strConvertToSnakeCase = RequestParameterDelegateKt.convertToSnakeCase(property.getName());
        }
        l<V, Object> lVar = this.valueMapper;
        if (lVar != null && (objInvoke = lVar.invoke(value)) != null) {
            value = (V) objInvoke;
        }
        thisRef.addParameter$library(strConvertToSnakeCase, value);
    }

    public V getValue(T thisRef, k<?> property) {
        m.f(thisRef, "thisRef");
        m.f(property, "property");
        return this.value;
    }

    public RequestParameterDelegate<T, V> provideDelegate(T thisRef, k<?> property) {
        m.f(thisRef, "thisRef");
        m.f(property, "property");
        V v10 = this.value;
        if (v10 != null) {
            updateRequestValue(thisRef, property, v10);
        }
        return this;
    }

    public void setValue(T thisRef, k<?> property, V value) {
        m.f(thisRef, "thisRef");
        m.f(property, "property");
        updateRequestValue(thisRef, property, value);
        this.value = value;
    }

    public /* synthetic */ RequestParameterDelegate(Object obj, String str, l lVar, int i10, g gVar) {
        this(obj, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : lVar);
    }
}
