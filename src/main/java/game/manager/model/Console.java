package game.manager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CONSOLE")
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "console_name")
    private String name;

    @OneToMany(mappedBy = "console", cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Game> games;

    public Console() {
        games = new ArrayList<Game>();
    }

    public Console(String name) {
        games = new ArrayList<Game>();
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

    public void addGame(Game game) {
        games.add(game);
        game.setConsole(this);
    }
}
