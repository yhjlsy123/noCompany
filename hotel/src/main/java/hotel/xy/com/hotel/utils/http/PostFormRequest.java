package hotel.xy.com.hotel.utils.http;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by zhy on 15/12/14.
 */
public class PostFormRequest extends OkHttpRequest {

    public PostFormRequest(String url, Object tag, Map<String, Object> params, Map<String, String> headers, int id) {
        super(url, tag, params, headers, id);
    }

    @Override
    protected RequestBody buildRequestBody(boolean isFile) {

        if (isFile && null != params) {
            MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder();
            multipartBodyBuilder.setType(MultipartBody.FORM);
            for (String key : params.keySet()) {
                if (params.get(key) instanceof String) {
                    multipartBodyBuilder.addFormDataPart(key, params.get(key).toString());
                } else if (params.get(key) instanceof File) {
                    multipartBodyBuilder.addFormDataPart(key, ((File) params.get(key)).getName(), RequestBody.create(MediaType.parse("image/png"), (File) params.get(key)));
                }

                return multipartBodyBuilder.build();
            }
        } else if (null != params) {
            FormBody.Builder builder = new FormBody.Builder();
            for (String key : params.keySet()) {
                builder.add(key, params.get(key).toString());
            }
            return builder.build();
        }

        return null;

    }


    @Override
    protected Request buildRequest(RequestBody requestBody) {
        return builder.post(requestBody).build();
    }

    private String guessMimeType(String path) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentTypeFor = null;
        try {
            contentTypeFor = fileNameMap.getContentTypeFor(URLEncoder.encode(path, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }
        return contentTypeFor;
    }


}
