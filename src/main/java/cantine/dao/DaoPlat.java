package cantine.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cantine.data.Plat;

public interface DaoPlat extends CrudRepository<Plat, Long>, PagingAndSortingRepository<Plat, Long> {
	
}
