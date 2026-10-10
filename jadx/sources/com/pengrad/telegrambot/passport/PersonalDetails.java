package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PersonalDetails extends DecryptedData implements Serializable {
    private static final long serialVersionUID = 0;
    private String birth_date;
    private String country_code;
    private String first_name;
    private String first_name_native;
    private String gender;
    private String last_name;
    private String last_name_native;
    private String middle_name;
    private String middle_name_native;
    private String residence_country_code;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PersonalDetails personalDetails = (PersonalDetails) obj;
            String str = this.first_name;
            if (str == null ? personalDetails.first_name != null : !str.equals(personalDetails.first_name)) {
                return false;
            }
            String str2 = this.last_name;
            if (str2 == null ? personalDetails.last_name != null : !str2.equals(personalDetails.last_name)) {
                return false;
            }
            String str3 = this.middle_name;
            if (str3 == null ? personalDetails.middle_name != null : !str3.equals(personalDetails.middle_name)) {
                return false;
            }
            String str4 = this.birth_date;
            if (str4 == null ? personalDetails.birth_date != null : !str4.equals(personalDetails.birth_date)) {
                return false;
            }
            String str5 = this.gender;
            if (str5 == null ? personalDetails.gender != null : !str5.equals(personalDetails.gender)) {
                return false;
            }
            String str6 = this.country_code;
            if (str6 == null ? personalDetails.country_code != null : !str6.equals(personalDetails.country_code)) {
                return false;
            }
            String str7 = this.residence_country_code;
            if (str7 == null ? personalDetails.residence_country_code != null : !str7.equals(personalDetails.residence_country_code)) {
                return false;
            }
            String str8 = this.first_name_native;
            if (str8 == null ? personalDetails.first_name_native != null : !str8.equals(personalDetails.first_name_native)) {
                return false;
            }
            String str9 = this.last_name_native;
            if (str9 == null ? personalDetails.last_name_native != null : !str9.equals(personalDetails.last_name_native)) {
                return false;
            }
            String str10 = this.middle_name_native;
            String str11 = personalDetails.middle_name_native;
            if (str10 != null) {
                return str10.equals(str11);
            }
            if (str11 == null) {
                return true;
            }
        }
        return false;
    }

    public String birthDate() {
        return this.birth_date;
    }

    public String countryCode() {
        return this.country_code;
    }

    public String firstName() {
        return this.first_name;
    }

    public String firstNameNative() {
        return this.first_name_native;
    }

    public String gender() {
        return this.gender;
    }

    public int hashCode() {
        String str = this.first_name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.last_name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.middle_name;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.birth_date;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.gender;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.country_code;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.residence_country_code;
        int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.first_name_native;
        int iHashCode8 = (iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.last_name_native;
        int iHashCode9 = (iHashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.middle_name_native;
        return iHashCode9 + (str10 != null ? str10.hashCode() : 0);
    }

    public String lastName() {
        return this.last_name;
    }

    public String lastNameNative() {
        return this.last_name_native;
    }

    public String middleName() {
        return this.middle_name;
    }

    public String middleNameNative() {
        return this.middle_name_native;
    }

    public String residenceCountryCode() {
        return this.residence_country_code;
    }

    public String toString() {
        return "PersonalDetails{first_name='" + this.first_name + "', last_name='" + this.last_name + "', middle_name='" + this.middle_name + "', birth_date='" + this.birth_date + "', gender='" + this.gender + "', country_code='" + this.country_code + "', residence_country_code='" + this.residence_country_code + "', first_name_native='" + this.first_name_native + "', last_name_native='" + this.last_name_native + "', middle_name_native='" + this.middle_name_native + "'}";
    }
}
