package us.tastybento.bskyblock.managers;

import java.util.ArrayList;
import java.util.List;

import us.tastybento.bskyblock.BSkyBlock;
import us.tastybento.bskyblock.api.flags.Flag;
import us.tastybento.bskyblock.api.panels.PanelItem;

public class FlagsManager {

    private BSkyBlock plugin;

    public FlagsManager(BSkyBlock plugin) {
        this.plugin = plugin;
    }

    private List<Flag> flags = new ArrayList<>();

    public void registerFlag(Flag flag) {
        //TODO all the security checks
        plugin.getLogger().info("DEBUG: registering flag " + flag.getID());
        flags.add(flag);
        // If there is a listener, register it into Bukkit.
        flag.getListener().ifPresent(l -> plugin.getServer().getPluginManager().registerEvents(l, plugin));
    }

    public List<Flag> getFlags() {
        return flags;
    }

    public Flag getFlagByID(String id) {
        for (Flag flag : flags) {
            if (flag.getID().equals(id.toUpperCase())) return flag;
        }
        return null;
    }

    public Flag getFlagByIcon(PanelItem item) {
        for (Flag flag : flags) {
            if (flag.getIcon().equals(item)) return flag;
        }
        return null;
    }
}
