package carpet_cuo;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class Carpet_CuOMod implements ModInitializer {
	public static final String MOD_ID = "carpet_cuo_addition";
	public static String version;
	@Override
	public void onInitialize() {
		version = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(RuntimeException::new).getMetadata().getVersion().getFriendlyString();
		Carpet_CuOServer.init();
	}
}