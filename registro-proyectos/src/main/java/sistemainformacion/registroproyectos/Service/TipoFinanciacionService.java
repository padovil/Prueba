package sistemainformacion.registroproyectos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistemainformacion.registroproyectos.Model.TipoFinanciacion;
import sistemainformacion.registroproyectos.Repository.TipoFinanciacionRepository;


@Service
public class TipoFinanciacionService {
    @Autowired
    private TipoFinanciacionRepository TipoFinanciacionRepository;

    @Transactional (readOnly = true)
    public List<TipoFinanciacion> getAll(){
        return (List <TipoFinanciacion>) TipoFinanciacionRepository.getAll();
    }

    @Transactional (readOnly = true)
    public Optional<TipoFinanciacion> getTipoFinanciacion(int id){
        return TipoFinanciacionRepository.getTipoFinanciacion(id);
    }

    public TipoFinanciacion save(TipoFinanciacion TipoFinanciacion){
        if(TipoFinanciacion.getId_pk_tipo_financiacion() == null){
            return TipoFinanciacionRepository.save(TipoFinanciacion);
        }else{
            Optional<TipoFinanciacion> aux = TipoFinanciacionRepository.getTipoFinanciacion(TipoFinanciacion.getId_pk_tipo_financiacion());
            if(aux.isEmpty()){
                return TipoFinanciacionRepository.save(TipoFinanciacion);
            }else{
                return TipoFinanciacion;
            }
        }
    }

    public TipoFinanciacion update(TipoFinanciacion TipoFinanciacion){
        if(TipoFinanciacion.getId_pk_tipo_financiacion()!=null){
            Optional<TipoFinanciacion>g=TipoFinanciacionRepository.getTipoFinanciacion(TipoFinanciacion.getId_pk_tipo_financiacion());

            if(!g.isEmpty()){
                if(TipoFinanciacion.getNombre_tipo_financiacion()!=null){
                    g.get().setNombre_tipo_financiacion(TipoFinanciacion.getNombre_tipo_financiacion());                    
                }
                   
                return TipoFinanciacionRepository.save(g.get());
            }
        }
        return TipoFinanciacion;
    }

    @Transactional 
    public void deleteTipoFinanciacion(int id){
        TipoFinanciacionRepository.delete(id);
    }
}
