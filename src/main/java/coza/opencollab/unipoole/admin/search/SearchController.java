package coza.opencollab.unipoole.admin.search;

import coza.opencollab.unipoole.admin.engine.UnipooleClient;
import coza.opencollab.unipoole.shared.Module;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This Controller manages the search of modules for which clients will be
 * created.
 *
 * @since 1.0.0
 * @author OpenCollab
 */
@Controller
public class SearchController {

    private static final Logger log = Logger.getLogger(SearchController.class);
    private static final String MODEL_NAME = "command";
    private static final Map<String, String> semester;
    static
    {
        semester = new HashMap<String, String>();
        semester.put("Y1","Year course");
        semester.put("Y2","Year course starting in the second part of the year");
        semester.put("S1","Semester one");
        semester.put("S2","Semester two");
    }

    @Autowired
    private UnipooleClient unipooleClient;

    /**
     * This is called to load the search form
     * @return ModelAndView
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView loadSearchForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("semester",semester);
        modelAndView.addObject(MODEL_NAME, new SearchModel());
        modelAndView.setViewName("search-tiles");
        return modelAndView;
    }

    /**
     * This is called when the search form is submitted. It searches for the
     * modules and does validation and error checking. If successful it
     * continues to the modules view, otherwise it returns to the search view.
     *
     * @param model The search criteria
     * @param result The binding result for validation
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView doSearch(
                @ModelAttribute("model") SearchModel model, 
                BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
                
        if (log.isDebugEnabled()) {
            log.debug("Module Code:" + model.getModuleCode()
                    + "Year:" + model.getYear()
                    + "Semester:" + model.getSemester());
        }
        if (result.hasErrors()) {
            return new ModelAndView("search-tiles", MODEL_NAME, model);
        }
        List<Module> modules = unipooleClient.searchForModule(model.getYear() , model.getSemester() , model.getModuleCode().toUpperCase());
        if (modules.isEmpty()) {
            modelAndView.addObject(MODEL_NAME ,new SearchModel());
            modelAndView.addObject("info_message","No courses, matching your criteria. Please try again.");
            modelAndView.addObject("semester",semester);
            modelAndView.setViewName("search-tiles");
            return modelAndView;
        }

        return new ModelAndView("modules-tiles", MODEL_NAME, modules );
    }
}
