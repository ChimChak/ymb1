package test.controller;

import test.action.HomeAction;
import test.cafe.action.CafeCommentDeleteAction;
import test.cafe.action.CafeCommentInsertAction;
import test.cafe.action.CafeCommentUpdateAction;
import test.cafe.action.CafeDeleteAction;
import test.cafe.action.CafeDetailAction;
import test.cafe.action.CafeInsertAction;
import test.cafe.action.CafeInsertformAction;
import test.cafe.action.CafeListAction;
import test.cafe.action.CafeUpdateAction;
import test.cafe.action.CafeUpdateformAction;
import test.file.action.FileDeleteAction;
import test.file.action.FileDownAction;
import test.file.action.FileListAction;
import test.file.action.FileUploadAction;
import test.file.action.FileUploadformAction;
import test.member.action.MemberDeleteAction;
import test.member.action.MemberInsertAction;
import test.member.action.MemberInsertformAction;
import test.member.action.MemberListAction;
import test.member.action.MemberUpdateAction;
import test.member.action.MemberUpdateformAction;
import test.users.action.CheckidAction;
import test.users.action.LoginAction;
import test.users.action.LoginformAction;
import test.users.action.LogoutAction;
import test.users.action.SignupAction;
import test.users.action.SignupFormAction;
import test.users.action.UsersDeleteAction;
import test.users.action.UsersInfoAction;
import test.users.action.UsersUpdateAction;
import test.users.action.UsersUpdateformAction;

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
		}else if(command.equals("/users/loginform")) {
			action=new LoginformAction();
		}else if(command.equals("/users/login")) {
			action=new LoginAction();
		}else if(command.equals("/users/logout")) {
			action=new LogoutAction();
		}else if(command.equals("/users/signup_form")) {
			action=new SignupFormAction();
		}else if(command.equals("/users/checkid")) {
			action=new CheckidAction();
		}else if(command.equals("/users/signup")) {
			action=new SignupAction();
		}else if(command.equals("/users/private/info")) {
			action=new UsersInfoAction();
		}else if(command.equals("/users/private/updateform")) {
			action=new UsersUpdateformAction();
		}else if(command.equals("/users/private/update")) {
			action=new UsersUpdateAction();
		}else if(command.equals("/users/private/delete")) {
			action=new UsersDeleteAction();
		}else if(command.equals("/cafe/list")) {
			action=new CafeListAction();
		}else if(command.equals("/cafe/private/insertform")) {
			action=new CafeInsertformAction();
		}else if(command.equals("/cafe/private/insert")) {
			action=new CafeInsertAction();
		}else if(command.equals("/cafe/detail")) {
			action=new CafeDetailAction();
		}else if(command.equals("/cafe/private/delete")) {
			action=new CafeDeleteAction();
		}else if(command.equals("/cafe/private/updateform")) {
			action=new CafeUpdateformAction();
		}else if(command.equals("/cafe/private/update")) {
			action=new CafeUpdateAction();
		}else if(command.equals("/cafe/private/comment_insert")) {
			action=new CafeCommentInsertAction();
		}else if(command.equals("/cafe/private/comment_delete")) {
			action=new CafeCommentDeleteAction();
		}else if(command.equals("/cafe/private/comment_update")) {
			action=new CafeCommentUpdateAction();
		}else if(command.equals("/file/list")) {
			action=new FileListAction();
		}else if(command.equals("/file/private/upload_form")) {
			action=new FileUploadformAction();
		}else if(command.equals("/file/private/upload")) {
			action=new FileUploadAction();
		}else if(command.equals("/file/download")) {
			action=new FileDownAction();
		}else if(command.equals("/file/private/delete")) {
			action=new FileDeleteAction();
		}
		return action;
	}
}










