package ec.edu.espe.as.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author jhona
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRQ.findAll", query = "SELECT u FROM UsuarioRQ u")
    , @NamedQuery(name = "UsuarioRQ.findByIdusuario", query = "SELECT u FROM UsuarioRQ u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "UsuarioRQ.findByUsuario", query = "SELECT u FROM UsuarioRQ u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "UsuarioRQ.findByClave", query = "SELECT u FROM UsuarioRQ u WHERE u.clave = :clave")
    , @NamedQuery(name = "UsuarioRQ.findByEst", query = "SELECT u FROM UsuarioRQ u WHERE u.est = :est")})
public class UsuarioRQ implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIO")
    private Integer idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CLAVE")
    private String clave;
    @Size(max = 256)
    @Column(name = "EST")
    private String est;
    @OneToMany(mappedBy = "idusuario")
    private Collection<ActivaciontransferenciasRQ> activaciontransferenciasRQCollection;
    @OneToMany(mappedBy = "idusuario")
    private Collection<LogRQ> logRQCollection;

    public UsuarioRQ() {
    }

    public UsuarioRQ(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public UsuarioRQ(Integer idusuario, String usuario, String clave) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    @XmlTransient
    public Collection<ActivaciontransferenciasRQ> getActivaciontransferenciasRQCollection() {
        return activaciontransferenciasRQCollection;
    }

    public void setActivaciontransferenciasRQCollection(Collection<ActivaciontransferenciasRQ> activaciontransferenciasRQCollection) {
        this.activaciontransferenciasRQCollection = activaciontransferenciasRQCollection;
    }

    @XmlTransient
    public Collection<LogRQ> getLogRQCollection() {
        return logRQCollection;
    }

    public void setLogRQCollection(Collection<LogRQ> logRQCollection) {
        this.logRQCollection = logRQCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRQ)) {
            return false;
        }
        UsuarioRQ other = (UsuarioRQ) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.as.model.UsuarioRQ[ idusuario=" + idusuario + " ]";
    }

}
