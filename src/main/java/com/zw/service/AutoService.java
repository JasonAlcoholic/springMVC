package com.zw.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zw.common.DBSupport;

/**
 * 
 * Data access kernel service class, and all CURD 
 * or other database operation supplied service by this class
 * @author wanglm
 * 
 */
@Service("AutoService")
@Transactional
@SuppressWarnings({"rawtypes","unchecked"})
public class AutoService{
	private static Logger logger = LogManager.getLogger(AutoService.class);

	@Autowired
	private DBSupport db;
	/**
	 * 
	 * @description transfer data type(string,long,double)
	 * @param entityName
	 * @param entity
	 * @return
	 */
	public HashMap<String, Object> transformType(String entityName,
			HashMap<String, Object> entity) {
		ClassMetadata cm = db.getSessionFactory().getClassMetadata(entityName);
		Iterator<Map.Entry<String, Object>> it = entity.entrySet().iterator();
		HashMap<String, Object> newentity = new HashMap<String, Object>();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = (Entry<String, Object>) it.next();
			String key = entry.getKey();
			Object ovalue = entry.getValue();
			logger.debug(key + "-*****>" + ovalue);
			String value = (ovalue == null ? "" : ovalue.toString());
			String type = "";
			try {
				type = cm.getPropertyType(key).getName();
			} catch (Exception ex) {
				logger.info("could not resolve property: " + key + " of " + entityName);
			}
			key = key.toLowerCase();
			logger.debug(key + "->" + value + "-->" + type);
			if (type.equals("long")) {
				if (value.equals("")) {
					value = "0";
				}
				newentity.put(key, Long.parseLong(value));
			} else if (type.equals("double")) {
				newentity.put(key, Double.parseDouble(value));
			} else {
				newentity.put(key, value);
			}
		}
		return newentity;
	}

	/**
	 * 
	 * @description save
	 * @param entityName
	 * @param entity
	 * @return
	 */
	public String save(String entityName, HashMap<String, Object> entity) {
		return db.save(entityName, transformType(entityName, entity));
	}

	/**
	 * 
	 * @description save all
	 * @param entityName
	 * @param list
	 */
	public void saveAll(String entityName, List<HashMap> list) {
		for (HashMap entity : list) {
			this.save(entityName, entity);
		}
	}

	/**
	 * 
	 * @description update all
	 * @param entityName
	 * @param list
	 */
	public void updateAll(String entityName, List<HashMap> list) {
		for (HashMap entity : list) {
			this.update(entityName, entity);
		}
	}

	/**
	 * 
	 * @description update
	 * @param entityName
	 * @param entity
	 */
	public void update(String entityName, HashMap<String, Object> entity) {
		db.update(entityName, transformType(entityName, entity));
	}

	/**
	 * 
	 * @description save or update
	 * @param entityName
	 * @param entity
	 * @return
	 */
	public String saveOrUpdate(String entityName, HashMap<String, Object> entity) {
		logger.debug("the hm is " + entity);
		HashMap<String,Object> result = transformType(entityName, entity);
		logger.debug("result is "+result);
		return db.saveOrUpdate(entityName,transformType(entityName, entity));
	}

	/**
	 * 
	 * @description save or update all
	 * @param entityName
	 * @param list
	 */
	public void saveOrUpdateAll(String entityName, List<HashMap> list) {
		for (HashMap entity : list) {
			this.saveOrUpdate(entityName, entity);
		}
	}

	/**
	 * 
	 * @description delete
	 * @param entityName
	 * @param entity
	 */
	public void delete(String entityName, HashMap<String, Object> entity) {
		db.delete(entityName, entity);
	}

	/**
	 * 
	 * @description delete all
	 * @param entityName
	 * @param list
	 */
	public void deleteAll(String entityName, List<HashMap> list) {
		for (HashMap entity : list) {
			delete(entityName, entity);
		}
	}

	/**
	 * Delete based on uuid
	 * 
	 * @param tableName
	 * @param uuid
	 */
	public void deleteByUUID(String tableName, String uuid) {
		String hql = "from " + tableName + " v where v.uuid='" + uuid + "'";
		List list = this.findByHql(hql);
		db.deleteAll(list);
	}

	/**
	 * 
	 * @description Query based on hql, then delete these data
	 * @param hql
	 */
	public void deleteByHql(String hql) {
		db.deleteByHql(hql);
	}

	/**
	 * 
	 * @description Query based on uuid
	 * @param tableName
	 * @param uuid
	 * @return
	 */
	public Object findByUUID(String tableName, String uuid) {
		List list = db.findByHql("from " + tableName + " v where v.uuid='" + uuid + "'", false);
		if (list.size() == 1)
			return list.get(0);
		else
			return null;
	}

	/**
	 * 
	 * @description delete all by uuid
	 * @param tableName
	 * @param list
	 */
	public void deleteByAllUUID(String tableName, ArrayList<String> list) {
		for (String s : list) {
			deleteByUUID(tableName, s);
		}
	}

	/**
	 * 
	 * @description Query result list based on hql
	 * @param hql
	 * @return
	 */
	public List findByHql(String hql) {
		return db.findByHql(hql, false);
	}

	/**
	 * 
	 * @description find By Hql Cache
	 * @param hql
	 * @return
	 */
	public List findByHqlCache(String hql) {
		return db.findByHql(hql, true);
	}

	/**
	 * 
	 * @description query all based on table name
	 * @param tableName
	 * @return
	 */
	public List findAll(String tableName) {
		return db.findAll(tableName);
	}


	
	/**
	 * 
	 * @description saveFuncRightByFunc: Default assigned the permissions that as same as its parent.
	 * @param entityName
	 * @param entity
	 * @return
	 */
	public String saveFuncRightByFunc(String entityName, HashMap<String, Object> entity)  {	
		//Save
		HashMap<String, Object> funcEntity = transformType(entityName, entity);	
		String uuid = db.save(entityName, funcEntity);
		
		//SaveFuncRightByFunc
		String srcFuncUUID = funcEntity.get("pid").toString();
		String opHql = "from U_PORTAL_REFROLEFUNC uprf where uprf.funcuuid='"
				+ srcFuncUUID + "' order by uprf.operateuuid";
		List<HashMap<String,Object>> srcRF = findByHql(opHql);
		
		//Copy and save
		List<HashMap<String,Object>> addList = new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < srcRF.size(); i++) {
			HashMap<String,Object> rf = new HashMap<String,Object>();
			rf.put("funcuuid",funcEntity.get("uuid").toString());
			if(funcEntity.get("funccode")!=null)  rf.put("funccode",  funcEntity.get("funccode").toString());
			rf.put("funcname",funcEntity.get("funcname").toString());
			rf.put("operateuuid",srcRF.get(i).get("operateuuid")==null?"":srcRF.get(i).get("operateuuid").toString());
			rf.put("roleuuid",srcRF.get(i).get("roleuuid")==null?"":srcRF.get(i).get("roleuuid").toString());
			rf.put("rolecode",srcRF.get(i).get("rolecode")==null?"":srcRF.get(i).get("rolecode").toString());
			rf.put("rolename",srcRF.get(i).get("rolename")==null?"":srcRF.get(i).get("rolename").toString());
			addList.add(rf);
		}
		for (HashMap<String, Object> hm : addList) {
			db.save("U_PORTAL_REFROLEFUNC", transformType("U_PORTAL_REFROLEFUNC", hm));			
		}		
		return uuid;
	}
}