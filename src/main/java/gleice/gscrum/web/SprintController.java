package gleice.gscrum.web;

import gleice.gscrum.dao.SprintDao;
import gleice.gscrum.modelo.Sprint;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SprintController {

        @RequestMapping("/novoSprint")
        public String form() {
                return "addsprint";
        }

        @RequestMapping("/adicionaSprint")
        public String adiciona(Sprint sprint) {

                try {

                        SprintDao dao = new SprintDao();
                        dao.adiciona(sprint);
                        System.out.println(sprint);

                } catch (SQLException e) {
                        e.printStackTrace();
                }

                return "sprintAdicionado";

        }
}
