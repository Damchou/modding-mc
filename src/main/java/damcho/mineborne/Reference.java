package damcho.mineborne;

public class Reference {

	public static final String MOD_ID = "dmb";
	public static final String NAME = "Damcho's Mineborne Adventure Mod";
	public static final String VERSION = "0.1";
	public static final String ACCEPTED_VERSIONS ="[1.12]";
	
	public static final String CLIENT_PROXY_CLASS = "damcho.mineborne.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "damcho.mineborne.proxy.ServerProxy";
	
	public static enum MineborneItems {
		ESTUS("estus", "ItemEstus"),
		FIREBOMB("firebomb", "ItemFirebomb");
		
		private String unlocalizedName;
		private String registryName;
		
		MineborneItems(String unlocalizedName, String registryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		
		public String getRegistryName() {
			return registryName;
		}

	}
	
	public static enum MineborneBlocks {
		DARKCOBBLE("darkcobble", "DarkCobble"),
		DARKBRICKS("darkbricks", "DarkBricks"),
		DARKSQUARE("darksquare", "DarkSquare"),
		DARKORNAMENT("darkornament", "DarkOrnament"),
		BLOCKBONFIRE("blockbonfire", "BlockBonfire");
		
		private String unlocalizedName;
		private String registryName;
		
		MineborneBlocks(String unlocalizedName, String registryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		
		public String getRegistryName() {
			return registryName;
		}

	}
}
