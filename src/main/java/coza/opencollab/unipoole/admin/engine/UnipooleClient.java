package coza.opencollab.unipoole.admin.engine;

import coza.opencollab.unipoole.shared.Module;
import coza.opencollab.unipoole.shared.Tool;
import java.util.List;
import java.util.Map;

/**
 * The client API for admin tool communication with the Unipoole service
 * 
 * @author OpenCollab
 */
public interface UnipooleClient {
    
    /**
     * Call the Unipoole service to create the client and get the status response
     * from the service
     *
     * @param moduleId The module id
     * @param tools The list of the tools to add to the client
     * @param name The user's name to send the report too.
     * @param email The email to send the report too.
     * @param destination The destination dir to write the client to.
     * @return A map containing the result of the action.
     */
    public Map<String, String> getCreateClient(String moduleId , List<String> tools, String name, String email, String destination);

    /**
     * Search for a list of modules matching the criteria
     *
     * @param year
     * @param semester
     * @param moduleCode 
     * @return a list of modules
     */
    public List<Module> searchForModule(String year, String semester, String moduleCode);

    /**
     * Get a list of tools for a given moduleId
     * @param moduleId
     * @return list of type Tool.
     */
    public List<Tool> getToolListForModule(String moduleId);
    
}