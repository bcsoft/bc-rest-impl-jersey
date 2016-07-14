package cn.bc.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * rest 服务的根访问路径对应的资源
 *
 * @author dragon 2016-07-14
 */
@Singleton
@Path("/")
public class RootResource {
	private final static Logger logger = LoggerFactory.getLogger(RootResource.class);

	public RootResource() {
		logger.debug("this={}", this);
	}

	@PostConstruct
	private void init() {
		logger.debug("init");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String root() {
		return "Hello! This root path has nothing.";
	}
}