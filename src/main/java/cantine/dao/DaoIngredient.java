package cantine.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cantine.data.Ingredient;

public interface DaoIngredient extends CrudRepository<Ingredient, Long>, PagingAndSortingRepository<Ingredient, Long> {

    
    Page<Ingredient> findByNomContaining(String search, Pageable pageable);

    // Pour vérifier si une unité est utilisée par un ingrédient
    @Query("SELECT COUNT(*) FROM ingredient WHERE id_unite = :idUnite")
    long compterPourUnite(@Param("idUnite") Long idUnite);

    // Vérification d’unicité du nom d’ingrédient (hors lui-même)
    @Query("SELECT COUNT(*) = 0 FROM ingredient WHERE nom = :nom AND id_ingredient <> COALESCE(:id, 0)")
    boolean verifierUniciteNom(@Param("nom") String nom, @Param("id") Long id);

    // Pas besoin de redéfinir findById ou deleteById : ils sont hérités

}
