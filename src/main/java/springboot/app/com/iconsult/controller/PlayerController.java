package springboot.app.com.iconsult.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.app.com.iconsult.entity.player;
import springboot.app.com.iconsult.services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable("id") int playerId) {
        player player = playerService.findPlayerById(playerId);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return new ResponseEntity<>("0",HttpStatus.BAD_GATEWAY);
        }
    }

    // Other controller methods
}
