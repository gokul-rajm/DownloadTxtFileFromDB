package csvDownload.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import csvDownload.Entity.EntityClass;

@Repository
public interface RepositoryClass extends JpaRepository<EntityClass, Integer>{
	
}
