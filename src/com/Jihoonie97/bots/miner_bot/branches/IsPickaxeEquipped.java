package com.Jihoonie97.bots.miner_bot.branches;

import com.Jihoonie97.bots.miner_bot.leafs.Stop;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.IsInventoryFull
//import path.to.your.StopTheBot

/**
 * NOTES:
 * Checks if a pickaxe is equipped
 */
public class IsPickaxeEquipped extends BranchTask {

    private IsInventoryFull isinventoryfull = new IsInventoryFull();
    private Stop stop = new Stop();

    String[] PICKAXES = new String[]{"Bronze pickaxe", "Iron pickaxe", "Steel pickaxe", "Black pickaxe", "Mithril pickaxe", "Adamant pickaxe", "Rune pickaxe", "Dragon pickaxe", "Infernal pickaxe"};

    @Override
    public boolean validate() {
        return Equipment.containsAnyOf(PICKAXES) || Inventory.containsAnyOf(PICKAXES);
    }

    @Override
    public TreeTask failureTask() {
        return stop;
    }

    @Override
    public TreeTask successTask() {
        return isinventoryfull;
    }
}
