package sistemainformacion.registroproyectos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistemainformacion.registroproyectos.Model.Rol;
import sistemainformacion.registroproyectos.Repository.RolRepository;


@Service
public class RolService {
    @Autowired
    private RolRepository RolRepository;

    @Transactional (readOnly = true)
    public List<Rol> getAll(){
        return (List <Rol>) RolRepository.getAll();
    }

    @Transactional (readOnly = true)
    public Optional<Rol> getRol(int id){
        return RolRepository.getRol(id);
    }

    public Rol save(Rol Rol){
        if(Rol.getId_pk_rol() == null){
            return RolRepository.save(Rol);
        }else{
            Optional<Rol> aux = RolRepository.getRol(Rol.getId_pk_rol());
            if(aux.isEmpty()){
                return RolRepository.save(Rol);
            }else{
                return Rol;
            }
        }
    }

    public Rol update(Rol Rol){
        if(Rol.getId_pk_rol()!=null){
            Optional<Rol>g=RolRepository.getRol(Rol.getId_pk_rol());

            if(!g.isEmpty()){
                if(Rol.getNombre_rol()!=null){
                    g.get().setNombre_rol(Rol.getNombre_rol());                    
                }
                   
                return RolRepository.save(g.get());
            }
        }
        return Rol;
    }

    @Transactional 
    public void deleteRol(int id){
        RolRepository.delete(id);
    }
}
