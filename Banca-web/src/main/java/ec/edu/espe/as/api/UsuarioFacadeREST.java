package ec.edu.espe.as.api;

import com.google.gson.Gson;
import ec.edu.espe.as.model.Log;
import ec.edu.espe.as.model.Usuario;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author jhona
 */
@Stateless
@Path("usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @EJB
    private LogFacadeREST ejbLog;

    @PersistenceContext(unitName = "ec.edu.espe.as_Banca-web_war_1PU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public Response login(Usuario entity) {
        String clave = entity.getClave();
        String usuario = entity.getUsuario();
        String Resultado = "INGRESO";
        boolean band = true;
        Usuario usu = null;
        Usuario ver = null;
        Log lg = new Log();
        try {
            usu = super.login(usuario, clave);
            System.out.println("Ingreso el usuario : " + usuario + " " + clave);
        } catch (Exception e) {
            System.out.println("Usuario invalido");
            Resultado = "FALLA";
            band = false;
        }
        try {
            ver = super.usuario(usuario);
            System.out.println("" + ver.getUsuario());
             URL url = new URL("http://localhost:8080/Banca-web/api/log");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
                String in="{\"clave\":\""+ver.getClave()+"\",\"est\":\""+ver.getEst()+"\",\"idusuario\":\""+ver.getIdusuario()+"\",\"usuario\":\""+ver.getUsuario()+"\"}";
		String input = "{\"idusuario\":"+in+",\"resultado\":\""+Resultado+"\",\"fecha\":\""+new java.sql.Timestamp(new java.util.Date().getTime())+"\",\"idlog\":\""+7+"\"}";
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
                System.out.println("input: "+input);
                System.out.println("Mensaje de respuesta: "+conn.getResponseCode());

        } catch (Exception e) {
            System.out.println("Algo salio mal :( ");
        }
        if (band) {
            return Response.noContent().build();
        } else {
            return Response.status(HttpServletResponse.SC_UNAUTHORIZED).build();
        }

    }


    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        boolean band=true;
        Usuario u = null;
        try {
           System.out.println("Se ha eliminado el usuario " + id);
            super.remove(super.find(id));             
        } catch (Exception e) {
            band=false;
        }
        if (band) {
            return Response.ok(u).build();
        } else {
            return Response.status(HttpServletResponse.SC_NOT_FOUND).build();
        }

    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Integer id) {
        boolean band=true;
        Usuario u = null;
        try {
            u = super.find(id);
            System.out.println("Usuario ingresado: "+u.getUsuario());
        } catch (Exception e) {
            band=false;
        }
        if (band) {
            return Response.ok(u).build();
        } else {
            return Response.status(HttpServletResponse.SC_NOT_FOUND).build();
        }

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
