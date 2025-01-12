package immersive_aircraft;

import immersive_aircraft.entity.VehicleEntity;
import immersive_aircraft.entity.misc.WeaponMount;
import immersive_aircraft.entity.weapons.RotaryCannon;
import immersive_aircraft.entity.weapons.Weapon;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class WeaponRegistry {
    public static final Map<ResourceLocation, WeaponConstructor> REGISTRY = new HashMap<>();

    public static void register(ResourceLocation id, WeaponConstructor constructor) {
        REGISTRY.put(id, constructor);
    }

    static {
        register(Main.locate("rotary_cannon"), RotaryCannon::new);
    }

    public static void bootstrap() {
        // nop
    }

    public static WeaponConstructor get(ItemStack weapon) {
        return REGISTRY.get(Registry.ITEM.getKey(weapon.getItem()));
    }

    public interface WeaponConstructor {
        Weapon create(VehicleEntity entity, ItemStack itemStack, WeaponMount mount, int slot);
    }
}
