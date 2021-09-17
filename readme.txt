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
     ServletContext - it allow to access system/application wide attributes -
        only created once, at start/deployment of the application
     RequestDispatcher - Interface defines how page request/response is going handler, it can done two ways:
        1. include - if Page X include Page Y, page Y will be execute and the process of execution will be returned to page X,
           after which page X continues to execute.
        2. forward - if Page X forwarding to Page Y, page Y will be execute and will not return the process of execution to page X,
    HttpSession

web.xml (Is a deployment descriptor) - simply defines how a web application is deployed in a web container/web server
    describing how java web application is deployed in the web container/web server

Life Cycle of Servlet
    1. Web Container (wildfly) Loads all servlet to jvm; done once (Start Server/deploying the application to the server)
    2. Web Container creates instance of the servlet; done once (Start server/deploying the application to the server)
    3. Init method is inside in each servet is called/executed; done once; (Start server/deploying the application to the server)
    4. Service method of each servlet will executed upon request(only method of a servlet that is called mutliple times on lifespan of servlet)
    5. Servlet is destroyed( Shutting down application server/ on undeploying the application from the server)

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

Event & Listener
    - Event - Occurrence of something in lifecycle of a servlet, servlet initialization, request, creation of servlet,
        destruction of servlet
    - Listener - Is an observer of event to do something else.
    - Event & Listeners work together

    Common Listeners
        ServletContextListener


Configuring Datasource in wildfly

A) Adding Driver(Jar file) In Wildfly and configuring it as a module
    1. Change directory to
        Wildfly Root Directory->module->system->layers->base->com

    2. Create a folder called sql - this folder where will be creating and saving all sql(mysql, postegres, oracle, mssql) connection
    3. Change directory to the created sql folder
    4. Create specific db folder in this we are mysql folder
    5. change directory to mysql folder
    6. Create folder called main(must called main)
    7. Change directory to main folder created
    8. Copy database driver to the main directory (the driver is a .jar file)
    9. Still inside main directory create a file called module.xml, and copy the contents below

        <?xml version="1.0" encoding="UTF-8"?>
        <module xmlns="urn:jboss:module:1.1" name="com.sql.mysql">
          <resources>
             <resource-root path="mysql-connector-java-5.1.39-bin.jar"/>
          </resources>
          <dependencies>
             <module name="javax.api"/>
             <module name="javax.transaction.api"/>
          </dependencies>
        </module>

B) Configuring module as a driver in standalone.xml
    1. In the subsystem of datasource, under <drivers> tag add driver configuration
        <driver name="mysql" module="rdbms">
            <xa-datasource-class>com.mysql.jdbc.Driver</xa-datasource-class>
        </driver>

        or

        <driver name="mysql" module="rdbms">
            <xa-datasource-class>com.mysql.cj.jdbc.Driver</xa-datasource-class>
        </driver>

        or

        <driver name="mysql" module="com.mysql">
            <xa-datasource-class>com.mysql.cj.jdbc.MysqlXADataSource</xa-datasource-class>
        </driver>


        or

        <driver name="mysql" module="com.mysql">
            <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
        </driver>

    2. Configure datasource with jndi and db url, and password under the <datasources> tag

        <datasource jndi-name="java:jboss/datasources/CnInventory" pool-name="CnInventory" enabled="true" use-java-context="true">
            <connection-url>jdbc:mysql://localhost:3306/inventory?useSSL=false</connection-url>
            <driver>mysql</driver>
            <security>
                <user-name>db_user</user-name>
                <password>db_password</password>
            </security>
        </datasource>

JSP Summarized notes

JSP (Java Server Pages) - java code inside HTML, unlike servlet is html inside java code
jsp is a file with extension .jsp

Life Cycle JSP FILE

In web container
index.jsp->index_jsp.java->index_jsp.class
hello.jsp->hello_jsp.java->hello_jsp.class

index.jsp
<html>
    <head></head>
    <body>
    <h2>Cohort Nine Inventory Management System</h2>
    </body>
</html>

1. Jsp Translation to java class which extends HttpServlet, making it a servlet
index_jsp.java
public class index_jsp extends HttpServlet{

    public void _jspInit(){

    }

    public void _jspService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter print = response.getWriter();
        print.print("<html>");
        print.print("<head></head>");
        print.print("<body>");
        print.print("<h2>Cohort Nine Inventory Management System</h2>");
        print.print("</body>");
        print.print("<html>");

    }

    public void _jspDestroy(){

    }
}

2. SCRIPTING ELEMENTS
    - tag element in jsp page that allows inclusion of java code inside html, <% java code %>
    - types tags:
        (i) Comment <%-- comments %>
        (ii) Directive <%@ directive name=""... %>, they are three types of directives
            a) page directive e.g import
            b) include directive
            3) taglib directive
        (iii) Declaration <%! declaration %> - used for class wide variable,method declaration.
        (iv) Scriptlet - java code <% java code %>
        (v) expression - print out <%= value %> - basically prints out values

2. IMPLICIT OBJECTS
    Objects that are automatically created at point where JSP is translated to Servlet
    examples of implicit objects
        out = JspWriter which equivalent to PrintWriter acquired through HttpResponse->getWriter();
        request	HttpServletRequest
        response	HttpServletResponse
        config	ServletConfig
        application	ServletContext
        session	HttpSession
        pageContext	PageContext
        page	Object
        exception	Throwable






