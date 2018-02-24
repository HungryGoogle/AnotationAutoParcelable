package deepin.anotationautopacelable.pacelable;

import android.os.Parcel;

/**
 * Created by li on 2018/2/24.
 */

public class UserInfo extends BaseParcelable {

    // =========================================================================
    // 1、需要序列化的，增加注解 @ParcelableField
    @ParcelableField
    public String mId;

    @ParcelableField
    public String mName;

    @ParcelableField
    public boolean bMale;

    @ParcelableField
    public int mAge;

    @ParcelableField
    public float mMoney;

    // =========================================================================
    // 2、直接将下面的 UserInfo 替换为你的 class名字 即可
    public UserInfo() {
    }

    protected UserInfo(Parcel in) {
        super(in);
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
    // =========================================================================
}
