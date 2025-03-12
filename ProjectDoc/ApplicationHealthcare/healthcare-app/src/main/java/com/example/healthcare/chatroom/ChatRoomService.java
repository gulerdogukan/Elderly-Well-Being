package com.example.healthcare.chatroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.healthcare.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public List<ChatRoom> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    public ChatRoom updateChatRoom(Long id, ChatRoom chatRoom) {
        ChatRoom existingChatRoom = chatRoomRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Chat Room not found"));
        existingChatRoom.setName(chatRoom.getName());
        existingChatRoom.setDescription(chatRoom.getDescription());
        return chatRoomRepository.save(existingChatRoom);
    }

    public void deleteChatRoom(Long id) {
        chatRoomRepository.deleteById(id);
    }
}
