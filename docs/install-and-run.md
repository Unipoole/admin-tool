# Installing the client
Now that you have downloaded the client in zip format we can install the client.
1. Copy the zip file to your digiband.
2. Extract the contents onto the root of the digiband.

## Running Unipoole from the digiband
Execute the unipoole.bat file. This will start a local node.js server and open the home page in your default browser.
You will see the following process running :
<img src="http://unipoole.github.io/images/install-and-run/console.png" style="max-width: 100%" />

### Registering for first use
Unipoole will ask you to register the first time it is run. If you are offline it will just give a a message informing you that you are not registered :

**Offline :**
<img src="http://unipoole.github.io/images/install-and-run/not-registered-offline.png" style="max-width: 100%" />

**Online :**
<img src="http://unipoole.github.io/images/install-and-run/not-registered-online.png" style="max-width: 100%" />

If you are online you will be taken to the Inital Setup screen where you have to enter your student number and myUnisa password.
<img src="http://unipoole.github.io/images/install-and-run/initial-setup.png" style="max-width: 100%" />

### Unipoole dashboard
+ Online status indicates whether the Unipoole can communicate with the Unipoole server
  - [![green](http://unipoole.github.io/images/install-and-run/green.png)] indicates online or in sync status
  - [![green](http://unipoole.github.io/images/install-and-run/red.png)] indicates a offline or out of sync status
+ Sync Now indicates if the tool is currently in sync with myUnisa
  - When clicking on Sync Now the tool will check the sync status
  - Sync status will also be checked when the page is refreshed
  - Sync status will only be checked if it has not checked in the last 2 min
  - A wait dialog will block any user action while the sync status is being checked
  <img src="http://unipoole.github.io/images/install-and-run/update-sync-status.png" style="max-width: 100%" />
  
### Synchronize
