package com.compass.uol.davi.desafio3.service;

import com.compass.uol.davi.desafio3.model.State;

public abstract class DefinedStatus {

	public static String define(String currentStatus, boolean success) {
		String status = null;
		
		if (currentStatus.equals(null)) {
			status = State.CREATED;
		}
		else if (currentStatus.equals(State.CREATED)) {
			status = State.POST_FIND;
		}
		else if (currentStatus.equals(State.POST_FIND)) {
			if (success) {
				status = State.POST_OK;
			}
			else {
				status = State.FAILED;
			}
		}
		else if (currentStatus.equals(State.POST_OK)) {
			status = State.COMMENTS_FIND;
		}
		else if (currentStatus.equals(State.COMMENTS_FIND)) {
			if (success) {
				status = State.COMMENTS_OK;
			}
			else {
				status = State.FAILED;
			}
		}
		else if (currentStatus.equals(State.COMMENTS_OK)) {
			status = State.ENABLED;
		}
		else if (currentStatus.equals(State.ENABLED)) {
			if (success) {
				status = State.UPDATING;
			}
			else {
				status = State.DISABLED;
			}
		}
		else if (currentStatus.equals(State.FAILED)) {
				status = State.DISABLED;
		}
		else if (currentStatus.equals(State.DISABLED)) {
			status = State.UPDATING;
		}
		else if (currentStatus.equals(State.UPDATING)) {
			define(currentStatus, success);
		}
		
		return status;
	}
}
