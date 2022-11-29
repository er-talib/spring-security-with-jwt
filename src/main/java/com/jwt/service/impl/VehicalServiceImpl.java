package com.jwt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.co.DriverCO;
import com.jwt.co.VehicalCO;
import com.jwt.entities.Driver;
import com.jwt.entities.Vehical;
import com.jwt.repositories.VehicalRepository;
import com.jwt.response.VehicalResponse;
import com.jwt.service.VehicalService;
import com.jwt.vo.DriverVO;
import com.jwt.vo.VehicalVO;

@Service
public class VehicalServiceImpl implements VehicalService {

	@Autowired
	private VehicalRepository vehicalRepository;

	@Override
	public String addVehicalDetails(VehicalCO vehicalCO) {

		Vehical vehical = new Vehical();
		vehical.setLengthOfVehical(vehicalCO.getLengthOfVehical());
		vehical.setVehicalExpireDate(vehicalCO.getVehicalExpireDate());
		vehical.setVehicalName(vehicalCO.getVehicalName());
		vehical.setVehicalNo(vehicalCO.getVehicalNo());
		vehical.setVehicalOwnerName(vehicalCO.getVehicalOwnerName());
		vehical.setVehicalType(vehicalCO.getVehicalType());

		Driver driver = new Driver();
		driver.setDriverAddress(vehicalCO.getDriverCO().getDriverAddress());
		driver.setDriverName(vehicalCO.getDriverCO().getDriverName());
		driver.setDriverSalary(vehicalCO.getDriverCO().getDriverSalary());
		driver.setGender(vehicalCO.getDriverCO().getGender());
		driver.setVehical(vehical);
		vehical.setDriver(driver);
		this.vehicalRepository.save(vehical);
		return "Vehical Details save successfully..!!";
	}

	@Override
	public VehicalCO updateVehicalDetails(VehicalCO vehicalCO, int vehicalId) {

		Vehical vehical = new Vehical();
		vehical.setVehicalId(vehicalId);
		vehical.setLengthOfVehical(vehicalCO.getLengthOfVehical());
		vehical.setVehicalExpireDate(vehicalCO.getVehicalExpireDate());
		vehical.setVehicalName(vehicalCO.getVehicalName());
		vehical.setVehicalNo(vehicalCO.getVehicalNo());
		vehical.setVehicalOwnerName(vehicalCO.getVehicalOwnerName());
		vehical.setVehicalType(vehicalCO.getVehicalType());

		Driver driver = new Driver();
		driver.setDriverId(vehicalId);
		driver.setDriverAddress(vehicalCO.getDriverCO().getDriverAddress());
		driver.setDriverName(vehicalCO.getDriverCO().getDriverName());
		driver.setDriverSalary(vehicalCO.getDriverCO().getDriverSalary());
		driver.setGender(vehicalCO.getDriverCO().getGender());
		driver.setVehical(vehical);
		vehical.setDriver(driver);
		this.vehicalRepository.save(vehical);

		Optional<Vehical> vehicalCO1 = this.vehicalRepository.findById(vehicalId);
		Vehical vehicalCO2 = vehicalCO1.get();
		VehicalCO vehical1 = new VehicalCO();
		vehical1.setLengthOfVehical(vehicalCO2.getLengthOfVehical());
		vehical1.setVehicalExpireDate(vehicalCO2.getVehicalExpireDate());
		vehical1.setVehicalName(vehicalCO2.getVehicalName());
		vehical1.setVehicalNo(vehicalCO2.getVehicalNo());
		vehical1.setVehicalOwnerName(vehicalCO2.getVehicalOwnerName());
		vehical1.setVehicalType(vehicalCO2.getVehicalType());

		DriverCO driver1 = new DriverCO();
		driver1.setDriverAddress(vehicalCO2.getDriver().getDriverAddress());
		driver1.setDriverName(vehicalCO2.getDriver().getDriverName());
		driver1.setDriverSalary(vehicalCO2.getDriver().getDriverSalary());
		driver1.setGender(vehicalCO2.getDriver().getGender());
         vehical1.setDriverCO(driver1);
		return vehical1;
	}

	@Override
	public VehicalVO getVehicalDetailsById(int vehicalId) {
		Optional<Vehical> vehicalDetails = this.vehicalRepository.findById(vehicalId);
		Vehical vehical = vehicalDetails.get();
		VehicalVO vehicalVO = new VehicalVO();
		vehicalVO.setLengthOfVehical(vehical.getLengthOfVehical());
		vehicalVO.setVehicalExpireDate(vehical.getVehicalExpireDate());
		vehicalVO.setVehicalName(vehical.getVehicalName());
		vehicalVO.setVehicalNo(vehical.getVehicalNo());
		vehicalVO.setVehicalOwnerName(vehical.getVehicalOwnerName());
		vehicalVO.setVehicalType(vehical.getVehicalType());

		DriverVO driverVO = new DriverVO();
		driverVO.setDriverAddress(vehical.getDriver().getDriverAddress());
		driverVO.setDriverName(vehical.getDriver().getDriverName());
		driverVO.setDriverSalary(vehical.getDriver().getDriverSalary());
		driverVO.setGender(vehical.getDriver().getGender());
		vehicalVO.setDriverVO(driverVO);
		return vehicalVO;
	}

	@Override
	public List<VehicalVO> getAllVehicalDetails() {

		List<Vehical> allVehicalDetails = this.vehicalRepository.findAll();
		List<VehicalVO> allVehical = allVehicalDetails.stream().map(v -> {
			VehicalVO vehicalVO = new VehicalVO();

			vehicalVO.setLengthOfVehical(v.getLengthOfVehical());
			vehicalVO.setVehicalExpireDate(v.getVehicalExpireDate());
			vehicalVO.setVehicalName(v.getVehicalName());
			vehicalVO.setVehicalNo(v.getVehicalNo());
			vehicalVO.setVehicalOwnerName(v.getVehicalOwnerName());
			vehicalVO.setVehicalType(v.getVehicalType());

			DriverVO driverVO = new DriverVO();
			driverVO.setDriverAddress(v.getDriver().getDriverAddress());
			driverVO.setDriverName(v.getDriver().getDriverName());
			driverVO.setDriverSalary(v.getDriver().getDriverSalary());
			driverVO.setGender(v.getDriver().getGender());
			vehicalVO.setDriverVO(driverVO);
			return vehicalVO;
		}).collect(Collectors.toList());
		return allVehical;
	}

	@Override
	public VehicalResponse deleteVehicalDetailsById(int vehicalId) {
		this.vehicalRepository.deleteById(vehicalId);
		VehicalResponse vehicalResponse = new VehicalResponse();
		vehicalResponse.setDeletedDate(new Date().toString());
		vehicalResponse.setMessage("Vehical details has been delete successfully..!!");
		return vehicalResponse;
	}

}
