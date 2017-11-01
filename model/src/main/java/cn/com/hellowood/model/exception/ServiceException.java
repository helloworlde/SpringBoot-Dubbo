package cn.com.hellowood.model.exception;

/**
 * @author HelloWood
 **/
public class ServiceException extends Exception {

    public ServiceException(String message, Exception e) {
        super(message + "\n" + e.getMessage());
    }

    public ServiceException(String message) {
        super(message);
    }
}