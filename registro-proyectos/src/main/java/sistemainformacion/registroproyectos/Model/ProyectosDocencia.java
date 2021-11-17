package sistemainformacion.registroproyectos.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="tbl_proyectos_docencia")
public class ProyectosDocencia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pk_proyectos_docencia;

    private Integer id_fk_docente;
    private Integer id_fk_facultad;
    
    private String cod_proyecto_ucentral;
    private String nombre_proyecto;
    
    @ManyToOne
    @JoinColumn(name="id_fk_tipo_poyecto")
    @JsonIgnoreProperties("proyectosDocencias")
    private TipoProyecto tipoPoyecto;

    @ManyToOne
    @JoinColumn(name="id_fk_rol")
    @JsonIgnoreProperties("proyectosDocencias")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name="id_fk_tipo_financiacion")
    @JsonIgnoreProperties("proyectosDocencias")
    private TipoFinanciacion tipoFinanciacion;

    private String enlace_proyecto;
    private String descripcion_proyecto;
    private String justificacion_proyecto;
    private String asignaturas_asociadas;
    private String resultados_producto;
    private String titulos_producto;
    private String tipo_producto;
    private String horas_planeadas_anio;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Date fecha_registro;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "proyectosDocencia")
    @JsonIgnoreProperties("proyectosDocencia")
    public List<AsociadosProyecto> asociadosDocentes;


    

    public ProyectosDocencia(Integer id_pk_proyectos_docencia, Integer id_fk_docente, Integer id_fk_facultad,
            String cod_proyecto_ucentral, String nombre_proyecto, TipoProyecto tipoPoyecto, Rol rol,
            TipoFinanciacion tipoFinanciacion, String enlace_proyecto, String descripcion_proyecto,
            String justificacion_proyecto, String asignaturas_asociadas, String resultados_producto,
            String titulos_producto, String tipo_producto, String horas_planeadas_anio, Date fecha_inicio,
            Date fecha_fin, Date fecha_registro, List<AsociadosProyecto> asociadosDocentes) {
        this.id_pk_proyectos_docencia = id_pk_proyectos_docencia;
        this.id_fk_docente = id_fk_docente;
        this.id_fk_facultad = id_fk_facultad;
        this.cod_proyecto_ucentral = cod_proyecto_ucentral;
        this.nombre_proyecto = nombre_proyecto;
        this.tipoPoyecto = tipoPoyecto;
        this.rol = rol;
        this.tipoFinanciacion = tipoFinanciacion;
        this.enlace_proyecto = enlace_proyecto;
        this.descripcion_proyecto = descripcion_proyecto;
        this.justificacion_proyecto = justificacion_proyecto;
        this.asignaturas_asociadas = asignaturas_asociadas;
        this.resultados_producto = resultados_producto;
        this.titulos_producto = titulos_producto;
        this.tipo_producto = tipo_producto;
        this.horas_planeadas_anio = horas_planeadas_anio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_registro = fecha_registro;
        this.asociadosDocentes = asociadosDocentes;
    }


    public Integer getId_pk_proyectos_docencia() {
        return id_pk_proyectos_docencia;
    }


    public void setId_pk_proyectos_docencia(Integer id_pk_proyectos_docencia) {
        this.id_pk_proyectos_docencia = id_pk_proyectos_docencia;
    }


    public Integer getId_fk_docente() {
        return id_fk_docente;
    }


    public void setId_fk_docente(Integer id_fk_docente) {
        this.id_fk_docente = id_fk_docente;
    }


    public Integer getId_fk_facultad() {
        return id_fk_facultad;
    }


    public void setId_fk_facultad(Integer id_fk_facultad) {
        this.id_fk_facultad = id_fk_facultad;
    }


    public String getCod_proyecto_ucentral() {
        return cod_proyecto_ucentral;
    }


    public void setCod_proyecto_ucentral(String cod_proyecto_ucentral) {
        this.cod_proyecto_ucentral = cod_proyecto_ucentral;
    }


    public String getNombre_proyecto() {
        return nombre_proyecto;
    }


    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }


    public TipoProyecto getTipoPoyecto() {
        return tipoPoyecto;
    }


    public void setTipoPoyecto(TipoProyecto tipoPoyecto) {
        this.tipoPoyecto = tipoPoyecto;
    }


    public Rol getRol() {
        return rol;
    }


    public void setRol(Rol rol) {
        this.rol = rol;
    }


    public TipoFinanciacion getTipoFinanciacion() {
        return tipoFinanciacion;
    }


    public void setTipoFinanciacion(TipoFinanciacion tipoFinanciacion) {
        this.tipoFinanciacion = tipoFinanciacion;
    }


    public String getEnlace_proyecto() {
        return enlace_proyecto;
    }


    public void setEnlace_proyecto(String enlace_proyecto) {
        this.enlace_proyecto = enlace_proyecto;
    }


    public String getDescripcion_proyecto() {
        return descripcion_proyecto;
    }


    public void setDescripcion_proyecto(String descripcion_proyecto) {
        this.descripcion_proyecto = descripcion_proyecto;
    }


    public String getJustificacion_proyecto() {
        return justificacion_proyecto;
    }


    public void setJustificacion_proyecto(String justificacion_proyecto) {
        this.justificacion_proyecto = justificacion_proyecto;
    }


    public String getAsignaturas_asociadas() {
        return asignaturas_asociadas;
    }


    public void setAsignaturas_asociadas(String asignaturas_asociadas) {
        this.asignaturas_asociadas = asignaturas_asociadas;
    }


    public String getResultados_producto() {
        return resultados_producto;
    }


    public void setResultados_producto(String resultados_producto) {
        this.resultados_producto = resultados_producto;
    }


    public String getTitulos_producto() {
        return titulos_producto;
    }


    public void setTitulos_producto(String titulos_producto) {
        this.titulos_producto = titulos_producto;
    }


    public String getTipo_producto() {
        return tipo_producto;
    }


    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }


    public String getHoras_planeadas_anio() {
        return horas_planeadas_anio;
    }


    public void setHoras_planeadas_anio(String horas_planeadas_anio) {
        this.horas_planeadas_anio = horas_planeadas_anio;
    }


    public Date getFecha_inicio() {
        return fecha_inicio;
    }


    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }


    public Date getFecha_fin() {
        return fecha_fin;
    }


    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


    public Date getFecha_registro() {
        return fecha_registro;
    }


    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }


    public List<AsociadosProyecto> getAsociadosDocentes() {
        return asociadosDocentes;
    }


    public void setAsociadosDocentes(List<AsociadosProyecto> asociadosDocentes) {
        this.asociadosDocentes = asociadosDocentes;
    }
  


    
}
