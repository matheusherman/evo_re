package com.google.gson;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class p extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f4924a;

    public p(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f4924a = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f4924a == null) {
            return pVar.f4924a == null;
        }
        if (v(this) && v(pVar)) {
            return s().longValue() == pVar.s().longValue();
        }
        Object obj2 = this.f4924a;
        if (!(obj2 instanceof Number) || !(pVar.f4924a instanceof Number)) {
            return obj2.equals(pVar.f4924a);
        }
        double dDoubleValue = s().doubleValue();
        double dDoubleValue2 = pVar.s().doubleValue();
        return dDoubleValue == dDoubleValue2 || (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2));
    }

    private static boolean v(p pVar) {
        Object obj = pVar.f4924a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f4924a == null) {
            return 31;
        }
        if (v(this)) {
            jDoubleToLongBits = s().longValue();
        } else {
            Object obj = this.f4924a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(s().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public Number s() {
        Object obj = this.f4924a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new com.google.gson.internal.g((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public String t() {
        Object obj = this.f4924a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (w()) {
            return s().toString();
        }
        if (u()) {
            return ((Boolean) this.f4924a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f4924a.getClass());
    }

    public boolean u() {
        return this.f4924a instanceof Boolean;
    }

    public boolean w() {
        return this.f4924a instanceof Number;
    }

    public boolean x() {
        return this.f4924a instanceof String;
    }

    public p(Number number) {
        Objects.requireNonNull(number);
        this.f4924a = number;
    }

    public boolean n() {
        if (u()) {
            return ((Boolean) this.f4924a).booleanValue();
        }
        return Boolean.parseBoolean(t());
    }

    public double o() {
        if (w()) {
            return s().doubleValue();
        }
        return Double.parseDouble(t());
    }

    public int q() {
        if (w()) {
            return s().intValue();
        }
        return Integer.parseInt(t());
    }

    public long r() {
        if (w()) {
            return s().longValue();
        }
        return Long.parseLong(t());
    }

    public p(String str) {
        Objects.requireNonNull(str);
        this.f4924a = str;
    }
}
