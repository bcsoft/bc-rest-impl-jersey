package cn.bc.rest.jersey;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

/**
 * post 各种数据类型的请求测试
 *
 * @author dragon 2016-07-28
 */
@Named
@Path("jersey")
public class JerseyResource {
  @POST
  @Path("form")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public String postForm(
    @DefaultValue("true") @FormDataParam("enabled") boolean enabled,
    //@FormDataParam("data") FileData bean,
    @FormDataParam("file") InputStream file,
    @FormDataParam("file") FormDataContentDisposition fileDisposition) {
    return null;
  }
}