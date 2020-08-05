package com.Jihoonie97.bots.miner_bot;

import com.Jihoonie97.bots.miner_bot.branches.IsPickaxeEquipped;
import com.Jihoonie97.bots.miner_bot.leafs.Stop;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.IsPickaxeEquipped
//import path.to.your.StopTheBot

/**
 * NOTES:
 * Checks if we are in the general region of iron rocks
 */
public class InIronRegion extends BranchTask {

    private IsPickaxeEquipped ispickaxeequipped = new IsPickaxeEquipped();
    private Stop stopthebot = new Stop();

    //    2983-3232, 2944-3200, 39-32
    Coordinate inIronRegion = new Coordinate(2983,2944,39);
    private Player player;


    @Override
    public boolean validate() {
        return (player = Players.getLocal()) != null && Distance.between(inIronRegion, player) < 50;
    }


    @Override
    public TreeTask failureTask() {
        return stopthebot;
    }

    @Override
    public TreeTask successTask() {
        return ispickaxeequipped;
    }
}
