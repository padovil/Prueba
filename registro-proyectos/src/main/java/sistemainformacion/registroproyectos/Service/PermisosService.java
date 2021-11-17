package sistemainformacion.registroproyectos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistemainformacion.registroproyectos.Model.Permisos;
import sistemainformacion.registroproyectos.Repository.PermisosRepository;


@Service
public class PermisosService {
    @Autowired
    private PermisosRepository PermisosRepository;

    @Transactional (readOnly = true)
    public List<Permisos> getAll(){
        return (List <Permisos>) PermisosRepository.getAll();
    }

    @Transactional (readOnly = true)
    public Optional<Permisos> getPermisos(int id){
        return PermisosRepository.getPermisos(id);
    }

    public Permisos save(Permisos Permisos){
        if(Permisos.getId_pk_permisos() == null){
            return PermisosRepository.save(Permisos);
        }else{
            Optional<Permisos> aux = PermisosRepository.getPermisos(Permisos.getId_pk_permisos());
            if(aux.isEmpty()){
                return PermisosRepository.save(Permisos);
            }else{
                return Permisos;
            }
        }
    }

    public Permisos update(Permisos Permisos){
        if(Permisos.getId_pk_permisos()!=null){
            Optional<Permisos>g=PermisosRepository.getPermisos(Permisos.getId_pk_permisos());

            if(!g.isEmpty()){
                if(Permisos.getContrasena()!=null){
                    g.get().setContrasena(Permisos.getContrasena());                    
                }
                   
                return PermisosRepository.save(g.get());
            }
        }
        return Permisos;
    }

    @Transactional 
    public void deletePermisos(int id){
        PermisosRepository.delete(id);
    }
}
