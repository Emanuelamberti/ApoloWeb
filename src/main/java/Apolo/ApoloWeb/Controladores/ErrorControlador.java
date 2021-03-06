package Apolo.ApoloWeb.Controladores;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorControlador implements ErrorController{
    
    @RequestMapping(value="/error", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest){
        
        ModelAndView errorPage = new ModelAndView("error");
        String errorMsg="";
        int httpErrorCode = (int) httpRequest.getAttribute("javax.servlet.error.status_code");
        
        switch (httpErrorCode){
            case 400: {
                errorMsg="El recurso solicitado no fue encontrado.";
                break;
            }
            case 403: {
                errorMsg="No tiene permisos para acceder a este recurso.";
                break;
            }
            case 401: {
                errorMsg="No se encuentra autorizado.";
                break;
            }
            case 404: {
                errorMsg="No se encuentra autorizado.";
                break;
            }
            case 500: {
                errorMsg="Ocurrió un error interno.";
                break;
            }
        }
        errorPage.addObject("codigo", httpErrorCode);
        errorPage.addObject("mensaje", errorMsg);
        return errorPage;
    }

}
