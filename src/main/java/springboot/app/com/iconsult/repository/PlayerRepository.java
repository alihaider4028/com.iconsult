package springboot.app.com.iconsult.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import springboot.app.com.iconsult.entity.player;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class PlayerRepository {

    JdbcTemplate jdbcTemplate;
    @Autowired
    public PlayerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<player> findPlayer(int id) {
    SimpleJdbcCall simpleJdbcCall= new SimpleJdbcCall(jdbcTemplate)
            .withSchemaName("sys")
            .withProcedureName("find_player")
            .declareParameters(new SqlInOutParameter("ID", Types.INTEGER),
                    new SqlOutParameter("C_CURSOR ", Types.REF_CURSOR))
            .returningResultSet("C_CURSOR", new RowMapper<player>() {
                        @Override
                        public player mapRow(ResultSet rs, int rowNum) throws SQLException {
                            player p = new player();
                            p.setId(id);
                            p.setFirstName(rs.getString("first_name"));
                            p.setLastName(rs.getString("last_name"));
                            p.setSports(rs.getString("sports"));
                            p.setAge(rs.getInt("age"));
                            System.out.println(p.toString());
                            return p;
                        }
                    });





        MapSqlParameterSource in = new MapSqlParameterSource().addValue("ID", 2);
        Map<String, Object> out = simpleJdbcCall.execute(in);
        List<player> list= (List<player>) out.get("C_CURSOR");
        return list;
    }
}

