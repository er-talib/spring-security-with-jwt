package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.co.VehicalCO;
import com.jwt.response.VehicalResponse;
import com.jwt.service.VehicalService;
import com.jwt.vo.VehicalVO;

@RestController
@RequestMapping("/vehical")
public class VehicalController {
	
	@Autowired
	private VehicalService vehicalService ;
	
	@PostMapping("/details/add")
	public ResponseEntity<?> addVehicalDetails(@RequestBody VehicalCO vehicalCO){
		String addVehicalDetails = this.vehicalService.addVehicalDetails(vehicalCO);
		return ResponseEntity.status(HttpStatus.CREATED).body(addVehicalDetails);
	}
	
	@PutMapping("/details/update/{vehicalId}")
	public ResponseEntity<?> updateVehicalDetails(@RequestBody VehicalCO vehicalCO , @PathVariable int vehicalId){
		VehicalCO updateVehicalDetails = this.vehicalService.updateVehicalDetails(vehicalCO,vehicalId);
		return ResponseEntity.ok(updateVehicalDetails);
	}
	
	@GetMapping("/details/get/{vehicalId}")
	public ResponseEntity<?> getVehicalDetailsById(@PathVariable int vehicalId){
		VehicalVO getVehicalDetails = this.vehicalService.getVehicalDetailsById(vehicalId);
		return ResponseEntity.ok(getVehicalDetails);
	}
	
	@GetMapping("/details/getAll")
	public ResponseEntity<?> getVehicalDetailsById(){
		 List<VehicalVO> allVehicalDetails = this.vehicalService.getAllVehicalDetails();
		return ResponseEntity.ok(allVehicalDetails);
	}
	@DeleteMapping("/details/deleted/{vehicalId}")
	public ResponseEntity<?> deleteVehicalDetailsById(@PathVariable int vehicalId){
		VehicalResponse vehicalResponse = this.vehicalService.deleteVehicalDetailsById(vehicalId);
		return ResponseEntity.status(HttpStatus.OK).body(vehicalResponse);
	}
	
}
