package com.jwt.service;

import java.util.List;

import com.jwt.co.VehicalCO;
import com.jwt.response.VehicalResponse;
import com.jwt.vo.VehicalVO;

public interface VehicalService {

	public String addVehicalDetails(VehicalCO vehicalCO);
	public VehicalCO updateVehicalDetails(VehicalCO vehicalCO , int vehicalId);
	public VehicalVO getVehicalDetailsById(int vehicalId);
	public List<VehicalVO> getAllVehicalDetails();
	public VehicalResponse deleteVehicalDetailsById(int vehicalId);

}
