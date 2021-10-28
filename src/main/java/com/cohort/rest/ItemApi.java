package com.cohort.rest;

import com.cohort.dto.RestResponse;
import com.cohort.ejb.ItemEjbI;
import com.cohort.model.Item;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/items")
public class ItemApi {

    @EJB
    private ItemEjbI itemEjb;

    @GET
    @Path("list/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("categoryId") int categoryId, @QueryParam("warehouseId") int warehouseId){

        Item filter = new Item();
        filter.setCategoryId(categoryId);
        return Response.ok().entity(itemEjb.list(filter, 0, 0)).build();

    }

    @GET
    @Path("list2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(Item item, @HeaderParam("User-Agent") String userAgent){
        System.out.println("user agent: " + userAgent);
        return Response.ok().entity(itemEjb.list(item, 0, 0)).build();

    }

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Item item){
        try {
            itemEjb.save(item);
            return Response.ok().entity(new RestResponse()).build();

        }catch (Exception ex){
            return Response.status(400).entity(new RestResponse(false, ex.getMessage())).build();
        }
    }


}
