package com.gbq.datamath.controller;


import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


import com.gbq.constants.Constants;
import com.gbq.datamath.service.DataMathServices;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import lombok.extern.slf4j.Slf4j;


/**  
* @classDesc: 功能描述:()
* @author: 过宝麒  
* @createTime: 2017年7月14日 上午11:15:42  
* @version: v1.0  
* @copyright:
*/
@Slf4j
@Controller
@RequestMapping("/")
public class DataMath {

	/**  
	* @methodDesc: 功能描述:()
	* @author: 过宝麒  
	* @param: @param args   
	* @createTime:2017年7月14日 上午11:15:42
	* @returnType:@param args void  
	* @copyright:
	*/

	@Autowired
	private DataMathServices dataMathServices;
	
	@ResponseBody
	@RequestMapping(value = "/earthDistance", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public Map earthDistance(@RequestBody String requestStr) {
		
		JSONObject jsStr = JSONObject.fromObject(requestStr);
		
		Double lng1 = Constants.convert((Double)jsStr.get("lng1"));
		Double lat1 = Constants.convert((Double)jsStr.get("lat1"));
		Double lng2 = Constants.convert((Double)jsStr.get("lng2"));
		Double lat2 = Constants.convert((Double)jsStr.get("lat2"));

		DecimalFormat df = new DecimalFormat("#.00");
		Double distance = dataMathServices.getShortestDistance(lng1,lat1, lng2,lat2);
		
		Map map = new HashMap<>();
		map.put("distance", distance);

		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getLatB", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public Map getLatB(@RequestBody String requestStr) {
		
		JSONObject jsStr = JSONObject.fromObject(requestStr); 
		
		Double lng1 = Constants.convert((Double)jsStr.get("lng1"));
		Double lat1 = Constants.convert((Double)jsStr.get("lat1"));
		Double lng2 = Constants.convert((Double)jsStr.get("lng2"));
		Double distance = Constants.convert((Double)jsStr.get("distance"));

		DecimalFormat df = new DecimalFormat("#.00");
		Double lat2 = dataMathServices.getLatB(lng1,lat1, lng2,distance);
		
		Map map = new HashMap<>();
		map.put("lat2", lat2);
		
		log.info(requestStr);
		return map;
	}

}
