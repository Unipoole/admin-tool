package coza.opencollab.unipoole.admin.createClient;

import coza.opencollab.unipoole.admin.engine.UnipooleClient;
import coza.opencollab.unipoole.shared.Module;
import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * The CreateClientController directs communication between the models and the
 * view. also responsible for creating the Dongle Client.
 *
 * @author OpenCollab
 */
@Controller
public class CreateClientController {

    @Autowired
    private UnipooleClient unipooleClient;

    /**
     * The function will be required to accept the Course and selected tools.
     * Open a connection to the engine, send the course details and selected
     * tools to the engine.
     *
     * @param moduleId
     * @param moduleName
     * @param toolIds 
     * @param userName
     * @param userEmail
     * @param clientDestination
     * @param clientDestinationCheck
     * @return ModelAndView
     */
    @RequestMapping(value = "/module/createClient", method = RequestMethod.POST)
    public ModelAndView createClient(
            @RequestParam(value = "id", required = true) String moduleId,
            @RequestParam(value = "name", required = true) String moduleName,
            @RequestParam(value = "createTool", required = false) String[] toolIds,
            @RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "userEmail", required = true) String userEmail,
            @RequestParam(value = "clientDestination", required = true) String clientDestination,
            @RequestParam(value = "clientDestinationCheck", required = false) boolean clientDestinationCheck) {

        ModelAndView modelAndView = new ModelAndView();
        Module module = new Module();

        module.setId(moduleId);
        module.setName(moduleName);

        if(!clientDestinationCheck){
            clientDestination = null;
        }
        Map<String, String> creatorData = unipooleClient.getCreateClient(module.getId(), null, userName, userEmail, clientDestination);
        if ("SUCCESS".equals(creatorData.get("status"))) {
            modelAndView.addAllObjects(creatorData);
            modelAndView.addObject("module", module);
        } else {
            modelAndView.addObject("error_message", creatorData.get("message"));
            modelAndView.addObject("error_code", creatorData.get("errorCode"));
            modelAndView.addObject("error_instruction", creatorData.get("instruction"));
        }

        modelAndView.setViewName("clientCreate-tiles");
        return modelAndView;
    }
}
