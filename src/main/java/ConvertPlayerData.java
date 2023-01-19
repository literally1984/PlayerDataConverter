import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class ConvertPlayerData implements CommandExecutor {
    public String OfflinePlayerName = "";
    public String FileNameWithoutExt = "";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof ConsoleCommandSender)) {
            return false;
        }

        System.out.println(ChatColor.DARK_GRAY + "Converting player files to UUIDs now." + ChatColor.RESET);
        File WorldFilePlayers = new File(Bukkit.getWorldContainer().getAbsolutePath().substring(0, Bukkit.getWorldContainer().getAbsolutePath().length() - 1) + "world" + File.separator + "players" + File.separator);
        File[] Players = WorldFilePlayers.listFiles();
        for (File child: Players) {
            FileNameWithoutExt = child.getName().replaceFirst("[.][^.]+$", "");
            OfflinePlayerName = "OfflinePlayer:" + FileNameWithoutExt;
            UUID PlayerOfflineUUID = UUID.nameUUIDFromBytes(OfflinePlayerName.getBytes(StandardCharsets.UTF_8));
            File RenamePlayer = new File(Bukkit.getWorldContainer().getAbsolutePath().substring(0, Bukkit.getWorldContainer().getAbsolutePath().length() - 1) + "world" + File.separator + "players" + File.separator + PlayerOfflineUUID.toString() + ".dat");
            child.renameTo(RenamePlayer);
        }

        File RenamePlayerDataFolder = new File(Bukkit.getWorldContainer().getAbsolutePath().substring(0, Bukkit.getWorldContainer().getAbsolutePath().length() - 1) + "world" + File.separator + "playerdata" + File.separator);
        WorldFilePlayers.renameTo(RenamePlayerDataFolder);

        System.out.println(ChatColor.DARK_GRAY + "Done converting player files to UUIDs." + ChatColor.RESET);
        return true;
    }
}
