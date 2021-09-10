Ways of implementing servlet
1. Implementing Servlet Interface - You implement all the methods of the interface
2. Extending GenericServlet - Abstract, has abstract service method, so only to override the service method to handle
    request and response from any protocol, it is not protocol specific
3. Extending HttpServlet - Http protocol specific
    (Most preferred because it has convenient methods that handlers http methods like get, post , put

Important classes/Interface
 Servlet - Interface
 GenericServlet - Interface
 HttpServlet
 HttpServletRequest (ServletRequest) - object created web container on servlet request, data bound to the object for accessing
 HttpServletResponse (ServletResponse) - object created web container on servlet request, data bound to the object for accessing
 ServletConfig - it allow to access to access and manipulate servlet attributes - each servlet has its on ServletConfig,
    it is not system wide
 ServletContext - it allow to access to access system/application wide attributes -
    only created once, at start/deployment of the application
 RequestDispatcher - Interface defines how page request/response is going handler, it can done two ways:
    1. include - if Page X include Page Y, then content of page Y will "be appended" on Page X, page gives the response back..
    2. forward

web.xml (Is a deployment descriptor) - simply defines how a web application is deployed in a web container/web server

//maps servlet
<servlet>
    <servlet-name>nameOfServlet</servlet-name>
    <servlet-class>full.class.path</servlet-class>
    <init-param>
      <param-name>Param Name</param-name>
      <param-value>Param Value</param-value>
    </init-param>
</servlet>

<servlet-mapping>
    <servlet-name>nameOfServlet</servlet-name>
    <url-pattern>/urlOfServlet</url-pattern>
</servlet-mapping>

to access servlet specific init params use:
 getServletConfig().getInitParameter("Param Name");

//context param are available system/application wide
<context-param>
    <param-name>Param Name</param-name>
    <param-value>Param Value</param-value>
</context-param>

to access context params params use:
 getServletContext().getInitParameter("Param Name");


Life Cycle of Servlet

1. Web Container (wildfly) Loads all servelt to jvm; done once (Start Server/deploying the application to the server)
2. Web Container creates instance of the servlet; done once (Start server/deploying the application to the server)
3. Init method is inside in each servet is called/executed; done once; (Start server/deploying the application to the server)
4. service method of each servelet will executed upon request(only method of a servlet that is called mutliple times on lifespan of servlet)
5. Servlet is destroyed( Shutting down application server/ on undeploying the application from the server)


Web.xml - Deployment Descriptor
describing how java web application is deployed in the web container/web server