package coza.opencollab.unipoole.admin.engine;

import coza.opencollab.unipoole.UnipooleException;
import coza.opencollab.unipoole.admin.settings.Settings;
import coza.opencollab.unipoole.shared.Module;
import coza.opencollab.unipoole.shared.Tool;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Default implementation of the Unipoole Client.
 * handles restful communication between the Admin tool and the Unipoole service.
 * @author OpenCollab
 */
public class DefaultUnipooleClient implements UnipooleClient {
    /**
     * The Spring Rest template. used for the communication and transformation of json
     */
    private final RestTemplate restTemplate = new RestTemplate();
    
    /**
     * Settings class handles the retrieval of variables stored in the properties file
     */
    private Settings settings;

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public DefaultUnipooleClient() {
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> getCreateClient(String moduleId, List<String> tools, String name, String email, String destination) {
        try {
            Map data = new HashMap();
            data.put("name", name);
            data.put("email", email);
            data.put("destination", destination);
            return restTemplate.postForObject(
                    MessageFormat.format(settings.getCreateClientUrl(), moduleId),
                    data, Map.class);
        } catch (RestClientException e) {
            throw new UnipooleException(3000, "Error Connecting to the Unipoole service.", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Module> searchForModule(String year, String semester, String moduleCode) {
        try {
            URL url = new URL(MessageFormat.format(getSettings().getSearchModuleUrl(), year, semester, moduleCode));

            // Make the HTTP GET request, marshaling the response to a String
            return restTemplate.getForObject(url.toString(), List.class);
        } catch (MalformedURLException e) {
            throw new UnipooleException(3000, "Error Connecting to the Unipoole service.", e);
        } catch (RestClientException e) {
            throw new UnipooleException(3000, "Error Connecting to the Unipoole service.", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Tool> getToolListForModule(String moduleId) {
        try {
            URL url = new URL(MessageFormat.format(settings.getToolListUrl(), moduleId));

            // Make the HTTP GET request, marshaling the response to a String
            return restTemplate.getForObject(url.toString(), List.class);
        } catch (MalformedURLException e) {
            throw new UnipooleException(3001,"Attempting to communicate to a web service using a malformed URL.", e);
        }
    }
}
