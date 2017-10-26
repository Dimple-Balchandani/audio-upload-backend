package com.vs.Syntoy.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.Syntoy.dao.FAQsDao;
import com.vs.Syntoy.dbentities.EpisodeEntity;
import com.vs.Syntoy.dbentities.FAQsEntity;
import com.vs.Syntoy.model.FAQsRequest;

@Transactional
@Service
public class FAQsService {

	@Autowired
	private FAQsDao obj;
	
	public void addFAQ(FAQsRequest entity){
		FAQsEntity faq = new FAQsEntity(entity);
		obj.addFAQs(faq);
	}
	
	public List<FAQsEntity> getFAQ(){
		return obj.listFAQs();
	}
	
	public FAQsEntity findFAQById(Long id){
		return obj.findById(id);
	}
	
	public void deleteFAQ(Long id){
		obj.deleteFAQs(id);
	}
	
	public void updateFAQ(Long id, FAQsRequest entity){
		FAQsEntity faq = new FAQsEntity(entity);
		faq.setId(id);
		obj.updateFAQs(id, faq);
	}
}	