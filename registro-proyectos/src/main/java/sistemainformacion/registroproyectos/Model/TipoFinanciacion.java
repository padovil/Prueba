package sistemainformacion.registroproyectos.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Getter @Setter @AllArgsConstructor @NoArgsConstructor
// @Data


@Entity
@Table(name="tbl_tipo_financiacion")
public class TipoFinanciacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pk_tipo_financiacion;

    private String nombre_tipo_financiacion;
    private Date fecha_registro;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "tipoFinanciacion")
    @JsonIgnoreProperties("tipoFinanciacion")
    public List<ProyectosDocencia> proyectosDocencias;

   

    public TipoFinanciacion(Integer id_pk_tipo_financiacion, String nombre_tipo_financiacion, Date fecha_registro,
            List<ProyectosDocencia> proyectosDocencias) {
        this.id_pk_tipo_financiacion = id_pk_tipo_financiacion;
        this.nombre_tipo_financiacion = nombre_tipo_financiacion;
        this.fecha_registro = fecha_registro;
        this.proyectosDocencias = proyectosDocencias;
    }

    public Integer getId_pk_tipo_financiacion() {
        return id_pk_tipo_financiacion;
    }

    public void setId_pk_tipo_financiacion(Integer id_pk_tipo_financiacion) {
        this.id_pk_tipo_financiacion = id_pk_tipo_financiacion;
    }

    public String getNombre_tipo_financiacion() {
        return nombre_tipo_financiacion;
    }

    public void setNombre_tipo_financiacion(String nombre_tipo_financiacion) {
        this.nombre_tipo_financiacion = nombre_tipo_financiacion;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public List<ProyectosDocencia> getProyectosDocencias() {
        return proyectosDocencias;
    }

    public void setProyectosDocencias(List<ProyectosDocencia> proyectosDocencias) {
        this.proyectosDocencias = proyectosDocencias;
    }


    
}
