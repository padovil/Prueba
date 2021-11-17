package sistemainformacion.registroproyectos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistemainformacion.registroproyectos.Model.AsociadosProyecto;
import sistemainformacion.registroproyectos.Repository.AsociadosProyectoRepository;


@Service
public class AsociadosProyectoService {
    @Autowired
    private AsociadosProyectoRepository AsociadosProyectoRepository;

    @Transactional (readOnly = true)
    public List<AsociadosProyecto> getAll(){
        return (List <AsociadosProyecto>) AsociadosProyectoRepository.getAll();
    }

    @Transactional (readOnly = true)
    public Optional<AsociadosProyecto> getAsociadosProyecto(int id){
        return AsociadosProyectoRepository.getAsociadosProyecto(id);
    }

    public AsociadosProyecto save(AsociadosProyecto AsociadosProyecto){
        if(AsociadosProyecto.getId_pk_asociados_proyecto() == null){
            return AsociadosProyectoRepository.save(AsociadosProyecto);
        }else{
            Optional<AsociadosProyecto> aux = AsociadosProyectoRepository.getAsociadosProyecto(AsociadosProyecto.getId_pk_asociados_proyecto());
            if(aux.isEmpty()){
                return AsociadosProyectoRepository.save(AsociadosProyecto);
            }else{
                return AsociadosProyecto;
            }
        }
    }

    public AsociadosProyecto update(AsociadosProyecto AsociadosProyecto){
        if(AsociadosProyecto.getId_pk_asociados_proyecto()!=null){
            Optional<AsociadosProyecto>g=AsociadosProyectoRepository.getAsociadosProyecto(AsociadosProyecto.getId_pk_asociados_proyecto());

            if(!g.isEmpty()){
                // if(AsociadosProyecto.get!=null){
                //     g.get().setNombre_tipo_proyecto(AsociadosProyecto.getNombre_tipo_proyecto());                    
                // }
                   
                return AsociadosProyectoRepository.save(g.get());
            }
        }
        return AsociadosProyecto;
    }

    @Transactional 
    public void deleteAsociadosProyecto(int id){
        AsociadosProyectoRepository.delete(id);
    }
}
