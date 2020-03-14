package hello;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HelloTest {

    @Test
    public void test_hello() throws Exception {
        Hello hello = new Hello();

        JSONObject helloResponse = hello.getHello();

        assertThat(helloResponse.keySet().size(), Matchers.equalTo(1));
        assertThat(helloResponse.keySet(), Matchers.contains("hello"));
        assertThat(helloResponse.getString("hello"), Matchers.equalTo("Hello"));
    }
}
