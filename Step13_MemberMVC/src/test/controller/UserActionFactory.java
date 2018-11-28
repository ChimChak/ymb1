package test.controller;

import test.action.HomeAction;
import test.member.action.MemberDeleteAction;
import test.member.action.MemberInsertAction;
import test.member.action.MemberInsertformAction;
import test.member.action.MemberListAction;
import test.member.action.MemberUpdateAction;
import test.member.action.MemberUpdateformAction;

/*
 *  비즈니스 로직을 수행할 액션 객체를 생성해서 리턴해주는 클래스
 */
public class UserActionFactory {
	// single ton 으로 사용될수 있도록 한다. 
	private static UserActionFactory factory;
	private UserActionFactory() {}
	public static UserActionFactory getInstance() {
		if(factory==null) {
			factory=new UserActionFactory();
		}
		return factory;
	}
	//인자로 전달되는 command 를 수행할 액션 객체를 리턴해주는 메소드
	public Action action(String command) {
		Action action=null;
		if(command.equals("/member/list")) {
			action=new MemberListAction();
		}else if(command.equals("/member/insertform")) {
			action=new MemberInsertformAction();
		}else if(command.equals("/member/insert")) {
			action=new MemberInsertAction();
		}else if(command.equals("/member/delete")) {
			action=new MemberDeleteAction();
		}else if(command.equals("/member/updateform")) {
			action=new MemberUpdateformAction();
		}else if(command.equals("/member/update")) {
			action=new MemberUpdateAction();
		}else if(command.equals("/home")) {
			action=new HomeAction();
		}
		return action;
	}
}










