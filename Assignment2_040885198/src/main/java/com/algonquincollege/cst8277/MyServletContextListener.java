package com.algonquincollege.cst8277;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
   @Override
   public void contextInitialized(ServletContextEvent sce) {
      ServletContextListener.super.contextInitialized(sce);

      //Registering the JSF Servlet
      Dynamic facesServlet = 
          sce.getServletContext().addServlet("Faces Servlet", FacesServlet.class.getName());
      //Specifying the Servlet Mapping
      facesServlet.addMapping("*.xhtml");
      //Setting Priority, 0 or higher for eager, if negative then it's lazy
      facesServlet.setLoadOnStartup(1);
   }
}