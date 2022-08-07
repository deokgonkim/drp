package net.dgkim.drp.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/menu")
public class MenuController {
    
    @RequestMapping("getMenuJson.do")
    public @ResponseBody String getMenuJson(WebRequest request,
                                            @RequestParam(value = "node", required = false) String node) {
        String jsonBody = null;
        if ( node == null || node.equals("root") ) {
            jsonBody = getRootMenu();
        } else {
            //if ( node.equals("mng1") ) {
                jsonBody = "{ menu: [{ id: 'mng1a', text: 'mng1', href: 'http://www.dgkim.net/' }] }";
            //}
        }
        return jsonBody;
    }
    
    protected String getRootMenu() {
        String jsonBody = null;
        
        jsonBody = String.format("{ menu: [ %s, %s ] }", toMenuItemJson("mng1", "adm1", null), toMenuItemJson("mng2", "adm2", null));
        
        return jsonBody;
    }
    
    private String toMenuItemJson(String id, String displayName, String href) {
        if ( href != null ) {
            return String.format("{ id: '%s', text: '%s', leaf: true, href: '%s' }", id, displayName, href);
        } else {
            return String.format("{ id: '%s', text: '%s' }", id, displayName);
        }
    }
}
