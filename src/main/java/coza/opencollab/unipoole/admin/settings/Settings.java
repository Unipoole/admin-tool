package coza.opencollab.unipoole.admin.settings;

/**
 * This holds the settings used in the admin tool.
 * The settings are configure in a properties file and injected through Spring.
 * 
 * @since 1.0.0
 * @author OpenCollab
 */
public class Settings {
    /**
     * The destination folder to write the Client to.
     */
    private String clientDestination;
    private String searchModuleUrl;
    private String toolListUrl;
    private String createClientUrl;
    /**
     * The username to use for the Client Creator service.
     */
    private String serviceUsername;
    /**
     * The password to use for the Client Creator service.
     */
    private String servicePassword;

    public String getSearchModuleUrl() {
        return searchModuleUrl;
    }

    public String getToolListUrl() {
        return toolListUrl;
    }

    public String getCreateClientUrl() {
        return createClientUrl;
    }

    public String getServiceUsername() {
        return serviceUsername;
    }

    public String getServicePassword() {
        return servicePassword;
    }

    //TODO comment
    public void setCreateClientUrl(String createClientUrl) {
        this.createClientUrl = createClientUrl;
    }
    
    public void setSearchModuleUrl(String searchModuleUrl){
        this.searchModuleUrl = searchModuleUrl;
    }

    public void setToolListUrl(String toolListUrl) {
        this.toolListUrl = toolListUrl;
    }

    public void setServiceUsername(String serviceUsername) {
        this.serviceUsername = serviceUsername;
    }

    public void setServicePassword(String servicePassword) {
        this.servicePassword = servicePassword;
    }

    /**
     * The destination folder to write the Client to.
     */
    public String getClientDestination() {
        return clientDestination;
    }

    /**
     * The destination folder to write the Client to.
     */
    public void setClientDestination(String clientDestination) {
        this.clientDestination = clientDestination;
    }
}
