package com.vs.Syntoy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vs.Syntoy.dbentities.EpisodeEntity;
import com.vs.Syntoy.model.EpisodeRequest;
import com.vs.Syntoy.utilities.Constants;

@Repository
public class EpisodeDaoImpl extends AbstractDAO<Long, EpisodeEntity> implements EpisodeDao {

	@Override
	public void addEpisode(EpisodeEntity request) {
		persist(request);
	}

	@Override
	public EpisodeEntity findById(Long id) {
		EpisodeEntity entity = getByKey(id);
		return entity;
	}

	@Override
	public void deleteEpisode(Long id) {
		EpisodeEntity episode = findById(id);
		delete(episode);
	}

	@Override
	public List<EpisodeEntity> listEpisodes() {
		List<EpisodeEntity> episodeList = getEntityManager().createQuery(Constants.QUERY_ALL_EPISODE).getResultList();
		return episodeList;
	}

	@Override
	public void updateEpisode(Long id, EpisodeEntity entity) {
		entity.setId(id);
		update(entity);
	}

	
}
