# DEH for Bukkit
Chicken eggs on hay blocks hatch safely into chicks just before they despawn.

The plugin refers to the Mod "Despawning Eggs Hatch", but it writes the code by itself.
It was written in 2023.
You can only download this plugin in GitHub.

## Usage
### Config
```yaml
# When enabled, an egg will only hatch when it is laid on top a hay block.
# This prevents wild chicken colonies from expanding without your knowledge.
eggOnlyHatchesWhenOnTopOfHayBlock: true

# The chance an egg will hatch just before despawning if the entity limiter is not active.
eggWillHatchChance: 1.0

# Prevents too many entities from hatching.
# A despawning egg will only hatch if there are less chickens than defined here in a radius of 'radiusEntityLimiterCheck' blocks around.
onlyHatchIfLessChickensAroundThan: 50

# The radius around the despawned egg for 'onlyHatchIfLessChickensAroundThan'.
radiusEntityLimiterCheck: 32

# If enabled, the newly hatched chicken is a small chick.
newHatchlingIsBaby: true

# eggWillHatchChance (default = 1.0, min 0, max 1.0)
# onlyHatchIfLessChickensAroundThan (default = 50, min 0, max 1000)
# radiusEntityLimiterCheck (default = 32, min 1, max 256)
# Please don't set a value out of range, otherwise it may work incorrectly。
```

### Permission
- tranic.deh [default: OP]

### Command
- /deh-reload

## License
Use [Apache-2.0](https://github.com/404Setup/DEH?tab=Apache-2.0-1-ov-file#readme) as the license.

If you publish my work elsewhere, you need my permission first and you must redirect the download source to my Modrinth, Curseforge, Hangar, SpigotForum and Github pages and keep the original link. You cannot declare this project as yours.

## Depend
- Java8 at least
- Spigot 1.12.2+