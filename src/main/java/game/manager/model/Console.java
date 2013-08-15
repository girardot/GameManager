package game.manager.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GAME_CONSOLE")
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "console", cascade={CascadeType.ALL})
    private List<Game> games;

    public Console() {
    }

    public Console(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
