package hotel.xy.com.hotel.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class SetMenu implements Parcelable {
    private String txt;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public static Creator<SetMenu> getCREATOR() {
        return CREATOR;
    }

    private int img;

    public String getTxt() {
        return txt;
    }

    public SetMenu(String txt, int img) {
        this.txt = txt;
        this.img = img;
    }

    public void setTxt(String txt) {
        this.txt = txt;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.txt);
    }

    public SetMenu() {
    }

    protected SetMenu(Parcel in) {
        this.txt = in.readString();
    }

    public static final Parcelable.Creator<SetMenu> CREATOR = new Parcelable.Creator<SetMenu>() {
        @Override
        public SetMenu createFromParcel(Parcel source) {
            return new SetMenu(source);
        }

        @Override
        public SetMenu[] newArray(int size) {
            return new SetMenu[size];
        }
    };
}
