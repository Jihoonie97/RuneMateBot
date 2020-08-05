package com.Jihoonie97.bots.miner_bot.leafs;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.script.framework.tree.LeafTask;

//import path.to.your.MineRock

/**
 * NOTES:
 * Walks to RockArea
 */
public class WalkToRockArea extends LeafTask {

    private Area rockArea = new Area.Rectangular(new Coordinate(2961, 3251,0), new Coordinate(2991, 3225, 0));
    @Override
    public void execute() {
        RegionPath toIron = RegionPath.buildTo(rockArea.getRandomCoordinate());
        if(toIron != null) {
            toIron.step();
        }
        else {
            Environment.getBot().getLogger().info("Path toIron was null in WalkToRockArea");
        }
    }
}
