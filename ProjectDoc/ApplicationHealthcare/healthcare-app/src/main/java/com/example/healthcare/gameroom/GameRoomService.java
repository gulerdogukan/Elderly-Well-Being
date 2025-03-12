package com.example.healthcare.gameroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.healthcare.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class GameRoomService {

    @Autowired
    private GameRoomRepository gameRoomRepository;

    public List<GameRoom> getAllGameRooms() {
        return gameRoomRepository.findAll();
    }

    public GameRoom createGameRoom(GameRoom gameRoom) {
        return gameRoomRepository.save(gameRoom);
    }

    public GameRoom updateGameRoom(Long id, GameRoom gameRoom) {
        GameRoom existingGameRoom = gameRoomRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Game Room not found"));
        existingGameRoom.setName(gameRoom.getName());
        existingGameRoom.setDescription(gameRoom.getDescription());
        return gameRoomRepository.save(existingGameRoom);
    }

    public void deleteGameRoom(Long id) {
        gameRoomRepository.deleteById(id);
    }
}
