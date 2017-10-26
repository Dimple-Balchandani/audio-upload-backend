package com.vs.Syntoy.services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.amazonaws.AmazonServiceException;
import com.vs.Syntoy.dao.AdminDao;
import com.vs.Syntoy.dao.EpisodeDao;
import com.vs.Syntoy.dbentities.AdminEntity;
import com.vs.Syntoy.dbentities.EpisodeEntity;
import com.vs.Syntoy.dbentities.GroupEntity;
import com.vs.Syntoy.model.EpisodeRequest;
import com.vs.Syntoy.utilities.S3Utility;
import java.nio.file.*;

@Transactional
@Service
public class EpisodeService {

	@Autowired
	private EpisodeDao obj;


	@Autowired
	private AdminDao adminDao;

	@Autowired
	private S3Utility s3Utility;

	public Boolean addEpisode(EpisodeRequest episode){


		EpisodeEntity epi = new EpisodeEntity(episode);

		//Setting Admin who created the Episode
		AdminEntity admin = adminDao.findById((long) 1);
		epi.setAdmin(admin);


		// Setting the release date
		Date d = new Date();
		epi.setUploadtime(d);

		String url = s3Utility.validateS3Link(episode.getEpisodeS3Link()); 

		
		if(url!=null && !url.isEmpty()){

			epi.setEpisodeS3Link(url);

			String command = "/usr/local/bin/ffprobe -v quiet -print_format compact=print_section=0:nokey=1:escape=csv"
					+ " -show_entries format=duration \"" + url +"\" > /var/tmp/temp.txt";

			List<String> list = new ArrayList<>();

			try {
				Process proc = Runtime.getRuntime().exec(command);
				proc.waitFor();
				System.out.println("Exit Value"+proc.exitValue());

				String fileName = "/var/tmp/temp.txt";

				String output = "";

				try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

					//br returns as stream and convert it into a List
					list = br.lines().collect(Collectors.toList());
					if(list.size()>0)
						output=list.get(0);
					
					Long duration = ((Float)Float.parseFloat(output)).longValue();
					
					Long hours =  duration/3600;
					
					duration = duration - hours * 3600;
					
					Long minutes = duration/60;
					
					duration = duration - minutes * 60;
					
					Long seconds = duration;

					epi.setEpisodeMin(minutes);
					epi.setEpisodeHours(hours);
					epi.setEpisodeSec(seconds);
					
					System.out.println(hours+":"+minutes+":"+seconds);
				
				} catch (IOException e) {
					System.out.println("Couldn't read ffmpeg response" + e.getMessage());					
				}

			} catch (Exception e)
			{
				System.out.println("Couldn't calculate duration"+e.getMessage());	
			}

			obj.addEpisode(epi);

			return true;
		} else {
			return false;
		}

	}

	public List<EpisodeEntity> getEpisode(){
		return obj.listEpisodes();
	}

	public EpisodeEntity findEpisodeById(Long id){
		return obj.findById(id);
	}

	public void deleteEpisode(Long id){
		obj.deleteEpisode(id);
	}

	public void updateEpisode(Long id, EpisodeRequest entity){
		EpisodeEntity epi = new EpisodeEntity(entity);
		epi.setId(id);	
		obj.updateEpisode(id, epi);
	}
}
