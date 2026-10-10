package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SecureData implements Serializable {
    private static final long serialVersionUID = 0;
    private SecureValue address;
    private SecureValue bank_statement;
    private SecureValue driver_license;
    private SecureValue identity_card;
    private SecureValue internal_passport;
    private SecureValue passport;
    private SecureValue passport_registration;
    private SecureValue personal_details;
    private SecureValue rental_agreement;
    private SecureValue temporary_registration;
    private SecureValue utility_bill;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SecureData secureData = (SecureData) obj;
            SecureValue secureValue = this.personal_details;
            if (secureValue == null ? secureData.personal_details != null : !secureValue.equals(secureData.personal_details)) {
                return false;
            }
            SecureValue secureValue2 = this.passport;
            if (secureValue2 == null ? secureData.passport != null : !secureValue2.equals(secureData.passport)) {
                return false;
            }
            SecureValue secureValue3 = this.internal_passport;
            if (secureValue3 == null ? secureData.internal_passport != null : !secureValue3.equals(secureData.internal_passport)) {
                return false;
            }
            SecureValue secureValue4 = this.driver_license;
            if (secureValue4 == null ? secureData.driver_license != null : !secureValue4.equals(secureData.driver_license)) {
                return false;
            }
            SecureValue secureValue5 = this.identity_card;
            if (secureValue5 == null ? secureData.identity_card != null : !secureValue5.equals(secureData.identity_card)) {
                return false;
            }
            SecureValue secureValue6 = this.address;
            if (secureValue6 == null ? secureData.address != null : !secureValue6.equals(secureData.address)) {
                return false;
            }
            SecureValue secureValue7 = this.utility_bill;
            if (secureValue7 == null ? secureData.utility_bill != null : !secureValue7.equals(secureData.utility_bill)) {
                return false;
            }
            SecureValue secureValue8 = this.bank_statement;
            if (secureValue8 == null ? secureData.bank_statement != null : !secureValue8.equals(secureData.bank_statement)) {
                return false;
            }
            SecureValue secureValue9 = this.rental_agreement;
            if (secureValue9 == null ? secureData.rental_agreement != null : !secureValue9.equals(secureData.rental_agreement)) {
                return false;
            }
            SecureValue secureValue10 = this.passport_registration;
            if (secureValue10 == null ? secureData.passport_registration != null : !secureValue10.equals(secureData.passport_registration)) {
                return false;
            }
            SecureValue secureValue11 = this.temporary_registration;
            SecureValue secureValue12 = secureData.temporary_registration;
            if (secureValue11 != null) {
                return secureValue11.equals(secureValue12);
            }
            if (secureValue12 == null) {
                return true;
            }
        }
        return false;
    }

    public SecureValue address() {
        return this.address;
    }

    public SecureValue bankStatement() {
        return this.bank_statement;
    }

    public SecureValue driverLicense() {
        return this.driver_license;
    }

    public int hashCode() {
        SecureValue secureValue = this.personal_details;
        int iHashCode = (secureValue != null ? secureValue.hashCode() : 0) * 31;
        SecureValue secureValue2 = this.passport;
        int iHashCode2 = (iHashCode + (secureValue2 != null ? secureValue2.hashCode() : 0)) * 31;
        SecureValue secureValue3 = this.internal_passport;
        int iHashCode3 = (iHashCode2 + (secureValue3 != null ? secureValue3.hashCode() : 0)) * 31;
        SecureValue secureValue4 = this.driver_license;
        int iHashCode4 = (iHashCode3 + (secureValue4 != null ? secureValue4.hashCode() : 0)) * 31;
        SecureValue secureValue5 = this.identity_card;
        int iHashCode5 = (iHashCode4 + (secureValue5 != null ? secureValue5.hashCode() : 0)) * 31;
        SecureValue secureValue6 = this.address;
        int iHashCode6 = (iHashCode5 + (secureValue6 != null ? secureValue6.hashCode() : 0)) * 31;
        SecureValue secureValue7 = this.utility_bill;
        int iHashCode7 = (iHashCode6 + (secureValue7 != null ? secureValue7.hashCode() : 0)) * 31;
        SecureValue secureValue8 = this.bank_statement;
        int iHashCode8 = (iHashCode7 + (secureValue8 != null ? secureValue8.hashCode() : 0)) * 31;
        SecureValue secureValue9 = this.rental_agreement;
        int iHashCode9 = (iHashCode8 + (secureValue9 != null ? secureValue9.hashCode() : 0)) * 31;
        SecureValue secureValue10 = this.passport_registration;
        int iHashCode10 = (iHashCode9 + (secureValue10 != null ? secureValue10.hashCode() : 0)) * 31;
        SecureValue secureValue11 = this.temporary_registration;
        return iHashCode10 + (secureValue11 != null ? secureValue11.hashCode() : 0);
    }

    public SecureValue identityCard() {
        return this.identity_card;
    }

    public SecureValue internalPassport() {
        return this.internal_passport;
    }

    public SecureValue passport() {
        return this.passport;
    }

    public SecureValue passportRegistration() {
        return this.passport_registration;
    }

    public SecureValue personalDetails() {
        return this.personal_details;
    }

    public SecureValue rentalAgreement() {
        return this.rental_agreement;
    }

    public SecureValue temporaryRegistration() {
        return this.temporary_registration;
    }

    public String toString() {
        return "SecureData{personal_details=" + this.personal_details + ", passport=" + this.passport + ", internal_passport=" + this.internal_passport + ", driver_license=" + this.driver_license + ", identity_card=" + this.identity_card + ", address=" + this.address + ", utility_bill=" + this.utility_bill + ", bank_statement=" + this.bank_statement + ", rental_agreement=" + this.rental_agreement + ", passport_registration=" + this.passport_registration + ", temporary_registration=" + this.temporary_registration + '}';
    }

    public SecureValue utilityBill() {
        return this.utility_bill;
    }

    public SecureValue ofType(EncryptedPassportElement.Type type) {
        try {
            return (SecureValue) getClass().getDeclaredField(type.name()).get(this);
        } catch (Exception unused) {
            return null;
        }
    }
}
