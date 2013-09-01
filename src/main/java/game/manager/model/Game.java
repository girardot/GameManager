package game.manager.model;

import javax.persistence.*;
import java.io.Serializable;

import static game.manager.model.GameProgression.TO_DO;

@Entity
@Table(name = "GAME")
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "progression")
    private GameProgression progression = TO_DO;

    @ManyToOne
    @JoinColumn(name = "console_id")
    private Console console;

    public Game() {
        progression = TO_DO;
    }

    public Game(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GameProgression getProgression() {
        return progression;
    }

    public void setProgression(GameProgression progression) {
        this.progression = progression;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

}
