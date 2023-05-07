package csvDownload.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import csvDownload.Entity.EntityClass;
import csvDownload.Response.ResponseClass;
import csvDownload.Service.ServiceClass;

@RestController
public class ControllerClass {
	
	 @Autowired
	 private ServiceClass serviceClass;
	 
	 @PostMapping("/post")
	 public ResponseClass saveDetails(@RequestBody EntityClass entityClass) {
		 return serviceClass.saveDetails(entityClass);
	 }
	 
	 
	 @GetMapping("/users/export")
	    public void exportToCSV(HttpServletResponse response) throws IOException {
	        response.setContentType("text/csv");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
	        response.setHeader(headerKey, headerValue);
	         
	        List<EntityClass> listUsers = serviceClass.listAll();
	 
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
	        String[] csvHeader = {"User ID", "E-mail", "Name","Age","Number"};
	        String[] nameMapping = {"id", "email", "name","age","number"};
	         
	        csvWriter.writeHeader(csvHeader);
	         
	        for (EntityClass entityClass : listUsers) {
	            csvWriter.write(entityClass, nameMapping);
	        }
	         
	        csvWriter.close();
	         
	    }
	 
//	 @GetMapping("/download")
//	  public ResponseEntity<Resource> getFile() {
//	    String filename = "myFile.csv";
//	    InputStreamResource file = new InputStreamResource(serviceClass.findAll());
//
//	    return ResponseEntity.ok()
//	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
//	        .contentType(MediaType.parseMediaType("application/csv"))
//	        .body(file);
//	  }
	 
//	 @GetMapping("/get/{id}")
//	 public ResponseClass getDetails(@PathVariable int id) {
//		 return serviceClass.getDetails(id);
//	 }
//	 
//	 @GetMapping("/getAll")
//	 public ResponseClass getAllDetails(EntityClass entityClass) {
//		 return serviceClass.getAllDetails(entityClass);
//	 }
//	 
//	 @PutMapping("/update")
//	 public ResponseClass updateDetails(@RequestBody EntityClass entityClass) {
//		 return serviceClass.updateDetails(entityClass);
//	 }
//	 
//	 @DeleteMapping("/delete/{id}")
//	 public ResponseClass deleteDetails(@PathVariable int id) {
//		 return serviceClass.deleteDetails(id);
//	 }
} 

