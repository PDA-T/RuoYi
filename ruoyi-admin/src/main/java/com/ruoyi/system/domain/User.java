package com.ruoyi.system.domain;

import java.math.BigDecimal;

public class User {
	/** ID自增 */
	private Long cuid;

	/** 市 */
	private String city;

	/** 区 */
	private String region;

	/** 街道 */
	private String street;

	/** 区域CODE */
	private String regionCode;

	/** 详细地址 */
	private String address;

	/** 别名 */
	private String alias;

	/** 单位名称 */
	private String unitName;

	/** 联系人 */
	private String contacts;

	/** 联系电话 */
	private String contactsPhone;

	/** 备注 */
	private String remarks;

	/** 经度 */
	private BigDecimal lon;

	/** 纬度 */
	private BigDecimal lat;

	/** 删除（0 正常 1 删除） */
	private Long delFlag;

	/** 状态(0 启用 1 禁用) */
	private Long status;

	/** 单位类型 (学校、食堂、饭馆等) */
	private String unitType;

	/** 单位类别(QY 清运公司/DW 点位单位) */
	private String unitLeibie;

	/** 营业执照号 */
	private String licenseNo;

	/** 车辆地址配置 */
	private String carUrl;

	public Long getCuid() {
		return cuid;
	}

	public User setCuid(Long cuid) {
		this.cuid = cuid;
		return this;
	}

	public String getCity() {
		return city;
	}

	public User setCity(String city) {
		this.city = city;
		return this;
	}

	public String getRegion() {
		return region;
	}

	public User setRegion(String region) {
		this.region = region;
		return this;
	}

	public String getStreet() {
		return street;
	}

	public User setStreet(String street) {
		this.street = street;
		return this;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public User setRegionCode(String regionCode) {
		this.regionCode = regionCode;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public User setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getAlias() {
		return alias;
	}

	public User setAlias(String alias) {
		this.alias = alias;
		return this;
	}

	public String getUnitName() {
		return unitName;
	}

	public User setUnitName(String unitName) {
		this.unitName = unitName;
		return this;
	}

	public String getContacts() {
		return contacts;
	}

	public User setContacts(String contacts) {
		this.contacts = contacts;
		return this;
	}

	public String getContactsPhone() {
		return contactsPhone;
	}

	public User setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
		return this;
	}

	public String getRemarks() {
		return remarks;
	}

	public User setRemarks(String remarks) {
		this.remarks = remarks;
		return this;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public User setLon(BigDecimal lon) {
		this.lon = lon;
		return this;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public User setLat(BigDecimal lat) {
		this.lat = lat;
		return this;
	}

	public Long getDelFlag() {
		return delFlag;
	}

	public User setDelFlag(Long delFlag) {
		this.delFlag = delFlag;
		return this;
	}

	public Long getStatus() {
		return status;
	}

	public User setStatus(Long status) {
		this.status = status;
		return this;
	}

	public String getUnitType() {
		return unitType;
	}

	public User setUnitType(String unitType) {
		this.unitType = unitType;
		return this;
	}

	public String getUnitLeibie() {
		return unitLeibie;
	}

	public User setUnitLeibie(String unitLeibie) {
		this.unitLeibie = unitLeibie;
		return this;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public User setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
		return this;
	}

	public String getCarUrl() {
		return carUrl;
	}

	public User setCarUrl(String carUrl) {
		this.carUrl = carUrl;
		return this;
	}
	public User(){
		super();
	}

	public User(Long cuid, String city, String region, String street, String regionCode, String address, String alias, String unitName, String contacts, String contactsPhone, String remarks, BigDecimal lon, BigDecimal lat, Long delFlag, Long status, String unitType, String unitLeibie, String licenseNo, String carUrl) {
		this.cuid = cuid;
		this.city = city;
		this.region = region;
		this.street = street;
		this.regionCode = regionCode;
		this.address = address;
		this.alias = alias;
		this.unitName = unitName;
		this.contacts = contacts;
		this.contactsPhone = contactsPhone;
		this.remarks = remarks;
		this.lon = lon;
		this.lat = lat;
		this.delFlag = delFlag;
		this.status = status;
		this.unitType = unitType;
		this.unitLeibie = unitLeibie;
		this.licenseNo = licenseNo;
		this.carUrl = carUrl;
	}

	@Override
	public String toString() {
		return "User{" +
				"cuid=" + cuid +
				", city='" + city + '\'' +
				", region='" + region + '\'' +
				", street='" + street + '\'' +
				", regionCode='" + regionCode + '\'' +
				", address='" + address + '\'' +
				", alias='" + alias + '\'' +
				", unitName='" + unitName + '\'' +
				", contacts='" + contacts + '\'' +
				", contactsPhone='" + contactsPhone + '\'' +
				", remarks='" + remarks + '\'' +
				", lon=" + lon +
				", lat=" + lat +
				", delFlag=" + delFlag +
				", status=" + status +
				", unitType='" + unitType + '\'' +
				", unitLeibie='" + unitLeibie + '\'' +
				", licenseNo='" + licenseNo + '\'' +
				", carUrl='" + carUrl + '\'' +
				'}';
	}
}
