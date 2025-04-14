package cantine.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cantine.data.Unite;
import java.util.List;

public interface DaoUnite extends CrudRepository<Unite, Long> {

    @Query("SELECT nom FROM Unite WHERE id_unite = :idUnite ORDER BY nom")
    List<String> trouverNomsParIdUnite(@Param("idUnite") Long idUnite);
}
