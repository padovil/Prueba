package sistemainformacion.registroproyectos.Repository;

import sistemainformacion.registroproyectos.Model.RolesSistema;
import sistemainformacion.registroproyectos.Repository.Crud.RolesSistemaCrudRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolesSistemaRepository {
    
    @Autowired
    private RolesSistemaCrudRepository RolesSistemaCrudRepository;
    
    public List<RolesSistema> getAll(){
        return  (List<RolesSistema>) RolesSistemaCrudRepository.findAll();
    }

    public Optional<RolesSistema> getRolesSistema(int id){
        return RolesSistemaCrudRepository.findById(id);
    }

    public RolesSistema save(RolesSistema RolesSistema){
        return RolesSistemaCrudRepository.save(RolesSistema);
    }

    public void delete(int id){
        RolesSistemaCrudRepository.deleteById(id);        
    }

}
