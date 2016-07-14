package cn.bc.rest.jersey;

import cn.bc.rest.AuthRequestFilter;
import cn.bc.rest.LogRequestFilter;
import cn.bc.rest.RootResource;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Priorities;

/**
 * Jersey Rest 应用程序的入口配置文件
 * <p>添加的 @ApplicationPath 用于定义根资源的路径，Servlet3+ 容器会自动识别此类，但如果在 web.xml 中
 * 设置 metadata-complete="true"，则会忽略此注解，需通过 servlet-mapping.url-pattern 指定，
 * 如将 url-pattern 设为 /* 代表根路径为 /，设为 /rest/* 代表根路径为 /rest，例：
 * <pre>
 *     &lt;!-- for servlet3 with metadata-complete="true" --&gt;
 *     &lt;servlet&gt;
 *       &lt;servlet-name&gt;cn.bc.rest.jersey.JerseyApplication&lt;/servlet-name&gt;
 *     &lt;/servlet&gt;
 *     &lt;servlet-mapping&gt;
 *       &lt;servlet-name&gt;cn.bc.rest.jersey.JerseyApplication&lt;/servlet-name&gt;
 *       &lt;url-pattern&gt;/rest/*&lt;/url-pattern&gt;
 *     &lt;/servlet-mapping&gt;
 * </pre>
 * </p>
 *
 * @author dragon 2016-07-14
 */
@ApplicationPath("rest")
public class JerseyApplication extends ResourceConfig {
	public JerseyApplication() {
		// 自动扫描并注册包下的所有 jax-rs 注解的资源（@Path、@Provider）
		packages("cn.bc");
		register(RootResource.class);

		// 注册默认 utf-8 编码的过滤器
		// 推荐在 web.xml 中进行统一配置而不是在这里特殊配置
		// register(CharsetResponseFilter.class);

		// 注册登录认证过滤器
		register(AuthRequestFilter.class, Priorities.AUTHENTICATION);

		// 注册记录请求日志过滤器: for test
		register(LogRequestFilter.class, Priorities.AUTHORIZATION);

		// 设置 spring 配置文件的位置
		property("contextConfigLocation", "spring.xml");
	}
}