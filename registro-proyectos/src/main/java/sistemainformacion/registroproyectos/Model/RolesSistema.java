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

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Getter @Setter @AllArgsConstructor @NoArgsConstructor
// @Data

@Entity
@Table(name="tbl_roles_sistema")
public class RolesSistema implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pk_roles_sistema;

    private String nombre_rol_sistema;
    private Date fecha_registro;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "rolesSistema")
    @JsonIgnoreProperties("rolesSistema")
    public List<Permisos> permisoss;

    

    public RolesSistema(Integer id_pk_roles_sistema, String nombre_rol_sistema, Date fecha_registro,
            List<Permisos> permisoss) {
        this.id_pk_roles_sistema = id_pk_roles_sistema;
        this.nombre_rol_sistema = nombre_rol_sistema;
        this.fecha_registro = fecha_registro;
        this.permisoss = permisoss;
    }

    public Integer getId_pk_roles_sistema() {
        return id_pk_roles_sistema;
    }

    public void setId_pk_roles_sistema(Integer id_pk_roles_sistema) {
        this.id_pk_roles_sistema = id_pk_roles_sistema;
    }

    public String getNombre_rol_sistema() {
        return nombre_rol_sistema;
    }

    public void setNombre_rol_sistema(String nombre_rol_sistema) {
        this.nombre_rol_sistema = nombre_rol_sistema;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public List<Permisos> getPermisoss() {
        return permisoss;
    }

    public void setPermisoss(List<Permisos> permisoss) {
        this.permisoss = permisoss;
    }
  

    
}
