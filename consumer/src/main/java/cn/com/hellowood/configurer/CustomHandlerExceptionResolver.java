package cn.com.hellowood.configurer;

import cn.com.hellowood.constant.CommonConstant;
import cn.com.hellowood.model.exception.ServiceException;
import cn.com.hellowood.model.util.CommonResponse;
import cn.com.hellowood.model.util.HttpStatus;
import cn.com.hellowood.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HelloWood
 **/
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

    private final Logger logger = LoggerFactory.getLogger(CustomHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        CommonResponse commonResponse = new CommonResponse();

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            if (ex instanceof ServiceException) {
                commonResponse.setCode(HttpStatus.FAILED)
                        .setMessage(ex.getMessage());
                logger.warn(ex.getMessage());
            } else {
                if (ex instanceof DataAccessException) {
                    commonResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR)
                            .setMessage(CommonConstant.DB_ERROR_MESSAGE);
                } else {
                    commonResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR)
                            .setMessage(CommonConstant.SERVER_ERROR_MESSAGE);
                }

                String message = String.format("interface [%s] has exception, method is %s.%s, exception message is %s",
                        request.getRequestURI(),
                        handlerMethod.getBean().getClass().getName(),
                        handlerMethod.getMethod().getName(),
                        ex.getMessage());
                logger.error(message, ex);
            }
        } else {
            if (ex instanceof NoHandlerFoundException) {
                commonResponse.setCode(HttpStatus.NOT_FUOUND)
                        .setMessage("interface [" + request.getRequestURI() + "] not exist");
            } else {
                commonResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR)
                        .setMessage(ex.getMessage());
                logger.error(ex.getMessage(), ex);
            }
        }

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(HttpStatus.SUCCESS.code);
        try {
            response.getWriter().write(JSONUtil.toJSONString(commonResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView();
    }
}
