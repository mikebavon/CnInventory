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
    Objects that are automatically created at point where JSP is translated to Servlet, and available for use in jsp as a
    already variable
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

JSP ACTIONS
 - standard tags that is part of jsp, used to element a lot java code/scriptlets in jsp file
 - jsp standard tags starts with jsp: prefix
 - Major tags use in jsp action
    1) jsp:include
    2) jsp:forward
    3) jsp:param

    4) jsp:useBean
    5) jsp:setProperty
    6) jsp:getProperty

    7) jsp:attribute
    8) jsp:plugin

Bean Is a java class with the following characteristics
    1. Must have non argument constructor.
    2. Must have implement Serializable
    3. Must have private properties with getters and setters to modify the properties

Expression Language (EL)
- simplify data access from bean and implicit objects
- EL syntax ${expression}
    ${param.name}
    ${sessionScope.user}
    ${sessionScope.user.name}
    ${sessionScope.user.address.phoneNo}
    ${sessionScope["user"]["address"]["phoneNo"]}

    ${param["name"]}

Uses EL
    1. Set attributes value
        <jsp:include page="${sessionScope.userPage}">

    2. Uses in jsp:setProperty
        <jsp:setProperty name="login" property="username" value="${usernameInThisPage}" />

EL implicit
    1. param - ServletRequest.getParameter
    2. sessionScope - HttpSession
    3. initParam
    4. applicationScope - ServletContext

Mathematical expression
    1. +,-,*,/

Logical Decision Structures
 == is eq
 > is gt
 < is lt
 >= is ge
 <= is le
 && is and
 ! is not
 || is or

JSTL Tags
    - ready made tags that replaces scriplets, use taglibs access jstl tags

To use the taglibs, you need two dependencies
    -jstl.jar
    -standard.jar - taglib

   taglibs categories
    -core
    -formating
    -sql
    -functions
    -xml

Core Taglibs
 <c:out> attributes value, escapeXml
 <c:set> attributes var,value,target,property,scope
 <c:if>
 <c:forEach>
 <c:chose> <c:when> <c:otherwise>

functions Taglibs
   <fn:contains()>
   <fn:containsIgnoreCase()>
   <fn:trim()>
   <fn:split()>
   <fn:join()>
   <fn:length()>
   <fn:toUpperCase()>
   <fn:toLowerCase()>


//===== javascript summary notes ====
javascript is not type strict
Objects

1. Using function
    function Student(){
    }

    var student = new Student();

2. using javascript literals
    var student = {};

3. this, prototype, call, apply, bind ===== .....

4. CDI

Normally - creating an object instance
 Dependency - One class or object is depending on another object to do something.

 public class Exam(){

    Student student = new Student();


 }

Class Exam depends on student;

Without CDI you use the new keyword
 Student student = new Student();

With CDI

  @Inject
  Student student; //container wildfly(CDI - weld) manages the instance, creation, desctruction.....

Injection Points
    -field
    -method - void,only parameter trying to inject
    -constructor

///=============================================================
Data access object --- access data ... dont do business...


JPA  - JAVA PERSISTENCE API - specification
ORM (Object relation mapping) - allows to map object to relational database tables;
Hibernate(orm) that implements JPA SPECIFICATION







