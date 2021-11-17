package sistemainformacion.registroproyectos.Repository;

import sistemainformacion.registroproyectos.Model.TipoFinanciacion;
import sistemainformacion.registroproyectos.Repository.Crud.TipoFinanciacionCrudRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TipoFinanciacionRepository {
    
    @Autowired
    private TipoFinanciacionCrudRepository tipoFinanciacionCrudRepository;
    
    public List<TipoFinanciacion> getAll(){
        return  (List<TipoFinanciacion>) tipoFinanciacionCrudRepository.findAll();
    }

    public Optional<TipoFinanciacion> getTipoFinanciacion(int id){
        return tipoFinanciacionCrudRepository.findById(id);
    }

    public TipoFinanciacion save(TipoFinanciacion tipoFinanciacion){
        return tipoFinanciacionCrudRepository.save(tipoFinanciacion);
    }

    public void delete(int id){
        tipoFinanciacionCrudRepository.deleteById(id);        
    }

}
