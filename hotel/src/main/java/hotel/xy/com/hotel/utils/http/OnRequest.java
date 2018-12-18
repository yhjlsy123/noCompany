package hotel.xy.com.hotel.utils.http;


import okhttp3.Call;

public interface OnRequest {
    void onSuccess(Object response, int id, String tag);

    void onFail(Call call, Exception e, int id);

    void inProgress(float progress, long total, int id);

}
