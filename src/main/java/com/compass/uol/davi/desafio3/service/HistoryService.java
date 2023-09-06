package com.compass.uol.davi.desafio3.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.uol.davi.desafio3.model.History;
import com.compass.uol.davi.desafio3.repository.HistoryRepository;

@Service
public class HistoryService {

	private HistoryRepository historyRepository;

	@Autowired
	public HistoryService(HistoryRepository historyRepository) {

		this.historyRepository = historyRepository;
	}

	public History saveHistory(Integer idPost, String status) {
		LocalDateTime date = LocalDateTime.now();
		History history = new History(idPost, date, status);
		historyRepository.save(history);

		return history;
	}

	public List<History> getHistoryOfPost(Integer id) {
		List<History> list = new ArrayList<>();

		return list;
	}

}
