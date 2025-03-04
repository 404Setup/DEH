package one.tranic.deh;

public class Config {
    private static boolean eggOnlyHatchesWhenOnTopOfHayBlock;
    private static double eggWillHatchChance;
    private static int onlyHatchIfLessChickensAroundThan;
    private static int radiusEntityLimiterCheck;
    private static boolean newHatchlingIsBaby;

    public static boolean isEggOnlyHatchesWhenOnTopOfHayBlock() {
        return eggOnlyHatchesWhenOnTopOfHayBlock;
    }

    public static double getEggWillHatchChance() {
        return eggWillHatchChance;
    }

    public static int getOnlyHatchIfLessChickensAroundThan() {
        return onlyHatchIfLessChickensAroundThan;
    }

    public static int getRadiusEntityLimiterCheck() {
        return radiusEntityLimiterCheck;
    }

    public static boolean isNewHatchlingIsBaby() {
        return newHatchlingIsBaby;
    }

    public static void reload() {
        Main.getInstance().saveDefaultConfig();
        Main.getInstance().reloadConfig();
        eggOnlyHatchesWhenOnTopOfHayBlock = Main.getInstance().getConfig().getBoolean("eggOnlyHatchesWhenOnTopOfHayBlock");
        eggWillHatchChance = Main.getInstance().getConfig().getDouble("eggWillHatchChance");
        onlyHatchIfLessChickensAroundThan = Main.getInstance().getConfig().getInt("onlyHatchIfLessChickensAroundThan");
        radiusEntityLimiterCheck = Main.getInstance().getConfig().getInt("radiusEntityLimiterCheck");
        newHatchlingIsBaby = Main.getInstance().getConfig().getBoolean("newHatchlingIsBaby");
    }
}
