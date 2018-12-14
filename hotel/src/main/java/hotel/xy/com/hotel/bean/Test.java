package hotel.xy.com.hotel.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Test implements Parcelable {

    /**
     * status : 201
     * message : APP被用户自己禁用，请在控制台解禁
     */

    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.status);
        dest.writeString(this.message);
    }

    public Test() {
    }

    protected Test(Parcel in) {
        this.status = in.readInt();
        this.message = in.readString();
    }

    public static final Parcelable.Creator<Test> CREATOR = new Parcelable.Creator<Test>() {
        @Override
        public Test createFromParcel(Parcel source) {
            return new Test(source);
        }

        @Override
        public Test[] newArray(int size) {
            return new Test[size];
        }
    };
}
