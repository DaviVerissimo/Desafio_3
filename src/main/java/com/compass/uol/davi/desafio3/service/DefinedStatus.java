package com.compass.uol.davi.desafio3.service;

import com.compass.uol.davi.desafio3.model.State;

public abstract class DefinedStatus {

	public static String define(String currentStatus, boolean success) {
		String status = null;
		
//		if (currentStatus == null) {
//			status = State.CREATED;
//		}
		if (currentStatus.equals(State.CREATED) ) {
			status = State.POST_FIND;
		}
		if (currentStatus == State.POST_FIND) {
			if (success) {
				status = State.POST_OK;
			}
			else {
				status = State.FAILED;
			}
		}
		if (currentStatus == State.POST_OK) {
			status = State.COMMENTS_FIND;
		}
		if (currentStatus == State.COMMENTS_FIND) {
			if (success) {
				status = State.COMMENTS_OK;
			}
			else {
				status = State.FAILED;
			}
		}
		if (currentStatus == State.COMMENTS_OK) {
			status = State.ENABLED;
		}
		if (currentStatus == State.ENABLED) {
			if (success) {
				status = State.UPDATING;
			}
			else {
				status = State.DISABLED;
			}
		}
		if (currentStatus  == State.FAILED) {
				status = State.DISABLED;
		}
		if (currentStatus == State.DISABLED) {
			status = State.UPDATING;
		}
		if (currentStatus == State.UPDATING) {
			define(currentStatus, success);
		}
		System.out.println("status defined status "+ status);
		
		return status;
	}
}
