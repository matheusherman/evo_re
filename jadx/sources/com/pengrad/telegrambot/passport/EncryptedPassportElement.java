package com.pengrad.telegrambot.passport;

import com.google.gson.e;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.passport.decrypt.Decrypt;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.response.GetFileResponse;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class EncryptedPassportElement implements Serializable {
    private static final long serialVersionUID = 0;
    private String data;
    private String email;
    private PassportFile[] files;
    private PassportFile front_side;
    private String hash;
    private String phone_number;
    private PassportFile reverse_side;
    private PassportFile selfie;
    private PassportFile[] translation;
    private Type type;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Type {
        personal_details,
        passport,
        driver_license,
        identity_card,
        internal_passport,
        address,
        utility_bill,
        bank_statement,
        rental_agreement,
        passport_registration,
        temporary_registration,
        phone_number,
        email
    }

    public byte[] decryptFile(PassportFile passportFile, FileCredentials fileCredentials, TelegramBot telegramBot) {
        return decryptFile(telegramBot.getFileContent(((GetFileResponse) telegramBot.execute(new GetFile(passportFile.fileId()))).file()), fileCredentials);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            EncryptedPassportElement encryptedPassportElement = (EncryptedPassportElement) obj;
            if (this.type != encryptedPassportElement.type) {
                return false;
            }
            String str = this.data;
            if (str == null ? encryptedPassportElement.data != null : !str.equals(encryptedPassportElement.data)) {
                return false;
            }
            String str2 = this.phone_number;
            if (str2 == null ? encryptedPassportElement.phone_number != null : !str2.equals(encryptedPassportElement.phone_number)) {
                return false;
            }
            String str3 = this.email;
            if (str3 == null ? encryptedPassportElement.email != null : !str3.equals(encryptedPassportElement.email)) {
                return false;
            }
            if (!Arrays.equals(this.files, encryptedPassportElement.files)) {
                return false;
            }
            PassportFile passportFile = this.front_side;
            if (passportFile == null ? encryptedPassportElement.front_side != null : !passportFile.equals(encryptedPassportElement.front_side)) {
                return false;
            }
            PassportFile passportFile2 = this.reverse_side;
            if (passportFile2 == null ? encryptedPassportElement.reverse_side != null : !passportFile2.equals(encryptedPassportElement.reverse_side)) {
                return false;
            }
            PassportFile passportFile3 = this.selfie;
            if (passportFile3 == null ? encryptedPassportElement.selfie != null : !passportFile3.equals(encryptedPassportElement.selfie)) {
                return false;
            }
            if (!Arrays.equals(this.translation, encryptedPassportElement.translation)) {
                return false;
            }
            String str4 = this.hash;
            String str5 = encryptedPassportElement.hash;
            if (str4 != null) {
                return str4.equals(str5);
            }
            if (str5 == null) {
                return true;
            }
        }
        return false;
    }

    private Class<? extends DecryptedData> dataClass() {
        Type type = Type.personal_details;
        Type type2 = this.type;
        if (type == type2) {
            return PersonalDetails.class;
        }
        if (Type.passport == type2 || Type.internal_passport == type2 || Type.driver_license == type2 || Type.identity_card == type2) {
            return IdDocumentData.class;
        }
        if (Type.address == type2) {
            return ResidentialAddress.class;
        }
        return null;
    }

    public String data() {
        return this.data;
    }

    public String email() {
        return this.email;
    }

    public PassportFile[] files() {
        return this.files;
    }

    public PassportFile frontSide() {
        return this.front_side;
    }

    public String hash() {
        return this.hash;
    }

    public int hashCode() {
        Type type = this.type;
        int iHashCode = (type != null ? type.hashCode() : 0) * 31;
        String str = this.data;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.phone_number;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.email;
        int iHashCode4 = (((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.files)) * 31;
        PassportFile passportFile = this.front_side;
        int iHashCode5 = (iHashCode4 + (passportFile != null ? passportFile.hashCode() : 0)) * 31;
        PassportFile passportFile2 = this.reverse_side;
        int iHashCode6 = (iHashCode5 + (passportFile2 != null ? passportFile2.hashCode() : 0)) * 31;
        PassportFile passportFile3 = this.selfie;
        int iHashCode7 = (((iHashCode6 + (passportFile3 != null ? passportFile3.hashCode() : 0)) * 31) + Arrays.hashCode(this.translation)) * 31;
        String str4 = this.hash;
        return iHashCode7 + (str4 != null ? str4.hashCode() : 0);
    }

    public String phoneNumber() {
        return this.phone_number;
    }

    public PassportFile reverseSide() {
        return this.reverse_side;
    }

    public PassportFile selfie() {
        return this.selfie;
    }

    public String toString() {
        return "EncryptedPassportElement{type=" + this.type + ", data='" + this.data + "', phone_number='" + this.phone_number + "', email='" + this.email + "', files=" + Arrays.toString(this.files) + ", front_side=" + this.front_side + ", reverse_side=" + this.reverse_side + ", selfie=" + this.selfie + ", translation=" + Arrays.toString(this.translation) + ", hash='" + this.hash + "'}";
    }

    public PassportFile[] translation() {
        return this.translation;
    }

    public Type type() {
        return this.type;
    }

    private FileCredentials findFileCredentials(PassportFile passportFile, Credentials credentials) {
        SecureValue secureValueOfType = credentials.secureData().ofType(this.type);
        if (passportFile.equals(this.front_side)) {
            return secureValueOfType.frontSide();
        }
        if (passportFile.equals(this.reverse_side)) {
            return secureValueOfType.reverseSide();
        }
        if (passportFile.equals(this.selfie)) {
            return secureValueOfType.selfie();
        }
        int i10 = 0;
        if (this.files != null) {
            int i11 = 0;
            while (true) {
                PassportFile[] passportFileArr = this.files;
                if (i11 >= passportFileArr.length) {
                    break;
                }
                if (passportFile.equals(passportFileArr[i11])) {
                    return secureValueOfType.files()[i11];
                }
                i11++;
            }
        }
        if (this.translation == null) {
            return null;
        }
        while (true) {
            PassportFile[] passportFileArr2 = this.translation;
            if (i10 < passportFileArr2.length) {
                if (passportFile.equals(passportFileArr2[i10])) {
                    return secureValueOfType.translation()[i10];
                }
                i10++;
            } else {
                return null;
            }
        }
    }

    public DecryptedData decryptData(Credentials credentials) {
        Class<? extends DecryptedData> clsDataClass = dataClass();
        if (clsDataClass != null && this.data != null) {
            DataCredentials dataCredentialsData = credentials.secureData().ofType(this.type).data();
            return (DecryptedData) new e().n(Decrypt.decryptData(this.data, dataCredentialsData.dataHash(), dataCredentialsData.secret()), clsDataClass);
        }
        return null;
    }

    public byte[] decryptFile(PassportFile passportFile, Credentials credentials, TelegramBot telegramBot) {
        FileCredentials fileCredentialsFindFileCredentials = findFileCredentials(passportFile, credentials);
        if (fileCredentialsFindFileCredentials != null) {
            return decryptFile(passportFile, fileCredentialsFindFileCredentials, telegramBot);
        }
        throw new IllegalArgumentException("Don't have file credentials for " + passportFile);
    }

    public byte[] decryptFile(byte[] bArr, FileCredentials fileCredentials) {
        return Decrypt.decryptFile(bArr, fileCredentials.fileHash(), fileCredentials.secret());
    }
}
