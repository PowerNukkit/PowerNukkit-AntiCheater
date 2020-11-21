package org.powernukkit.plugins.example;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.EntityHuman;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.utils.TextFormat;

public class CloneCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(TextFormat.DARK_RED+""+TextFormat.BOLD + "Error!"+TextFormat.RESET+TextFormat.RED+" Only players can execute this command!");
            return false;
        }
        Player player = (Player) commandSender;
        player.saveNBT();
        EntityHuman human = new EntityHuman(player.getChunk(), new CompoundTag()
                .put("Pos", player.namedTag.get("Pos").copy())
                .put("Rotation", player.namedTag.get("Rotation").copy())
                .put("Motion", player.namedTag.get("Motion").copy())
                .put("Skin", player.namedTag.get("Skin").copy())
                .putBoolean("IsCloned", true)
        );
        human.setSkin(player.getSkin());
        human.spawnToAll();
        player.sendMessage(TextFormat.DARK_GREEN+""+TextFormat.BOLD+"Success!"+TextFormat.RESET+TextFormat.GREEN+" You have been cloned!");
        return true;
    }
}
