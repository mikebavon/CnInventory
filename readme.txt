
    Life Cycle of Servlet

    1. Web Container (wildfly) Loads all servelt to jvm; done once (Start Server/deploying the application to the server)
    2. Web Container creates instance of the servlet; done once (Start server/deploying the application to the server)
    3. Init method is inside in each servet is called/executed; done once; (Start server/deploying the application to the server)
    4. service method of each servelet will executed upon request(only method of a servlet that is called mutliple times on lifespan of servlet)
    5. Servlet is destroyed( Shutting down application server/ on undeploying the application from the server)