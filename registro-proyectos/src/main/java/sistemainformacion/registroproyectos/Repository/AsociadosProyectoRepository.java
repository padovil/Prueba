package sistemainformacion.registroproyectos.Repository;

import sistemainformacion.registroproyectos.Model.AsociadosProyecto;
import sistemainformacion.registroproyectos.Repository.Crud.AsociadosProyectoCrudRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AsociadosProyectoRepository {
    
    @Autowired
    private AsociadosProyectoCrudRepository asociadosProyectoCrudRepository;
    
    public List<AsociadosProyecto> getAll(){
        return  (List<AsociadosProyecto>) asociadosProyectoCrudRepository.findAll();
    }

    public Optional<AsociadosProyecto> getAsociadosProyecto(int id){
        return asociadosProyectoCrudRepository.findById(id);
    }

    public AsociadosProyecto save(AsociadosProyecto asociadosProyecto){
        return asociadosProyectoCrudRepository.save(asociadosProyecto);
    }

    public void delete(int id){
        asociadosProyectoCrudRepository.deleteById(id);        
    }

}
