package ec.edu.espe.as.api;

import ec.edu.espe.as.model.Log;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * @author jhona
 */
@Stateless
@Path("log")
public class LogFacadeREST extends AbstractFacade<Log> {

    @PersistenceContext(unitName = "ec.edu.espe.as_Banca-web_war_1PU")
    private EntityManager em;

    public LogFacadeREST() {
        super(Log.class);
    }
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Log l){
        super.create(l);
    }
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Integer id) {
        return Response.ok(super.find(id)).build(); 
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
