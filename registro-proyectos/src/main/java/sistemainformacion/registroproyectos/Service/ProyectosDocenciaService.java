package sistemainformacion.registroproyectos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistemainformacion.registroproyectos.Model.ProyectosDocencia;
import sistemainformacion.registroproyectos.Repository.ProyectosDocenciaRepository;


@Service
public class ProyectosDocenciaService {
    @Autowired
    private ProyectosDocenciaRepository ProyectosDocenciaRepository;

    @Transactional (readOnly = true)
    public List<ProyectosDocencia> getAll(){
        return (List <ProyectosDocencia>) ProyectosDocenciaRepository.getAll();
    }

    @Transactional (readOnly = true)
    public Optional<ProyectosDocencia> getProyectosDocencia(int id){
        return ProyectosDocenciaRepository.getProyectosDocencia(id);
    }

    public ProyectosDocencia save(ProyectosDocencia ProyectosDocencia){
        if(ProyectosDocencia.getId_pk_proyectos_docencia() == null){
            return ProyectosDocenciaRepository.save(ProyectosDocencia);
        }else{
            Optional<ProyectosDocencia> aux = ProyectosDocenciaRepository.getProyectosDocencia(ProyectosDocencia.getId_pk_proyectos_docencia());
            if(aux.isEmpty()){
                return ProyectosDocenciaRepository.save(ProyectosDocencia);
            }else{
                return ProyectosDocencia;
            }
        }
    }

    public ProyectosDocencia update(ProyectosDocencia ProyectosDocencia){
        if(ProyectosDocencia.getId_pk_proyectos_docencia()!=null){
            Optional<ProyectosDocencia>g=ProyectosDocenciaRepository.getProyectosDocencia(ProyectosDocencia.getId_pk_proyectos_docencia());

            if(!g.isEmpty()){

                // FALTA ACTUALIZAR LOS SELECT --------------------------------------*********************


                
                if(ProyectosDocencia.getCod_proyecto_ucentral()!=null){
                    g.get().setCod_proyecto_ucentral(ProyectosDocencia.getCod_proyecto_ucentral());                    
                }

                if(ProyectosDocencia.getNombre_proyecto()!=null){
                    g.get().setNombre_proyecto(ProyectosDocencia.getNombre_proyecto());                    
                }

                if(ProyectosDocencia.getEnlace_proyecto()!=null){
                    g.get().setEnlace_proyecto(ProyectosDocencia.getEnlace_proyecto());                    
                }

                if(ProyectosDocencia.getDescripcion_proyecto()!=null){
                    g.get().setDescripcion_proyecto(ProyectosDocencia.getDescripcion_proyecto());                    
                }

                if(ProyectosDocencia.getJustificacion_proyecto()!=null){
                    g.get().setJustificacion_proyecto(ProyectosDocencia.getJustificacion_proyecto());                    
                }

                if(ProyectosDocencia.getAsignaturas_asociadas()!=null){
                    g.get().setAsignaturas_asociadas(ProyectosDocencia.getAsignaturas_asociadas());                    
                }
                 
                if(ProyectosDocencia.getResultados_producto()!=null){
                    g.get().setResultados_producto(ProyectosDocencia.getResultados_producto());                    
                }

                if(ProyectosDocencia.getTitulos_producto()!=null){
                    g.get().setTitulos_producto(ProyectosDocencia.getTitulos_producto());                    
                }

                if(ProyectosDocencia.getTipo_producto()!=null){
                    g.get().setTipo_producto(ProyectosDocencia.getTipo_producto());                    
                }

                if(ProyectosDocencia.getHoras_planeadas_anio()!=null){
                    g.get().setHoras_planeadas_anio(ProyectosDocencia.getHoras_planeadas_anio());                    
                }

                if(ProyectosDocencia.getFecha_inicio()!=null){
                    g.get().setFecha_inicio(ProyectosDocencia.getFecha_inicio());                    
                }

                if(ProyectosDocencia.getFecha_fin()!=null){
                    g.get().setFecha_fin(ProyectosDocencia.getFecha_fin());                    
                }


                return ProyectosDocenciaRepository.save(g.get());
            }
        }
        return ProyectosDocencia;
    }

    @Transactional 
    public void deleteProyectosDocencia(int id){
        ProyectosDocenciaRepository.delete(id);
    }
}
