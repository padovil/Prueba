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
@Table(name="tbl_rol")
public class Rol implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pk_rol;

    private String nombre_rol;
    private Date fecha_registro;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "rol")
    @JsonIgnoreProperties("rol")
    public List<ProyectosDocencia> proyectosDocencias;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "rol")
    @JsonIgnoreProperties("rol")
    public List<AsociadosProyecto> asociadosDocentes;

    
    public Rol(Integer id_pk_rol, String nombre_rol, Date fecha_registro, List<ProyectosDocencia> proyectosDocencias,
            List<AsociadosProyecto> asociadosDocentes) {
        this.id_pk_rol = id_pk_rol;
        this.nombre_rol = nombre_rol;
        this.fecha_registro = fecha_registro;
        this.proyectosDocencias = proyectosDocencias;
        this.asociadosDocentes = asociadosDocentes;
    }

    public Integer getId_pk_rol() {
        return id_pk_rol;
    }

    public void setId_pk_rol(Integer id_pk_rol) {
        this.id_pk_rol = id_pk_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
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

    public List<AsociadosProyecto> getAsociadosDocentes() {
        return asociadosDocentes;
    }

    public void setAsociadosDocentes(List<AsociadosProyecto> asociadosDocentes) {
        this.asociadosDocentes = asociadosDocentes;
    }
  
    
}
