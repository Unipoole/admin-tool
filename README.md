[![Build Status](https://travis-ci.org/Unipoole/admin-tool.svg?branch=master)](https://travis-ci.org/Unipoole/admin-tool)
[![License](https://img.shields.io/badge/License-ECL%202.0-blue.svg)](https://opensource.org/licenses/ECL-2.0)

# admin-tool
The admin-tool is the tool responsible for creating the Unipoole digi-band Clients for a module.
This is a deployable project.

## Building
```bash
git clone https://github.com/Unipoole/admin-tool.git
cd admin-tool
mvn clean install
```

## Configuration
The Admin-Tool use configuration from a file called `application.properties`. There is a configuration file in the deployment (`admin-tool.war`) with the default properties under `WEB-INF\config\application.properties`. When the Admin-Tool run it will also look for `application.properties` in the `UNIPOOLE_HOME` (set in the environmental variables) which will override the default properties.
The following must be set:
``` ini
#Setting: The base URL to the Client Creator service
engine.base.url=http://your.unipoole.server/unipoole-service/
 
#Active Directory
ad.adProviderURL=ldap://your.ad.server:389/DC=user,DC=ac,DC=za
ad.unisaDomain=user.ac.za
ad.authenticationType=simple
```

## Deployment
If the Maven build is successful there will be a `admin-tool.war` archive in the `target` folder of the build. This archive can be deployed to your Tomcat instance

## Documentation
* [New Client creation](./docs/new-client-creation.md)