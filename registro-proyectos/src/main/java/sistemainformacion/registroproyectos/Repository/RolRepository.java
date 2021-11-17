package sistemainformacion.registroproyectos.Repository;

import sistemainformacion.registroproyectos.Model.Rol;
import sistemainformacion.registroproyectos.Repository.Crud.RolCrudRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolRepository {
    
    @Autowired
    private RolCrudRepository rolCrudRepository;
    
    public List<Rol> getAll(){
        return  (List<Rol>) rolCrudRepository.findAll();
    }

    public Optional<Rol> getRol(int id){
        return rolCrudRepository.findById(id);
    }

    public Rol save(Rol rol){
        return rolCrudRepository.save(rol);
    }

    public void delete(int id){
        rolCrudRepository.deleteById(id);        
    }

}
