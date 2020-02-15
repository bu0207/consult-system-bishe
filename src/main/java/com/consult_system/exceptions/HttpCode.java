package com.consult_system.exceptions;

public enum HttpCode {
	/** 200请求成功 */
	OK(200),
	/** 207频繁操作 */
	MULTI_STATUS(207),
	/** 303登录失败 */
	LOGIN_FAIL(303),
	/** 400请求参数出错 */
	BAD_REQUEST(400),
	/** 401没有登录 */
	UNAUTHENTICATED(401),
	/** 403没有权限 */
	FORBIDDEN(403),
	/** 404找不到页面 */
	NOT_FOUND(404),
	/** 408请求超时 */
	REQUEST_TIMEOUT(408),
	/** 409发生冲突 */
	CONFLICT(409),
	/** 410已被删除 */
	GONE(410),
	/** 423已被锁定 */
	LOCKED(423),
	/** 423已被锁定 */
	NOTENANTID(424),
	/** 当前产品已经过期 */
	EXPIRED_PRODUCTTIME(444),
	/** 500服务器出错 */
	INTERNAL_SERVER_ERROR(500),
	/** 获取access_token时Secret错误，或者access_token无效 */
	INVALID_ACCESS_TOKEN(40001),
	/** 不合法的凭证类型 */
	INVALID_CREDENTIAL(40002),
	/** 不合法的UserID */
	INVALID_USERID(40003),
	/** 不合法的媒体文件类型 */
	INVALID_MEDIA(40004),
	/** 不合法的文件类型 */
	INVALID_FILETYPE(40005),
	/** 不合法的文件大小 */
	INVALID_FILESIZE(40006),
	/** 不合法的媒体文件id */
	INVALID_MEDIAID(40007),
	/**invalid appid，appid或open_appid无效*/
	INVALID_APPIDOROPENAPPID(40013),
	/** 不合法的菜单类型 */
	INVALID_MENUTYPE(40015),
	/** 不合法的子菜单级数 */
	INVALID_MENULEVEL(40022),
	/** 不合法的oauth_code */
	INVALID_OAUTHCODE(40029),
	/** 不合法的参数 */
	INVALID_PARAM(40035),
	/** 不合法的请求格式 */
	INVALID_REQUESTFORMAT(40038),
	/** 不合法的上报地理位置标志位 */
	INVALID_GEOLOCATION(40059),
	/** 设置应用头像失败 */
	INVALID_AVATAR(40061),
	/** 参数为空 */
	INVALID_NULLPARAM(40063),
	/** 标题长度不合法 */
	INVALID_TITLELENGTH(40067),
	/** 不合法的openid */
	INVALID_OPENID(40073),
	/** 不合法的预授权码 */
	INVALID_PREAUTHCODE(40077),
	/** 不合法的第三方应用appid */
	INVALID_APPID(40086),
	/** 不合法的URL */
	INVALID_URL(40094),
	/** 修改失败 */
	INVALID_UPDATEFAIL(40095),
	/** 缺少bannerKeyId */
	MISS_BANNERKEYID(40096),
	/** 缺少tenantId */
	MISS_TENANTID(40097),
	/** 缺少productPin */
	MISS_PRODUCTPIN(40098),
	/** 缺少productId */
	MISS_PRODUCTID(40099),
	/** 缺少HttpServletRequest参数 */
	MISS_HTTPSERVLETREQUEST(41000),
	/** 缺少access_token参数 */
	MISS_ACCESSTOKEN(41001),
	/** 缺少refresh_token参数 */
	MISS_REFRESHTOKEN(41003),
	/** 缺少secret参数 */
	MISS_SECRET(41004),
	/** 缺少media_id参数 */
	MISS_MEDIAID(41006),
	/** 缺少用户信息 */
	MISS_USERINFO(41007),
	/** 缺少oauth code */
	MISS_OAUTHCODE(41008),
	/** 缺少UserID */
	MISS_USERID(41009),
	/** 缺少url */
	MISS_URL(41010),
	/** 缺少应用名字 */
	MISS_PRODUCTNAME(41013),
	/** 缺少应用描述 */
	MISS_DESC(41014),
	/** 缺少Content */
	MISS_CONTENT(41015),
	/** 缺少标题 */
	MISS_TITLE(41016),
	/** access_token过期 */
	EXPIRED_ACCESSTOKEN(42001),
	/** refresh_token过期 */
	EXPIRED_REFRESHTOKEN(42002),
	/** oauth_code过期 */
	EXPIRED_OAUTHCODE(42003),
	/** 预授权码失效 */
	EXPIRED_PREOAUTHCODE(42007),
	/** 需要成员已关注 */
	NEED_USERCONCERN(43004),
	/** 需要授权 */
	NEED_AUTHORIZE(43007),
	/** 需要支付授权 */
	NEED_PAYAUTHORIZE(43008),
	/** POST的数据包为空 */
	EMPTY_POST(44002),
	/** 多媒体文件大小超过限制 */
	MEDIAFILESIZE_EXCEED(45001),
	/** 消息内容大小超过限制 */
	MSGCONTENSIZE_EXCEED(45002),
	/** 描述大小超过限制 */
	DESCSIZE_EXCEED(45004),
	/** 链接长度超过限制 */
	URLLENGTH_EXCEED(45005),
	/** 接口调用超过限制 */
	APIREQUEST_LIMIT(45009),
	/** banner样式数量超过限制 */
	BANNERTYPE_LIMIT(45010),
	/** 帐号数量超过上限 */
	ACCOUNTNUM_LIMIT(45024),
	/**职员数量超过上限*/
	EMPLOYEENUM_LIMIT(45025),
	/** 请先绑定小程序 */
	WXPROXYNOTFOUND(46003),
	/** 不存在的成员 */
	USERNOTFOUND(46004),
	/** 解析JSON/XML内容错误 */
	PARSEJSONORXML_ERROR(47001),
	/** 应用已停用 */
	PRODUCT_SOLDOUT(50003),
	/** 成员状态不正确，需要成员为企业验证中状态 */
	USERSTATE_ERROR(50004),
	/** 部门长度不符合限制 */
	DEPTNAMELENGTH_LIMIT(60001),
	/** 部门层级深度超过限制 */
	DEPTLEVEL_LIMIT(60002),
	/** 部门不存在 */
	DEPT_NOTFOUND(60003),
	/** 父亲部门不存在 */
	PARENTDEPT_NOTFOUND(60004),
	/** 不允许删除有成员的部门 */
	DEPTWITHEMPLOYEE_DELETE_NOTALLOWED(60005),
	/** 不允许删除有子部门的部门 */
	DEPTWITHCHILDDELETE_NOTALLOWED(60006),
	/** 不允许删除根部门 */
	ROOTDEPTDELETE_NOTALLOWED(60007),
	/** 部门ID或者部门名称已存在 */
	DEPTIDORNAME_EXISTS(60008),
	/** 手机号码不合法 */
	INVALID_PHONENUM(60103),
	/** 手机号码已存在 */
	PHONENUM_EXISTS(60104),
	/** 邮箱不合法 */
	INVALID_EMAIL(60105),
	/** 邮箱已存在 */
	EMAIL_EXISTS(60106),
	/** 微信号不合法 */
	INVALID_WECHAT(60107),
	/** 微信号已存在 */
	WECHAT_EXISTS(60108),
	/** 成员姓名不合法 */
	INVALID_USERNAME(60112),
	/** 成员已禁用 */
	USER_BAN(60120),
	/** 无效的部门id */
	DEPTID_NOTFOUND(60123),
	/** 无效的父部门id */
	PARENTDEPTID_NOTFOUND(60124),
	/** 非法部门名字，长度超过限制、重名等，重名包括与csv文件中同级部门重名或者与旧组织架构包含成员的同级部门重名 */
	DEPTNAME_DUPLICATE(60125),
	/** 创建部门失败 */
	CREATEDEPT_FAIL(60126),
	/** 缺少部门id */
	MISS_DEPTID(60127),
	/** 包含不合法的词语 */
	CONTAIN_SENSITIVEWORD(85000),


