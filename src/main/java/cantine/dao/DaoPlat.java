package cantine.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import cantine.data.Plat;
import cantine.data.TypePlat;

public interface DaoPlat extends CrudRepository<TypePlat, Long> {

   
    @Query("SELECT * FROM ...")
    @NonNull
    Iterable<TypePlat> findAll();

	
}