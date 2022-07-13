package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    // другие ваши тесты

    @Test
    public void shouldPlay() { // Суммарное сыгранное время игроком, после установки игры.
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн2", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 4);
        player.play(game2, 1);

        int expected = 5;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }


    @Test
    public void shouldPlay2() {//Игра не установлена.
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн2", "Аркады");

        Player player = new Player("Petya");
        player.play(game, 2);
        player.play(game2, 5);

        assertThrows(RuntimeException.class, () -> player.sumGenre("Аркады"));
    }

    @Test
    public void shouldMostPlayerByGenre() { // Возращает название игры, в которую играли больше всего.
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн2", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 3);
        player.play(game2, 1);

        Game expected = player.mostPlayerByGenre("Аркады");
        String actual = game.getTitle();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldInstallGame() { //Возращает суммарное время игры при повторной установки игры.
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 4);
        player.installGame(game);

        int expected = 4;
        int actual = player.sumGenre("Аркады");

        assertEquals(expected, actual);
    }
}
