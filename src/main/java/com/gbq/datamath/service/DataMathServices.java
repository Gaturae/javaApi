package com.gbq.datamath.service;

import java.io.File;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gbq.constants.Constants;

/**  
* @classDesc: 功能描述:()
* @author: 过宝麒  
* @createTime: 2017年7月14日 上午11:31:47  
* @version: v1.0  
* @copyright:善林(上海)金融信息服务有限公司 
*/

public interface DataMathServices {
	
 
    //lng1 第一个点经度，lat1第一点纬度；lng2第二点经度，lat2第二点纬度
    public double getShortestDistance(double lng1,double lat1,double lng2,double lat2 );
    
    //已知A点经纬度和B点经度求B点纬度
    public double getLatB(double lng1,double lat1,double lng2,double s );
    
    //接受前端传来的文件流
    public Map getUploadFileInfo(File file);


}
