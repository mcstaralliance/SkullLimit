package cn.ylarod.mcp.skulllimit;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Ylarod,LDS_XiaoYe
 * @date 2021/01/24
 */
public final class SkullLimit extends JavaPlugin implements Listener {
    final String limitMessage = "§b[§c小域§b] §c请使用空手破坏头颅类物品。";
    final String enableMessage = "SkullLimit has been enabled.";

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(enableMessage);
    }

    @Override
    public void onDisable() {}

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(event.getBlock().getType() == Material.SKULL && !player.isOp() &&
                player.getInventory().getItemInMainHand().getType() != Material.AIR &&
                player.getGameMode() == GameMode.SURVIVAL ){
            player.sendMessage(limitMessage);
            event.setCancelled(true);
        }
    }
}
