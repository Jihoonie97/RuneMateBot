package com.Jihoonie97.bots.miner_bot.leafs;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * Deposit inventory at Bank deposit box
 */
public class DepositInventory extends LeafTask {

    // Bank deposit box coordinates: (3045, 3234, 0)
    // when using: (3045, 3235, 0)
    private Coordinate depositBoxCoord = new Coordinate(3045, 3234, 0);
    private Player player;

    @Override
    public void execute() {
        GameObject depositBox = GameObjects.newQuery().on(depositBoxCoord).names("Bank deposit box").actions("Deposit").results().first();
        if(depositBox != null) {
            if(depositBox.isVisible()) {
                if(depositBox.interact("Deposit")) {
                    Execution.delayUntil(()-> Bank.isOpen(), () -> (player = Players.getLocal()) != null && player.isMoving(), 100, 1000);
                }
            }
            else {
                Camera.turnTo(depositBox);
            }
        }
        else {
            Environment.getBot().getLogger().info("Bank deposit box was null in DepositInventory");
        }
    }
}
