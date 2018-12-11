package ec.edu.espe.as.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jhona
 */
@Entity
@Table(name = "ACTIVACIONTRANSFERENCIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activaciontransferencias.findAll", query = "SELECT a FROM Activaciontransferencias a")
    , @NamedQuery(name = "Activaciontransferencias.findByIdtrans", query = "SELECT a FROM Activaciontransferencias a WHERE a.idtrans = :idtrans")
    , @NamedQuery(name = "Activaciontransferencias.findByNumcuenta", query = "SELECT a FROM Activaciontransferencias a WHERE a.numcuenta = :numcuenta")
    , @NamedQuery(name = "Activaciontransferencias.findByEstado", query = "SELECT a FROM Activaciontransferencias a WHERE a.estado = :estado")
    , @NamedQuery(name = "Activaciontransferencias.findByMonto", query = "SELECT a FROM Activaciontransferencias a WHERE a.monto = :monto")})
public class Activaciontransferencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTRANS")
    private Integer idtrans;
    @Size(max = 32)
    @Column(name = "NUMCUENTA")
    private String numcuenta;
    @Size(max = 32)
    @Column(name = "ESTADO")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO")
    private BigDecimal monto;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;

    public Activaciontransferencias() {
    }

    public Activaciontransferencias(Integer idtrans) {
        this.idtrans = idtrans;
    }

    public Integer getIdtrans() {
        return idtrans;
    }

    public void setIdtrans(Integer idtrans) {
        this.idtrans = idtrans;
    }

    public String getNumcuenta() {
        return numcuenta;
    }

    public void setNumcuenta(String numcuenta) {
        this.numcuenta = numcuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
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
        hash += (idtrans != null ? idtrans.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activaciontransferencias)) {
            return false;
        }
        Activaciontransferencias other = (Activaciontransferencias) object;
        if ((this.idtrans == null && other.idtrans != null) || (this.idtrans != null && !this.idtrans.equals(other.idtrans))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Activaciontransferencias{" + "idtrans=" + idtrans + ", numcuenta=" + numcuenta + ", estado=" + estado + ", monto=" + monto + ", idusuario=" + idusuario + '}';
    }

   
}
