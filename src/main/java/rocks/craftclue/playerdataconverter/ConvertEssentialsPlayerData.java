package rocks.craftclue.playerdataconverter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class ConvertEssentialsPlayerData implements CommandExecutor {
    public String OfflinePlayerName = "";
    public String FileNameWithoutExt = "";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof ConsoleCommandSender)) {
            return false;
        }

        System.out.println(ChatColor.DARK_GRAY + "Converting Essentials player files to UUIDs now." + ChatColor.RESET);
        File WorldFilePlayers = new File(Bukkit.getWorldContainer().getAbsolutePath().substring(0, Bukkit.getWorldContainer().getAbsolutePath().length() - 1) + "plugins" + File.separator + "Essentials" + File.separator + "userdata" + File.separator);
        File[] Players = WorldFilePlayers.listFiles();
        for (File child: Players) {
            FileNameWithoutExt = child.getName().replaceFirst("[.][^.]+$", "");
            OfflinePlayerName = "OfflinePlayer:" + FileNameWithoutExt;
            UUID PlayerOfflineUUID = UUID.nameUUIDFromBytes(OfflinePlayerName.getBytes(StandardCharsets.UTF_8));
            File RenamePlayer = new File(Bukkit.getWorldContainer().getAbsolutePath().substring(0, Bukkit.getWorldContainer().getAbsolutePath().length() - 1) + "plugins" + File.separator + "Essentials" + File.separator + "userdata" + File.separator + PlayerOfflineUUID.toString() + ".yml");
            child.renameTo(RenamePlayer);
        }

        System.out.println(ChatColor.DARK_GRAY + "Done converting Essentials player files to UUIDs." + ChatColor.RESET);
        return true;
    }
}
