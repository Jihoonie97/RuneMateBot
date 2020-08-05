package com.Jihoonie97.bots.miner_bot.branches;

import com.Jihoonie97.bots.miner_bot.leafs.MineRock;
import com.Jihoonie97.bots.miner_bot.leafs.WalkToRockArea;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.MineRock
//import path.to.your.WalkToRockArea

/**
 * NOTES:
 * Checks if we are in the area we want to be in when we are mining iron rocks
 */
public class InRockArea extends BranchTask {

    private MineRock minerock = new MineRock();
    private WalkToRockArea walktorockarea = new WalkToRockArea();

    //    *estimated next to iron ore (2981, 3234, 0)

    Coordinate inRockRegion = new Coordinate(2981,3234,0);
    private Player player;

    @Override
    public boolean validate() {
        return (player = Players.getLocal()) != null && Distance.between(inRockRegion, player) < 10;
    }

    @Override
    public TreeTask failureTask() {
        return walktorockarea;
    }

    @Override
    public TreeTask successTask() {
        return minerock;
    }
}
