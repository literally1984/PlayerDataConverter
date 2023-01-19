import org.bukkit.plugin.java.JavaPlugin;

public class PlayerDataConverter extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("convertplayerdata").setExecutor(new ConvertPlayerData());
        this.getCommand("convertessentialsplayerdata").setExecutor(new ConvertEssentialsPlayerData());
    }
}
