package org.academiadecodigo.asycntomatics.byebye.dao;


import org.academiadecodigo.asycntomatics.byebye.model.Model;

import java.util.List;

public interface Dao<T extends Model> {

  List<T> findAll();

    /**
     * Gets the model
     *
     * @param id the model id
     * @return the model
     */
    T findById(Integer id);

    /**
     * Saves or updates the model
     *
     * @param modelObject the model to be saved or updated
     * @return the saved or updated model
     */
    T saveOrUpdate(T modelObject);

    /**
     * Deletes the model
     *
     * @param id the id of the model to be deleted
     */
    void delete(Integer id);


}
