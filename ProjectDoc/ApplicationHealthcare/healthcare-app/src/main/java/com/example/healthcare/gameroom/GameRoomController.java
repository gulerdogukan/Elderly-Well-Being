package com.example.healthcare.gameroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamerooms")
public class GameRoomController {

    @Autowired
    private GameRoomService gameRoomService;

    @GetMapping
    public List<GameRoom> getAllGameRooms() {
        return gameRoomService.getAllGameRooms();
    }

    @PostMapping
    public GameRoom createGameRoom(@RequestBody GameRoom gameRoom) {
        return gameRoomService.createGameRoom(gameRoom);
    }

    @PutMapping("/{id}")
    public GameRoom updateGameRoom(@PathVariable Long id, @RequestBody GameRoom gameRoom) {
        return gameRoomService.updateGameRoom(id, gameRoom);
    }

    @DeleteMapping("/{id}")
    public void deleteGameRoom(@PathVariable Long id) {
        gameRoomService.deleteGameRoom(id);
    }
}
