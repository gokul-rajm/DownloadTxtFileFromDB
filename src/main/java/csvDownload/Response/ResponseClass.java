package csvDownload.Response;

import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseClass {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    public HttpStatus status;
	public Object data;
    public String message;

    public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public ResponseClass(HttpStatus status,String message,Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public ResponseClass(HttpStatus status,String message) {
		super();
		this.status = status;
		this.message = message;
	}
}
