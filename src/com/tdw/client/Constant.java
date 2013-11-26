package com.tdw.client;

public class Constant {

	public static final String DEFAULTHOST = "http://oagd.crbcint.com/WapService/";
	public static final String kISREMEBER = "kISREMEBER";

	public static final String APPFILEPATH = "/data/data/"
			+ ApplicationEnvironment.getInstance().getApplication()
					.getPackageName();

	// assets下的文件保存路径
	public static final String ASSETSPATH = APPFILEPATH + "/assets/";
	// 签购单签名图片保存路径
	public static final String SIGNIMAGESPATH = APPFILEPATH + "/signImages/";
	// 公钥
	public static final String PUBLICKEY_MOD = "publickey_mod";
	public static final String PUBLICKEY_EXP = "publickey_exp";
	public static final String PUBLICKEY_VERSION = "publickey_version";
	public static final String PUBLICKEY_TYPE = "publickey_type";

	public static final String INIT_PUBLICKEY_MOD = "D9D0D2224E6E84899184BBCD389F8EE08EB09EBA123948309804113B3F829D24D6093F1AFC153D113FAB8673114F4FABFDAAC9BB1B58B9E569B255BA4C338A2465642411A5EB0D68B78BB1B4E45AFF51580C3802AE01FF4DCF976D4CC681944C478FE3490A051F2B4894C321703C4D091E5365718509B20D23D78BBAD163E405";
	public static final String INIT_PUBLICKEY_EXP = "010001";
	public static final String INIT_PUBLICKEY_VERSION = "000000000000";
}
