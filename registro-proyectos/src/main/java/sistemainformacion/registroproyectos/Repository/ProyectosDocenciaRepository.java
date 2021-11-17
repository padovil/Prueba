package sistemainformacion.registroproyectos.Repository;

import sistemainformacion.registroproyectos.Model.ProyectosDocencia;
import sistemainformacion.registroproyectos.Repository.Crud.ProyectosDocenciaCrudRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProyectosDocenciaRepository {
    
    @Autowired
    private ProyectosDocenciaCrudRepository proyectosDocenciaCrudRepository;
    
    public List<ProyectosDocencia> getAll(){
        return  (List<ProyectosDocencia>) proyectosDocenciaCrudRepository.findAll();
    }

    public Optional<ProyectosDocencia> getProyectosDocencia(int id){
        return proyectosDocenciaCrudRepository.findById(id);
    }

    public ProyectosDocencia save(ProyectosDocencia proyectosDocencia){
        return proyectosDocenciaCrudRepository.save(proyectosDocencia);
    }

    public void delete(int id){
        proyectosDocenciaCrudRepository.deleteById(id);        
    }

}
