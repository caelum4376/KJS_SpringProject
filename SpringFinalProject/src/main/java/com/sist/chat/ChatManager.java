package com.sist.chat;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.*;
@ServerEndpoint("/chat/chat-ws")
public class ChatManager {
	private static List<Session> users = new ArrayList<Session>();
	
	// 연결 요청시에 처리
	@OnOpen
	public void onOpen(Session session) {
		users.add(session);
		System.out.println("클라이언트 접속... : " + session.getId());
	}
	
	// 연결종료시 처리
	@OnClose
	public void onClose(Session session) {
		users.remove(session);
		System.out.println("클라이언트 퇴장... : " + session.getId());
	}
	
	// 채팅
	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		System.out.println("수신 메세지... : " + message);
		Iterator<Session> it = users.iterator();
		System.out.println("현재 인원 : " + users.size());
		while(it.hasNext()) {
			it.next().getBasicRemote().sendText(message);
			System.out.println(session.getId()+"전송");
		}
//		for (Session s:users) {
//			s.getBasicRemote().sendText(message);
//			System.out.println(s.getId()+"전송");
//		}
	}
}
