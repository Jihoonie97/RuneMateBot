package com.Jihoonie97.bots.miner_bot.leafs;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

import java.awt.*;

/**
 * NOTES:
 * Finds a rock and mines it
 */
public class MineRock extends LeafTask {

    private Color iron = new Color(32,17,14);
    private Color empty = new Color(48, 48, 48);
    final Area ores = new Area.Rectangular(new Coordinate(2983,2944,39), new Coordinate(3232,3200,32));

    @Override
    public void execute() {
        GameObject mineableRock = GameObjects.newQuery().within(ores).colorSubstitutions(empty,iron).results().nearest();
        if(mineableRock != null) {
            int miningXPbefore = Skill.MINING.getExperience();
            if(mineableRock.isVisible()) {
//                interact statement is in an if statement so the delay only occurs if the interact returns true
                if(mineableRock.interact("Mine")) {
                    Execution.delayUntil(() -> !mineableRock.isValid() || Skill.MINING.getExperience() > miningXPbefore, 200, 15000);
                }
            }
            else {
                Camera.turnTo(mineableRock);
            }
        }
        else {
            Environment.getBot().getLogger().info("The rock we looked for in MineRock was null");
        }
    }
}
