package deepin.anotationautopacelable.pacelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by li on 2018/2/24.
 */

public class UserInfo0 implements Parcelable {

    @ParcelableField
    public String mId;

    public UserInfo0() {
    }


    protected UserInfo0(Parcel in) {
        mId = in.readString();
    }

    public static final Creator<UserInfo0> CREATOR = new Creator<UserInfo0>() {
        @Override
        public UserInfo0 createFromParcel(Parcel in) {
            return new UserInfo0(in);
        }
        @Override
        public UserInfo0[] newArray(int size) {
            return new UserInfo0[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;//默认返回O
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
    }

}
