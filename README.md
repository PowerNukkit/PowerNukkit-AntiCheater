# Example Plugin for PowerNukkit
This is an example plugin which can also be used as template to start your own plugin.

As an example I created a plugin named clone-me, it creates a clone of yourself when you run `/clone`
and gives you a flower if you hit the clone and then despawn the clone. It also send some fancy messages.

These is enough to serve as an example on how to:
- Begin a new plugin
- Create event listeners and handlers
- Create custom commands
- Format text
- Spawn NPCs
- Despawn NPCs
- Detect attacks
- Make entities invulnerable
- Create and fill a `plugin.yml` file
- Debug your plugin properly

## Cloning and importing
1. Just do a normal `git clone https://github.com/PowerNukkit/ExamplePlugin.git` (or the URL of your own git repository)
2. Import the `pom.xml` file with your IDE, it should do the rest by itself

## Debugging
1. Create a zip file containing only your `plugin.yml` file
2. Rename the zip file to change the extension to jar
3. Create an empty folder anywhere, that will be your server folder.  
   <small>_Note: You don't need to place the PowerNukkit jar in the folder, your IDE will load it from the maven classpath._</small>
4. Create a folder named `plugins` inside your server folder  
   <small>_Note: It is needed to bootstrap your plugin, your IDE will load your plugin classes from the classpath automatically,
   so it needs to have only the `plugin.yml` file._</small>
5. Move the jar file that contains only the `plugin.yml` to the `plugins` folder
6. Create a new Application run configuration setting the working directory to the server folder and the main class to:  `cn.nukkit.Nukkit`  
![](https://i.imgur.com/NUrrZab.png)
7. Now you can run in debug mode. If you change the `plugin.yml` you will need to update the jar file that you've made.
