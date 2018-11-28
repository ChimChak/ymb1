package test.file.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class FileDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//삭제할 파일 번호를 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
	 	//삭제할 파일의 정보 얻어오기
	 	FileDto dto=FileDao.getInstance().getData(num);
	 	
	 	String id=(String)request.getSession().getAttribute("id");
	 	if(!id.equals(dto.getWriter())){
	 		//금지된 요청이라고 에러를 응답한다.
	 		try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, 
						"남의 파일 지우기 없기!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		return null;//메소드 종료 
	 	}
	 	
	 	//파일 시스템에서 삭제 하기 위해서는 저장된 파일명을 알아야 한다. 
	 	String saveFileName=dto.getSaveFileName();
	 	
	 	//1. DB 에서 파일 정보 삭제
	 	FileDao.getInstance().delete(num);
	 	//2. 파일 시스템에서 파일 삭제 
	 	String path=request.getServletContext().getRealPath("/upload")+
	 		File.separator+saveFileName;
	 	//파일 객체 생성해서 삭제하기 
	 	File file=new File(path);
	 	file.delete();
	 	//응답하기(리다일렉트)
		return new ActionForward("/file/list.do", true);
	}

}
