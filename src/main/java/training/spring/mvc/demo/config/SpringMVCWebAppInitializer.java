package training.spring.mvc.demo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCWebAppInitializer implements WebApplicationInitializer {
		
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(SpringMVCWebAppConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"SpringDispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		ContextLoaderListener contextLoaderListener = new ContextLoaderListener(appContext);

		servletContext.addListener(contextLoaderListener);

	}


}

//public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
//    protected Class <?> [] getRootConfigClasses() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    protected Class <?> [] getServletConfigClasses() {
//        return new Class[] {
//            WebAppConfig.class
//        };
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] {
//            "/"
//        };
//    }
//}
