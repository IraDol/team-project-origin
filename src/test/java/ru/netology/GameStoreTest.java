package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    // другие ваши тесты
    @Test
    public void shouldAddOnePlayer() {
        GameStore store = new GameStore();
        store.addPlayTime("Petr", 5);
        String  expected = "Petr";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);

 }
    @Test
    public void shouldAddTwoPlayerAndAndReturnBestPlayer() {
        GameStore store = new GameStore();
        store.addPlayTime("Petr", 5);
        store.addPlayTime("Ivan", 1);
        String expected = "Petr";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddThreePlayerAndReturnBestPlayer() {
        GameStore store = new GameStore();
        store.addPlayTime("Petr", 2);
        store.addPlayTime("Igor", 5);
        store.addPlayTime("Ivan", 5);
        String expected = "Igor";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnNull() {
        GameStore store = new GameStore();

        String expected = null;
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckBorderOfTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Petr", -2);

        String expected = null;
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayerTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Petr", 2);
        store.addPlayTime("Igor", 5);
        store.addPlayTime("Ivan", 5);
        int expected = 12;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }













}
