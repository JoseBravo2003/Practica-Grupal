
package com.practica.service.impl;

import com.practica.dao.ArbolDao;
import com.practica.domain.Arbol;
import com.practica.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImpl implements ArbolService {
    
    @Autowired
    private ArbolDao arbolDao;
            
    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArbols(boolean activos) {
        var lista = arbolDao.findAll();
        // Si activos es true, se deben pasar solo la arbols activas
        
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    @Override
    
    //Este busca el objeto que coincida si lo encuentra todo bien y si no devuelve null
    @Transactional(readOnly = true)
    public Arbol getArbol(Arbol arbol) {
        return arbolDao.findById(arbol.getIdArbol()).orElse(null);
    }

    @Override
    
    //Si el obejto tiene definido un idarbol y si no viene con el id hace un insert
    @Transactional
    public void save(Arbol arbol) {
        arbolDao.save(arbol);
    }

    @Override
    
    //busca un objeto con idarbol y si lo encuentra lo borra
    @Transactional
    public void delete(Arbol arbol) {
        arbolDao.delete(arbol);
    }
    
}
