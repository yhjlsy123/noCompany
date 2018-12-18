package hotel.xy.com.hotel.utils.http;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class OkHttpRequestBuilder<T extends OkHttpRequestBuilder> {
    protected String url;
    protected String tag;
    protected Class<?> result;
    protected Map<String, String> headers;
    protected Map<String, Object> params;
    protected int id;

    public T id(int id) {
        this.id = id;
        return (T) this;
    }

    public T url(String url) {
        this.url = url;
        return (T) this;
    }


    public T tag(String tag) {
        this.tag = tag;
        return (T) this;
    }

    public T restult(Class<?> result) {
        this.result = result;
        return (T) this;
    }

    public T headers(Map<String, String> headers) {
        this.headers = headers;
        return (T) this;
    }

    public T addHeader(String key, String val) {
        if (this.headers == null) {
            headers = new LinkedHashMap<>();
        }
        headers.put(key, val);
        return (T) this;
    }

    public abstract RequestCall build();
}
