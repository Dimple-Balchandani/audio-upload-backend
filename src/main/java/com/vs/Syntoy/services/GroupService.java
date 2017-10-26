package com.vs.Syntoy.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.Syntoy.dao.GroupDao;
import com.vs.Syntoy.dbentities.FAQsEntity;
import com.vs.Syntoy.dbentities.GroupEntity;
import com.vs.Syntoy.model.GroupRequest;

@Transactional
@Service
public class GroupService {

	public static final Logger logger = LoggerFactory.getLogger(GroupService.class);

	@Autowired
	private GroupDao obj;

	public Long addGroup(GroupRequest group){

		Long groupId = -1L;
		try{
			GroupEntity grp = new GroupEntity(group);
			obj.addGroup(grp);
			groupId =  grp.getId();
		}
		catch (Exception e){
			logger.error("Exception in Add Group",e.getMessage());
		}

		return groupId;
		
	}

	public List<GroupEntity> getGroup(){
		return obj.listGroups();
	}

	public GroupEntity findGroupById(Long id){
		return obj.findById(id);
	}

	public void deleteGroup(Long id){
		obj.deleteGroup(id);
	}

	public void updateGroup(Long id, GroupRequest entity){
		GroupEntity grp = new GroupEntity(entity);
		grp.setId(id);
		obj.updateGroup(id, grp);
	}

}
