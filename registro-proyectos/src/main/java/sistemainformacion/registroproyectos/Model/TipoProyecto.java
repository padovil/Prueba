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
@Table(name="tbl_tipo_proyecto")
public class TipoProyecto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pk_tipo_proyecto;

    private String nombre_tipo_proyecto;
    private Date fecha_registro;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "tipoProyecto")
    @JsonIgnoreProperties("tipoProyecto")
    public List<ProyectosDocencia> proyectosDocencias;

   

    public TipoProyecto(Integer id_pk_tipo_proyecto, String nombre_tipo_proyecto, Date fecha_registro,
            List<ProyectosDocencia> proyectosDocencias) {
        this.id_pk_tipo_proyecto = id_pk_tipo_proyecto;
        this.nombre_tipo_proyecto = nombre_tipo_proyecto;
        this.fecha_registro = fecha_registro;
        this.proyectosDocencias = proyectosDocencias;
    }

    public Integer getId_pk_tipo_proyecto() {
        return id_pk_tipo_proyecto;
    }

    public void setId_pk_tipo_proyecto(Integer id_pk_tipo_proyecto) {
        this.id_pk_tipo_proyecto = id_pk_tipo_proyecto;
    }

    public String getNombre_tipo_proyecto() {
        return nombre_tipo_proyecto;
    }

    public void setNombre_tipo_proyecto(String nombre_tipo_proyecto) {
        this.nombre_tipo_proyecto = nombre_tipo_proyecto;
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
