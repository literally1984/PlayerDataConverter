# PlayerDataConverter
A Minecraft plugin which converts pre-1.8 player files to offline-mode UUID-based ones. Also works with Essentials player files.

## How To Use
1. Take a backup of your player files. It's very unlikely that the plugin will screw up and damage them, but it's better to be safe than sorry.
2. Download the plugin JAR from this repository's releases tab and put it in your server's plugin folder. The plugin *should* work for all Minecraft versions, but it's only been tested on 1.5.2.
3. Restart your server.
4. To convert player data, run the command "convertplayerdata" from your server console. <bold>This command assumes the player data files are located in the /world/players/ directory.</bold> The files will get converted and the folder which houses the player files will be renamed to "playerdata". This is because 1.8 and onwards uses the folder name "playerdata" instead of "players".
5. To convert Essentials player data, run the command "convertessentialsplayerdata" from your server console. <bold>This command assumes the player data files are located in the /plugins/Essentials/userdata/ directory.</bold>
6. Upgrade your server to 1.8 or higher and if all goes correctly, all of your player data will have been saved.
