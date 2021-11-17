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
@Table(name="tbl_permisos")
public class Permisos implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pk_permisos;

    private Integer id_fk_docente;

    @ManyToOne
    @JoinColumn(name="id_fk_roles_sistema")
    @JsonIgnoreProperties("permisoss")
    private RolesSistema rolesSistema;

    private String contrasena;
    private Date fecha_registro;
    
    
    public Permisos(Integer id_pk_permisos, Integer id_fk_docente, RolesSistema rolesSistema, String contrasena,
            Date fecha_registro) {
        this.id_pk_permisos = id_pk_permisos;
        this.id_fk_docente = id_fk_docente;
        this.rolesSistema = rolesSistema;
        this.contrasena = contrasena;
        this.fecha_registro = fecha_registro;
    }
    
    public Integer getId_pk_permisos() {
        return id_pk_permisos;
    }
    public void setId_pk_permisos(Integer id_pk_permisos) {
        this.id_pk_permisos = id_pk_permisos;
    }
    public Integer getId_fk_docente() {
        return id_fk_docente;
    }
    public void setId_fk_docente(Integer id_fk_docente) {
        this.id_fk_docente = id_fk_docente;
    }
    public RolesSistema getRolesSistema() {
        return rolesSistema;
    }
    public void setRolesSistema(RolesSistema rolesSistema) {
        this.rolesSistema = rolesSistema;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Date getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    

    
}
