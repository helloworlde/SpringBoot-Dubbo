package cn.com.hellowood.util;


import cn.com.hellowood.constant.CommonConstant;
import cn.com.hellowood.model.util.CommonResponse;
import cn.com.hellowood.model.util.HttpStatus;

/**
 * @author HelloWood
 **/
public class ResponseUtil {

    /**
     * Return response with default success or fail message by status
     *
     * @param resultStatus
     * @return
     */
    public static CommonResponse generateResponse(boolean resultStatus) {
        CommonResponse commonResponse = new CommonResponse();
        if (resultStatus) {
            commonResponse
                    .setCode(HttpStatus.SUCCESS)
                    .setMessage(CommonConstant.DEFAULT_SUCCEESS_MESSAGE);

        } else {
            commonResponse
                    .setCode(HttpStatus.FAILED)
                    .setMessage(CommonConstant.DEFAULT_FAIL_MESSAGE);
        }

        return commonResponse;
    }

    /**
     * Return response with custom message by status
     *
     * @param resultStatus
     * @param message
     * @return
     */
    public static CommonResponse generateResponse(boolean resultStatus, String message) {
        CommonResponse commonResponse = new CommonResponse();
        if (resultStatus) {
            commonResponse
                    .setCode(HttpStatus.SUCCESS)
                    .setMessage(message);

        } else {
            commonResponse
                    .setCode(HttpStatus.FAILED)
                    .setMessage(message);
        }

        return commonResponse;
    }

    /**
     * Return response with data
     *
     * @param data
     * @return
     */
    public static CommonResponse generateResponse(Object data) {
        CommonResponse commonResponse = new CommonResponse();
        if (data != null) {
            commonResponse
                    .setCode(HttpStatus.SUCCESS)
                    .setMessage(CommonConstant.DEFAULT_SUCCEESS_MESSAGE)
                    .setData(data);
        } else {
            commonResponse
                    .setCode(HttpStatus.SUCCESS)
                    .setMessage(CommonConstant.NO_RESULT_MESSAGE);
        }
        return commonResponse;
    }
}
