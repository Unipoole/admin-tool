package coza.opencollab.unipoole.admin.search;

/**
 * The model containing the search parameters
 * 
 * @since 1.0.0
 * @author OpenCollab
 */
public class SearchModel {

    /**
     * The year to link to the module in Sakai.
     */
    private String year;
    /**
     * The semester to link to the module in Sakai.
     */
    private String semester;
    /**
     * The module code to link to the module in Sakai.
     */
    private String moduleCode;

    /**
     * The year to link to the module in Sakai.
     */
    public String getYear() {
        return year;
    }
     
    /**
     * The year to link to the module in Sakai.
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * The semester to link to the module in Sakai.
     */
    public String getSemester() {
        return semester;
    }

    /**
     * The semester to link to the module in Sakai.
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * The module code to link to the module in Sakai.
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * The module code to link to the module in Sakai.
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
}
