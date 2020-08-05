package com.Jihoonie97.bots.miner_bot.branches;

import com.Jihoonie97.bots.miner_bot.branches.InRockArea;
import com.Jihoonie97.bots.miner_bot.leafs.DepositInventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.DepositInventory
//import path.to.your.InRockArea

/**
 * NOTES:
 * Checks if inventory is full
 */
public class IsInventoryFull extends BranchTask {

    private DepositInventory depositinventory = new DepositInventory();
    private InRockArea inrockarea = new InRockArea();

    @Override
    public boolean validate() {
        return Inventory.isFull();
    }

    @Override
    public TreeTask failureTask() {
        return inrockarea;
    }

    @Override
    public TreeTask successTask() {
        return depositinventory;
    }
}
