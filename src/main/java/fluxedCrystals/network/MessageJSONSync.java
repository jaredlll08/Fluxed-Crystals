package fluxedCrystals.network;

import io.netty.buffer.ByteBuf;

import java.util.List;

import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import fluxedCrystals.FluxedCrystals;
import fluxedCrystals.api.RecipeRegistry;
import fluxedCrystals.tileEntity.TileEntityGemCutter;

public class MessageJSONSync implements IMessage, IMessageHandler<MessageJSONSync, IMessage> {

	private List seedCrops;
	private List infuser;
	private List cutter;
	private List refiner;

	public MessageJSONSync() {
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		int seedCropsSize = buf.readInt();
		int infuserSize = buf.readInt();
		int cutterSize = buf.readInt();
		int refinerSize = buf.readInt();

		for (int i = 0; i < seedCropsSize; i++) {
			seedCrops.add(RecipeRegistry.getSeedCropRecipes().get(i));
		}
		for (int i = 0; i < infuserSize; i++) {
			infuser.add(RecipeRegistry.getSeedRecipes().get(i));
		}
		
		for (int i = 0; i < cutterSize; i++) {
			cutter.add(RecipeRegistry.getGemCutterRecipes().get(i));
		}
		for (int i = 0; i < refinerSize; i++) {
			refiner.add(RecipeRegistry.getGemRefinerRecipes().get(i));
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(RecipeRegistry.getSeedCropRecipes().size());
		buf.writeInt(RecipeRegistry.getSeedRecipes().size());
		buf.writeInt(RecipeRegistry.getGemCutterRecipes().size());
		buf.writeInt(RecipeRegistry.getGemRefinerRecipes().size());
	}
	@Override
	public IMessage onMessage(MessageJSONSync message, MessageContext ctx) {
		RecipeRegistry.setCrops(message.seedCrops);
		RecipeRegistry.setGemsCut(message.cutter);
		RecipeRegistry.setGemsRef(message.refiner);
		RecipeRegistry.setSeedRecipes(message.infuser);
		
		
		
		return null;
	}
}