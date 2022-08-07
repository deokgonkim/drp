package net.dgkim.drp.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/main")
public class MainController {
    
    @RequestMapping("welcome.do")
    public String welcome(WebRequest request, ModelMap modelMap) {
        String viewName = null;
        
        viewName = "main/welcome";
        modelMap.addAttribute("UserPrincipal", request.getUserPrincipal());
        
        return viewName;
    }
}
