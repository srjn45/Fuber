package code.srjn.fuber.model;

public class Response {

	private boolean status;
	private String message;
	private Object payload;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + ", payload=" + payload + "]";
	}

}
