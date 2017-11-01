package cn.com.hellowood.model.util;

/**
 * @author HelloWood
 **/
public enum HttpStatus {

    SUCCESS(200),
    REDIRECT(301),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FUOUND(404),
    FAILED(418),
    METHOD_NOT_ALLOWED(405),
    INTERNAL_SERVER_ERROR(500);

    public int code;

    HttpStatus(int code) {
        this.code = code;
    }
}
