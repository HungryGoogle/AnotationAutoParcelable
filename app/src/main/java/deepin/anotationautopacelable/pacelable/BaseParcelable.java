package deepin.anotationautopacelable.pacelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * 序列化基类
 *      1、demo 参考{@link UserInfo}
 *      2、需要序列化的参数需要增加注解{@link ParcelableField}
 *
 *      备注：目前支持 int, long, boolean, short, float, double, String
 */
public class BaseParcelable implements Parcelable {
    BaseParcelable() {
    }

    // ----------------------------------------------------------------------------
    // 1 从parcel中读取
    protected BaseParcelable(Parcel in) {
        Field[] declaredFields = getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; ++i) {
            Field field = declaredFields[i];
            if (field.isAnnotationPresent(ParcelableField.class)) {
                readFieldDataFromParcel(in, field);
            }
        }
    }

    // 2 写入到parcel中
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Field[] declaredFields = getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; ++i) {
            Field field = declaredFields[i];
            if (field.isAnnotationPresent(ParcelableField.class)) {
                writeData2Parcel(dest, field);
            }
        }
    }


    // ----------------------------------------------------------------------------
    // 具体实现函数
    private void readFieldDataFromParcel(Parcel in, Field field) {
        try {
            if(!field.isAccessible()) {
                field.setAccessible(true);
            }

            if (field.getType().equals(String.class)) {
                field.set(this, in.readString());
            }
            else if (field.getType().equals(int.class)) {
                field.set(this, in.readInt());
            }
            else if (field.getType().equals(long.class)) {
                field.set(this, in.readLong());
            }
            else if (field.getType().equals(boolean.class)) {
                field.set(this, in.readByte() == 1);
            }
            else if (field.getType().equals(float.class)) {
                field.set(this, in.readFloat());
            }
            else if (field.getType().equals(double.class)) {
                field.set(this, in.readDouble());
            }
            else if (field.getType().equals(short.class)) {
                field.set(this, (short)in.readInt());
            }else{
                Log.e("********","readFieldDataFromParcel not support " + field.getType().toString());
            }

            // 扩展其他类型...
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void writeData2Parcel(Parcel dest, Field field) {
        try {
            if(!field.isAccessible()) {
                field.setAccessible(true);
            }

            if (field.getType().equals(String.class)) {
                dest.writeString((String) field.get(this));
            }
            else if (field.getType().equals(int.class)) {
                dest.writeInt((int) field.get(this));
            }
            else if (field.getType().equals(long.class)) {
                dest.writeLong((long) field.get(this));
            }
            else if (field.getType().equals(boolean.class)) {
                dest.writeInt((boolean)field.get(this) ? 1 : 0);
            }
            else if (field.getType().equals(float.class)) {
                dest.writeFloat((float) field.get(this));
            }
            else if (field.getType().equals(double.class)) {
                dest.writeDouble((double) field.get(this));
            }
            else if (field.getType().equals(short.class)) {
                dest.writeInt((short) field.get(this));
            }
            else {
                Log.e("********","writeData2Parcel not support " + field.getType().toString());
            }

            // 扩展其他类型...
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static final Creator<BaseParcelable> CREATOR = new Creator<BaseParcelable>() {
        @Override
        public BaseParcelable createFromParcel(Parcel in) {
            return new BaseParcelable(in);
        }

        @Override
        public BaseParcelable[] newArray(int size) {
            return new BaseParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;//默认返回O
    }
}
