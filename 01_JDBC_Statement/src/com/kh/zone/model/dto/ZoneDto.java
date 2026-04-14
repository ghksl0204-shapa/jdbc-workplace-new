package com.kh.zone.model.dto;

public class ZoneDto {

	private String zoneId;
	private String zoneName;
	private String zoneType;
	
	public ZoneDto() {
		super();
	}

	public ZoneDto(String zoneName, String zoneType) {
		super();
		this.zoneName = zoneName;
		this.zoneType = zoneType;
	}

	public ZoneDto(String zoneId, String zoneName, String zoneType) {
		super();
		this.zoneId = zoneId;
		this.zoneName = zoneName;
		this.zoneType = zoneType;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneType() {
		return zoneType;
	}

	public void setZoneType(String zoneType) {
		this.zoneType = zoneType;
	}

	@Override
	public String toString() {
		return "ZoneDto [zoneId=" + zoneId + ", zoneName=" + zoneName + ", zoneType=" + zoneType + "]";
	}
}
