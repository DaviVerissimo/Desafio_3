package com.compass.uol.davi.desafio3.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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

	public History saveHistory(Integer idPost, String statusAtual, boolean success) {
		LocalDate date = LocalDate.now();
		String status = DefinedStatus.define(statusAtual, success);
		History history = new History(idPost, date, status);
		historyRepository.save(history);

		return history;
	}

	public List<History> getHistoryOfPost(Integer id) {
		List<History> list = new ArrayList<>();
		List<History> listAux = historyRepository.findByIdPost(id);
		if (!listAux.isEmpty()) {
			list = listAux.stream().sorted(Comparator.comparing(History::getDate)).toList();

		}

		return list;
	}

}
