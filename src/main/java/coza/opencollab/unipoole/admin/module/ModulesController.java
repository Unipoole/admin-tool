package coza.opencollab.unipoole.admin.module;

import coza.opencollab.unipoole.admin.engine.UnipooleClient;
import coza.opencollab.unipoole.admin.settings.Settings;
import coza.opencollab.unipoole.shared.Module;
import coza.opencollab.unipoole.shared.Tool;
import coza.opencollab.unipoole.util.AuthenticationUtil;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller set up the modules detail page
 * 
 * @author OpenCollab
 * @since 1.0.0
 */
@Controller
public class ModulesController {

    @Autowired
    private UnipooleClient unipooleClient;
    @Autowired
    private Settings settings;
    
    /**
     * When given a module name , retrieve all module information as well as tools belonging to the module
     * @param name name of the module, passed as get URL variable
     * @param id passed as get URL
     * @return ModelAndView 
     */
    @RequestMapping(value = "/module/{name}/{id}", method = RequestMethod.GET)
    public  ModelAndView loadModuleInformation(@PathVariable String name, @PathVariable String id) {
        Module module = new Module();
        HashMap moduleData = new HashMap();
        if(!name.isEmpty() ){
            module.setName(name);
            module.setId(id);
            List<Tool> tools = unipooleClient.getToolListForModule(id);
            moduleData = new HashMap();
            moduleData.put("module", module);
            moduleData.put("tools", tools);
            moduleData.put("userName", AuthenticationUtil.getUserDisplayName());
            moduleData.put("userEmail", AuthenticationUtil.getUserEmail());
            moduleData.put("clientDestination", settings.getClientDestination());
        }
        return new ModelAndView("module-tiles", "command", moduleData);
    }
}
