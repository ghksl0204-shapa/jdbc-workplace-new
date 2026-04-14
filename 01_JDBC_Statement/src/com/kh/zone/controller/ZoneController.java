package com.kh.zone.controller;

import java.util.List;

import com.kh.zone.model.dto.ZoneDto;
import com.kh.zone.model.service.ZoneService;

public class ZoneController {

	private ZoneService zs = new ZoneService();
	
	public int save(ZoneDto zoneDto) {
		return zs.save(zoneDto);
	}

	public List<ZoneDto> findAll() {
		return zs.findAll();
	}

	public int update(ZoneDto zoneDto) {
		return zs.update(zoneDto);
	}

	public int delete(String id) {
		return zs.delete(id);
	}


}
