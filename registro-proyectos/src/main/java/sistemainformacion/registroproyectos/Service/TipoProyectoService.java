package sistemainformacion.registroproyectos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistemainformacion.registroproyectos.Model.TipoProyecto;
import sistemainformacion.registroproyectos.Repository.TipoProyectoRepository;


@Service
public class TipoProyectoService {
    @Autowired
    private TipoProyectoRepository tipoProyectoRepository;

    @Transactional (readOnly = true)
    public List<TipoProyecto> getAll(){
        return (List <TipoProyecto>) tipoProyectoRepository.getAll();
    }

    @Transactional (readOnly = true)
    public Optional<TipoProyecto> getTipoProyecto(int id){
        return tipoProyectoRepository.getTipoProyecto(id);
    }

    public TipoProyecto save(TipoProyecto tipoProyecto){
        if(tipoProyecto.getId_pk_tipo_proyecto() == null){
            return tipoProyectoRepository.save(tipoProyecto);
        }else{
            Optional<TipoProyecto> aux = tipoProyectoRepository.getTipoProyecto(tipoProyecto.getId_pk_tipo_proyecto());
            if(aux.isEmpty()){
                return tipoProyectoRepository.save(tipoProyecto);
            }else{
                return tipoProyecto;
            }
        }
    }

    public TipoProyecto update(TipoProyecto tipoProyecto){
        if(tipoProyecto.getId_pk_tipo_proyecto()!=null){
            Optional<TipoProyecto>g=tipoProyectoRepository.getTipoProyecto(tipoProyecto.getId_pk_tipo_proyecto());

            if(!g.isEmpty()){
                if(tipoProyecto.getNombre_tipo_proyecto()!=null){
                    g.get().setNombre_tipo_proyecto(tipoProyecto.getNombre_tipo_proyecto());                    
                }
                   
                return tipoProyectoRepository.save(g.get());
            }
        }
        return tipoProyecto;
    }

    @Transactional 
    public void deleteTipoProyecto(int id){
        tipoProyectoRepository.delete(id);
    }
}
