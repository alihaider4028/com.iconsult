package springboot.app.com.iconsult.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.app.com.iconsult.entity.player;
import springboot.app.com.iconsult.repository.PlayerRepository;

import java.util.List;
import java.util.Map;


@Service
    public class PlayerService {
        @Autowired
        private PlayerRepository playerRepository;

        public player findPlayerById(int id) {
            player player = null;
            try {
                List<player>  result= playerRepository.findPlayer(id);
                if (result != null ) {
                   player= result.get(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                // handle exception
            }
            return player;
        }
    }


