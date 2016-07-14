package cn.bc.rest;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dragon 2016-07-14
 */
public class CustomApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<>();
		s.add(RootResource.class);
		return s;
	}
}
