package sistemainformacion.registroproyectos.Repository;

import sistemainformacion.registroproyectos.Model.TipoProyecto;
import sistemainformacion.registroproyectos.Repository.Crud.TipoProyectoCrudRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TipoProyectoRepository {
    
    @Autowired
    private TipoProyectoCrudRepository tipoProyectoCrudRepository;
    
    public List<TipoProyecto> getAll(){
        return  (List<TipoProyecto>) tipoProyectoCrudRepository.findAll();
    }

    public Optional<TipoProyecto> getTipoProyecto(int id){
        return tipoProyectoCrudRepository.findById(id);
    }

    public TipoProyecto save(TipoProyecto tipoProyecto){
        return tipoProyectoCrudRepository.save(tipoProyecto);
    }

    public void delete(int id){
        tipoProyectoCrudRepository.deleteById(id);        
    }

}
