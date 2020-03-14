package hello;

import javax.ws.rs.GET;
import org.json.JSONObject;
import javax.ws.rs.Path;

@Path("/")
public class Hello {
    @GET
    @Path("/hello")
    public JSONObject getHello() {
        return new JSONObject().put("hello", "Hello");
    }
}
