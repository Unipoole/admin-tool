package coza.opencollab.unipoole.admin.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This Controller manages the display of the settings.
 * The settings for the admin tool is all set in a properties file and then
 * injected with Spring. Settings is not customisable in the tool.
 * 
 * @since 1.0.0
 * @author OpenCollab
 */
@Controller
public class SettingsController {
    /**
     * The settings injected by Spring
     */
    @Autowired
    private Settings settings;
    
    /**
     * Called to display the settings. This method passes the settings to
     * the view.
     */
    @RequestMapping(value="/settings",method=RequestMethod.GET)
    public ModelAndView settings() {
        return new ModelAndView("settings-tiles", "setting", settings);
    }
}
