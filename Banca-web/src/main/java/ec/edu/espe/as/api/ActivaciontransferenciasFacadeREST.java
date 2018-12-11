package ec.edu.espe.as.api;

import ec.edu.espe.as.model.Activaciontransferencias;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("activacion")
public class ActivaciontransferenciasFacadeREST extends AbstractFacade<Activaciontransferencias> {

    @PersistenceContext(unitName = "ec.edu.espe.as_Banca-web_war_1PU")
    private EntityManager em;

    public ActivaciontransferenciasFacadeREST() {
        super(Activaciontransferencias.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Activaciontransferencias entity) {   
        System.out.println("Se ha insertado "+entity);
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Integer id, Activaciontransferencias entity) {
        super.edit(entity);
        System.out.println("Se ha modificado " + entity);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Integer id) {
        Activaciontransferencias at= super.find(id);
        System.out.println("El monto de "+id +" es :"+at.getMonto());
        return Response.ok(at).build();  
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
