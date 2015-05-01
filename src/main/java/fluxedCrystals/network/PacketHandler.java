package fluxedCrystals.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import fluxedCrystals.ModProps;

public class PacketHandler {
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModProps.modid);

	private static int id = 0;
	public static void init() {
		INSTANCE.registerMessage(MessageEnergyUpdate.class, MessageEnergyUpdate.class, id++, Side.CLIENT);
		INSTANCE.registerMessage(MessageEnergyStorage.class, MessageEnergyStorage.class, id++, Side.CLIENT);
		INSTANCE.registerMessage(MessageBiome.class, MessageBiome.class, id++, Side.CLIENT);
		INSTANCE.registerMessage(MessageSeedInfuser.class, MessageSeedInfuser.class, id++, Side.CLIENT);
		INSTANCE.registerMessage(MessageSeedInfuser.class, MessageSeedInfuser.class, id++, Side.SERVER);
		INSTANCE.registerMessage(MessageGemRefiner.class, MessageGemRefiner.class, id++, Side.SERVER);
		INSTANCE.registerMessage(MessageGemRefiner.class, MessageGemRefiner.class, id++, Side.CLIENT);
		INSTANCE.registerMessage(MessageGemCutter.class, MessageGemCutter.class, id++, Side.SERVER);
		INSTANCE.registerMessage(MessageGemCutter.class, MessageGemCutter.class, id++, Side.CLIENT);
		INSTANCE.registerMessage(MessageSolarFluxSync.class, MessageSolarFluxSync.class, id++, Side.CLIENT);
		INSTANCE.registerMessage(MessageJSONSync.class, MessageJSONSync.class, id++, Side.CLIENT);
		
		
	}
}