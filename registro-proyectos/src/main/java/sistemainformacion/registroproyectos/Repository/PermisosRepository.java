package sistemainformacion.registroproyectos.Repository;

import sistemainformacion.registroproyectos.Model.Permisos;
import sistemainformacion.registroproyectos.Repository.Crud.PermisoCrudRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PermisosRepository {
    
    @Autowired
    private PermisoCrudRepository PermisosCrudRepository;
    
    public List<Permisos> getAll(){
        return  (List<Permisos>) PermisosCrudRepository.findAll();
    }

    public Optional<Permisos> getPermisos(int id){
        return PermisosCrudRepository.findById(id);
    }

    public Permisos save(Permisos Permisos){
        return PermisosCrudRepository.save(Permisos);
    }

    public void delete(int id){
        PermisosCrudRepository.deleteById(id);        
    }

}