	/** 85001	微信号不存在或微信号设置为不可搜索 */
	NOTEXIST_WECHAT(85001),
	/** 85002	小程序绑定的体验者数量达到上限 */
	UPPERLIMIT_TRAILWXP(85002),
	/** 85003	微信号绑定的小程序体验者达到上限 */
	UPPERLIMIT_TRAILWECHAT(85003),
	/** 85004	微信号已经绑定 */
	WECHAT_ISBOUND(85004),

	/** 85006   标签格式错误*/
	BAD_LABEL_FORMAT(85006),
	/** 85007   页面路径错误*/
	PAGE_PATH_ERROR(85007),
	/** 85008   类目填写错误*/
	CATEGORY_ERROR(85008),
	/** 85009   已经有正在审核的版本*/
	HAVE_REVIEWING_VERSION(85009),
	/** 85010   item_list有项目为空*/
	HAVE_EMPTY_ITEMS(85010),
	/** 85011   标题填写错误*/
	TITLE_ERROR(85011),

    /** 85012	无效的审核id*/
    INVALID_AUDIT_ID(85012),
    /** 85013	无效的自定义配置*/
    INVALID_CUSTOM_CONFIGURATION(85013),
    /** 85014	无效的模版编号*/
    INVALID_TEMPLATE_NUMBER(85014),
	/** 85015	该账号不是小程序账号 */
	NOT_WXP_ACCOUNT(85015),
	/** 85016	域名数量超过限制 */
	EXCEEDLIMIT_DOAMIN(85016),
	/** 85017	没有新增域名，请确认小程序已经添加了域名或该域名是否没有在第三方平台添加 */
	NO_NEW_DOMAIN(85017),
	/** 85018	域名没有在第三方平台设置  */
	NOTSETDOMAIN_ONTHIRD(85018),
    /** 85019	没有审核版本 */
    NO_AUDIT_VERSION(85019),
    /** 85020	审核状态未满足发布 */
    AUDIT_STATUS_NOT_FULFILLED(85020),
	/** 85021	状态不可变 */
	STATUS_CANNOT_CHANGE(85021),
	/** 85022	action非法 */
	ACTION_ILLEGAL(85022),
    /** 85043   模版错误 */
    TEMPLATE_ERROR(85043),
    /** 85044   代码包超过大小限制 */
    CODE_EXCEEDS_LIMIT(85044),
    /** 85045   ext_json有不存在的路径 */
    EXTJSON_NO_PATH(85045),
    /** 85046   tabBar中缺少path */
    MISSING_PATH_TABBAR(85046),
    /** 85047   pages字段为空 */
    PAGES_FIELD_EMPTY(85047),
    /** 85048   ext_json解析失败 */
    EXTJSON_PARSE_FAILURE(85048),
	/** 85064   找不到模版 */
	CANNOT_FIND_TEMPLATE(85064),
	/** 85065   模版库已满 */
	TEMPLATE_LIBRARY_FULL(85065),
	/** 85083   搜索标记位被封禁，无法修改 */
	SEARCH_MARKERS_BLOCKED(85083),
	/** 85084   非法的status值，只能填0或者1 */
	ILLEGAL_STATUS_VALUE(85084);

	private final Integer value;

	private HttpCode(Integer value) {
		this.value = value;
	}

	/**
	 * Return the integer value of this status code.
	 */
	public Integer value() {
		return this.value;
	}

	public String msg() {
		return "HTTPCODE_" + this.value;
	}

	public String toString() {
		return this.value.toString();
	}
}
