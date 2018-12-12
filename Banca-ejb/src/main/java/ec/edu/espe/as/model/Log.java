package ec.edu.espe.as.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jhona
 */
@Entity
@Table(name = "LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l")
    , @NamedQuery(name = "Log.findByIdlog", query = "SELECT l FROM Log l WHERE l.idlog = :idlog")
    , @NamedQuery(name = "Log.findByResultado", query = "SELECT l FROM Log l WHERE l.resultado = :resultado")
    , @NamedQuery(name = "Log.findByFecha", query = "SELECT l FROM Log l WHERE l.fecha = :fecha")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLOG")
    private Integer idlog;
    @Size(max = 128)
    @Column(name = "RESULTADO")
    private String resultado;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;

    public Log() {
    }

    public Log(Integer idlog) {
        this.idlog = idlog;
    }

    public Integer getIdlog() {
        return idlog;
    }

    public void setIdlog(Integer idlog) {
        this.idlog = idlog;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlog != null ? idlog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.idlog == null && other.idlog != null) || (this.idlog != null && !this.idlog.equals(other.idlog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Log{" + "idlog=" + idlog + ", resultado=" + resultado + ", fecha=" + fecha + ", idusuario=" + idusuario + '}';
    }

    

}
