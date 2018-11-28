package test.file.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class FileUploadAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 폼 전송되는 파라미터 추출 
		
		// Tomcat 서버를 실행했을때 WebContent/upload  폴더의 실제 경로 얻어오기
		String realPath=request.getServletContext().getRealPath("/upload");
		System.out.println("파일 저장경로:"+realPath);
		// 최대 업로드 사이즈 설정
		int sizeLimit=1024*1024*50; // 50 MByte
		// MultipartRequest 객체를 생성한다 (cos.jar)
		MultipartRequest mr=null;
		try {
			mr = new MultipartRequest(request, //HttpServletRequest 객체
					realPath,  //파일을 저장할 경로
					sizeLimit, //최대 업로드 사이즈 제한
					"utf-8", //파일명에 한글이 있을경우 깨지지 않게
					new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //동일한 파일이 있을 경우 파일명 자동 rename  
		//제목
		String title=mr.getParameter("title");
		//업로드한 원본 파일명
		String orgFileName=mr.getOriginalFileName("myFile");
		//파일시스템에 저장된 파일명
		String saveFileName=mr.getFilesystemName("myFile");
		//파일의 크기(다운로드 시켜줄때 필요하다)
		long fileSize=mr.getFile("myFile").length();
		//업로드한 클라이언트의 아이디
		String writer=(String)request.getSession().getAttribute("id");
		
		//2. 업로드된 파일정보 저장
		//저장할 파일의 정보를 FileDto 객체에 담고 
		FileDto dto=new FileDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setOrgFileName(orgFileName);
		dto.setSaveFileName(saveFileName);
		dto.setFileSize(fileSize);
		//FileDao 객체를 이용해서 DB 에 저장하기 
		FileDao.getInstance().insert(dto);
		//3. 리다일렉트 응답		
		return new ActionForward("/file/list.do", true);
	}

}






