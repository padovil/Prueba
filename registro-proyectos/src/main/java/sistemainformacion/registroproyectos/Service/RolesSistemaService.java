package sistemainformacion.registroproyectos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistemainformacion.registroproyectos.Model.RolesSistema;
import sistemainformacion.registroproyectos.Repository.RolesSistemaRepository;


@Service
public class RolesSistemaService {
    @Autowired
    private RolesSistemaRepository RolesSistemaRepository;

    @Transactional (readOnly = true)
    public List<RolesSistema> getAll(){
        return (List <RolesSistema>) RolesSistemaRepository.getAll();
    }

    @Transactional (readOnly = true)
    public Optional<RolesSistema> getRolesSistema(int id){
        return RolesSistemaRepository.getRolesSistema(id);
    }

    public RolesSistema save(RolesSistema RolesSistema){
        if(RolesSistema.getId_pk_roles_sistema() == null){
            return RolesSistemaRepository.save(RolesSistema);
        }else{
            Optional<RolesSistema> aux = RolesSistemaRepository.getRolesSistema(RolesSistema.getId_pk_roles_sistema());
            if(aux.isEmpty()){
                return RolesSistemaRepository.save(RolesSistema);
            }else{
                return RolesSistema;
            }
        }
    }

    public RolesSistema update(RolesSistema RolesSistema){
        if(RolesSistema.getId_pk_roles_sistema()!=null){
            Optional<RolesSistema>g=RolesSistemaRepository.getRolesSistema(RolesSistema.getId_pk_roles_sistema());

            if(!g.isEmpty()){
                if(RolesSistema.getNombre_rol_sistema()!=null){
                    g.get().setNombre_rol_sistema(RolesSistema.getNombre_rol_sistema());                    
                }
                   
                return RolesSistemaRepository.save(g.get());
            }
        }
        return RolesSistema;
    }

    @Transactional 
    public void deleteRolesSistema(int id){
        RolesSistemaRepository.delete(id);
    }
}
