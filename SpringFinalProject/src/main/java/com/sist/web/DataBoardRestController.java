package com.sist.web;
import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dao;
	
	@PostMapping(value = "databoard/insert_vue.do", produces = "text/plain;charset=UTF-8")
	public String databoard_insert(DataBoardVO vo, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/")+"upload\\";
		path = path.replace("\\", File.separator);
		List<MultipartFile> list = vo.getImages();
		if (list == null) {
//			System.out.println("파일 업로드가 없습니다");
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		} else {
//			System.out.println("파일이 "+list.size()+"개 업로드 됨");
			String filename="";
			String filesize="";
			for (MultipartFile mf:list) {
				String name = mf.getOriginalFilename();
				File file = new File(path+name);
				try {
					mf.transferTo(file);
				} catch (Exception e) {}
//				System.out.println(name);
				
				filename+=name+",";
				filesize+=file.length()+",";
			}
			
			filename=filename.substring(0,filename.lastIndexOf(","));
			filesize=filesize.substring(0,filesize.lastIndexOf(","));
			vo.setFilecount(list.size());
			vo.setFilename(filename);
			vo.setFilesize(filesize);
		}
		dao.dataBoardInsert(vo);
		return "ok";
	}
	
	// Vue / React => JSONP
	@GetMapping(value = "databoard/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String databoard_list(int page) throws Exception {
		
		Map map = new HashMap();
		int rowSize = 10;
		int start = (rowSize*page) - (rowSize-1);
		int end = rowSize * page;
		map.put("start", start);
		map.put("end", end);
		List<DataBoardVO> list = dao.dataBoardListData(map);
		int totalpage = dao.databoardTotalPage();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		
		return json;
	}
	
	@GetMapping(value = "databoard/page_vue.do", produces = "text/plain;charset=UTF-8")
	public String databoard_page(int page) throws Exception {
		int totalpage = dao.databoardTotalPage();
		Map map = new HashMap();
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value = "databoard/detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String databoard_detail(int no) throws Exception {
		DataBoardVO vo = dao.databoardDetailData(no);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(vo);
		return json;
	}
	
}
