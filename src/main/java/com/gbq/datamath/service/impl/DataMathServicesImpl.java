package com.gbq.datamath.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gbq.constants.Constants;
import com.gbq.datamath.service.DataMathServices;


import lombok.extern.slf4j.Slf4j;

/**  
* @classDesc: 功能描述:()
* @author: 过宝麒  
* @createTime: 2017年7月14日 下午12:54:13  
* @version: v1.0  
* @copyright:善林(上海)金融信息服务有限公司 
*/

@Slf4j
@Service
public class DataMathServicesImpl implements DataMathServices{
	
	
	 //lng1 第一个点经度，lat1第一点纬度；lng2第二点经度，lat2第二点纬度
    public double getShortestDistance(double lng1,double lat1,double lng2,double lat2 ){

    	double s = Constants.EARTH_RADIUS*Math.acos(Math.cos(lat1)*Math.cos(lat2)*Math.cos(lng1-lng2) + Math.sin(lat1)*Math.sin(lat2));

    	return s*1000;   //得到米数

    }
    
    //已知A点经纬度和B点经度求B点纬度
    public double getLatB(double lng1,double lat1,double lng2,double s ){

    	double lat2;
    	s=s/1000;

    	lat2=Math.atan((Math.cos(s/Constants.EARTH_RADIUS)-Math.cos(lat1)*Math.cos(lng1-lng2))/(Math.sin(lat1)));
    	return lat2*180*2/Math.PI;   //得到千米数

    }

	/*  
	*(non-Javadoc)  
	* @see com.gbq.datamath.service.DataMathServices#getUploadFileInfo(java.lang.String, java.io.File)  
	*/  
	@Override
	public Map getUploadFileInfo(File file) {
		Map map=new HashMap();
		//map.put("name", file.getName());
		
		return map;  
		    
	}
    

}
