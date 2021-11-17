package sistemainformacion.registroproyectos.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="tbl_asociados_proyecto")
public class AsociadosProyecto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pk_asociados_proyecto;

    private Integer id_fk_docente;
    
    @ManyToOne
    @JoinColumn(name="id_fk_rol")
    @JsonIgnoreProperties("asociadosDocentes")
    private Rol rol;

   
    @ManyToOne
    @JoinColumn(name="id_fk_proyectos_docencia")
    @JsonIgnoreProperties("asociadosDocentes")
    private ProyectosDocencia proyectosDocencia;

    private Date fecha_registro;

   

    public AsociadosProyecto(Integer id_pk_asociados_proyecto, Integer id_fk_docente, Rol rol,
            ProyectosDocencia proyectosDocencia, Date fecha_registro) {
        this.id_pk_asociados_proyecto = id_pk_asociados_proyecto;
        this.id_fk_docente = id_fk_docente;
        this.rol = rol;
        this.proyectosDocencia = proyectosDocencia;
        this.fecha_registro = fecha_registro;
    }

    public Integer getId_pk_asociados_proyecto() {
        return id_pk_asociados_proyecto;
    }

    public void setId_pk_asociados_proyecto(Integer id_pk_asociados_proyecto) {
        this.id_pk_asociados_proyecto = id_pk_asociados_proyecto;
    }

    public Integer getId_fk_docente() {
        return id_fk_docente;
    }

    public void setId_fk_docente(Integer id_fk_docente) {
        this.id_fk_docente = id_fk_docente;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public ProyectosDocencia getProyectosDocencia() {
        return proyectosDocencia;
    }

    public void setProyectosDocencia(ProyectosDocencia proyectosDocencia) {
        this.proyectosDocencia = proyectosDocencia;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

   
}
