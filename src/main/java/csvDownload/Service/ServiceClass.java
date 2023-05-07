package csvDownload.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import csvDownload.Entity.EntityClass;
import csvDownload.Repository.RepositoryClass;
import csvDownload.Response.ResponseClass;

@Service
public class ServiceClass {

	@Autowired
	private RepositoryClass repositoryClass;
	
	public ResponseClass saveDetails(EntityClass entityClass) {
		return new ResponseClass(HttpStatus.CREATED, "Created Successfully", repositoryClass.save(entityClass));
	}
	
	public List<EntityClass> listAll() {
        return repositoryClass.findAll(Sort.by("email").ascending());
    }
	
//	public ByteArrayInputStream findAll() {
//	    List<EntityClass> entityClass = repositoryClass.findAll();
//
//	    ByteArrayInputStream in = HelperClass.tutorialsToCSV(entityClass);
//	    return in;
//	  }

//	public ResponseClass getDetails(int id) {
//		return new ResponseClass(HttpStatus.OK, "Retrieved Successfully", repositoryClass.findById(id));
//	}
//
//	public ResponseClass updateDetails(EntityClass entityClass) {
//		return new ResponseClass(HttpStatus.OK, "Updated Successfully", repositoryClass.save(entityClass));
//	}
//
//	public ResponseClass getAllDetails(EntityClass entityClass) {
//		return new ResponseClass(HttpStatus.OK, "Retrieved Successfully", repositoryClass.findAll());
//	}
//
//	public ResponseClass deleteDetails(int id) {
//		repositoryClass.deleteById(id);
//		return new ResponseClass(HttpStatus.OK, "Deleted Successfully");
//	}
}
