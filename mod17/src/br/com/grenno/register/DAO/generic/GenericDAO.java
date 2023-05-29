package br.com.grenno.register.DAO.generic;

import br.com.grenno.register.domain.IPersistent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends IPersistent> implements IGenericDAO<T>{
    // create a generic database where primaryKey is Class and each element is a Map
    protected Map<Class, Map<Long, T>> map;
    public abstract Class<T> getClassType();

    public abstract void updateSpecificEntity(T entityDataToUpdate, T registeredObject);

    public GenericDAO() {
        if(this.map == null) {
            this.map = new HashMap<>();
            Map<Long, T> innerMap = this.map.get(getClassType());
            if (innerMap == null) {
                // instance if "Table" doesn't exist
                innerMap = new HashMap<>();
                this.map.put(getClassType(), innerMap);
            }
        }
    }

    @Override
    public Boolean register(T entity) {
        Map<Long, T> innerMap = this.map.get(getClassType());
        if(innerMap.containsKey(entity.getKey())) {
            return false;
        }
        innerMap.put(entity.getKey(), entity);
        return true;
    }

    @Override
    public void delete(Long primaryKey) {
        Map<Long, T> innerMap = this.map.get(getClassType());
        T registeredEntity = innerMap.get(primaryKey);

        if(registeredEntity != null) {
            innerMap.remove(registeredEntity.getKey(), registeredEntity);
        }
    }

    @Override
    public void update(T entityDataToUpdate) {
        Map<Long, T> innerMap = this.map.get(getClassType());
        T registeredObject = innerMap.get(entityDataToUpdate.getKey());

        if(registeredObject != null) {
            updateSpecificEntity(entityDataToUpdate, registeredObject);
        }
    }

    @Override
    public T find(Long primaryKey) {
        Map<Long, T> innerMap = this.map.get(getClassType());
        return innerMap.get(primaryKey);
    }

    @Override
    public Collection<T> fetchAll() {
        Map<Long, T> innerMap = this.map.get(getClassType());
        return innerMap.values();
    }
}
