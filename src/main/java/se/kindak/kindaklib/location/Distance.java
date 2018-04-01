package se.kindak.kindaklib.location;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Distance {

    public static boolean inRadius(Location location1, Location location2, int radius) {
        return location1.distance(location2) < radius;
    }

    public static List<Block> getBlocksInRadius(Location location, int radius) {
        List<Block> blocks = new ArrayList<>();
        //positivs
        for (int x = 0; x < radius; x++) {
            blocks.add(location.add(x, 0, 0).getBlock());
            location.subtract(x, 0, 0);
        }
        for (int y = 0; y < radius; y++) {
            blocks.add(location.add(0, y, 0).getBlock());
            location.subtract(0, y, 0);
        }
        for (int z = 0; z < radius; z++) {
            blocks.add(location.add(0, 0, z).getBlock());
            location.subtract(0, 0, z);
        }
        // negatives
        for (int x = 0; x < radius; x++) {
            blocks.add(location.subtract(x, 0, 0).getBlock());
            location.add(x, 0, 0);
        }
        for (int y = 0; y < radius; y++) {
            blocks.add(location.subtract(0, y, 0).getBlock());
            location.add(0, y, 0);
        }
        for (int z = 0; z < radius; z++) {
            blocks.add(location.subtract(0, 0, z).getBlock());
            location.add(0, 0, z);
        }
        return blocks;
    }
}