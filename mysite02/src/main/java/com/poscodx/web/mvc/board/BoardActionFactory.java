package com.poscodx.web.mvc.board;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.mvc.ActionFactory;

public class BoardActionFactory implements ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if("deleteform".equals(actionName)) {
			action = new DeleteFormAction();
		} else if("write".equals(actionName)) {
			action = new writeAction();
		} else if("writeform".equals(actionName)) {
			action = new writeFormAction();
		} else if("view".equals(actionName)) {
			action = new viewAction();
		} else {
			action = new ListAction();
		}
		
		return action;
	}
}
